-- Unser Name der Tabelle ist "Fragen" - "Question"

-- The DROP TABLE statement is used to drop an existing table in a database.
DROP TABLE IF EXISTS Question;

-- Creates new Table
CREATE TABLE Question(
id INT NOT NULL,
question VARCHAR(255) NOT NULL,
difficulty INT NOT NULL,
answers varchar(255) NOT NULL,
FOREIGN KEY (answers) REFERENCES Answers(answers_other_table),
solution INT NOT NULL,
category VARCHAR NOT NULL,
PRIMARY KEY(id)
)
