-- Create table for Category
CREATE TABLE category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          created_at DATETIME,
                          updated_at DATETIME,
                          is_deleted BOOLEAN,
                          title VARCHAR(255) NOT NULL
);

-- Create table for Product
CREATE TABLE product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         created_at DATETIME,
                         updated_at DATETIME,
                         is_deleted BOOLEAN,
                         title VARCHAR(255) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL,
                         description TEXT,
                         image_url VARCHAR(255),
                         category_id INT,
                         FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);
