Feature: Program module Negative Scenarios
Background: User sets Authoization to No  Auth


Scenario Outline: create a program with valid end points and request body with existing data
    Given: The user create post request with existing program name
    When User sends HTTPS request,request body with existing program name from the excel sheet "<Sheetname>" and <RowNumber>
    Then The user submits the post request and verifies the status 400
    Examples: 
      | Sheetname | RowNumber | 
      | ProgNeg   |         2 |  
      
 Scenario Outline: create a program with missing mandatory field in request body
    Given: The user create post request with missing mandatory field
    When User sends HTTPS request,request body with missing mandatory fields from the excel sheet "<Sheetname>" and <RowNumber>
    Then The user submits the post request and verifies the status 400
    Examples: 
      | Sheetname | RowNumber | 
      | ProgNeg   |         3 |  
      
Scenario Outline: check user is able to get request by invalid programId
    Given:User create get request by invalid program id
    When User sends HTTPS request to get request by invalid program id  from the excel sheet "<SheetName>" and <RowNumber>
    Then The user submits the get request and verifies the status 404
    Examples: 
      | SheetName | RowNumber | 
      | ProgNeg   |         4 |  
   Scenario Outline: update a program with invalid id 
    Given: The user create update request
    When User sends HTTPS request with invalid program id to update program from the excel sheet "<SheetName>" and <RowNumber>
    Then The user submits the update request and verifies the status 404
    Examples: 
      | SheetName | RowNumber |
      | ProgNeg   |     6   	 | 

 Scenario Outline: update a program with missed mandatory feilds
    Given: The user create update request
    When User sends HTTPS request with missing mandatory fields to update program by program id from the excel sheet "<SheetName>" and <RowNumber>
    Then The user submits the update request and verifies the status 500
    Examples: 
      | SheetName | RowNumber | 
      | ProgNeg   |     7  	 | 
  	
   Scenario Outline: update a program with  invalid programName
    Given: The user create update request
    When User sends HTTPS request with invalid program name to update program from the excel sheet "<SheetName>" and <RowNumber>
    Then The user submits the update request and verifies the status 404
    Examples: 
      | SheetName | RowNumber | 
      | ProgNeg   |     9  	 |  
  	
 Scenario Outline: update a program with  missed mandatoryfileds
    Given: The user create update request
    When User sends HTTPS request with missing mandatory fields to update program by program name from the excel sheet "<SheetName>" and <RowNumber>
    Then The user submits the update request and verifies the status 500
    Examples: 
      | SheetName | RowNumber | 
      | ProgNeg   |     10  	 | 
      
   