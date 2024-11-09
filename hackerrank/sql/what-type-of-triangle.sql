SELECT
CASE
    WHEN (A + B) <= C THEN 'Not A Triangle'
    WHEN A = B AND B = C THEN 'Equilateral'
    WHEN (A = B OR A = C OR B = C) AND (A != C OR A != B OR B != C) THEN 'Isosceles'
    ELSE 'Scalene'
END AS KIND
FROM TRIANGLES
