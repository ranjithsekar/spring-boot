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

import com.bootrest.model.Category;
import com.bootrest.repository.CategoryDao;
import com.bootrest.repository.SubCategoryDao;
import com.bootrest.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

/**
 * Service to upload the category data. Upload the subcategory data after
 * calling this service since 1) delete the subcategory and category data, 2)
 * upload the new category data.
 * 
 * @author Ranjith Sekar
 * @since 2019-Nov-20
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService{

  /** Inject Category Repository Object. **/
  @Autowired
  private CategoryDao categoryRepository;

  /** Inject SubCategory Repository Object. **/
  @Autowired
  private SubCategoryDao subCategoryRepository;

  /**
   * 1) Read the file line by line, 2) parse the data, 3) remove existing data
   * from db, 4) insert parsed data.
   * 
   * @param fileName - input filename.
   */
  public void addCategory(String fileName) {
    Stream<String> lines = null;

    try {
      lines = Files.lines(Paths.get(fileName));
      List<Category> categories = lines.map(categoryMap).collect(Collectors.toList());

      subCategoryRepository.deleteAll();
      log.info("All the existing subcategories are deleted.");

      categoryRepository.deleteAll();
      log.info("All the existing categories are deleted.");

      List<Category> inserted = categoryRepository.insert(categories);
      log.info(inserted.size() + " categories inserted");

      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }

  /**
   * Construct the Category object from the csv.
   */
  private Function<String, Category> categoryMap = (line) -> {
    String[] data = line.split(",");

    Category category = new Category();
    category.setCategoryId(data[0]);
    category.setCategoryName(data[1]);
    category.setCategoryTitle(data[2]);
    category.setDescription(data[3]);
    category.setActive(Boolean.valueOf(data[4]));

    return category;
  };

}
