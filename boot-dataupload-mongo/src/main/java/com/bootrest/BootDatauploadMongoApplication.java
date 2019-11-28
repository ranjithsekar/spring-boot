package com.bootrest;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bootrest.service.CategoryService;
import com.bootrest.service.CityService;
import com.bootrest.service.CountryService;
import com.bootrest.service.StateService;
import com.bootrest.service.SubCategoryService;

import lombok.extern.slf4j.Slf4j;

/**
 * Application to upload master service data includes uploading category,
 * subcategory, country, state and city data.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@SpringBootApplication
@Slf4j
public class BootDatauploadMongoApplication implements CommandLineRunner {

  /** Inject Category Service object. **/
  @Autowired
  private CategoryService categoryService;

  /** Inject SubCategory Service object. **/
  @Autowired
  private SubCategoryService subCategoryService;

  /** Inject Country Service object. **/
  @Autowired
  private CountryService countryService;

  /** Inject State Service object. **/
  @Autowired
  private StateService stateService;

  /** Inject City Service object. **/
  @Autowired
  private CityService cityService;

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
    String fileName = "input/city.csv";
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