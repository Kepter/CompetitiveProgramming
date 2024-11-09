SELECT DISTINCT Company.company_code,
Company.founder,
(SELECT COUNT(DISTINCT Lead_Manager.lead_manager_code) FROM Lead_Manager WHERE Lead_Manager.company_code = Company.company_code),
(SELECT COUNT(DISTINCT Senior_Manager.senior_manager_code) FROM Senior_Manager WHERE Senior_Manager.company_code = Company.company_code),
(SELECT COUNT(DISTINCT Manager.manager_code) FROM Manager WHERE Manager.company_code = Company.company_code),
(SELECT COUNT(DISTINCT Employee.employee_code) FROM Employee WHERE Employee.company_code = Company.company_code)
FROM Company
ORDER BY Company.company_code
