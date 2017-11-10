RENAME TABLE ITEMS_ON_ORDER TO ITEMGROUP;

ALTER TABLE ITEMGROUP(
ADD COLUMN AMOUNT INT(10),
ADD COLUMN SHIPPING_DATE DATE NOT NULL
);

ALTER TABLE ORDERS(
ADD COLUMN TOTAL_PRICE DECIMAL(10, 2)
);

