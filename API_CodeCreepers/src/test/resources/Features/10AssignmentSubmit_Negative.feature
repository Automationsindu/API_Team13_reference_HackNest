Feature: Assignment Submit Negative Scenarios
Background: User sets Authoization to No  Auth


Scenario Outline: Check if user is able to create assignment submission id with valid endpoints and request body for existing values
Given: User creates POST request for assignment submit module for the LMS API endpoints
When User sends HTTPS POST request and request body with mandatory and additional fields from the assignment submit excel sheet "<SheetName>" and <RowNumber>
Then User receives 400 Bad Request with response body for the assignment submit module invalid post request

Examples: 
      |SheetName                | RowNumber |
      | AssignmentSubmit        |         0 |   
      
Scenario Outline: Check if user is able to create assignment submission id with valid endpoints and request body missing mandatory fields
Given: User creates POST request for assignment submit module for the LMS API endpoints
When User sends HTTPS POST request and request body with missing mandatory fields from the assignment submit excel sheet "<SheetName>" and <RowNumber>
Then User receives 400 Bad Request with response body for the assignment submit module invalid post request

Examples: 
      |SheetName                | RowNumber |
      | AssignmentSubmit        |         1 |  
      

Scenario Outline: Check if user able to retrieve a grades with invalid Assignment ID
Given: User creates GET Request for the LMS API endpoint with invalid Assignemnt ID
When User sends HTTPS Get Request with invalid Assignment ID <ID>
Then User receives 404 Not Found Status with message and boolean success details for invalid Submission request

Examples:
|ID|
|3635|  

Scenario Outline: Check if user able to retrieve a grades with invalid Student ID
Given: User creates GET Request for the LMS API endpoint with invalid Student ID
When User sends HTTPS Get Request with invalid Student ID "<ID>"
Then User receives 404 Not Found Status with message and boolean success details for invalid Submission request

Examples:
|ID|
|U9343|  


Scenario Outline: Check if user able to retrieve a grades with invalid batch ID
Given: User creates GET Request for the LMS API endpoint with invalid batch ID
When User sends HTTPS Get Request with invalid batch ID <ID>
Then User receives 404 Not Found Status with message and boolean success details for invalid Submission request

Examples:
|ID|
|6023|  


Scenario Outline: Check if user able to retrieve a submission with invalid user ID
Given: User creates GET Request for the LMS API endpoint with invalid user ID
When User sends HTTPS Get Request to retrieve submission with invalid user ID "<ID>"
Then User receives 404 Not Found Status with message and boolean success details for invalid Submission request

Examples:
|ID|
|U4512| 

Scenario Outline: Check if user able to update a submission with invalid submission ID and mandatory request body
Given: User creates PUT Request for the LMS API endpoint  and  invalid submission ID
When User sends HTTPS PUT Request  and  request Body  with invalid submission Id <ID> mandatory and additional fields from excel sheet "<SheetName>" and <RowNumber>
Then User receives 404 Not Found Status with message and boolean success details for invalid Submission request

Examples:
    |ID      |SheetName                | RowNumber  |
    |1234    | AssignmentSubmit          |           1|   

Scenario Outline: Check if user able to update a submission with valid submission ID and missing mandatory fields request body
Given: User creates PUT Request for the LMS API endpoint  and Valid submission Id
When User sends HTTPS Request  and request Body with missing mandatory fields  with valid submission Id <ID> mandatory and additional fields from excel sheet "<SheetName>" and <RowNumber>
Then User receives 400 Bad request with message and boolean success details for invalid Submission request

Examples:
    |ID      |SheetName                | RowNumber  |
    |1562    | AssignmentSubmit          |           1|   
 
Scenario Outline: Check if user able to delete a record with invalid Submission ID
Given: User creates DELETE Request for the LMS API endpoint  and  invalid Submission Id
When User sends HTTPS Delete Request for invalid Submission <ID>
Then User receives 404 Not Found Status with message and boolean success details for invalid Submission ID

Examples:
|ID|
|1023| 


