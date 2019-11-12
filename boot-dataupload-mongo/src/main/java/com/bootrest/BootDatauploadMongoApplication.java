package com.bootrest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import com.bootrest.service.DataUploadService;

@SpringBootApplication
public class BootDatauploadMongoApplication implements CommandLineRunner {

  @Autowired
  private DataUploadService service;

  public static void main(String[] args) throws IOException {
    SpringApplication.run(BootDatauploadMongoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    String fileName = args[0];
    if (!StringUtils.isEmpty(fileName)) {
      if (fileName.contains("subcategory")) {
        service.addSubCategory(fileName);
      } else {
        service.addCategory(fileName);
      }
    }
  }
}