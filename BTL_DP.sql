
USE master
GO

DROP DATABASE BTL_DP
GO

CREATE Database BTL_DP
GO

USE BTL_DP
GO

Create table Category(
	Id int primary key,
	Name nvarchar(100) NOT NULL,
	Status bit NOT NULL,
);

Create table Product(
	Id nvarchar(10),
	Name nvarchar(100) NOT NULL,
	Price float NOT NULL,
	Category_id int NOT NULL,
	FOREIGN KEY (Category_id) REFERENCES Category(Id),
	Status bit NOT NULL
);

SELECT * FROM Category;
Insert into Category values (1, 'test', 'true');
GO