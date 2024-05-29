drop table product
drop TABLE [order]
drop table  orderdetail


CREATE TABLE product (
    id INT IDENTITY(1,1) PRIMARY KEY,
    product_id VARCHAR(10) NOT NULL UNIQUE ,
    product_name VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    quantity INT NOT NULL
);


CREATE TABLE [order] (
    order_id VARCHAR(20) PRIMARY KEY,
    member_id INT NOT NULL,
    price INT NOT NULL,
    paystatus TINYINT NOT NULL CHECK (paystatus IN (0, 1)),

);


CREATE TABLE orderdetail (
    orderitemsn INT IDENTITY(1,1) PRIMARY KEY,
    order_id VARCHAR(20) NOT NULL,
    product_id VARCHAR(10) NOT NULL,
    quantity INT NOT NULL,
    standprice DECIMAL(10, 2) NOT NULL,
    itemprice DECIMAL(10, 2) NOT NULL,

    FOREIGN KEY (order_id) REFERENCES [order] (order_id),

   FOREIGN KEY (product_id) REFERENCES product (product_id)
);

INSERT INTO Product (product_id,product_name, price, quantity) VALUES 
('P001','osii 舒壓按摩椅', 98000, 5),
('P002','網友最愛起司蛋糕', 1200, 50),
('P003','真愛密碼項鍊', 8500, 20),
('P004','test', 1200, 0),
('P005','osii 舒壓按摩椅', 98000, 5),
('P006','網友最愛起司蛋糕', 1200, 0),
('P007','真愛密碼項鍊', 8500, 20);


INSERT INTO [order] (order_id, member_id, Price, PayStatus) VALUES 
('Ms20250801186230', 458, 98000, 1),
('Ms20250805157824', 55688, 9700, 0),
('Ms20250805258200', 1713, 2400, 1);

-- 插入訂單明細資料
INSERT INTO OrderDetail (order_id, product_id, Quantity, StandPrice, ItemPrice) VALUES 
('Ms20250801186230', 'P001', 1, 98000, 98000),
('Ms20250805157824', 'P002', 1, 1200, 1200),
('Ms20250805157824', 'P003', 1, 8500, 8500),
('Ms20250805258200', 'P002', 2, 1200, 2400);




SELECT * FROM Product;
SELECT * FROM  [order];
SELECT * FROM OrderDetail;

