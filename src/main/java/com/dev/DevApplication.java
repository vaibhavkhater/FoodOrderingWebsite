package com.dev;

// import com.dev.dao.RestaurantJdbcDao;
import com.dev.dao.UserJdbcDao;
// import com.dev.models.Item;
// import com.dev.models.Restaurant;
// import com.dev.models.User;
import com.dev.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import com.dev.dao.ItemJdbcDao;

@SpringBootApplication
public class DevApplication {

    public static void main(String[] args) {
        // for testing purposes
        var context = SpringApplication.run(DevApplication.class, args);
         UserJdbcDao userJdbcDao = context.getBean(UserJdbcDao.class);
         User admin = userJdbcDao.getUserById(100);
         System.out.println(admin);
        // User rohith = new User("Rohith", "Peddi", 1234567890, "dev@rohith.pro","password");
        // userJdbcDao.createUser(rohith);
        // User inserted = userJdbcDao.getUserById(rohith.getUserId());
        // System.out.println(inserted);
        // Restaurant r = new Restaurant("Capsicum", null, null, 1234567890, "Lanka complex", "Varanasi", "Uttar Pradesh", 221005, 4.75, 10, "Capsicum Restaurant is the best restaurant in the world!");
        // RestaurantJdbcDao restaurantJdbcDao = context.getBean(RestaurantJdbcDao.class);
        // restaurantJdbcDao.createRestaurant(r);
        // Restaurant insertedRestaurant = restaurantJdbcDao.getRestaurantById(r.getRestaurantId());
        // System.out.println(insertedRestaurant);
        // Item i = new Item("Veg Biryani", r.getRestaurantId(), true, 200, "Veg biryani is the best biryani in the world!", true, 4.5, 10);
        // ItemJdbcDao itemJdbcDao = context.getBean(ItemJdbcDao.class);
        // itemJdbcDao.createItem(i);
        // Item insertedItem = itemJdbcDao.getItemById(i.getItemId());
        // System.out.println(insertedItem);
    }

}
