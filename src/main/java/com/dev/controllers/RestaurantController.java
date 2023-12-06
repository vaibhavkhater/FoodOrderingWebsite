package com.dev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import com.dev.dao.*;
import com.dev.models.*;

import java.util.*;


@RequestMapping("/restaurants")
@Controller
public class RestaurantController {
    private ItemJdbcDao itemJdbcDao;
    private RestaurantJdbcDao restaurantJdbcDao;

    @Autowired
    public RestaurantController(ItemJdbcDao itemJdbcDao, RestaurantJdbcDao restaurantJdbcDao) {
        this.itemJdbcDao = itemJdbcDao;
        this.restaurantJdbcDao = restaurantJdbcDao;
    }
    
    @GetMapping("")
    public String getAllRestaurants(Model model) {
        model.addAttribute("restaurants", restaurantJdbcDao.getAllRestaurants());
        System.out.println(restaurantJdbcDao.getAllRestaurants());
        return "restaurants";
    }
    
    @RequestMapping("/{id}")
    public String getAllItems(@PathVariable("id") long id,Model model) {
        model.addAttribute("items", itemJdbcDao.getAllItemsbyRestaurantId(id));
        return "items";
    }

}
