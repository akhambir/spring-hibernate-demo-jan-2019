package com.akhambir.controller;

import com.akhambir.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView vm) {
        vm.setViewName("categories");
        vm.addObject("categories", categoryService.getAll());
        return vm;
    }

}
