create table if not exists Ingredient (
                                          id varchar(4) not null,
                                          name varchar(25) not null,
                                          type varchar(10) not null
);

CREATE TABLE IF NOT EXISTS Burger (
                                      id identity,
                                      name varchar(50) NOT NULL,
                                      created_At timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS Burger_Ingredients (
                                                  burger_id bigint NOT NULL,
                                                  ingredients_id varchar(4) NOT NULL
);

ALTER TABLE Burger_Ingredients ADD FOREIGN KEY (burger_id) REFERENCES Burger(id);
ALTER TABLE Burger_Ingredients ADD FOREIGN KEY (ingredients_id) REFERENCES Ingredient(id);

CREATE TABLE IF NOT EXISTS Burger_Order (
                                            id identity,
                                            delivery_Name varchar(50) NOT NULL,
                                            delivery_Street varchar(50) NOT NULL,
                                            delivery_City varchar(50) NOT NULL,
                                            delivery_State varchar(10) NOT NULL,
                                            delivery_Zip varchar(10) NOT NULL,
                                            cc_Number varchar(16) NOT NULL,
                                            cc_Expiration varchar(5) NOT NULL,
                                            cc_CVV varchar(3) NOT NULL,
                                            placed_At timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS Burger_Order_Burger (
                                                    order_id bigint NOT NULL,
                                                    burger_id bigint NOT NULL
);

ALTER TABLE Burger_Order_Burger ADD FOREIGN KEY (order_id) REFERENCES Burger_Order(id);
ALTER TABLE Burger_Order_Burger ADD FOREIGN KEY (burger_id) REFERENCES Burger(id);
