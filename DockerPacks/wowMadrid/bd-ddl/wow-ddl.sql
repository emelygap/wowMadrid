\c wow;

DROP TABLE IF EXISTS bookmark;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS locations;
DROP TABLE IF EXISTS areas;
DROP TABLE IF EXISTS districts;

CREATE TABLE districts(
	id SERIAL NOT NULL,
 	"district_name" VARCHAR(100) NOT NULL UNIQUE,
 	
	CONSTRAINT pk_districts PRIMARY KEY (id)
);

CREATE TABLE areas(
	id SERIAL NOT NULL,
 	"street_address" VARCHAR NOT NULL,
 	"postal_code" VARCHAR(15) NOT NULL,
 	
	CONSTRAINT pk_areas PRIMARY KEY (id)
);

CREATE TABLE locations(
	id SERIAL NOT NULL,
 	latitude VARCHAR(50) NOT NULL,
	longitude VARCHAR(50) NOT NULL,
 	
	CONSTRAINT pk_locations PRIMARY KEY (id)
);

CREATE TABLE users(
	id SERIAL NOT NULL,
 	"name" VARCHAR(100) NOT NULL,
 	"last_name" VARCHAR(100) NOT NULL,
 	email_address VARCHAR(30)UNIQUE NOT NULL,
 	username VARCHAR(100) NOT NULL,
 	"password" VARCHAR(200) NOT NULL,
 	"profile_picture" BYTEA,
 	
	CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE addresses(
	id SERIAL NOT NULL,
	"area" INTEGER,
	district INTEGER,
 	
	CONSTRAINT pk_addresses PRIMARY KEY (id),
	--CONSTRAINT uk_addresses UNIQUE ("area", district),
	CONSTRAINT fk_addresses_area FOREIGN KEY ("area") REFERENCES areas(id) ON DELETE SET NULL,
	CONSTRAINT fk_addresses_district FOREIGN KEY (district) REFERENCES districts(id) ON DELETE SET NULL
);

CREATE TABLE events(
	id VARCHAR(15) NOT NULL,
 	title VARCHAR NOT NULL,
 	description VARCHAR,
 	"type" VARCHAR(150),
 	"free" BOOLEAN,
 	price VARCHAR,
 	"date_start" DATE NOT NULL,
 	"date_end" DATE NOT NULL,
 	"time" TIME,
 	"location_name" VARCHAR(150),
 	address INTEGER,
 	"location" INTEGER,
 	
	CONSTRAINT pk_events PRIMARY KEY (id),
	CONSTRAINT fk_events_address FOREIGN KEY (address) REFERENCES addresses(id) ON DELETE SET NULL,
	CONSTRAINT fk_events_location FOREIGN KEY ("location") REFERENCES locations(id) ON DELETE SET NULL
);

CREATE TABLE bookmark(
	"id_user" INTEGER NOT NULL,
	"id_event" VARCHAR(15) NOT NULL,
 	
	CONSTRAINT pk_bookmark PRIMARY KEY ("id_user", "id_event"),
	CONSTRAINT fk_bookmark_id_user FOREIGN KEY ("id_user") REFERENCES users(id) ON DELETE CASCADE,
	CONSTRAINT fk_bookmark_id_event FOREIGN KEY ("id_event") REFERENCES events(id) ON DELETE CASCADE
);
