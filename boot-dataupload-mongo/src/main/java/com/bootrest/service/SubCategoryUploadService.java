package com.bootrest.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrest.dao.SubCategoryRepository;
import com.bootrest.model.SubCategory;

@Service
public class SubCategoryUploadService {
  private final Logger log = LoggerFactory.getLogger(SubCategoryUploadService.class);

  @Autowired
  SubCategoryRepository subCategoryRepo;

  public void addSubCategory(String fileName) {
    Stream<String> lines;
    try {
      lines = Files.lines(Paths.get(fileName));
      List<SubCategory> subCategories = lines.map(subCategoryMap).collect(Collectors.toList());
      subCategoryRepo.deleteAll();
      List<SubCategory> inserted = subCategoryRepo.insert(subCategories);
      log.info(inserted.size() + " subcategories inserted.");
      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }

  private Function<String, SubCategory> subCategoryMap = (line) -> {
    String[] data = line.split(",");
    SubCategory subCategory = new SubCategory();
    subCategory.setCategoryId(Integer.valueOf(data[0]));
    subCategory.setName(data[1]);
    subCategory.setTitle(data[2]);
    subCategory.setDesc(data[3]);
    subCategory.setActive(Boolean.valueOf(data[4]));

    return subCategory;
  };

}
