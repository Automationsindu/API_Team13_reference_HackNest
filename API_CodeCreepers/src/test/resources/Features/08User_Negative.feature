Feature: User Negative Scenarios
Background: User sets Authoization to No  Auth


@negative1_post
Scenario Outline: Check if user able to create a User with valid endpoint and request body (existing values in phone no)

Given: User creates POST Request for the LMS API endpoint
When User sends HTTPSrequest from the user excel sheet "<SheetName>" and <RowNumber> for negative Post
Then User receives 400 Bad Request Status with message and boolean success details for invalid user req

Examples: 
|SheetName        | RowNumber |
|UserNeg| 		         0|

Scenario Outline: Check if user able to create a User with valid endpoint and request body (existing values in phone no)

Given: User creates POST Request for the LMS API endpoint
When User sends HTTPS Request and request Body  (missing mandatory fields) "<SheetName>" and <RowNumber> for negative Post
Then User receives 400 Bad Request Status with message and boolean success details for invalid user req

Examples: 
|SheetName        | RowNumber |
|UserNeg | 		             0|


Scenario Outline: Check if user able to retrieve a user with Invalid User ID

Given User creates GET Request for the LMS API endpoint with Invalid "<UserID>"
When User sends HTTPS Request 
Then User receives 404 Not Found  Status with response body for user update 

Examples:
|UserID|
|U826|

Scenario Outline: Check if user able to update a user with invalid User Id and request body

Given User creates PUT Request for the LMS API endpoint
When User sends HTTPS Request and  request Body with mandatory fields "<InvaliduserId>"
Then User receives 404 Not Found  Status with response body for user update  

Examples:
|InvaliduserId| 
|U826|

Scenario Outline:Check if user able to update a user with valid User Id and request body (missing field)
Given User creates PUT Request for the LMS API endpoint
When User sends HTTPS Request and  request Body with missing mandatory fields "<validUserId>" from the user excel "<SheetName>" and <RowNumber>
Then User receives 400 Not Found  Status with response body for user update 

Examples:
|validUserId|SheetName                 | RowNumber |
     |U8267   |   UserNeg          |         0 |


Scenario Outline:Check if user able to delete a user with valid LMS API,invalid user Id
Given User creates DELETE Request for the LMS API endpoint  and  invalid "<user ID>" 
When User sends HTTPS Request
Then User receives 404 Not Found Status with message and boolean success details for invalid user req
Examples:
|user ID|
|U10|

Scenario Outline: Check if user able to create a User missing mandatory fields in request body
Given User creates POST Request for the LMS API endpoint missing
When User sends HTTPS Request and  request Body with mandatory ,additional  fields "<SheetName>" and <RowNumber> 
Then User receives 400 Bad Request Status with message and boolean success details invalid missing field
Examples: 
|SheetName        | RowNumber |
|UserNeg   		| 		 0|


Scenario Outline: Check if user able to  assign user to program / batch with invalid User Id and request body
Given: User creates PUT Request for the LMS API endpoint
When User sends HTTPS PUT Request and  request Body with mandatory fields from the user excel "<SheetName>" and <RowNumber>
Then User receives 404 Not Found Status with message and boolean success detailst

Examples: 
      |SheetName                 | RowNumber |
      |   UserNeg          |         0 | 