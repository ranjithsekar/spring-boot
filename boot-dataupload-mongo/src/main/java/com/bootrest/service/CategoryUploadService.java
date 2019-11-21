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

import com.bootrest.dao.CategoryRepository;
import com.bootrest.model.Category;

@Service
public class CategoryUploadService {

  private final Logger log = LoggerFactory.getLogger(CategoryUploadService.class);

  @Autowired
  private CategoryRepository categoryRepo;

  public void addCategory(String fileName) {
    Stream<String> lines = null;
    try {
      lines = Files.lines(Paths.get(fileName));
      List<Category> categories = lines.map(categoryMap).collect(Collectors.toList());
      categoryRepo.deleteAll();
      List<Category> inserted = categoryRepo.insert(categories);
      log.info(inserted.size() + " categories inserted");
      lines.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
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

}
