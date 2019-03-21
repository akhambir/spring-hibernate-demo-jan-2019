package com.akhambir.dao;

import com.akhambir.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> getAll() {
        List<Category> result = sessionFactory.getCurrentSession()
                .createQuery("from Category c", Category.class)
                .list();
        System.out.println();
        return result;
    }
}
