CREATE TABLE `author` (
  id   BIGINT       NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX (name)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `publisher` (
  id   BIGINT       NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX (name)
) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `book` (
  id           BIGINT       NOT NULL AUTO_INCREMENT,
  name         VARCHAR(255) NOT NULL,
  author_id    BIGINT       NOT NULL,
  publisher_id BIGINT       NOT NULL,
  PRIMARY KEY (`id`),
  INDEX (name),

  FOREIGN KEY (author_id)
  REFERENCES author(id),

  FOREIGN KEY (publisher_id)
  REFERENCES publisher(id)

) ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW `bookdata` (
    id,
    name,
    author_id,
    author_name,
    publisher_id,
    publisher_name
) AS
    SELECT
      book.id   as id,
      book.name as name,
      a.id      as author_id,
      a.name    as author_name,
      p.id      as publisher_id,
      p.name    as publisher_name
    FROM book
      LEFT JOIN author    a ON book.author_id = a.id
      LEFT JOIN publisher p ON book.publisher_id = p.id
    ORDER BY book.id
