/*
Created: 17/02/2024
Modified: 17/02/2024
Model: PostgreSQL 12
Database: PostgreSQL 12
*/

-- Create tables section -------------------------------------------------

-- Table CLIENTS

CREATE TABLE "CLIENTS"
(
  "client_id" Character varying NOT NULL,
  "name" Character varying,
  "mobile_phone" Character varying,
  "email" Character varying
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE "CLIENTS" ADD CONSTRAINT "PK_CLIENTS" PRIMARY KEY ("client_id")
;

-- Table PRODUCTS_TYPE

CREATE TABLE "PRODUCTS_TYPE"
(
  "product_type_id" Character varying NOT NULL,
  "description" Character varying
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE "PRODUCTS_TYPE" ADD CONSTRAINT "PK_PRODUCTS_TYPE" PRIMARY KEY ("product_type_id")
;

-- Table DESTINATIONS

CREATE TABLE "DESTINATIONS"
(
  "destination_id" Character varying NOT NULL,
  "type" Character varying,
  "name" Character varying,
  "location" Character varying,
  "ability" Character varying
)
WITH (
  autovacuum_enabled=true)
;

ALTER TABLE "DESTINATIONS" ADD CONSTRAINT "PK_DESTINATIONS" PRIMARY KEY ("destination_id")
;

-- Table SHIPPING

CREATE TABLE "SHIPPING"
(
  "shipping_id" Character varying NOT NULL,
  "shipping_type" Character varying,
  "quantity_product" Numeric,
  "registration_date" Date,
  "deliver_date" Date,
  "price_shipping" Double precision,
  "final_price" Double precision,
  "discount_applied" Character varying,
  "vehicle_number" Character varying,
  "guide_number" Character varying,
  "product_type_id" Character varying,
  "client_id" Character varying,
  "destination_id" Character varying
)
WITH (
  autovacuum_enabled=true)
;

CREATE INDEX "IX_Relationship1" ON "SHIPPING" ("product_type_id")
;

CREATE INDEX "IX_Relationship2" ON "SHIPPING" ("client_id")
;

CREATE INDEX "IX_Relationship3" ON "SHIPPING" ("destination_id")
;

ALTER TABLE "SHIPPING" ADD CONSTRAINT "PK_SHIPPING" PRIMARY KEY ("shipping_id")
;

-- Create foreign keys (relationships) section -------------------------------------------------

ALTER TABLE "SHIPPING"
  ADD CONSTRAINT "prty_ship_fk"
    FOREIGN KEY ("product_type_id")
    REFERENCES "PRODUCTS_TYPE" ("product_type_id")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE "SHIPPING"
  ADD CONSTRAINT "clie_ship_fk"
    FOREIGN KEY ("client_id")
    REFERENCES "CLIENTS" ("client_id")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

ALTER TABLE "SHIPPING"
  ADD CONSTRAINT "dest_ship_fk"
    FOREIGN KEY ("destination_id")
    REFERENCES "DESTINATIONS" ("destination_id")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
;

