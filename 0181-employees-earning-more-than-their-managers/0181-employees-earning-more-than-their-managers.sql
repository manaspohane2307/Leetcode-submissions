# Write your MySQL query statement below
#we want table that contains employee id,name,salary,managetId,managerName,managerSalary thus do self join
#employee id is primary key
#managerId is foreign key
#e1 is emp table and e2 is manager table
#from e1 table take managerid of an employee.Then in e2 table check if managerid exist. Then check salary

Select e1.name as Employee
From Employee e1
INNER JOIN Employee e2
ON e1.managerId = e2.id
WHERE e1.salary > e2.salary