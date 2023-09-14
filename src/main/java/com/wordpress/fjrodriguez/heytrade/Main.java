package com.wordpress.fjrodriguez.heytrade;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.wordpress.fjrodriguez.heytrade.excel.Workbook;
import com.wordpress.fjrodriguez.heytrade.file.FolderService;

public class Main {

  public static void main(String[] args) throws IOException, URISyntaxException {
    FolderService folderService = new FolderService();
    List<File> files = folderService.getFileList();
    Workbook workbook = new Workbook();
    workbook.create(files);
  }
}