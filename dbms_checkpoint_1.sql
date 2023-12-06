drop database if exists dbms_test;
create database dbms_test;
use dbms_test;

create table users (
	UserId bigint primary key,
    FirstName varchar(50),
    LastName varchar(50),
    PhoneNumber bigint CHECK (PhoneNumber REGEXP '^[0-9]{10}$'),
    Email varchar(255) CHECK (Email REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'),
    UserPassword varchar(100),
    RoleId bigint default 2,
    UNIQUE(email)
);

create table userAddress (
	AddressId bigint primary key,
    UserId bigint,
    StreetAddress text,
    City varchar(50),
    State varchar(50),
    Pincode varchar(10)
);

create table drivers (
	DriverId bigint primary key,
    FirstName varchar(50),
    LastName varchar(50),
    NumberOfUsersRated int,
    PhoneNumber bigint CHECK (PhoneNumber REGEXP '^[0-9]{10}$'),
    Rating double
);
-- done 
create table Promocode (
	PromocodeId bigint primary key,
    PromoName varchar(100),
    StartDate DATE,
    EndDate DATE,
    MinimumOrderValue Decimal(10,2),
    Discount Decimal(4,2) check(0 <= Discount <= 100),
    PromoDescription text
);

create table cart (
	CartId bigint primary key,
    Status boolean,
    UserId bigint,
    Foreign key (UserId) references users(UserId)
);

create table restaurant (
	RestaurantId bigint primary key,
    RestaurantName varchar(50),
    StartTime time,
    EndTime time,
    IsVegeterian boolean,
    PhoneNumber bigint CHECK (PhoneNumber REGEXP '^[0-9]{10}$'),
    StreetAddress text,
    City varchar(50),
    State varchar(50),
    Pincode varchar(10),
    Rating double,
    NumberOfUsersRated int,
    RestaurantDescription text default null
);

create table items (
	ItemId bigint primary key,
    ItemName varchar(255),
    RestaurantId bigint,
    IsVegeterian boolean,
    Price decimal(10,2),
    ItemDescription text,
    IsAvailable boolean,
    Rating double,
    NumberOfUsersRated int,
    Foreign key(RestaurantId) references Restaurant(RestaurantId)
);



create table orders (
	OrderId bigint primary key,
    Amount Decimal(10,2),
    Orderstatus boolean,
    PromocodeId bigint,
    CartId bigint,
    DriverId bigint,
    TrackingUrl varchar(255),
    AddressId bigint,
    Foreign key (PromocodeId) references promocode(PromocodeId),
    Foreign key (DriverId) references drivers(DriverId),
    Foreign key (CartId) references cart(CartId),
    Foreign key (AddressId) references userAddress(AddressId)
);

create table transactions (
	TransactionId bigint primary key,
    OrderId bigint,
    TransactionType varchar(20),
    TransactionStatus varchar(20),
    Foreign key (OrderId) references orders(OrderId)
);

-- done 
create table cartItems (
	CartId bigint,
    ItemId bigint,
    Quantity int,
    primary key(CartId,ItemId),
    Foreign key(CartId) references cart(CartId),
    Foreign key(ItemId) references items(ItemId)
);

create table itemCategory (
	itemId bigint primary key,
    category varchar(255),
    Foreign key(ItemId) references items(ItemId)
);

INSERT INTO users(userid, firstname, lastname, phonenumber, email, userpassword)
VALUES
    (1,'Amit', 'Kumar', 9876543210, 'amit.kumar@example.com', 'password123'),
    (2,'Rajesh', 'Sharma', 9876543211, 'rajesh.sharma@example.com', 'secret456'),
    (3,'Priya', 'Patel', 9876543212, 'priya.patel@example.com', 'secure789'),
    (4,'Sneha', 'Verma', 9876543213, 'sneha.verma@example.com', 'password123'),
    (5,'Rahul', 'Singh', 9876543214, 'rahul.singh@example.com', 'mypassword567'),
    (6,'Neha', 'Gupta', 9876543215, 'neha.gupta@example.com', 'secret789'),
    (7,'Sachin', 'Shah', 9876543216, 'sachin.shah@example.com', 'password123'),
    (8,'Anjali', 'Rao', 9876543217, 'anjali.rao@example.com', 'mypassword123'),
    (9,'Raj', 'Mishra', 9876543218, 'raj.mishra@example.com', 'secure789'),
    (10,'Swati', 'Nair', 9876543219, 'swati.nair@example.com', 'password123'),
    (11,'Deepak', 'Iyer', 9876543220, 'deepak.iyer@example.com', 'secret456'),
    (12,'Kavita', 'Rajput', 9876543221, 'kavita.rajput@example.com', 'password567'),
    (13,'Aditi', 'Kulkarni', 9876543222, 'aditi.kulkarni@example.com', 'mypassword123'),
    (14,'Rajiv', 'Prasad', 9876543223, 'rajiv.prasad@example.com', 'secure789'),
    (15,'Pooja', 'Chopra', 9876543224, 'pooja.chopra@example.com', 'password123'),
    (16,'Vikram', 'Pande', 9876543225, 'vikram.pande@example.com', 'mypassword567'),
    (17,'Sarika', 'Reddy', 9876543226, 'sarika.reddy@example.com', 'secret789'),
    (18,'Gaurav', 'Gupta', 9876543227, 'gaurav.gupta@example.com', 'password123'),
    (19,'Meera', 'Malhotra', 9876543228, 'meera.malhotra@example.com', 'mypassword123'),
    (20,'Sanjay', 'Choudhury', 9876543229, 'sanjay.choudhury@example.com', 'secure789');


INSERT INTO restaurant 
VALUES
    (1,'The Spice Garden', '10:00:00', '22:00:00', 0, 9876543210, '45A Richmond Road', 'Bangalore', 'Karnataka', '560025', 4, 120, 'some description'),
    (2,'Café Royale', '11:30:00', '23:00:00', 1, 9876543211, '22B Park Street', 'Kolkata', 'West Bengal', '700016', 4, 80, 'some description'),
    (3,'Green Valley Bistro', '09:00:00', '21:30:00', 0, 9876543212, '31A Jubilee Hills', 'Hyderabad', 'Telangana', '500033', 5, 150, 'some description'),
    (4,'Taste of India', '12:00:00', '22:30:00', 0, 9876543213, '14C Connaught Place', 'Delhi', 'Delhi', '110001', 3, 200, 'some description'),
    (5,'Spice Junction', '10:30:00', '21:30:00', 0, 9876543214, '7E Brigade Road', 'Bangalore', 'Karnataka', '560001', 4, 100, 'some description'),
    (6,'Saffron Delight', '11:00:00', '22:30:00', 0, 9876543215, '3D MG Road', 'Pune', 'Maharashtra', '411001', 4, 90, 'some description'),
    (7,'Delhi Diner', '09:30:00', '20:00:00', 1, 9876543216, '8B Church Street', 'Chennai', 'Tamil Nadu', '600001', 3, 140, 'some description'),
    (8,'The Royal Tandoor', '12:30:00', '23:30:00', 1, 9876543217, '19A Rajpur Road', 'Dehradun', 'Uttarakhand', '248001', 4, 75, 'some description'),
    (9,'Spice Route', '10:45:00', '21:45:00', 1, 9876543218, '25A Ashoka Road', 'Jaipur', 'Rajasthan', '302001', 4, 110, 'some description'),
    (10,'Mumbai Masala', '09:15:00', '20:15:00', 1, 9876543219, '17B Marine Drive', 'Mumbai', 'Maharashtra', '400001', 5, 180, 'some description'),
    (11,'Tandoor Village', '11:00:00', '22:00:00', 1, 9876543220, '12E Shyambazar', 'Kolkata', 'West Bengal', '700004', 4, 95, 'some description'),
    (12,'Flavors of Kochi', '09:30:00', '20:30:00', 0, 9876543221, '15C Jubilee Hills', 'Hyderabad', 'Telangana', '500033', 3, 60, 'some description'),
    (13,'Gurgaon Grills', '10:15:00', '21:15:00', 0, 9876543222, '9D Connaught Place', 'Delhi', 'Delhi', '110001', 4, 130, 'some description'),
    (14,'Delhi Delights', '12:00:00', '23:00:00', 0, 9876543223, '5E Brigade Road', 'Bangalore', 'Karnataka', '560001', 5, 175, 'some description'),
    (15,'Hyderabadi Spice', '09:45:00', '20:45:00', 0, 9876543224, '2F MG Road', 'Pune', 'Maharashtra', '411001', 4, 105, 'some description'),
    (16,'Patiala Palace', '11:30:00', '22:30:00', 0, 9876543225, '11A Cathedral Road', 'Chennai', 'Tamil Nadu', '600001', 3, 70, 'some description'),
    (17,'Bhopal Bites', '10:00:00', '21:00:00', 1, 9876543226, '7C JLN Marg', 'Jaipur', 'Rajasthan', '302001', 4, 125, 'some description'),
    (18,'Nagpur Spice House', '12:15:00', '23:15:00', 1, 9876543227, '14D Marine Drive', 'Mumbai', 'Maharashtra', '400001', 3, 85, 'some description'),
    (19,'Coimbatore Cuisine', '09:15:00', '20:15:00', 1, 9876543228, '27B Rajpur Road', 'Dehradun', 'Uttarakhand', '248001', 4, 110, 'some description'),
    (20,'Varanasi Vibe', '10:30:00', '21:30:00', 1, 9876543229, '31E City Center', 'Varanasi', 'Uttar Pradesh', '221001', 5, 15, 'some description');



INSERT INTO userAddress
VALUES
    (1, 1, '45A Richmond Road', 'Bangalore', 'Karnataka', '560025'),
    (2, 2,'22B Park Street', 'Kolkata', 'West Bengal', '700016'),
    (3,3, '31A Jubilee Hills', 'Hyderabad', 'Telangana', '500033'),
    (4, 4, '14C Connaught Place', 'Delhi', 'Delhi', '110001'),
    (5,5, '7E Brigade Road', 'Bangalore', 'Karnataka', '560001'),
    (6, 6,'3D MG Road', 'Pune', 'Maharashtra', '411001'),
    (7, 7,'8B Church Street', 'Chennai', 'Tamil Nadu', '600001'),
    (8, 8,'19A Rajpur Road', 'Dehradun', 'Uttarakhand', '248001'),
    (9, 9,'25A Ashoka Road', 'Jaipur', 'Rajasthan', '302001'),
    (10,10, '17B Marine Drive', 'Mumbai', 'Maharashtra', '400001'),
    (11,11,  '12E Shyambazar', 'Kolkata', 'West Bengal', '700004'),
    (12,12, '15C Jubilee Hills', 'Hyderabad', 'Telangana', '500033'),
    (13,13, '9D Connaught Place', 'Delhi', 'Delhi', '110001'),
    (14,14, '5E Brigade Road', 'Bangalore', 'Karnataka', '560001'),
    (15,15, '2F MG Road', 'Pune', 'Maharashtra', '411001'),
    (16,16, '11A Cathedral Road', 'Chennai', 'Tamil Nadu', '600001'),
    (17,17, '27B Rajpur Road', 'Dehradun', 'Uttarakhand', '248001'),
    (18, 18,'7C JLN Marg', 'Jaipur', 'Rajasthan', '302001'),
    (19, 19, '14D Marine Drive', 'Mumbai', 'Maharashtra', '400001'),
    (20,20, '31E City Center', 'Udaipur', 'Rajasthan', '313001');
    
INSERT INTO items
VALUES
    (1,'Deluxe Veg Thali', 1, 1, 129.99, 'A lavish vegetarian thali with assorted dishes.', 1, 4, 120),
    (2,'Non-Veg Platter', 1, 0, 149.99, 'An assorted platter of non-vegetarian delights.', 1, 4, 80),
    (3,'Special Seafood Platter', 1, 0, 179.99, 'A seafood platter with a variety of dishes.', 1, 5, 150),
    (4,'Signature Tandoori Platter', 1, 0, 139.99, 'A selection of tandoori delights.', 1, 5, 200),
    (5,'Gourmet Vegetarian Feast', 1, 1, 124.99, 'A gourmet feast with vegetarian specialties.', 1, 4, 100),
    (6,'Royal Mutton Biryani', 1, 0, 169.99, 'A royal biryani with tender mutton.', 1, 3, 90),
    (7,'Chefs Special Curry', 1, 0, 159.99, 'Chefs special curry with a unique flavor.', 1, 4, 140),
    (8,'Exotic Dessert Platter', 1, 1, 119.99, 'An exotic dessert platter with sweet treats.', 1, 3, 75),
    (9,'Premium Veg Buffet', 1, 1, 144.99, 'A premium buffet with a variety of vegetarian dishes.', 1, 4, 110),
    (10,'Grand Non-Veg Buffet', 1, 0, 159.99, 'A grand buffet featuring non-vegetarian delicacies.', 1, 5, 180),
	(11,'Vegetarian Platter', 2, 1, 219.99, 'An assorted platter of vegetarian delights.', 1, 4, 120),
    (12,'Paneer Special', 2, 1, 249.99, 'Special paneer dish with exotic spices.', 1, 4, 80),
    (13,'Exquisite Veg Biryani', 2, 1, 229.99, 'Exquisite veg biryani with fragrant rice.', 1, 5, 150),
    (14,'Veggie Delight', 2, 1, 219.99, 'A delightful vegetarian dish with fresh veggies.', 1, 5, 200),
    (15,'Tandoori Mushroom', 2, 1, 239.99, 'Tandoori marinated mushrooms with mint chutney.', 1, 4, 100),
    (16,'Indian Spinach Curry', 2, 1, 229.99, 'Delicious spinach curry with Indian spices.', 1, 3, 90),
    (17,'Spicy Veg Kebabs', 2, 1, 219.99, 'Spicy and flavorful vegetarian kebabs.', 1, 4, 140),
    (18,'Veggie Delight Pizza', 2, 1, 229.99, 'A pizza loaded with veggie delights.', 1, 3, 75),
(19,'Creamy Veg Pasta', 2, 1, 239.99, 'Creamy pasta with a variety of vegetables.', 1, 4, 110),
(20,'Choco Nut Sundae', 2, 1, 249.99, 'Indulgent chocolate and nut sundae.', 1, 5, 180),
(21,'Chicken Tandoori', 3, 0, 229.99, 'Tandoori marinated chicken with mint chutney.', 1, 4, 120),
(22,'Fish Curry', 3, 0, 249.99, 'Spicy fish curry with rice.', 1, 4, 80),
(23,'Veg Fried Rice', 3, 1, 219.99, 'Vegetarian fried rice with fresh vegetables.', 1, 5, 150),
(24,'Chicken Shawarma', 3, 0, 219.99, 'Delicious chicken shawarma in pita bread.', 1, 5, 200),
(25,'Egg Biryani', 3, 0, 239.99, 'Flavorful egg biryani with fragrant rice.', 1, 4, 100),
(26,'Paneer Tikka Wrap', 3, 1, 229.99, 'Paneer tikka wrapped in naan bread.', 1, 3, 90),
(27,'Mutton Korma', 3, 0, 219.99, 'Rich and creamy mutton korma.', 1, 4, 140),
(28,'Veg Spring Rolls', 3, 1, 229.99, 'Crispy and tasty vegetable spring rolls.', 1, 3, 75),
(29,'Butter Chicken Pizza', 3, 0, 239.99, 'Pizza topped with butter chicken.', 1, 4, 110),
(30,'Chocolate Lava Cake', 3, 1, 249.99, 'Decadent chocolate lava cake with ice cream.', 1, 5, 180),
(31,'Chicken Biryani', 4, 0, 199.99, 'Aromatic chicken biryani with basmati rice.', 1, 4, 120),
(32,'Butter Chicken', 4, 0, 229.99, 'Creamy butter chicken with naan.', 1, 4, 80),
(33,'Mutton Rogan Josh', 4, 0, 249.99, 'Tender mutton in rich rogan josh gravy.', 1, 5, 150),
(34,'Chicken Curry', 4, 0, 219.99, 'Spicy chicken curry with rice.', 1, 5, 200),
(35,'Fish Fry', 4, 0, 239.99, 'Crispy and spicy fried fish.', 1, 4, 100),
(36,'Egg Biryani', 4, 0, 209.99, 'Flavorful egg biryani with fragrant rice.', 1, 3, 90),
(37,'Mutton Korma', 4, 0, 229.99, 'Rich and creamy mutton korma.', 1, 4, 140),
(38,'Chicken Shawarma', 4, 0, 219.99, 'Delicious chicken shawarma in pita bread.', 1, 3, 75),
(39,'Chicken Tikka', 4, 0, 229.99, 'Spicy and flavorful chicken tikka.', 1, 4, 110),
(40,'Schezwan Prawns', 4, 0, 239.99, 'Spicy Schezwan prawns with noodles.', 1, 5, 180),
(41,'Mutton Biryani', 5, 0, 199.99, 'Flavorful mutton biryani with basmati rice.', 1, 4, 120),
(42,'Chicken Tandoori', 5, 0, 229.99, 'Tandoori marinated chicken with mint chutney.', 1, 4, 80),
(43,'Fish Curry', 5, 0, 249.99, 'Spicy fish curry with rice.', 1, 5, 150),
(44,'Chicken Hakka Noodles', 5, 0, 219.99, 'Stir-fried chicken hakka noodles.', 1, 5, 200),
(45,'Mutton Kebabs', 5, 0, 239.99, 'Succulent mutton kebabs with spices.', 1, 4, 100),
(46,'Butter Chicken Pizza', 5, 0, 209.99, 'Pizza topped with butter chicken.', 1, 3, 90),
(47,'Chicken Korma', 5, 0, 229.99, 'Rich and creamy chicken korma.', 1, 4, 140),
(48,'Chicken Burger', 5, 0, 219.99, 'Juicy chicken burger with fries.', 1, 3, 75),
(49,'Grilled Prawns', 5, 0, 229.99, 'Grilled prawns with a special sauce.', 1, 4, 110),
(50,'Chicken Biryani', 5, 0, 239.99, 'Spicy chicken biryani with aromatic rice.', 1, 5, 180),
(51,'Tandoori Chicken', 6, 0, 199.99, 'Tandoori marinated chicken with mint chutney.', 1, 4, 120),
(52,'Chicken Curry', 6, 0, 229.99, 'Spicy chicken curry with rice.', 1, 4, 80),
(53,'Grilled Salmon', 6, 0, 249.99, 'Grilled salmon with lemon butter sauce.', 1, 5, 150),
(54,'Spicy Chicken Wings', 6, 0, 219.99, 'Spicy and crispy chicken wings.', 1, 5, 200),
(55,'Lamb Chops', 6, 0, 239.99, 'Succulent lamb chops marinated in herbs.', 1, 4, 100),
(56,'Fish Tacos', 6, 0, 209.99, 'Delicious fish tacos with salsa.', 1, 3, 90),
(57,'Beef Steak', 6, 0, 229.99, 'Juicy beef steak cooked to perfection.', 1, 4, 140),
(58,'BBQ Ribs', 6, 0, 219.99, 'Tender BBQ ribs with BBQ sauce.', 1, 3, 75),
(59,'Pork Sausages', 6, 0, 229.99, 'Savory pork sausages grilled to perfection.', 1, 4, 110),
(60,'Seafood Paella', 6, 0, 239.99, 'Traditional seafood paella with saffron rice.', 1, 5, 180),
(61,'Veg Platter', 7, 1, 219.99, 'An assorted platter of vegetarian delights.', 1, 4, 120),
(62,'Paneer Tikka', 7, 1, 249.99, 'Spicy paneer tikka with assorted spices.', 1, 4, 80),
(63,'Veg Biryani', 7, 1, 229.99, 'Flavorful vegetable biryani with raita.', 1, 5, 150),
(64,'Dal Makhani', 7, 1, 219.99, 'Creamy and flavorful dal makhani.', 1, 5, 200),
(65,'Veggie Delight Pizza', 7, 1, 239.99, 'A pizza loaded with veggie delights.', 1, 4, 100),
(66,'Vegetarian Sizzler', 7, 1, 229.99, 'Sizzling platter with vegetarian specialties.', 1, 3, 90),
(67,'Veg Spring Rolls', 7, 1, 219.99, 'Crispy and tasty vegetable spring rolls.', 1, 4, 140),
(68,'Veggie Delight Wrap', 8, 1, 239.99, 'Wrap filled with veggie delights.', 1, 4, 120),
(69,'Mushroom Biryani', 8, 1, 219.99, 'Mushroom biryani with aromatic spices.', 1, 4, 80),
(70,'Palak Paneer', 8, 1, 249.99, 'Delicious palak paneer with naan.', 1, 5, 150),
(71,'Veggie Burger', 8, 1, 229.99, 'Tasty veggie burger with fries.', 1, 5, 200),
(72,'Garden Fresh Salad', 8, 1, 239.99, 'A fresh and healthy garden salad.', 1, 4, 100),
(73,'Veggie Tandoori Platter', 8, 1, 209.99, 'Tandoori platter with assorted veggies.', 1, 3, 90),
(74,'Paneer Butter Masala', 8, 1, 229.99, 'Paneer in rich buttery tomato gravy.', 1, 4, 140),
(75,'Veg Sizzler', 9, 1, 219.99, 'Sizzling platter with vegetarian specialties.', 1, 4, 120),
(76,'Veg Noodles', 9, 1, 239.99, 'Stir-fried vegetarian noodles.', 1, 4, 80),
(77,'Chole Bhature', 9, 1, 229.99, 'Spicy chole bhature served with pickle.', 1, 5, 150),
(78,'Veg Pulao', 9, 1, 219.99, 'Vegetarian pulao with fresh vegetables.', 1, 5, 200),
(79,'Veggie Pizza', 9, 1, 239.99, 'Pizza loaded with veggie toppings.', 1, 4, 100),
(80,'Veggie Kebabs', 9, 1, 229.99, 'Delicious and spicy vegetarian kebabs.', 1, 3, 90),
(81,'Veg Fried Rice', 9, 1, 219.99, 'Fried rice with assorted vegetables.', 1, 4, 140),
(82,'Veggie Delight Salad', 10, 1, 219.99, 'A healthy and delicious veggie salad.', 1, 4, 120),
(83,'Veggie Wrap', 10, 1, 249.99, 'Wrap filled with veggie delights.', 1, 4, 80),
(84,'Veg Manchurian', 10, 1, 229.99, 'Crispy vegetable balls in tangy sauce.', 1, 5, 150),
(85,'Veggie Burger', 10, 1, 219.99, 'Tasty veggie burger with fries.', 1, 5, 200),
(86,'Paneer Tikka', 10, 1, 239.99, 'Spicy paneer tikka with assorted spices.', 1, 4, 100),
(87,'Veggie Sizzler', 10, 1, 229.99, 'Sizzling platter with vegetarian specialties.', 1, 3, 90),
(88,'Veggie Pizza', 10, 1, 219.99, 'Pizza loaded with veggie toppings.', 1, 4, 140),
(89,'Veggie Delight Platter', 11, 1, 219.99, 'An assorted platter of vegetarian delights.', 1, 4, 120),
(90,'Veg Biryani', 11, 1, 249.99, 'Flavorful vegetable biryani with raita.', 1, 4, 80),
(91,'Mushroom Curry', 11, 1, 229.99, 'Spicy mushroom curry with rice.', 1, 5, 150),
(92,'Veggie Noodles', 11, 1, 219.99, 'Stir-fried vegetarian noodles.', 1, 5, 200),
(93,'Aloo Paratha', 11, 1, 239.99, 'Stuffed aloo paratha with yogurt.', 1, 4, 100),
(94,'Dal Tadka', 11, 1, 229.99, 'Delicious dal tadka with Indian spices.', 1, 3, 90),
(95,'Veggie Spring Rolls', 11, 1, 219.99, 'Crispy and tasty vegetable spring rolls.', 1, 4, 140),
(96,'Mixed Grill Platter', 12, 0, 259.99, 'A mix of grilled chicken, mutton, and veggies.', 1, 4, 120),
(97,'Veggie Sizzler', 12, 1, 189.99, 'Sizzling platter with vegetarian specialties.', 1, 4, 80),
(98,'Butter Chicken', 12, 0, 289.99, 'Creamy butter chicken with naan.', 1, 5, 150),
(99,'Mutton Biryani', 12, 0, 279.99, 'Flavorful mutton biryani with basmati rice.', 1, 5, 200),
(100,'Vegetarian Pasta', 12, 1, 199.99, 'Pasta with a variety of fresh vegetables.', 1, 4, 100),
(101,'Chicken Wings', 12, 0, 209.99, 'Spicy and crispy chicken wings.', 1, 3, 90),
(102,'Veggie Burger', 12, 1, 169.99, 'Tasty veggie burger with fries.', 1, 4, 140),
(103,'Seafood Platter', 13, 0, 359.99, 'A platter with assorted seafood delicacies.', 1, 4, 120),
(104,'Veggie Delight Wrap', 13, 1, 199.99, 'Wrap filled with veggie delights.', 1, 4, 80),
(105,'Chicken Shawarma', 13, 0, 249.99, 'Delicious chicken shawarma in pita bread.', 1, 5, 150),
(106,'Pasta Alfredo', 13, 1, 229.99, 'Creamy pasta alfredo with cheese.', 1, 5, 200),
(107,'Spicy Prawns', 13, 0, 269.99, 'Spicy and tangy prawns with a kick.', 1, 4, 100),
(108,'Paneer Tikka Pizza', 13, 1, 189.99, 'Pizza topped with paneer tikka.', 1, 3, 90),
(109,'Tandoori Chicken Salad', 13, 0, 179.99, 'Tandoori chicken served on a bed of salad.', 1, 4, 140),
(110,'Vegetarian Biryani', 14, 1, 199.99, 'Flavorful vegetarian biryani with raita.', 1, 4, 120),
(111,'Grilled Lamb Chops', 14, 0, 299.99, 'Juicy grilled lamb chops with spices.', 1, 4, 80),
(112,'Veggie Noodles', 14, 1, 179.99, 'Stir-fried vegetarian noodles.', 1, 5, 150),
(113,'Chicken Kebabs', 14, 0, 239.99, 'Succulent chicken kebabs marinated in spices.', 1, 5, 200),
(114,'Paneer Butter Masala', 14, 1, 259.99, 'Paneer in rich buttery tomato gravy.', 1, 4, 100),
(115,'Veggie Delight Pizza', 14, 1, 189.99, 'A pizza loaded with veggie delights.', 1, 3, 90),
(116,'Fish Curry', 14, 0, 249.99, 'Spicy fish curry with rice.', 1, 4, 140),
(117,'Chicken Biryani', 15, 0, 299.99, 'Aromatic chicken biryani with basmati rice.', 1, 4, 120),
(118,'Mushroom Masala', 15, 1, 199.99, 'Mushroom masala with Indian spices.', 1, 4, 80),
(119,'Chicken Curry', 15, 0, 269.99, 'Spicy chicken curry with rice.', 1, 5, 150),
(120,'Veg Pulao', 15, 1, 249.99, 'Vegetarian pulao with fresh vegetables.', 1, 5, 200),
(121,'Grilled Salmon', 15, 0, 359.99, 'Grilled salmon with lemon butter sauce.', 1, 4, 100),
(122,'Chicken Burger', 15, 0, 209.99, 'Juicy chicken burger with fries.', 1, 3, 90),
(123,'Vegetable Biryani', 15, 1, 229.99, 'Flavorful vegetable biryani with raita.', 1, 4, 140),
(124,'Veggie Delight Salad', 16, 1, 169.99, 'A healthy and delicious veggie salad.', 1, 4, 120),
(125,'Fish and Chips', 16, 0, 209.99, 'Crispy fish and chips with tartar sauce.', 1, 4, 80),
(126,'Paneer Tikka', 16, 1, 229.99, 'Spicy paneer tikka with assorted spices.', 1, 5, 150),
(127,'Beef Steak', 16, 0, 299.99, 'Juicy beef steak cooked to perfection.', 1, 5, 200),
(128,'Veggie Pizza', 16, 1, 189.99, 'Pizza loaded with veggie toppings.', 1, 4, 100),
(129,'Chicken Alfredo Pasta', 16, 0, 269.99, 'Creamy chicken alfredo pasta with cheese.', 1, 3, 90),
(130,'Mixed Grill Platter', 16, 0, 259.99, 'A mix of grilled chicken, lamb, and veggies.', 1, 4, 140),
(131,'Dal Baati Churma', 17, 1, 189.99, 'Traditional Rajasthani dish with lentils, wheat balls, and sweet.', 1, 4, 120),
(132,'Gatte Ki Sabzi', 17, 1, 199.99, 'Spicy gram flour dumplings in curry.', 1, 4, 80),
(133,'Ker Sangri', 17, 1, 209.99, 'A traditional Rajasthani dish made from dried beans and berries.', 1, 5, 150),
(134,'Rajasthani Thali', 17, 1, 249.99, 'A platter with a variety of Rajasthani dishes.', 1, 5, 200),
(135,'Aloo Pyaaz Paratha', 17, 1, 179.99, 'Stuffed potato and onion paratha.', 1, 4, 100),
(136,'Methi Thepla', 17, 1, 169.99, 'Fenugreek flatbreads from Rajasthan.', 1, 3, 90),
(137,'Mawa Kachori', 17, 1, 199.99, 'Sweet and rich pastry filled with condensed milk.', 1, 4, 140),
(138,'Chole Bhature', 18, 1, 199.99, 'Delhi-style spicy chickpeas with fried bread.', 1, 4, 120),
(139,'Paneer Tikka', 18, 1, 219.99, 'Spicy paneer tikka with assorted spices.', 1, 4, 80),
(140,'Aloo Paratha', 18, 1, 189.99, 'Stuffed potato paratha served with yogurt.', 1, 5, 150),
(141,'Butter pasta', 18, 1, 279.99, 'Creamy butter pasta with richness.', 1, 5, 200),
(142,'Rajma Chawal', 18, 1, 209.99, 'Kidney beans curry with rice.', 1, 4, 100),
(143,'Papri Chaat', 18, 1, 169.99, 'Delhi-style street food with crispy crackers and chutney.', 1, 3, 90),
(144,'Gulab Jamun', 18, 1, 179.99, 'Sweet fried dumplings in sugar syrup.', 1, 4, 140),
(145,'Paneer Butter Masala', 19, 1, 229.99, 'Paneer in rich buttery tomato gravy.', 1, 4, 120),
(146,'Dal Makhani', 19, 1, 209.99, 'Creamy and flavorful dal makhani.', 1, 4, 80),
(147,'Tandoori Roti', 19, 1, 169.99, 'Whole wheat flatbread baked in tandoor.', 1, 5, 150),
(148,'Veg Biryani', 19, 1, 239.99, 'Flavorful vegetable biryani with raita.', 1, 5, 200),
(149,'Malai Kofta', 19, 1, 249.99, 'Deep-fried vegetable balls in creamy tomato gravy.', 1, 4, 100),
(150,'Chana Masala', 19, 1, 189.99, 'Spicy chickpeas curry.', 1, 3, 90),
(151,'Aloo Gobi', 19, 1, 199.99, 'Potato and cauliflower curry.', 1, 4, 140),
(152,'Paneer Tikka Masala', 20, 1, 259.99, 'Paneer tikka in spicy tomato gravy.', 1, 4, 120),
(153,'Veg Pulao', 20, 1, 199.99, 'Vegetarian pulao with fresh vegetables.', 1, 4, 80),
(154,'Butter Naan', 20, 1, 189.99, 'Butter-flavored Indian bread.', 1, 5, 150),
(155,'Palak Paneer', 20, 1, 229.99, 'Delicious palak paneer with naan.', 1, 5, 200),
(156,'Aloo Tikki', 20, 1, 179.99, 'Crispy potato patties served with chutney.', 1, 4, 100),
(157,'Matar Paneer', 20, 1, 189.99, 'Paneer and peas in tomato gravy.', 1, 3, 90),
(158,'Kheer', 20, 1, 169.99, 'Indian rice pudding with cardamom.', 1, 4, 140);

INSERT INTO drivers
VALUES
(1,'Rajesh', 'Kumar', 45, 9876543210, 4.5),
(2,'Amit', 'Singh', 62, 8765432109, 4.2),
(3,'Priya', 'Sharma', 34, 7654321098, 4.8),
(4,'Sandeep', 'Verma', 52, 6543210987, 4.4),
(5,'Anjali', 'Gupta', 70, 5432109876, 4.7),
(6,'Neha', 'Yadav', 28, 4321098765, 4.9),
(7,'Arun', 'Patel', 55, 3210987654, 4.2),
(8,'Suresh', 'Rajput', 41, 2109876543, 4.6),
(9,'Pooja', 'Joshi', 49, 1098765432, 4.3),
(10,'Rahul', 'Malik', 37, 9876543211, 4.8),
(11,'Meera', 'Saxena', 63, 8765432100, 4.5),
(12,'Vikram', 'Gupta', 52, 7654321099, 4.1),
(13,'Deepak', 'Singhania', 58, 6543210988, 4.4),
(14,'Neha', 'Shukla', 47, 5432109877, 4.7),
(15,'Rajendra', 'Gandhi', 38, 4321098766, 4.9),
(16,'Sarita', 'Kapoor', 43, 3210987655, 4.3),
(17,'Sanjay', 'Garg', 50, 2109876544, 4.6),
(18,'Kavita', 'Singhal', 54, 1098765433, 4.2),
(19,'Ramesh', 'Choudhary', 39, 9876543212, 4.8),
(20,'Anita', 'Mishra', 46, 8765432101, 4.5);


INSERT INTO Promocode
VALUES
(1,'SAVE10', '2023-10-01', '2023-10-31', 50.00, 10.00, 'Get 10% off on orders above $50.'),
(2,'FREESHIP', '2023-10-15', '2023-11-15', 30.00, 90.00, 'Free shipping on orders above $30.'),
(3,'HALFOFF', '2023-11-01', '2023-11-30', 75.00, 50.00, '50% off on orders above $75.'),
(4,'NEWUSER15', '2023-10-01', '2023-12-31', 20.00, 15.00, 'New users get 15% off on orders above $20.'),
(5,'WEEKEND20', '2023-10-22', '2023-10-24', 40.00, 20.00, 'Weekend special: 20% off on orders above $40.'),
(6,'LOYALTY5', '2023-10-01', '2024-03-31', 10.00, 5.00, 'Loyalty discount: 5% off on all orders.'),
(7,'EARLYBIRD', '2023-09-15', '2023-10-15', 25.00, 15.00, 'Early bird special: 15% off on orders above $25.'),
(8,'MIDYEAR25', '2023-06-01', '2023-06-30', 100.00, 25.00, 'Mid-year sale: 25% off on orders above $100.'),
(9,'SPECIAL50', '2023-12-24', '2023-12-25', 75.00, 50.00, 'Special holiday offer: 50% off on orders above $75.'),
(10,'SAVEMORE', '2023-11-15', '2023-11-30', 60.00, 30.00, 'Save more: 30% off on orders above $60.'),
(11,'WINTER10', '2023-12-01', '2023-12-31', 50.00, 10.00, 'Winter discount: 10% off on orders above $50.'),
(12,'GREATDEAL', '2023-11-15', '2023-11-30', 80.00, 40.00, 'Great deal: 40% off on orders above $80.'),
(13,'SPRINGSALE', '2023-04-01', '2023-04-15', 35.00, 20.00, 'Spring sale: 20% off on orders above $35.'),
(14,'FLASH25', '2023-10-15', '2023-10-16', 30.00, 25.00, 'Flash sale: 25% off on orders above $30.'),
(15,'EASTER10', '2023-04-10', '2023-04-10', 20.00, 10.00, 'Easter special: 10% off on orders above $20.'),
(16,'MIDWEEK15', '2023-10-18', '2023-10-19', 40.00, 15.00, 'Midweek offer: 15% off on orders above $40.'),
(17,'SUMMER20', '2023-07-01', '2023-08-31', 50.00, 20.00, 'Summer discount: 20% off on orders above $50.'),
(18,'THANKSGIVING', '2023-11-23', '2023-11-23', 45.00, 10.00, 'Thanksgiving special: 10% off on orders above $45.'),
(19,'BACKTOSCHOOL', '2023-08-15', '2023-08-31', 30.00, 15.00, 'Back-to-school offer: 15% off on orders above $30.'),
(20,'HOLIDAY40', '2023-12-24', '2023-12-31', 90.00, 40.00, 'Holiday season: 40% off on orders above $90.');

CREATE TABLE roles(
	roleid bigint NOT NULL PRIMARY KEY,
    rolename VARCHAR(50),
    UNIQUE(rolename)
);

INSERT INTO roles VALUES 
(1, "ROLE_ADMIN"), 
(2, "ROLE_CUSTOMER"), 
(3, "ROLE_RESTAURANT"),
(4,"ROLE_DRIVER");

ALTER TABLE users ADD FOREIGN KEY (roleId) REFERENCES roles(roleid);

INSERT INTO users VALUES (100, "Admin", "", 1234567890, "admin@food.com", "dbms@123", 1);
select * FROM USERS;
USE dbms_test;
SHOW TABLES;

CREATE TABLE privileges(
	id bigint primary key,
    privilege VARCHAR(100)
);




    
    
