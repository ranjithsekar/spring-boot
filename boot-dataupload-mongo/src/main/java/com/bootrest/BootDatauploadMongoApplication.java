package com.bootrest;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bootrest.service.CategoryUploadService;
import com.bootrest.service.CityUploadService;
import com.bootrest.service.CountryUploadService;
import com.bootrest.service.StateUploadService;
import com.bootrest.service.SubCategoryUploadService;

@SpringBootApplication
public class BootDatauploadMongoApplication implements CommandLineRunner {
  private final Logger log = LoggerFactory.getLogger(BootDatauploadMongoApplication.class);

  @Autowired
  private CategoryUploadService categoryService;

  @Autowired
  private SubCategoryUploadService subCategoryService;

  @Autowired
  private CountryUploadService countryService;

  @Autowired
  private StateUploadService stateService;

  @Autowired
  private CityUploadService cityService;

  public static void main(String[] args) throws IOException {
    SpringApplication.run(BootDatauploadMongoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    String fileName = args[0];
    if (StringUtils.isNotEmpty(fileName)) {
      log.info("Input file: " + fileName);
      if (fileName.contains("country")) {
        countryService.addCountry(fileName);
      } else if (fileName.contains("state")) {
        stateService.addState(fileName);
      } else if (fileName.contains("city")) {
        cityService.addCity(fileName);
      } else if (fileName.contains("subcategory")) {
        subCategoryService.addSubCategory(fileName);
      } else if (fileName.contains("category")) {
        categoryService.addCategory(fileName);
      }
    }
  }
}