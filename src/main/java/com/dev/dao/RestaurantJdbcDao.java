package com.dev.dao;

import com.dev.models.Restaurant;
// import com.dev.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;

@Component
public class RestaurantJdbcDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public RestaurantJdbcDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private final RowMapper<Restaurant> userRowMapper = (rs, rowNum) -> {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(rs.getLong("RestaurantId"));
        restaurant.setRestaurantName(rs.getString("RestaurantName"));
        restaurant.setRestaurantDescription(rs.getString("RestaurantDescription"));
        restaurant.setStreetAddress(rs.getString("StreetAddress"));
        restaurant.setPhoneNumber(rs.getLong("PhoneNumber"));
        restaurant.setCity(rs.getString("City"));
        restaurant.setPincode(rs.getLong("Pincode"));
        restaurant.setState(rs.getString("State"));
        restaurant.setStartTime(rs.getTime("StartTime"));
        restaurant.setEndTime(rs.getTime("EndTime"));
        restaurant.setRating(rs.getDouble("Rating"));
        restaurant.setNumberOfUsersRated(rs.getLong("NumberOfUsersRated"));
        restaurant.setVegeterian(rs.getBoolean("IsVegeterian"));
        return restaurant;
    };

    private HashMap<String, Object> getRestaurantMap(Restaurant restaurant) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("RestaurantId", restaurant.getRestaurantId());
        map.put("RestaurantName", restaurant.getRestaurantName());
        map.put("RestaurantDescription", restaurant.getRestaurantDescription());
        map.put("StreetAddress", restaurant.getStreetAddress());
        map.put("PhoneNumber", restaurant.getPhoneNumber());
        map.put("City", restaurant.getCity());
        map.put("Pincode", restaurant.getPincode());
        map.put("State", restaurant.getState());
        map.put("StartTime", restaurant.getStartTime());
        map.put("EndTime", restaurant.getEndTime());
        map.put("Rating", restaurant.getRating());
        map.put("NumberOfUsersRated", restaurant.getNumberOfUsersRated());
        map.put("IsVegeterian", restaurant.isVegeterian());
        return map;
    }

    public void createRestaurant(Restaurant restaurant) {
        String sql = "INSERT INTO Restaurant (RestaurantId, RestaurantName, RestaurantDescription, StreetAddress, PhoneNumber, City, Pincode, State, StartTime, EndTime, Rating, NumberOfUsersRated, IsVegeterain) VALUES (:RestaurantId, :RestaurantName, :RestaurantDescription, :StreetAddress, :PhoneNumber, :City, :Pincode, :State, :StartTime, :EndTime, :Rating, :NumberOfUsersRated, :IsVegeterian)";
        HashMap<String, Object> params = getRestaurantMap(restaurant);
        namedParameterJdbcTemplate.update(sql, params);
    }

    public Restaurant getRestaurantById(long id){
        String sql = "SELECT * FROM Restaurant WHERE RestaurantId = :RestaurantId";
        HashMap<String, Object> params = new HashMap<>();
        params.put("RestaurantId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, params, userRowMapper);
    }

    public List<Restaurant> getAllRestaurants() {
        String sql = "SELECT * FROM Restaurant";
        return namedParameterJdbcTemplate.query(sql, userRowMapper);
    }

    public List<Restaurant> getRestaurantWithNameLike(String name) {
        String sql = "SELECT * FROM Restaurant WHERE RestaurantName LIKE :RestaurantName";
        HashMap<String, Object> params = new HashMap<>();
        params.put("RestaurantName", "%"+name+"%");
        return namedParameterJdbcTemplate.query(sql, params, userRowMapper);
    }

    
}
