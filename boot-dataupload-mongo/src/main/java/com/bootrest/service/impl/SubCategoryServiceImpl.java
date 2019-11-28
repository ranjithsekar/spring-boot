package com.bootrest.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrest.model.SubCategory;
import com.bootrest.repository.SubCategoryRepository;
import com.bootrest.service.SubCategoryService;

import lombok.extern.slf4j.Slf4j;

/**
 * Service to upload sub category data. 1) delete the existing subcategory data,
 * 2) upload the new subcategory data.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Service
@Slf4j
public class SubCategoryServiceImpl implements SubCategoryService {

  /** Inject SubCategory Repository Object. **/
  @Autowired
  private SubCategoryRepository subCategoryRepository;

  /**
   * 1) Read the file line by line, 2) parse the data, 3) remove existing data
   * from db, 4) insert parsed data.
   * 
   * @param fileName - input filename.
   */
  public void addSubCategory(String fileName) {
    Stream<String> lines;

    try {
      lines = Files.lines(Paths.get(fileName));
      List<SubCategory> subCategories = lines.map(subCategoryMap).collect(Collectors.toList());

      subCategoryRepository.deleteAll();
      log.info("All the existing subcategory data deleted.");

      List<SubCategory> inserted = subCategoryRepository.insert(subCategories);
      log.info(inserted.size() + " subcategories inserted.");

      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }

  /**
   * Construct the Subcategory object from the csv.
   */
  private Function<String, SubCategory> subCategoryMap = (line) -> {
    String[] data = line.split(",");

    SubCategory subCategory = new SubCategory();
    subCategory.setCategoryId(data[0]);
    subCategory.setSubCategoryId(data[1]);
    subCategory.setSubCategoryName(data[2]);
    subCategory.setSubCategoryTitle(data[3]);
    subCategory.setDescription(data[4]);
    subCategory.setActive(Boolean.valueOf(data[5]));

    return subCategory;
  };

}