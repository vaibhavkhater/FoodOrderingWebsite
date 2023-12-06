package com.dev.controllers;
 
import com.dev.dao.CartJdbcDao;
import com.dev.dao.CartItemsJdbcDao;
import com.dev.models.Cart;
import com.dev.models.CartItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
 
@RequestMapping("/cart")
@Controller
public class CartController {
    private CartJdbcDao cartJdbcDao;
    private CartItemsJdbcDao cartItemsJdbcDao;
 
    @Autowired
    public CartController(CartJdbcDao cartJdbcDao, CartItemsJdbcDao cartItemsJdbcDao) {
        this.cartJdbcDao = cartJdbcDao;
        this.cartItemsJdbcDao = cartItemsJdbcDao;
    }
 
    @PostMapping("/create")
    @ResponseBody
    public Cart createCart(Cart cart) {
        cartJdbcDao.createCart(cart);
        return cart;
    }
 
    @GetMapping("/create")
    public String createCart(Model model) 
    {
        model.addAttribute("cart", new Cart());
        return "cart";
    }
 
    @PostMapping("/additems")
    @ResponseBody
    public CartItems addCartItems(CartItems cartItems) {
        cartItemsJdbcDao.createCartItems(cartItems);
        return cartItems;
    }
 
    @GetMapping("/additems")
    public String addItems(Model model) {
        model.addAttribute("cartItems", new CartItems());
        return "addItems";
    }
 
    @RequestMapping("/{id}")
    public String getCartItemsbyCartId(@PathVariable("id") long id, Model model){
        model.addAttribute("cartItems", cartItemsJdbcDao.getCartItemsByCartId(id));
        return "cartItems";
   }
 
}
