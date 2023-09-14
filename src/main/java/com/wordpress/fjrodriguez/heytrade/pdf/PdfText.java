package com.wordpress.fjrodriguez.heytrade.pdf;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PdfText {

  public List<String> generateLinesFromPDF(String filename) throws IOException {
    File f = new File(filename);
    PDFParser parser = new PDFParser(new RandomAccessReadBufferedFile(f));
    PDDocument pdDoc = parser.parse();

    GetLinesFromPDF pdfStripper = new GetLinesFromPDF();
    pdfStripper.getText(pdDoc);
    List<String> lines = pdfStripper.getLines();

    if (pdDoc != null)
      pdDoc.close();

   return lines;
  }
}
