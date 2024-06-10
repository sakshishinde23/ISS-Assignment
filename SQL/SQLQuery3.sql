-- Create the DEPARTMENTS table
CREATE TABLE DEPARTMENTS (
    department_id VARCHAR(9) PRIMARY KEY,
    department_name VARCHAR(50)
);

-- Insert sample data into the DEPARTMENTS table
INSERT INTO DEPARTMENTS (department_id, department_name) VALUES
('IT', 'Information Technology'),
('HR', 'Human Resources'),
('Finance', 'Finance');


--INNER JOIN
-- Select employee names and their department names using INNER JOIN
SELECT e.first_name, e.last_name, d.department_name
FROM MOCK_DATA e
INNER JOIN DEPARTMENTS d ON e.department = d.department_id;


--RIGHT JOIN
-- Select all departments and their employees, including those departments without employees, using RIGHT JOIN
SELECT e.first_name, e.last_name, d.department_name
FROM MOCK_DATA e
RIGHT JOIN DEPARTMENTS d ON e.department = d.department_id;


--LEFT JOIN
-- Select all employees and their department names, including those without a department, using LEFT JOIN
SELECT e.first_name, e.last_name, d.department_name
FROM MOCK_DATA e
LEFT JOIN DEPARTMENTS d ON e.department = d.department_id;


--FULL JOIN
-- Select all employees and their department names, including those without a department, using LEFT JOIN
SELECT e.first_name, e.last_name, d.department_name
FROM MOCK_DATA e
LEFT JOIN DEPARTMENTS d ON e.department = d.department_id;
