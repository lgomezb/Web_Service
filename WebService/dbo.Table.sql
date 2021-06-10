CREATE TABLE [dbo].[Table]
(
	[Id] INT NOT NULL PRIMARY KEY, 
    [agente] VARCHAR(50) NOT NULL, 
    [extension] VARCHAR(50) NOT NULL, 
    [host] VARCHAR(50) NOT NULL, 
    [evento] VARCHAR(MAX) NOT NULL, 
    [descripcion] VARCHAR(MAX) NOT NULL
)
