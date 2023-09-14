package com.wordpress.fjrodriguez.heytrade.pdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

public class GetLinesFromPDF extends PDFTextStripper {

  private List<String> lines = new ArrayList<>();

  @Override
  protected void writeString(String str, List<TextPosition> textPositions) throws IOException {
    output.write(str);
    lines.add(str);
  }

  public List<String> getLines() {
    return lines;
  }
}
