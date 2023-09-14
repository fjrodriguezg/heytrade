package com.wordpress.fjrodriguez.heytrade.file;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import com.wordpress.fjrodriguez.heytrade.Main;

public class FolderService {
  public List<File> getFileList() throws URISyntaxException, IOException {
    List<File> files;
    URL resource = Main.class.getClassLoader().getResource(".");
    try (Stream<Path> stream =  Files.walk(Paths.get(resource.toURI()))) {
      files = stream.filter(Files::isRegularFile)
          .filter(file -> file.toString().endsWith(".pdf"))
          .map(Path::toFile)
          .toList();
    }

    return files;
  }
}
