--SELECT
-- Select all columns from the MOCK_DATA table
SELECT * FROM MOCK_DATA;

-- Select specific columns from the MOCK_DATA table
SELECT first_name, last_name, email FROM MOCK_DATA;

--DISTINCT
-- Select distinct departments from the MOCK_DATA table
SELECT DISTINCT department FROM MOCK_DATA;

--WHERE
-- Select employees from the IT department
SELECT * FROM MOCK_DATA WHERE department = 'IT';

-- Select employees with a salary greater than 70000
SELECT * FROM MOCK_DATA WHERE salary > 70000;


--AND & OR
-- Select employees from the IT department with a salary greater than 70000
SELECT * FROM MOCK_DATA WHERE department = 'IT' AND salary > 70000;

-- Select employees from the IT department or employees with a salary greater than 70000
SELECT * FROM MOCK_DATA WHERE department = 'IT' OR salary > 70000;


--ORDER BY
-- Select all employees ordered by last name ascending
SELECT * FROM MOCK_DATA ORDER BY last_name ASC;

-- Select all employees ordered by salary descending
SELECT * FROM MOCK_DATA ORDER BY salary DESC;

--INSERT INTO
-- Insert a new employee into the MOCK_DATA table
INSERT INTO MOCK_DATA (employee_id, first_name, last_name, email, date_of_birth, department, salary, hire_date, manager_id, job_title) 
VALUES (101, 'Alice', 'Wonderland', 'alice.wonderland@example.com', '1995-09-15', 'Finance', 80000.00, '2022-05-20', 3, 'Accountant');

--UPDATE
-- Update the salary of an employee with employee_id = 1
UPDATE MOCK_DATA SET salary = 78000.00 WHERE employee_id = 1;

--DELETE
-- Delete an employee with employee_id = 101
DELETE FROM MOCK_DATA WHERE employee_id = 101;

--SELECT TOP
-- Select the top 5 highest paid employees
SELECT TOP 5 * FROM MOCK_DATA ORDER BY salary DESC;

--LIKE
-- Select employees whose first name starts with 'J'
SELECT * FROM MOCK_DATA WHERE first_name LIKE 'J%';

-- Select employees whose last name ends with 'son'
SELECT * FROM MOCK_DATA WHERE last_name LIKE '%son';

--WILDCARDS
-- Select employees whose email contains 'example'
SELECT * FROM MOCK_DATA WHERE email LIKE '%es%';

--IN
-- Select employees from the IT or HR departments
SELECT * FROM MOCK_DATA WHERE department IN ('IT', 'HR');

--BETWEEEN
-- Select employees with a salary between 60000 and 80000
SELECT * FROM MOCK_DATA WHERE salary BETWEEN 60000 AND 80000;

--ALIASES
-- Select employees with an alias for the salary column
SELECT first_name, last_name, salary AS employee_salary FROM MOCK_DATA;
