---------------------------
-- Created by Niklas N.
---------------------------

-- Unser Name der Tabelle ist "Fragen"

-- The DROP TABLE statement is used to drop an existing table in a database.
DROP TABLE IF EXISTS Fragen;

-- Creates new Table
CREATE TABLE Fragen(
ID INT NOT NULL,
QUESTIONS VARCHAR(5) NOT NULL,
DIFFICULTY INT NOT NULL,
ANSWERS VARCHAR(20),
SOLUTION INT,
CATEGORY VARCHAR,
PRIMARY KEY(id)
)

-- Insert Values into Database
INSERT INTO Fragen (ID, QUESTIONS, DIFFICULTY, ANSWERS, SOLUTION, CATEGORY)
VALUES ("ID", "QUESTIONS", "DIFFICULTY", "ANSWERS", "SOLUTION", "CATEGORY");

-- The ALTER TABLE statement is used to add, delete, or modify columns in an existing table.
-- Example
ALTER TABLE Fragen
ADD MailFromUser VARCHAR(255);

-- The SELECT statement is used to select data from a database.
SELECT ID, QUESTIONS FROM Fragen;