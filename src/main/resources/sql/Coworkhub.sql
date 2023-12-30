drop database workspaceManagementSystem;

create database workspaceManagementSystem;

use workspaceManagementSystem;
-- Employee table
CREATE TABLE employee (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    tel INT(10) NOT NULL,
    email VARCHAR(30),
    position VARCHAR(50)
);

-- User table
CREATE TABLE user (
    empid VARCHAR(10),
    username VARCHAR(100) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    CONSTRAINT foreign_key_user_empid FOREIGN KEY (empid) REFERENCES employee (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Member table
CREATE TABLE member (
    id VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(30) NOT NULL,
    address VARCHAR(100) NOT NULL,
    dob DATE,
    age INT,
    profession VARCHAR(50) NOT NULL,
    loyalty DOUBLE,
    phone VARCHAR(15),
    emergency_contact VARCHAR(100)
);

-- Orders table
CREATE TABLE orders (
    id VARCHAR(10) PRIMARY KEY,
    total_price DOUBLE NOT NULL,
    date DATE NOT NULL,
    member_id VARCHAR(10),
    payment_method VARCHAR(20),
    CONSTRAINT foreign_key_orders_member_id FOREIGN KEY (member_id) REFERENCES member (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Beverage table
CREATE TABLE beverage (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(150) NOT NULL,
    price DOUBLE
);

-- Order_detail table
CREATE TABLE order_detail (
	order_id VARCHAR(10) PRIMARY KEY,
    beverage_id VARCHAR(10),
    member_id VARCHAR(10),
    qty INT,
    order_date DATE,
    CONSTRAINT foreign_key_order_detail_beverage_id FOREIGN KEY (beverage_id) REFERENCES beverage (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT foreign_key_order_detail_member_id FOREIGN KEY (member_id) REFERENCES member (id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Workspace table
CREATE TABLE workspace (
    id VARCHAR(10) PRIMARY KEY,
    description VARCHAR(150) NOT NULL,
    availability VARCHAR(5) NOT NULL,
    price DOUBLE,
    type VARCHAR(20) NOT NULL,
    capacity INT
);

CREATE TABLE package (
    id VARCHAR(10) PRIMARY KEY,
    package_name VARCHAR(10) NOT NULL,
    description VARCHAR(150) NOT NULL,
    price DOUBLE
);


-- Reservation_detail table
CREATE TABLE reservation (
	id VARCHAR(10) PRIMARY KEY,
    package_id VARCHAR(10),
    workspace_id VARCHAR(10),
	reserved_date DATE,
    total_price DOUBLE,
    CONSTRAINT  FOREIGN KEY (workspace_id) REFERENCES workspace (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT  FOREIGN KEY (package_id) REFERENCES package(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Package table

-- Workspace_package table
CREATE TABLE reservation_detail (
	reservation_id VARCHAR(10),
    member_id VARCHAR(10),
    member_name VARCHAR(10),
    package_name VARCHAR(10),
    workspace_id VARCHAR(10),
    workspace_type VARCHAR(10),
    CONSTRAINT foreign_key_reservation_detail_workspace_id FOREIGN KEY (workspace_id) REFERENCES workspace (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT foreign_key_reservation_detail_member_id FOREIGN KEY (member_id) REFERENCES member (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (reservation_id) REFERENCES reservation(id) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE message (
    content TEXT NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

