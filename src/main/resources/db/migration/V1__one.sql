
create table  purchase
(
	id serial not null
		constraint purchase_pkey
			primary key,
    age integer not null,
	last_name varchar(255),
	name varchar(255),
	amount real not null,
	count integer not null,
	purchase_date timestamp
);


create table  product
(
	id serial not null
		constraint product_pkey
			primary key,
	name varchar(255)
);


create table  products_purchases
(
	purchase_id bigint not null
		constraint fk_Purchase
			references purchase,
	product_id bigint not null
		constraint fk_Product
			references product
);
