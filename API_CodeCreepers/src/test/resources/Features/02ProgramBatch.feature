Feature: Batch Module
Background: User sets Authoization to No  Auth

  Scenario Outline: Create a batch with valid endponts and request body
    Given User create post request
    When User sends HTTPS request, request body from excel sheet "<SheetName>" and <RowNumber>
    Then The user receives 201 status code

   Examples: 
      |SheetName        | RowNumber |
      | ProgramBatch     |         0 |

  Scenario: Check user is able to retrive all batches
    Given User create get all request
    When User sends HTTPS request
    Then User receives 200 OK status with response body

  Scenario Outline: Check user is able to retrive batch with valid batchid
    Given User create get request with valid batchid
    When User sends HTTPS Request with a valid <ID>
    Then User receives 200 OK status with response body by batchid

    Examples: 
      | ID    |
      | 11356 |

  Scenario Outline: Check user is able to retrive batch with valid batchname
    Given User create get request with valid batchname
    When User sends HTTPS request by valid "<batchname>"
    Then User receives 200 OK status with response body by valid batchname

    Examples: 
      | batchname                            |
      | Jul23-Coders_Creepers-SDET-SDET01-08 |

  Scenario Outline: Check user is able to retrive batch with valid programid
    Given User create get request with valid programid
    When User sends HTTPS request by valid programid with <programid>
    Then User receives 200 OK status with response body

    Examples: 
      | programid |
      |     14521 |

  Scenario Outline: Update a batch with valid batchid and mandatory request body
    Given User create put request and valid batchid
    When User sends HTTPS put request for <ID> request body from excel sheet "<SheetName>" and <RowNumber>
    Then The user receives 200 status and updated response body

    Examples: 
      | ID    | SheetName       | RowNumber |
      | 11356 | ProgramBatch    |         1 |





















