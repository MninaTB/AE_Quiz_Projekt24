-- Unser Name der Tabelle ist "Fragen" - "Question"

-- The DROP TABLE statement is used to drop an existing table in a database.
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS answers;
DROP TABLE IF EXISTS categories;

CREATE TABLE IF NOT EXISTS categories(
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS answers (
  id INT UNSIGNED AUTO_INCREMENT,
  a VARCHAR(255) NOT NULL,
  b VARCHAR(255) NOT NULL,
  c VARCHAR(255) NOT NULL,
  d VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS questions (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  question VARCHAR(255) NOT NULL,
  difficulty INT NOT NULL,
  answer_id INT UNSIGNED NOT NULL,
  solution INT NOT NULL,
  category_id INT UNSIGNED NOT NULL,
  FOREIGN KEY (answer_id) REFERENCES answers(id) ON DELETE CASCADE,
  FOREIGN KEY (category_id) REFERENCES categories(id),
  PRIMARY KEY (id)
);

