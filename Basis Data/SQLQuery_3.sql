USE TSQL2012;
GO

-- -----------------
-- Aggregation Functions
-- ---------------------
-- It is kind of function that we use to calculate 1 or more values in the same
-- Column to results in single output.
-- It is different from scalar function that calculate EXACTLY 1 input to become 
-- also 1 output
-- Some example of aggregation function: SUM, MIN, MAx, AVG, COUNT
-- Example: What is the most expensive price of all products?
SELECT unitprice FROM Production.Products; -- Results in 77 rows
SELECT MAX(unitprice) FROM Production.Products; -- Only 1 rows
-- How about the cheapest price?
SELECT MIN(unitprice) FROM Production.Products; 
-- How about the average price?
SELECT AVG(unitprice) FROM Production.Products; 
-- Then, what is the total price of all products?
SELECT SUM(unitprice) FROM Production.Products; 
-- Lastly, how many product do we have?
SELECT COUNT(unitprice) FROM Production.Products; 
SELECT COUNT(productname) FROM Production.Products; 
SELECT COUNT(productid) FROM Production.Products; 
-- That's why we can use:
SELECT COUNT(*) FROM Production.Products;
-- Now, what if  i want to see all the statistics in on table?
SELECT
    MAX(unitprice) AS [Most Expensive Price], -- This will gives us column name
                                               -- instead of (No column name).
    MIN(unitprice) AS [cheapest Price],
    AVG(unitprice) AS [Average Price],
    SUM(unitprice) AS [total Price],
    COUNT(unitprice) AS [# of Products]
FROM
    Production.Products;

-- Nootes : By using aggregation function, we are unable to know the name, or other
-- atributes of the row, we can only know the 'value' or the number
-- If we want to know, for example what products is the most expensive one
-- we have to use SQL combinations, or Sub-query.
-- Example: What is the NAME of the most expensive product?
-- ALternative-1: Use multiple select query
--1. Find the expensive price first
SELECT MAX(unitprice) FROM Production.Products;
--2. Find the corresponding products that has the same price with the previous result.
SELECT productname FROM Production.Products WHERE unitprice = 263.50;
-- Alternative-2: Use subquery
SELECT productname FROM Production.Products WHERE unitprice = (
    SELECT MAX(unitprice) FROM Production.Products -- This iso equal 263.50
);

-- ----------------
-- Group by clause
-------------------
-- This used to perform aggregation operations but the ones that need context.
-- Or in another words: "Based on what?" . And "What" here means which column.
-- Without GROUP BY, aggregation function will result in EXACTLY  one value.
-- But with GORUP BY, the results can be one value or more, based on the unique value 
-- of the desired column.
-- Example: What are the total weight of shipments for each city?
SELECT SUM(freight) 
FROM Sales.Orders
GROUP BY shipcity;
-- And what if we want to order it so the largest amount of shipping put on the top?
-- Example: what are the total weight of shipments for each city?
SELECT shipcity, SUM(freight) AS [Total Weight]
FROM Sales.Orders
GROUP BY shipcity
ORDER BY [Total Weight] DESC;

-- Another Example: How much revenue coming from each of the product sales?
SELECT
    productid,
    SUM(unitprice * qty * (1 - discount)) AS TotalRevenue
FROM Sales.OrderDetails
GROUP BY productid
ORDER BY TotalRevenue DESC;

-- Having clause
-- --------------
-- This is used to filter the groups created by GROUP BY clause.
-- Example: Show all cities that has more than one employees
SELECT
    city,
    COUNT(*) AS NumberOfEmployee
FROM HR.Employees
GROUP BY city
HAVING COUNT(*) > 1;

--Another Example: Show customer ID that has commited purchase more than 10x.
SELECT 
    custid,
    COUNT(orderid) AS purchase_count
FROM Sales.Orders
GROUP BY custid
HAVING COUNT(orderid) > 10;

-- ------------
-- Sub-Query
-- ------------
-- Is any SELECT statement that is put into another SELECT statement.
-- The "inside" one is called "INNER QUERY" or "SUB-QUERY"
-- The "outside" one is called "OUTER QUERY"
-- Based on the result sub-query can be divide into 3 categories:
-- Scalar --> 1 value
-- Multi valued --> More than 1 value but still 1 column
-- Tabled valued --> More than 1 value and more than 1 column 
-- Example: Shw the ID customer that commited the very LAST purchase!
SELECT custid FROM Sales.Orders WHERE orderdate = (
    SELECT MAX(orderdate) FROM Sales.Orders --This is a SCALAR sub-query
                                            -- because when it is executed it will resulting 1 value
);

-- Another example: we got the IDs of customers doing the last day purchases.
-- Now we also want to know who are they. What's their names. How to do that?
-- Manual way
SELECT contactname FROM sales.customers
WHERE custid = 65 OR custid = 9 OR custid = 68 OR CUSTID = 73;
-- or using IN
SELECT contactname FROM sales.customers
WHERE custid IN (65, 9, 68, 73);
-- The problem is: what if the number of custid found is 1000?
-- This very timing of course
-- Use sub-query instead!
SELECT contactname FROM sales.customers WHERE custid IN ( --This is now the outer query
    SELECT custid FROM Sales.Orders WHERE orderdate = ( -- Now this become sub-query also
        SELECT MAX(orderdate) FROM Sales.Orders --This is a SCALAR sub-query
    )
);