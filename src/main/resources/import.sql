INSERT INTO `authors` (`id`, `name`, `gender`, `born`) VALUES (1, 'Шкляр Василь Миколайович', 'MALE', '1951-06-10');
INSERT INTO `authors` (`id`, `name`, `gender`, `born`) VALUES (2, 'Joshua Bloch', 'MALE', '1961-07-28');
INSERT INTO `authors` (`id`, `name`, `gender`, `born`) VALUES (3, 'Martin Fowler','MALE', null);
INSERT INTO `authors` (`id`, `name`, `gender`, `born`) VALUES (4, 'Chad Fowler','MALE', null);
INSERT INTO `authors` (`id`, `name`, `gender`, `born`) VALUES (5, 'J. K. Rowling', 'FEMALE', '1965-07-31');
INSERT INTO `authors` (`id`, `name`, `gender`, `born`) VALUES (6, 'Dan Brown','MALE', '1964-06-22');
INSERT INTO `authors` (`id`, `name`, `gender`, `born`) VALUES (7, 'Suzanne Collins', 'FEMALE', '1962-08-10');

INSERT INTO `books` (`id`, `name`,`published`, `genre`,`rating`) VALUES (1, 'Залишенець. Чорний ворон', null, 'historical novel', '5');
INSERT INTO `books` (`id`, `name`,`published`, `genre`,`rating`) VALUES (2, 'Ключ', '1999-01-01', 'novel', '3');
INSERT INTO `books` (`id`, `name`,`published`, `genre`,`rating`) VALUES (3, 'Effective Java: Programming Language Guide', '2001-03-02', 'technical', '5');
INSERT INTO `books` (`id`, `name`,`published`, `genre`,`rating`) VALUES (4, 'Java Concurrency in Practice', '2006-04-23', 'technical', '4');
INSERT INTO `books` (`id`, `name`,`published`, `genre`,`rating`) VALUES (5, 'Java Puzzlers: Traps, Pitfalls, and Corner Cases', '2005-02-02', 'technical', '4');
INSERT INTO `books` (`id`, `name`,`published`, `genre`,`rating`) VALUES (6, 'Patterns of Enterprise Application Architecture', '2002-06-25', 'technical', '3');
INSERT INTO `books` (`id`, `name`,`published`, `genre`,`rating`) VALUES (7, 'Harry Potter and the Philosophers Stone', '1997-06-26', 'fantasy', '5');
INSERT INTO `books` (`id`, `name`,`published`, `genre`,`rating`) VALUES (8, 'The Passionate Programmer', '1999-09-21', 'education', '5');
INSERT INTO `books` (`id`, `name`,`published`, `genre`,`rating`) VALUES (9, 'The Lost Symbol', null, 'crime', '4');

INSERT INTO `author_book` (`author_id`, `book_id`) VALUES (1, 1);
INSERT INTO `author_book` (`author_id`, `book_id`) VALUES ( 2, 1);
INSERT INTO `author_book` (`author_id`, `book_id`) VALUES ( 3, 2);
INSERT INTO `author_book` (`author_id`, `book_id`) VALUES ( 4, 2);
INSERT INTO `author_book` (`author_id`, `book_id`) VALUES ( 5, 2);
INSERT INTO `author_book` (`author_id`, `book_id`) VALUES ( 6, 3);
INSERT INTO `author_book` (`author_id`, `book_id`) VALUES ( 9, 6);
INSERT INTO `author_book` (`author_id`, `book_id`) VALUES ( 8, 4);
INSERT INTO `author_book` (`author_id`, `book_id`) VALUES ( 7, 5);
