Feature: Deletion All Module
Background: User sets Authoization to No  Auth


Scenario Outline: Check if user able to delete a submission with valid submission Id
Given: User creates DELETE Request for the LMS API endpoint  and  valid submission ID
When User sends HTTPS Delete Request for valid submission <ID>
Then User receives 200 Ok status with message

Examples:
|ID|
|3515|  

Scenario Outline: Check if user able to delete a record with valid Assignment ID
Given: User creates DELETE Request for the LMS API endpoint  and  valid Assignment Id
When User sends HTTPS Delete Request for valid assignment <ID>
Then User receives 200 Ok status with message with valid assignmentid

Examples:
|ID|
|3935|  

Scenario Outline: Check if user able to delete a record with valid User ID
Given: User creates DELETE Request for the LMS API endpoint  and  valid User Id
When User sends HTTPS Delete Request for valid User "<ID>"
Then User receives 200 Ok status with message with valid userid

Examples:
|ID|
|U9357|  

Scenario Outline: Check if user able to delete a record with valid Batch ID
Given: User creates DELETE Request for the LMS API endpoint  and  valid Batch Id
When User sends HTTPS Delete Request for valid Batch <ID>
Then User receives 200 Ok status with message with valid batchid

Examples:
|ID|
|6481| 

Scenario Outline: Check if user able to delete a record with valid Program ID
Given: User creates DELETE Request for the LMS API endpoint  and  valid Program Id
When User sends HTTPS Delete Request for valid Program <ID>
Then User receives 200 Ok status with message with valid programid

Examples:
|ID|
|10942| 

Scenario Outline: Check if user able to delete a program with valid programName
    Given: User creates DELETE Request for the LMS API endpoint  and  valid programName
    When User sends HTTPS Request to delete program by program name from the excel sheet "<SheetName>" and <RowNumber>
    Then The user submits the update request and verifies the status 200 for successful deletion 
    
    Examples: 
      |SheetName        | RowNumber |
      |ProgramData     |         3 |

