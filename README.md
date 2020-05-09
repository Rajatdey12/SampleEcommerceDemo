This is a Sample Backend Application which implements a simple e-Commerce website functionality.
What it does: 
A basic "CRUD" operation.
Joining of 3 tables to fianlly place Order
Manipulate the USER, PRODUCT & SHOPPING CART Details

SETTING UP OF THE DATABASE :
Install MySQL
Create a Database with name rajat
username: root
password: password
(Port and URL will be default. No need to modify. After setup you can try test connection and check the Database name)
USE THESE COMMANDS IN SQL QUERY:-
SHOW DATABASES;
USE rajat;

CREATE THREE TABLES:-
CREATE TABLE product (id long, name VARCHAR(20),
       description VARCHAR(50), quantity Integer, unit_price double);
	   
	   
CREATE TABLE user (id long, name VARCHAR(20), email VARCHAR(30));
	   
CREATE TABLE shopping_cart (id long, user_id VARCHAR(20),
       product_id VARCHAR(20), stock Integer, amount double, status varchar(20), date VARCHAR(30));
       
For Connection you can refer the application.properties file

FOR USING DUMMY REQUEST BODY, PLEASE REFER THE requestbody.json FILE.

ENDPOINTS:-
USER ENDPOINT:

For Adding Users
http://localhost:8080/users/addUsers

For Getting All Users
http://localhost:8080/users/allusers

For Getting users by ID
http://localhost:8080/users/{id}

For Deleting User by ID
http://localhost:8080/users/deleteUser/{id}

For Deleting User
http://localhost:8080/users/deleteUser

PRODUCT ENDPOINT:

For Adding Product
http://localhost:8080/products/addProducts

For Delete all Product
http://localhost:8080/products/deleteAllProduct

For delete product by ID
http://localhost:8080/products/deleteProduct/{id}

For Getting Product by ID
http://localhost:8080/products/getProduct/{id}

Get All Products
http://localhost:8080/products


SHOPPING CART ENDPOINT:

For adding to shopping Cart:
http://localhost:8080/shoppingCart/addItem

For getting all cart item:
http://localhost:8080/shoppingCart

For getting cart item by id
http://localhost:8080/shoppingCart/cartItems/{id}

For deleting cart item by ID
http://localhost:8080/shoppingCart/delete/{id}

For deleting all cart item
http://localhost:8080/shoppingCart/deleteAll

For updating cart item
http://localhost:8080/shoppingCart//updateItem/{id}

Purchasing Item in the Cart
http://localhost:8080/shoppingCart/purchase/{id}

HISTORY ENDPOINT TO CHECK ORDER HISTORY:
http://localhost:8080/history

