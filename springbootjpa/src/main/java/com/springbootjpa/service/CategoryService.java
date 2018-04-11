package com.springbootjpa.service;

import com.springbootjpa.domain.Category;
import com.springbootjpa.domain.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class CategoryService {

    @Resource(name = "categoryRepository")
    private CategoryRepository categoryRepository;

    //
    public void save(Category category) {
        categoryRepository.save(category);
    }

    //
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }
}
