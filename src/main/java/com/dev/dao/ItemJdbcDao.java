package com.dev.dao;

import com.dev.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

import java.util.HashMap;

@Component
public class ItemJdbcDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ItemJdbcDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private final RowMapper<Item> userRowMapper = (rs, rowNum) -> {
        Item item = new Item();
        item.setItemId(rs.getLong("ItemId"));
        item.setItemName(rs.getString("ItemName"));
        item.setRestaurantId(rs.getLong("RestaurantId"));
        item.setVegeterian(rs.getBoolean("IsVegeterian"));
        item.setPrice(rs.getDouble("Price"));
        item.setItemDescription(rs.getString("ItemDescription"));
        item.setAvailable(rs.getBoolean("IsAvailable"));
        item.setRating(rs.getDouble("Rating"));
        item.setNumberOfUsersRated(rs.getLong("NumberOfUsersRated"));
        return item;
    };

    private HashMap<String, Object> getItemMap(Item item) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ItemId", item.getItemId());
        map.put("ItemName", item.getItemName());
        map.put("RestaurantId", item.getRestaurantId());
        map.put("IsVegeterian", item.isVegeterian());
        map.put("Price", item.getPrice());
        map.put("ItemDescription", item.getItemDescription());
        map.put("IsAvailable", item.isAvailable());
        map.put("Rating", item.getRating());
        map.put("NumberOfUsersRated", item.getNumberOfUsersRated());
        return map;
    }

    public void createItem(Item item) {
        String sql = "INSERT INTO Items (ItemId, ItemName, RestaurantId, IsVegeterian, Price, ItemDescription, IsAvailable, Rating, NumberOfUsersRated) VALUES (:ItemId, :ItemName, :RestaurantId, :IsVegeterian, :Price, :ItemDescription, :IsAvailable, :Rating, :NumberOfUsersRated)";
        HashMap<String, Object> params = getItemMap(item);
        namedParameterJdbcTemplate.update(sql, params);
    }

    public Item getItemById(long id){
        String sql = "SELECT * FROM Items WHERE ItemId = :ItemId";
        HashMap<String, Object> params = new HashMap<>();
        params.put("ItemId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, params, userRowMapper);
    }

    public List<Item> getAllItemsbyRestaurantId(long id) {
        String sql = "SELECT * FROM Items WHERE RestaurantId = :RestaurantId";
        HashMap<String, Object> params = new HashMap<>();
        params.put("RestaurantId", id);
        return namedParameterJdbcTemplate.query(sql, params, userRowMapper);
    }
}
