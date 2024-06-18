-- Create the MOCK_DATA2 table
CREATE TABLE MOCK_DATA2 (
    employee_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    date_of_birth DATE,
    department VARCHAR(9),
    salary DECIMAL(8,2),
    hire_date DATE,
    manager_id INT,
    job_title VARCHAR(50)
);

-- Insert sample data into the MOCK_DATA2 table
INSERT INTO MOCK_DATA2 (employee_id, first_name, last_name, email, date_of_birth, department, salary, hire_date, manager_id, job_title) VALUES
(101, 'Alice', 'Wonderland', 'alice.wonderland@example.com', '1995-09-15', 'Finance', 80000.00, '2022-05-20', 3, 'Accountant');

-- Combine results from MOCK_DATA and MOCK_DATA2 using UNION
SELECT first_name, last_name, email FROM MOCK_DATA
UNION
SELECT first_name, last_name, email FROM MOCK_DATA2;


--SELECT INTO
-- Create a backup table and copy data into it using SELECT INTO
SELECT * INTO MOCK_DATA_BACKUP FROM MOCK_DATA;

--INSERT INTO SELECT
-- Create the MOCK_DATA_NEW table
CREATE TABLE MOCK_DATA_NEW (
    employee_id INT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50),
    date_of_birth DATE,
    department VARCHAR(9),
    salary DECIMAL(8,2),
    hire_date DATE,
    manager_id INT,
    job_title VARCHAR(50)
);

-- Insert data from MOCK_DATA into MOCK_DATA_NEW using INSERT INTO SELECT
INSERT INTO MOCK_DATA_NEW (employee_id, first_name, last_name, email, date_of_birth, department, salary, hire_date, manager_id, job_title)
SELECT employee_id, first_name, last_name, email, date_of_birth, department, salary, hire_date, manager_id, job_title
FROM MOCK_DATA;

--CREATE DATABASE
CREATE DATABASE MyDatabase;

--CREATE TABLE WITH CONSTRAINTS
CREATE TABLE EmployeesWithConstraints (
    employee_id INT PRIMARY KEY, -- Primary Key constraint
    first_name VARCHAR(50) NOT NULL, -- NOT NULL constraint
    last_name VARCHAR(50) NOT NULL, -- NOT NULL constraint
    email VARCHAR(50) UNIQUE, -- UNIQUE constraint
    date_of_birth DATE,
    department VARCHAR(50),
    salary DECIMAL(8,2),
    hire_date DATE,
    manager_id INT,
    job_title VARCHAR(50)
	CONSTRAINT fk_department FOREIGN KEY (department) REFERENCES DEPARTMENTS(department_id) -- Foreign Key constraint
);

--CREATE INDEX
-- Create an index on the salary column for faster retrieval
CREATE INDEX idx_salary ON MOCK_DATA(salary);

-- Create an index on the department column for faster joins
CREATE INDEX idx_department ON MOCK_DATA(department);


