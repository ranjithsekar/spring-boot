package com.bootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrest.dao.CategoryRepository;
import com.bootrest.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  CategoryRepository categoryRepository;

  @Override
  public Category addCategory(Category category) {
    return categoryRepository.save(category);
  }

  @Override
  public List<Category> addCategory(List<Category> categories) {
    return categoryRepository.saveAll(categories);
  }

  @Override
  public int removeCategory(Category category) {
    return 0;
  }

  @Override
  public int removeCategory(List<Category> categories) {
    return 0;
  }

}
