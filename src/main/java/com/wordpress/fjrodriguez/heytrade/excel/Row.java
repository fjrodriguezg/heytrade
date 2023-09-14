package com.wordpress.fjrodriguez.heytrade.excel;

import java.util.List;
import java.util.function.BiFunction;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;

public class Row {

  public void create(List<String> lines, Sheet sh, int startingPosition, int rowNumber, int readCol,
      BiFunction<Integer, Integer, Integer> f) {

    org.apache.poi.ss.usermodel.Row row = sh.createRow(rowNumber);
    for (int cellnum = 0; cellnum <= readCol; cellnum++) {
      Cell cell = row.createCell(cellnum);
      cell.setCellValue(lines.get(f.apply(cellnum, startingPosition)));
    }
  }
}
