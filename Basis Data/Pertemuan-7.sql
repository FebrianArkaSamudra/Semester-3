-- --------------------------------------------------------------------------------------------------
-- 01. VIEW
-- A VIEW is a SELECT statement that can be saved and reused as if it were a regular table.
-- --------------------------------------------------------------------------------------------------
-- Example: Saving a complex query to make it easier to reuse.

USE TSQL2012;
GO

SELECT * FROM Production.Products;
SELECT * FROM Production.Categories;

-- Below is a query to display complete product data along with the category name.
-- ====
SELECT
	p.productid AS [Product Code],
	p.productname AS [Product Name],
	p.categoryid AS [Category Code],
	c.categoryname AS [Category Name]
FROM
	Production.Products p
		INNER JOIN Production.Categories c ON p.categoryid = c.categoryid;
GO

-- Create a VIEW. If it already exists, delete the previous one first.
-- ====
DROP VIEW IF EXISTS Production.RekapProduk; -- Deleting a view does not affect the original data.
GO

CREATE VIEW Production.RekapProduk AS -- If a view with the same name already exists, it cannot be created.
SELECT
	p.productid AS [Product Code],
	p.productname AS [Product Name],
	p.categoryid AS [Category Code],
	c.categoryname AS [Category Name]
FROM
	Production.Products p
		INNER JOIN Production.Categories c ON p.categoryid = c.categoryid;
GO -- Don’t forget GO to prevent errors in the statements below.

-- Call the VIEW
-- ====
SELECT * FROM Production.RekapProduk;
GO

-- You can apply filters and other operations as you would with a regular table.
-- ====
SELECT [Product Name], [Category Name] FROM Production.RekapProduk
WHERE [Category Code] = 1;

-- However, VIEWs cannot be used for INSERT, UPDATE, or DELETE.
-- They are read-only.
DELETE FROM Production.RekapProduk WHERE [Category Code] = 1; -- Fails.

-- --------------------------------------------------------------------------------------------------
-- 02. Table-Valued Function (TVF)
-- A SELECT statement wrapped in a function and stored in the database.
-- --------------------------------------------------------------------------------------------------
-- Example: Making it easy to display employees based on their position.

-- Check the employee data
SELECT * FROM HR.Employees;

-- First, create the query.
SELECT
	firstname + ' ' + lastname AS [Full Name],
	title AS Position,
	phone AS [Phone Number]
FROM
	HR.Employees
WHERE
	title LIKE '%CEO%'; -- Ideally, this can be replaced based on the position type.
GO

-- Create the TVF
-- Similar to Java or C#
-- String greetPerson(String personName)
-- {
--   return "Hello, Welcome " + personName + "!";
-- }
-- For retrieving phone numbers:
-- Table findPhoneNumber(String position)
-- {
--   return .... list of phone numbers;
-- }
CREATE FUNCTION HR.CariNoTelp(@position AS NVARCHAR(255)) -- To update the function, change CREATE to ALTER.
RETURNS TABLE
AS
RETURN SELECT
	firstname + ' ' + lastname AS [Full Name],
	title AS Position,
	phone AS [Phone Number]
FROM
	HR.Employees
WHERE
	title LIKE '%' + @position + '%'; -- This can be changed based on the position type.
GO

-- Once stored in the database, you can call the TVF.
-- It’s more compact than a VIEW when there’s a need to filter data.
-- ====
SELECT * FROM Hr.CariNoTelp('Sales');
SELECT * FROM Hr.CariNoTelp('Representative');
-- If this were a view, you’d need to call it like this:
-- SELECT * FROM HR.CariNoTelp WHERE position LIKE '%Sales%';
-- SELECT * FROM HR.CariNoTelp WHERE position LIKE '%Representative%';

-- --------------------------------------------------------------------------------------------------
-- 03. Derived Table
-- A SELECT statement that is not stored in the database but can be treated like a table.
-- Benefits:
-- 1. Useful when performing a SELECT on values that need to be processed by another SELECT statement.
-- 2. Useful if you want to display only a subset of columns from a query with many columns without creating a VIEW.
-- --------------------------------------------------------------------------------------------------

-- Example: Count transactions from the Sales.Order table by year (number of sales per year).

-- Check the data first:
SELECT * FROM Sales.Orders;

-- In essence, we need to use the COUNT() aggregation function + GROUP BY.
SELECT 
	orderdate,
	COUNT(orderdate) AS count
FROM
	Sales.Orders
GROUP BY
	orderdate;
-- The above query is correct but gives results by DATE, not by year.

-- Use the YEAR function to display the year
SELECT orderdate, YEAR(orderdate) AS year FROM Sales.Orders;
GO

-- We could save the above query as a VIEW, then call it with GROUP BY.
CREATE VIEW Sales.TanggalTransaksi AS
	SELECT orderdate, YEAR(orderdate) AS year FROM Sales.Orders;
GO
SELECT year, COUNT(year) AS total FROM Sales.TanggalTransaksi GROUP BY year;

-- But if you prefer not to, you can use a Derived Table or CTE directly.
SELECT
	year,
	COUNT(year) AS count
FROM
	(SELECT orderdate, YEAR(orderdate) AS year FROM Sales.Orders) AS DT_year -- <-- This line is the derived table.
GROUP BY DT_year.year;

-- --------------------------------------------------------------------------------------------------
-- 04. Common-Table Expression (CTE)
-- A CTE is similar, but with different syntax.
-- --------------------------------------------------------------------------------------------------
WITH CTE_Year AS
(SELECT orderdate, YEAR(orderdate) AS year FROM Sales.Orders)
-- The 2 lines above are the CTE.
SELECT year, COUNT(year) AS count FROM CTE_Year GROUP BY CTE_Year.year;

-- Another example: When you only need a subset of columns from a query with many columns.
SELECT p.*, c.categoryname, c.description FROM
	Production.Products p
		INNER JOIN Production.Categories c ON p.categoryid = C.categoryid;
-- If you only want to display the columns product name, category, and description:
-- You can use either CTE or Derived Table as you like.
WITH cte AS
(SELECT p.*, c.categoryname, c.[description] FROM Production.Products p INNER JOIN Production.Categories c ON p.categoryid = C.categoryid)
SELECT productname, categoryname, [description] FROM cte;
