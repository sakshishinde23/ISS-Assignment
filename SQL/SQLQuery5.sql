--DROP
-- Drop the MOCK_DATA table
DROP TABLE MOCK_DATA;

-- Drop the DEPARTMENTS table
DROP TABLE DEPARTMENTS;


--ALTER
-- Add a new column to the MOCK_DATA table
ALTER TABLE MOCK_DATA ADD phone_number VARCHAR(15);

-- Modify the data type of a column in the MOCK_DATA table
ALTER TABLE MOCK_DATA ALTER COLUMN salary DECIMAL(10,2);

-- Drop a column from the MOCK_DATA table
ALTER TABLE MOCK_DATA DROP COLUMN phone_number;

--AUTO INCREMENT
-- Create a table with an auto-incrementing primary key
CREATE TABLE EmployeesWithAutoIncrement (
    employee_id INT IDENTITY(1,1) PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(50) UNIQUE,
    date_of_birth DATE,
    department VARCHAR(9),
    salary DECIMAL(8,2),
    hire_date DATE,
    manager_id INT,
    job_title VARCHAR(50)
);

-- Insert data without specifying the employee_id
INSERT INTO EmployeesWithAutoIncrement (first_name, last_name, email, date_of_birth, department, salary, hire_date, manager_id, job_title)
VALUES ('John', 'Doe', 'john.doe@example.com', '1985-04-12', 'IT', 75000.00, '2015-06-01', 3, 'Software Engineer');
SELECT * FROM EmployeesWithAutoIncrement;

--VIEWS
-- Create a view to display employee details with their department names
CREATE VIEW EmployeeDetails AS
SELECT employee_id, first_name, last_name, email, date_of_birth, salary, hire_date, manager_id, job_title
FROM MOCK_DATA ;

-- Select data from the view
SELECT * FROM EmployeeDetails;

--NULL VALUES
-- Select employees where the manager_id is NULL
SELECT * FROM MOCK_DATA WHERE manager_id IS NULL;

-- Select employees where the email is not NULL
SELECT * FROM MOCK_DATA WHERE email IS NOT NULL;

--GROUP BY
-- Group employees by department and calculate the average salary
SELECT department, AVG(salary) AS average_salary
FROM MOCK_DATA
GROUP BY department;

--HAVING
-- Group employees by department and calculate the average salary, only showing departments with an average salary above 70,000
SELECT department, AVG(salary) AS average_salary
FROM MOCK_DATA
GROUP BY department
HAVING AVG(salary) > 70000;

--AGGREGATE FUNCTIONS
-- Count the number of employees in each department
SELECT department, COUNT(*) AS employee_count
FROM MOCK_DATA
GROUP BY department;

-- Calculate the total salary in each department
SELECT department, SUM(salary) AS total_salary
FROM MOCK_DATA
GROUP BY department;

-- Find the maximum salary in each department
SELECT department, MAX(salary) AS max_salary
FROM MOCK_DATA
GROUP BY department;

-- Find the minimum salary in each department
SELECT department, MIN(salary) AS min_salary
FROM MOCK_DATA
GROUP BY department;

