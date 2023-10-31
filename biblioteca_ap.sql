CREATE DATABASE IF NOT EXISTS biblioteca_ap;

-- Ejecutar estas cargas luego de ejecutar el proyecto spring

USE biblioteca_ap;

INSERT INTO author (is_enabled, name) VALUES
(1, 'John Smith'),
(1, 'Alice Johnson'),
(1, 'David Brown'),
(1, 'Emily Davis'),
(1, 'Michael Wilson');

INSERT INTO editorial (is_enabled, name) VALUES
(1, 'Book World'),
(1, 'Mystery Publications'),
(1, 'Adventure Books'),
(1, 'Enchanted Press');

INSERT INTO book (borrowed_copies, copies, is_enabled, isbn, remaining_copies, title, year, editorial_id) VALUES
(5, 20, 1, 1234567890, 15, 'The Great Adventure', 2005, 1),
(3, 10, 1, 9876543210, 7, 'Mystery in the Forest', 2010, 2),
(2, 15, 1, 4567890123, 13, 'Lost and Found', 2018, 3),  
(0, 5, 1, 5678901234, 5, 'The Secret Code', 2015, 4),   
(7, 12, 1, 3456789012, 5, 'Hidden Treasures', 2009, 2); 

INSERT INTO book_author_list (book_id, author_list_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 5);
