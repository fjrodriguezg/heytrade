package com.wordpress.fjrodriguez.heytrade.excel;

import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class Sheet {

  public org.apache.poi.ss.usermodel.Sheet getOrCreate(SXSSFWorkbook wb, String title) {
    SXSSFSheet existingSheet = wb.getSheet(title);
    return existingSheet != null ? existingSheet : wb.createSheet(title);
  }
}
