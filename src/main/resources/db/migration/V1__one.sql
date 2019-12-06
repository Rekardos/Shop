create table customer
(
	id bigint not null
		constraint customer_pkey
			primary key,
	age integer not null,
	last_name varchar(255),
	name varchar(255)
);


create table  orders
(
	id bigint not null
		constraint orders_pkey
			primary key,
	amount real not null,
	count integer not null,
	purchase_date timestamp
);


create table  product
(
	id bigint not null
		constraint product_pkey
			primary key,
	name varchar(255),
	price real not null
);



create table  orders_products
(
	orders_id bigint not null
		constraint fk_Order
			references orders,
	products_id bigint not null
		constraint fk_Product
			references product
);
