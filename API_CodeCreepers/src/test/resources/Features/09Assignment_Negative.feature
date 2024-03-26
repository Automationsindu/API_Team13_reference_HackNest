Feature: Assignment Negative Scenarios
Background: User sets Authoization to No  Auth

Scenario Outline: Check if user able to add a record with valid endpoint and request body with existing value
Given: User creates POST Request for the LMS API endpoint
When User sends HTTPS Request and  request Body with mandatory and additional  fields for an existing id from the excel sheet "<SheetName>" and <RowNumber>
Then User receives 400 Bad Request Status with message and boolean success details with invalid Assignment Request

Examples: 
      |SheetName          | RowNumber |
      | Assignment        |         0 |
      
      
Scenario Outline: Check if user able to add a record with valid endpoint and request body with missing value
Given: User creates POST Request for the LMS API endpoint
When User sends HTTPS Request and  request Body with missing mandatory and additional  fields for an id from the excel sheet "<SheetName>" and <RowNumber>
Then User receives 400 Bad Request Status with message and boolean success details with invalid Assignment Request

Examples: 
      |SheetName          | RowNumber |
      | Assignment        |         0 |      

Scenario Outline: Check if user able to retrieve a record with invalid Assignment ID
Given: User creates GET Request for the LMS API endpoint with invalid Assignment ID
When User sends HTTPS Get Request with invalid Assignment <ID> in the request
Then  User receives 404 Not Found Status with message and boolean success details for Get Request with invalid Assignmentid

Examples:
|ID|
|3635|

Scenario Outline: Check if user able to retrieve a record with invalid Batch ID
Given: User creates GET Request for the LMS API endpoint with invalid Batch ID
When User sends HTTPS Get Request with invalid Batch <ID> in the request
Then  User receives 404 Not Found Status with message and boolean success details for Get Request with invalid BatchId

Examples:
|ID|
|6023|

Scenario Outline: Check if user able to update a assignment with invalid assignment ID and mandatory request body
Given: User creates PUT Request for the LMS API endpoint  and  invalid assignment ID
When User sends HTTPS PUT Request  and  request Body  with invalid assignment Id <ID> mandatory and additional fields from excel sheet "<SheetName>" and <RowNumber>
Then User receives 404 Not Found Status with message and boolean success details for put Request with invalid Assignmentid

Examples:
    |ID      |SheetName                | RowNumber  |
    |3635    | Assignment          |           1|   

Scenario Outline: Check if user able to update a assignment with valid assignment ID and missing mandatory fields request body
Given: User creates PUT Request for the LMS API endpoint  and Valid assignment Id
When User sends HTTPS Request  and request Body with missing mandatory fields  with valid assignment Id <ID> mandatory and additional fields from excel sheet "<SheetName>" and <RowNumber>
Then User receives 400 Bad request with message and boolean success details for put Request with valid Assignmentid

Examples:
    |ID      |SheetName                | RowNumber  |
    |3935    | Assignment          |           1| 
    
    
Scenario Outline: Check if user able to delete a record with invalid Assignment ID
Given: User creates DELETE Request for the LMS API endpoint  and  invalid Assignment Id
When User sends HTTPS Delete Request for invalid assignment <ID>
Then User receives 404 Not Found Status with message and boolean success details for invalid Assignment ID

Examples:
|ID|
|3654| 