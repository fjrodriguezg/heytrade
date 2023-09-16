package com.wordpress.fjrodriguez.heytrade.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.wordpress.fjrodriguez.heytrade.pdf.PdfText;

public class Workbook {

  public static final String DIVIDENDOS = "dividendos";
  public static final String COMPRA = "Compra";
  public static final String VENTA = "Venta";

  public void create(List<File> files) throws IOException {
    PdfText pdfText = new PdfText();
    Row row = new Row();
    com.wordpress.fjrodriguez.heytrade.excel.Sheet sheet = new com.wordpress.fjrodriguez.heytrade.excel.Sheet();
    AtomicInteger countDividends = new AtomicInteger(1);
    AtomicInteger countBuys = new AtomicInteger(1);
    AtomicInteger countSells = new AtomicInteger(1);

    try (FileOutputStream out = new FileOutputStream("heyTrade.xlsx")) {
      try (SXSSFWorkbook wb = new SXSSFWorkbook(100)) {
        for (File file : files) {
          List<String> lines = pdfText.generateLinesFromPDF(file.toString());
          if (lines.get(3).contains(DIVIDENDOS)) {
            addRow(sheet.getOrCreate(wb, DIVIDENDOS), row, lines, countDividends, 18, 10, 11,
                (cellNum, startingPosition) -> cellNum * 2 + startingPosition);
          } else if (lines.get(27).contains(COMPRA)) {
            addRow(sheet.getOrCreate(wb, COMPRA), row, lines, countBuys, 12, 10, 29, Integer::sum);
          } else if (lines.get(27).contains(VENTA)) {
            addRow(sheet. getOrCreate(wb, VENTA), row, lines, countSells, 12, 10, 29, Integer::sum);
          }
        }
        wb.write(out);
        wb.dispose();
      }
    }
  }

  private void addRow(Sheet sh, Row row, List<String> lines, AtomicInteger count, int colsToRead,
      int startingReadingHeader, int startingReadingData, BiFunction<Integer, Integer, Integer> f) {
    if (sh.getRow(0) == null) {
      row.create(lines, sh, startingReadingHeader, 0, colsToRead, f);
    }
    row.create(lines, sh, startingReadingData, count.get(), colsToRead, f);
    count.getAndIncrement();
  }

}

