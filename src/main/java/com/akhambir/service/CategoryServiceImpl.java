package com.akhambir.service;

import com.akhambir.dao.CategoryDao;
import com.akhambir.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAll() {
        List<Category> result = categoryDao.getAll();
        System.out.println();
        return result;
    }
}
