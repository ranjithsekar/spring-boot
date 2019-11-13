package com.bootrest.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrest.dao.CategoryRepository;
import com.bootrest.dao.SubCategoryRepository;
import com.bootrest.model.Category;
import com.bootrest.model.SubCategory;

@Service
public class DataUploadServiceImpl implements DataUploadService {

  @Autowired
  CategoryRepository categoryRepo;

  @Autowired
  SubCategoryRepository subCategoryRepo;

  @Override
  public void addCategory(String fileName) throws Exception {
    Stream<String> lines = Files.lines(Paths.get(fileName));
    List<Category> categories = lines.map(categoryMap).collect(Collectors.toList());
    categoryRepo.deleteAll();
    categoryRepo.insert(categories);
    lines.close();
  }

  @Override
  public void addSubCategory(String fileName) throws Exception {
    Stream<String> lines = Files.lines(Paths.get(fileName));
    List<SubCategory> subCategories = lines.map(subCategoryMap).collect(Collectors.toList());
    subCategoryRepo.deleteAll();
    subCategoryRepo.insert(subCategories);
    lines.close();
  }

  private Function<String, Category> categoryMap = (line) -> {
    String[] data = line.split(",");
    Category category = new Category();
    category.setId(Integer.valueOf(data[0]));
    category.setName(data[1]);
    category.setTitle(data[2]);
    category.setDescription(data[3]);
    category.setActive(Boolean.valueOf(data[4]));

    return category;
  };

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
