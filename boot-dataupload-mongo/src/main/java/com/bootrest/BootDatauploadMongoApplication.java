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

/**
 * Application to upload master service data includes uploading category,
 * subcategory, country, state and city data.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@SpringBootApplication
public class BootDatauploadMongoApplication implements CommandLineRunner {
  private final Logger log = LoggerFactory.getLogger(BootDatauploadMongoApplication.class);

  /** Inject Category Upload Service object. **/
  @Autowired
  private CategoryUploadService categoryService;

  /** Inject SubCategory Upload Service object. **/
  @Autowired
  private SubCategoryUploadService subCategoryService;

  /** Inject Country Upload Service object. **/
  @Autowired
  private CountryUploadService countryService;

  /** Inject State Upload Service object. **/
  @Autowired
  private StateUploadService stateService;

  /** Inject City Upload Service object. **/
  @Autowired
  private CityUploadService cityService;

  /**
   * Main method for the application execution.
   * 
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    SpringApplication.run(BootDatauploadMongoApplication.class, args);
  }

  /**
   * Read the command line argument and pick the right service.
   */
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