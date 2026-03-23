

CREATE DATABASE IF NOT EXISTS driving_school_db;
USE driving_school_db;

-- ── Users (login accounts)
CREATE TABLE IF NOT EXISTS users (
    user_id      VARCHAR(20)  PRIMARY KEY,
    username     VARCHAR(50)  NOT NULL UNIQUE,
    password     VARCHAR(255) NOT NULL,
    role         ENUM('Admin','Student','Instructor') NOT NULL DEFAULT 'Student',
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- ── Sample Data
INSERT IGNORE INTO users VALUES
  ('U001','admin','admin123','Admin',NOW()),



SELECT 'Database setup complete!' AS Status;
