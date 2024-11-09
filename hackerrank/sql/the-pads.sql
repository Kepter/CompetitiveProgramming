SELECT CONCAT(Name, "(", SUBSTRING(Occupation, 1, 1), ")") FROM OCCUPATIONS ORDER BY Name;
SELECT CONCAT('There are a total of ', COUNT(Occupation), " ", LOWER(Occupation), "s.") AS occupation_count FROM OCCUPATIONS GROUP BY Occupation ORDER BY occupation_count
