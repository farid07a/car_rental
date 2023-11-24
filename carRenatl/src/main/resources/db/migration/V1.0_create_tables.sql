DROP TABle IF EXISTS order_table;
DROP TABle IF EXISTS car_table;
DROP TABle IF EXISTS user_table;

CREATE TABLE user_table 
(
	user_id BIGSERIAL PRIMARY KEY,
	user_name VARCHAR (100),
	user_email VARCHAR (100) NOT NULL UNIQUE,
	user_password VARCHAR (100) NOT NULL ,
	user_address VARCHAR (250) NOT NULL,
	user_blocked BOOL DEFAULT false,
	user_role VARCHAR (50)
);


CREATE TABLE car_table
(
 	car_id BIGSERIAL PRIMARY KEY,
	car_model VARCHAR (100),
	car_release_year VARCHAR (100),
	car_color VARCHAR (100),
	car_company VARCHAR (100)
);


CREATE TABLE order_table 
(
 
 	order_id BIGSERIAL PRIMARY KEY ,
	user_id BIGINT REFERENCES user_table(user_id) ,
	car_id BIGINT ,
	order_date DATE ,
	return_date DATE,
	car_reurned BOOL DEFAULT false,
	rental_cost NUMERIC (7,2), /*10000.22**/
 	FOREIGN KEY (car_id) REFERENCES car_table (car_id)
)



