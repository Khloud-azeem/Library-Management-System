CREATE TABLE books (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  publication_year INT NOT NULL,
  isbn VARCHAR(20) NOT NULL
);

CREATE TABLE patrons (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  contact_info VARCHAR(255) NOT NULL
);

CREATE TABLE borrowing_records (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  book_id BIGINT,
  patron_id BIGINT,
  borrow_date DATE,
  return_date DATE,
  FOREIGN KEY (book_id) REFERENCES books(id),
  FOREIGN KEY (patron_id) REFERENCES patrons(id)
);
