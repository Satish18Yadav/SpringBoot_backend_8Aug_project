-- V2__insert_data.sql
-- Insert data into category
INSERT INTO category (created_at, updated_at, is_deleted, title)
VALUES
    (NOW(), NOW(), FALSE, 'Electronics'),
    (NOW(), NOW(), FALSE, 'Books');

-- Insert data into product
INSERT INTO product (created_at, updated_at, is_deleted, title, price, description, image_url, category_id)
VALUES
    (NOW(), NOW(), FALSE, 'Smartphone', 599.99, 'Latest 5G smartphone', 'https://example.com/smartphone.jpg', 1),
    (NOW(), NOW(), FALSE, 'Laptop', 1299.99, 'High performance laptop', 'https://example.com/laptop.jpg', 1),
    (NOW(), NOW(), FALSE, 'Headphones', 199.99, 'Noise-cancelling headphones', 'https://example.com/headphones.jpg', 1),
    (NOW(), NOW(), FALSE, 'Camera', 749.99, 'DSLR camera', 'https://example.com/camera.jpg', 1),
    (NOW(), NOW(), FALSE, 'Book A', 19.99, 'Fictional novel', 'https://example.com/book_a.jpg', 2),
    (NOW(), NOW(), FALSE, 'Book B', 24.99, 'Non-fictional book', 'https://example.com/book_b.jpg', 2),
    (NOW(), NOW(), FALSE, 'Tablet', 399.99, '10-inch tablet', 'https://example.com/tablet.jpg', 1),
    (NOW(), NOW(), FALSE, 'Smartwatch', 199.99, 'Fitness tracking smartwatch', 'https://example.com/smartwatch.jpg', 1);
