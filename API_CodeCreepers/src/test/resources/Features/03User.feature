



Feature: User Module
Background: User sets Authoization to No  Auth

@Api_create_User
Scenario Outline: Check if user is able to create a new user with valid endpoints and request body
Given: User creates POST request for user module for the LMS API endpoints
When User sends HTTPS request and request body with mandatory and additional fields from the user excel sheet "<SheetName>" and <RowNumber>
Then User receives 201 created status with response body for the user module post request

Examples: 
      |SheetName        | RowNumber |
      | User            |         0 |

@Api_get_UserId
Scenario Outline: Check if user able to retrieve a user with valid User ID

Given User creates GET Request for the LMS API endpoint with valid "<UserID>"
When User sends HTTPS Request 
Then User receives 200 OK Status with response body for get user

Examples:
|UserID|
|U8267|

@Api_getAllUsers
Scenario: Get request to extract all the users

Given User creates GET Request for the LMS API All User endpoint 
When User sends HTTPS Request  
Then User fetches all the user and do validations

@Api_AllStaff
Scenario: Check if user able to retrieve a users of all staff with valid LMS API

Given User creates GET Request for the LMS API All Staff endpoint
When User sends HTTPS Request  
Then User fetches all staff and do validations

@Api_get_roles
Scenario: Check if user able to retrieve a users by roles with valid LMS API

Given User creates GET Request for the LMS API for users with the roles 
When User sends HTTPS Request  
Then User receives the list of users with their roles 

 

@Api_put_PBU_update
Scenario Outline: Check if user able to assign user to program and batch with valid User Id and request body
Given: User creates PUT Request for updating user details in the LMS API endpoint
When User sends HTTPS PUT Request and  request Body with mandatory fields from the user excel sheet "<SheetName>" and <RowNumber>
Then User receives 200 Ok Status with response message for the user module put request

Examples: 
      |SheetName                 | RowNumber |
      | UserBatchProg            |         0 | 


@Api_update_roleStatus
Scenario Outline: Check if user able to update a user with valid User Id and request body

Given User creates PUT Request for updating user details in the LMS API endpoint
When User sends HTTPS Request and  request Body with mandatory fields "<userId>"
Then User receives 200 Ok Status with response message for the user module put request

Examples:
|userId| 
|U8267|
