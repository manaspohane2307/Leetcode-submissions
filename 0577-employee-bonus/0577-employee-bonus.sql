# Write your MySQL query statement below

SELECT e.name, b.bonus
From Employee e
LEFT JOIN Bonus b
ON e.empID = b.empId
WHERE b.bonus < 1000
OR b.bonus IS NULL #bcoz we want to display null if bonus does not exist