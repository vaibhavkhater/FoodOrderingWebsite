package com.dev.dao;

import com.dev.models.Cart;
// import com.dev.models.User;
import com.dev.models.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CartJdbcDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CartJdbcDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private final RowMapper<Cart> cartRowMapper = (rs, rowNum) -> {
        Cart cart = new Cart();
        cart.setCartId(rs.getLong("CartId"));
        cart.setUserId(rs.getLong("UserId"));
        cart.setStatus(rs.getBoolean("Status"));
        cart.setRestaurantId(rs.getLong("RestaurantId"));
        return cart;
    };

    private HashMap<String, Object> getCartMap(Cart cart) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("CartId", cart.getCartId());
        map.put("UserId", cart.getUserId());
        map.put("Status", cart.isStatus());
        map.put("RestaurantId", cart.getRestaurantId());
        return map;
    }

    public void createCart(Cart cart) {
        if(cart.getCartId()==0) cart.setCartId(0);// sets it to a random val.
        String sql = "INSERT INTO Cart (CartId, UserId, Status, RestaurantId) VALUES (:CartId,:UserId, :Status, :RestaurantId)";
        HashMap<String, Object> params = getCartMap(cart);
        namedParameterJdbcTemplate.update(sql, params);
    }

    public Cart getCartById(long id){
        String sql = "SELECT * FROM Cart WHERE CartId = :CartId";
        HashMap<String, Object> params = new HashMap<>();
        params.put("CartId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, params, cartRowMapper);
    }

    public List<Cart> getCartByUserId(long id){
        String sql = "SELECT * FROM Cart WHERE UserId = :UserId AND Status = 1";
        HashMap<String, Object> params = new HashMap<>();
        params.put("UserId", id);
        return namedParameterJdbcTemplate.query(sql, params, cartRowMapper);
    }

    public Cart getCartByUserIdAndRestaurantId(long userId, long restaurantId){
        String sql = "SELECT * FROM Cart WHERE UserId = :UserId AND RestaurantId = :RestaurantId AND Status = 0";
        HashMap<String, Object> params = new HashMap<>();
        params.put("UserId", userId);
        params.put("RestaurantId", restaurantId);
        return namedParameterJdbcTemplate.queryForObject(sql, params, cartRowMapper);
    }
}
