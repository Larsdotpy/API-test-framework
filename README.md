# API-test-framework

`Test framework for simple CRUD Rest API.`

![Scherm­afbeelding 2023-06-25 om 16 54 21](https://github.com/Larsdotpy/API-test-framework/assets/103534528/9d37e1b1-4533-44e8-8f46-15360aa93445)


**Languages**: Java

**Automator**: -

## Project setup

### Localhost
The API is hosted on the localhost address of your own machine. You can change the port in the *application.yaml* file if needed. 

### Modification
You can modify the variables such a names, id's etc. to your liking. Make sure to do this in a structured and safe way to avoid any errors when running the project after modification. It is also possible to add additional methods to expand the possibilities of the API. 

### Dependencies
Make sure to check the dependencies in the *pom.xml* file to check for any errors before running the project. Any misconfigurations can cause failure to the API.

### Rest client
xxxx

### CRUD
The API uses four simple actions: Create, Read, Update & Delete. 

The **CREATE** method will allow the user to create a new person in the database. Using this method will require the necessary parameters according to the JSON format. 

The **READ** method will allow the user to read/retrieve characteristics of the person/people in the database. This can be done for a specific person or for the entire database all at once.

The **UPDATE** method will allow the user to change/update existing characteristics of a person in the database.

The **DELETE** method will allow the user to delete an existing person from the database. Deleting only refers to deleting an entire person from the database. To delete specific characteristics of one person you can add additional delete methods in the project code to your liking.

### Controller layer
xxxx explain controller layer xxxx

### Business/Service layer
xxxx explain business/service layer xxxx

### Databse/Repository layer
xxxx explain database/repository layer xxxx

### Database
*MySQL*: `https://dev.mysql.com/downloads/mysql/` 
*MySQLWorkbench*: `https://dev.mysql.com/downloads/workbench/`

To use the API database you need to setup the database manually via MySQLWorkbench and a MySQL connection that talks with the workbench. Without this connection, the API cannot create, read, update or delete any data in and from the database. Check the *application.yaml* file to see what details you should use for the setup. These details can be changed to your liking. 

## API Documentation
create, read, update and delete methods hier uitleggen (eventueel swagger link)

## Testing

### Amount of testcases
Create testcases: 0

Read   testcases: 0

Update testcases: 0

Delete testcases: 0

Total  testcases: 0
