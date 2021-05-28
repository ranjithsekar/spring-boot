package com.bootrest.service;

import java.util.List;

import com.bootrest.model.Category;

public interface CategoryService {

  Category addCategory(Category category);

  List<Category> addCategory(Category[] categories);

  int removeCategory(Category category);

  int removeCategory(List<Category> categories);
}
