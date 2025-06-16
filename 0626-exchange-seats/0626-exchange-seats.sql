# Write your MySQL query statement below

SELECT 
    CASE
        WHEN 
            id = (SELECT MAX(id) FROM Seat) AND MOD(id,2) = 1
            THEN id
        WHEN 
            MOD(id,2) = 1#if odd id then return next id
            THEN id+1
        ELSE#if even id then return previous id
            id-1
    END AS id, student
FROM Seat
ORDER BY id