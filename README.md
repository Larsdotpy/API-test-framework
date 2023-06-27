# API-test-framework

`Test framework for simple CRUD Rest API.`

![Scherm­afbeelding 2023-06-25 om 16 54 21](https://github.com/Larsdotpy/API-test-framework/assets/103534528/9d37e1b1-4533-44e8-8f46-15360aa93445)


**Languages**: Java

**Automator**: Junit, AssertJ, Mockito, Postman, Lombok

## Project setup

*In order to successfully run the API, the SQL workbench needs to be up and running aswell. Without this, the Java code is not able to set up a connection.*

### Localhost
The API is hosted on the localhost address of your own machine. You can change the port in the *application.yaml* file if needed. 

### Modification
You can modify the variables such a names, id's etc. to your liking. Make sure to do this in a structured and safe way to avoid any errors when running the project after modification. It is also possible to add additional methods to expand the possibilities of the API. 

### Dependencies
Make sure to check the dependencies in the *pom.xml* file to check for any errors before running the project. Any misconfigurations can cause failure to the API.

### Rest client
In a REST API, a REST client refers to any application or component that interacts with the API by sending HTTP requests to the server and processing the responses received. The REST client initiates requests to consume or manipulate the resources exposed by the REST API.

The REST client typically performs the following tasks:

- Constructs and sends HTTP requests, specifying the HTTP method (GET, POST, PUT, DELETE) and the URL of the desired resource.
- Sets request headers such as Content-Type, Authorization, or Accept.
- Serializes request data (such as query parameters or request bodies) into the appropriate format, such as URL-encoded, JSON, or XML.
- Handles authentication if required, by including authentication credentials or tokens in the request headers.
- Receives and processes the server's response, including status codes, headers, and response bodies.
- Deserializes the response body into a usable format (e.g., JSON, XML, or binary) and extracts the required data.
- Performs error handling, handling different response statuses and reporting any errors or exceptions that occur during the request/response cycle.

Overall, the REST client plays a crucial role in consuming and interacting with the REST API, allowing external applications, services, or components to access and utilize the API's resources and functionalities.

### CRUD
The API uses four simple actions: Create, Read, Update & Delete. 

The **CREATE** method will allow the user to create a new person in the database. Using this method will require the necessary parameters according to the JSON format. 

The **READ** method will allow the user to read/retrieve characteristics of the person/people in the database. This can be done for a specific person or for the entire database all at once.

The **UPDATE** method will allow the user to change/update existing characteristics of a person in the database.

The **DELETE** method will allow the user to delete an existing person from the database. Deleting only refers to deleting an entire person from the database. To delete specific characteristics of one person you can add additional delete methods in the project code to your liking.

### Controller layer
In a REST API, the controller layer is responsible for handling incoming HTTP requests, processing them, and producing appropriate responses. It acts as an intermediary between the client (which sends the requests) and the underlying business logic or data access layer.

The main tasks of the controller layer in a REST API include:

**Request Routing**: The controller determines which method or function should handle a specific HTTP request based on the request's HTTP method (GET, POST, PUT, DELETE) and the requested resource's URL. It maps the URL endpoints to the corresponding controller methods.

**Request Parsing**: The controller extracts data and parameters from the incoming request. It retrieves information such as query parameters, request headers, request body, and path variables, and converts them into appropriate data structures that can be processed by the application.

**Input Validation**: The controller validates the incoming data and checks if it meets the required criteria or constraints. It ensures that the data is in the expected format and performs validation checks to prevent any security vulnerabilities or invalid operations.

**Business Logic Invocation**: After validating the input, the controller invokes the relevant methods or functions from the underlying business logic layer. The business logic layer performs the actual processing and manipulation of data or performs any other necessary operations.

**Data Transformation**: The controller may transform the data received from the business logic layer into the appropriate format to be returned to the client. This can include formatting the data as JSON, XML, or any other agreed-upon representation for the response.

**Response Handling**: Once the business logic layer has completed its processing, the controller constructs the HTTP response. It sets the appropriate status code, headers, and body content. The response is then sent back to the client as the result of the request.

**Exception Handling**: The controller layer handles any exceptions or errors that occur during the request processing. It captures exceptions, transforms them into appropriate error responses, and provides meaningful error messages or codes to the client.

By encapsulating these responsibilities, the controller layer helps in separating concerns and maintaining a clear separation between the client interface and the underlying business logic of the REST API.

### Business/Service layer
The business/service layer in a REST API is responsible for implementing the core business logic and application rules. It serves as an intermediary between the controller layer (which handles the incoming requests and responses) and the data access layer (which interacts with the database or external systems).

The main functions of the business/service layer in a REST API include:

**Business Logic Implementation**: The business/service layer contains the implementation of the application's business rules and processes. It encapsulates complex business operations, calculations, validations, and workflows that are specific to the domain or functionality of the API.

**Data Manipulation and Processing**: The business/service layer performs data manipulation and processing operations. It receives data from the controller layer and performs transformations, computations, or any other required operations on the data. This layer is responsible for orchestrating and coordinating multiple data-related tasks.

**Validation and Business Rules Enforcement**: The business/service layer enforces the business rules and constraints defined by the application. It validates the data received from the controller layer, ensuring it meets the required criteria. It performs checks such as data integrity, authorization, authentication, and any other domain-specific rules.

**Transaction Management**: In cases where the API interacts with a database or external systems, the business/service layer manages transactions. It ensures that operations are performed atomically and consistently. It may initiate database transactions, handle rollback scenarios, or coordinate multiple operations as part of a single transaction.

**Integration with External Systems**: If the API needs to communicate with external services or systems, the business/service layer handles the integration. It encapsulates the communication with external APIs, web services, databases, or other resources. It abstracts the complexities of integration and provides a consistent interface for the rest of the application.

**Business Workflow Orchestration**: The business/service layer coordinates and orchestrates the flow of business processes or workflows. It defines the sequence of steps and actions required to fulfill a particular request or operation. It may involve coordinating multiple steps, handling conditional logic, and ensuring the correct execution order.

**Error Handling and Exception Management**: The business/service layer handles errors and exceptions that occur during the execution of business logic. It captures and handles exceptions, performs error logging, and generates appropriate error messages or responses. It ensures that the API provides meaningful feedback to the client in case of errors or exceptional scenarios.

By separating the business/service layer from the other layers in the API, such as the controller and data access layers, the codebase becomes more modular, maintainable, and testable. It promotes the separation of concerns and allows for easier modifications or enhancements to the business logic without affecting other parts of the system.

### Databse/Repository layer
The database/repository layer in a REST API is responsible for interacting with the underlying database or data storage system. It provides an abstraction over the database operations and serves as a bridge between the business/service layer and the persistent storage.

The key functions of the database/repository layer in a REST API include:

**Data Access and Retrieval**: The database/repository layer handles the retrieval of data from the database. It encapsulates the logic required to execute queries, fetch records, and retrieve data based on specific criteria or conditions.

**Data Manipulation and Persistence**: The database/repository layer handles the creation, modification, and deletion of data in the database. It provides methods or functions to insert new records, update existing records, and delete records as required by the business logic.

**Query Composition and Optimization**: The database/repository layer is responsible for constructing database queries based on the requirements of the business/service layer. It builds and optimizes queries to ensure efficient retrieval and manipulation of data. This layer may utilize query builders, ORM (Object-Relational Mapping) frameworks, or SQL statements to interact with the database.

**Mapping Between Data Models and Database Schema**: The database/repository layer maps the data models used in the business/service layer to the corresponding database schema. It manages the conversion between the objects used in the application code and the database tables, columns, and relationships. This mapping ensures that the data is correctly stored and retrieved from the database.

**Caching and Performance Optimization**: The database/repository layer may incorporate caching mechanisms to improve performance. It can cache frequently accessed data or the results of expensive database operations to reduce the load on the database and enhance response times. Caching strategies like in-memory caching or external caching systems can be employed.

**Transaction Management**: The database/repository layer manages transactions that involve multiple database operations. It ensures that changes to the database are performed atomically, ensuring data consistency. It may initiate transactions, handle commit and rollback operations, and provide mechanisms to ensure the integrity of the data.

**Connection Management**: The database/repository layer manages the connections to the database. It establishes and maintains connections, handles connection pooling, and optimizes connection usage to improve performance and scalability. It may also handle connection failures, retries, and reconnections when necessary.

By encapsulating the database operations within the database/repository layer, the rest of the application, such as the business/service layer, can work with abstracted methods and functions without being tightly coupled to the underlying database implementation. This separation enables flexibility in choosing different databases or switching between different storage systems without impacting the overall application code.

### Database
*MySQL*: `https://dev.mysql.com/downloads/mysql/` 
*MySQLWorkbench*: `https://dev.mysql.com/downloads/workbench/`

To use the API database you need to setup the database manually via MySQLWorkbench and a MySQL connection that talks with the workbench. Without this connection, the API cannot create, read, update or delete any data in and from the database. Check the *application.yaml* file to see what details you should use for the setup. These details can be changed to your liking. 

## API Documentation
create, read, update and delete methods hier uitleggen (eventueel swagger link)

## Testing

In order to really tackle the challenge of API testing I decided to test this API in three different ways. Unit tests, Java automation tests and Postman tests.

### Amount of testcases
Unit testcases: **12**

Postman testcases: **11**

Java Rest assured testcases: **0**

Total testcas: **23**

### Postman
The Postman tool can be used for both manual and automated tests for the API framework. It can be used to check if data is created, read, updated or deleted in a valid way and if it does not result in any errors. Below I presented a link to my Postman project which contains automated tests for this API framework. This is additional to the unit testing in Java and the seperate API testing framework in Java.

The Postman tests are added to the API project as a JSON file. You can open Postman and then open a project. Navigate to the folder where you saved the JSON file. It is recommended to save the JSON file from the API project seperately after cloning the repository, so that you can open it in Postman without any errors.

To open a Postman project that is saved in a JSON file, you can follow these steps:

1. Launch the Postman application on your computer. If you don't have it installed, you can download and install it from the Postman website (https://www.postman.com/downloads/).

2. Once Postman is open, click on the "Import" button located at the top left corner of the application's window.

3. In the import window that appears, select the "Import File" tab.

4. Click on the "Choose Files" button and navigate to the location where your JSON file is saved. Select the JSON file and click on "Open" to import it.

5. Postman will automatically recognize the JSON file format and import it as a collection. You should see a preview of the collection's details in the import window.

6. Review the settings and options in the import window. You can choose to import the collection into an existing workspace or create a new workspace. You can also customize the collection name and other import settings if needed.

7. Once you've reviewed the import settings, click on the "Import" button to import the JSON file as a Postman collection.

8. After the import process is complete, you will see the imported collection listed in the left sidebar of the Postman application. Click on the collection to expand it and view the saved requests, folders, and other elements within the project.

### Java automation
xxxxx
