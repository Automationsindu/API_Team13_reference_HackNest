package api.Step_Definitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import api.Actions.Program_Batch_Negative_TestCases;
import api.Utilities.ExcelReader;
import enums.Env_Var;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Program_Batch_Negative_Steps {
	
	Program_Batch_Negative_TestCases batchrequestN = new Program_Batch_Negative_TestCases();
	
	Env_Var batchid=new Env_Var();
	
	@Given("User create post request with exsisting batch name")
	public void user_create_post_request_with_exsisting_batch_name() {
	    
	}

	@When("User sends HTTPS request, request body from excel sheet again {string} and {int}")
	public void user_sends_https_request_request_body_from_excel_sheet_again_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		
         ExcelReader reader=new ExcelReader();
		
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		String batchDescription=testData.get(RowNumber).get("batchDescription");
		String batchName=testData.get(RowNumber).get("batchName");
		String batchNoOfClasses=testData.get(RowNumber).get("batchNoOfClasses");
		String batchStatus=testData.get(RowNumber).get("batchStatus");
		String ProgramId=testData.get(RowNumber).get("programId");
		
		batchrequestN.TestPostBatchExistingBatchname(batchDescription, batchName, batchNoOfClasses, batchStatus);
	    
	}

	@Then("User receives {int} Bad Request status")
	public void user_receives_bad_request_status(Integer int1) {
		batchrequestN.verify_post_status_Existing_Batchname();
	    
	}

	@Given("User create post request missing mandatory fields")
	public void user_create_post_request_missing_mandatory_fields() {
	  
	}

	@When("User sends HTTPS request, request body from excel sheet {string} and {int} with missing mandatory field")
	public void user_sends_https_request_request_body_from_excel_sheet_and_with_missing_mandatory_field(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
       ExcelReader reader=new ExcelReader();
		
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		String batchDescription=testData.get(RowNumber).get("batchDescription");
		String batchName=testData.get(RowNumber).get("batchName");
		String batchNoOfClasses=testData.get(RowNumber).get("batchNoOfClasses");
		String batchStatus=testData.get(RowNumber).get("batchStatus");
	
		batchrequestN.TestPostBatchMissingFields(batchDescription, batchName, batchNoOfClasses, batchStatus);
	}

	@Then("User receives {int} Bad Requests status")
	public void user_receives_bad_requests_status(Integer int1) {
	    batchrequestN.verify_post_status_Missing_Fields();
	}

	@Given("User create get request with invalid batchid")
	public void user_create_get_request_with_invalid_batchid() {
	    
	}

	@When("User sends HTTPS request by invalid {int}")
	public void user_sends_https_request_by_invalid(Integer int1) {
		int id= int1;
	    batchrequestN.TestgetbyInvalidBatchid(id);

	}

	@Then("User receives {int} NOT FOUND status")
	public void user_receives_not_found_status(Integer int1) {
		batchrequestN.verify_get_status_Invalid_Batchid();
	}

	@Given("User create get request with invalid batchname")
	public void user_create_get_request_with_invalid_batchname() {
	    
	}

	@When("User sends HTTPS request with invalid {string}")
	public void user_sends_https_request_with_invalid_(String str1) {
		String batchname=str1;
	    batchrequestN.TestgetbyInvalidBatchname(batchname);
	}
	
	@Then("User receives {int} NOT FOUND status by invalid batchname")
	public void User_receives_not_found_status_by_invalid_batchname(Integer int1) {
		batchrequestN.verify_get_status_Invalid_Batchname();
	}

	@Given("User create get request with invalid programid")
	public void user_create_get_request_with_invalid_programid() {
	   
	}

	@When("User sends HTTPS request {int}")
	public void user_sends_https_request(Integer int1) {
		int programid=int1;
		batchrequestN.TestgetbyInvalidProgramId(programid);
	}
	
	@Then("User receives {int} NOT FOUND status for programid")
	public void User_receives_not_found_status_for_programid(Integer int1) {
	    batchrequestN.verify_get_status_Invalid_Programid();
	}

	

	@Given("User create put request and invalid batchid")
	public void user_create_put_request_and_invalid_batchid() {
	   
	}
	
	@When("User sends HTTPS request for {int} request body from excel sheet {string} and {int}")
	public void user_sends_https_request_for_request_body_from_excel_sheet( Integer int2, String SheetName, Integer RowNumber) throws Exception, IOException {
		
        ExcelReader reader=new ExcelReader();
		
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		String batchDescription=testData.get(RowNumber).get("batchDescription");
		String batchNoOfClasses=testData.get(RowNumber).get("batchNoOfClasses");
		String batchStatus=testData.get(RowNumber).get("batchStatus");

		int id= int2;
		
		System.out.println("batchDescription : " +batchDescription);
		System.out.println("batchNoOfClasses : " +batchNoOfClasses);
		System.out.println("batchStatus : " +batchStatus);
		
		batchrequestN.TestPutBatchInvalidBatchID(batchDescription, batchNoOfClasses, batchStatus, id); 
		

	}

	@Then("The user receives {int} NOT FOUND status for invalid batchid")
	public void the_user_receives_not_found_status_for_invalid_batchid(Integer int1) {
		batchrequestN.verify_put_status_InvalidBatchID();
	   	}

	@Given("User creates put request and valid batchid and missing mandatory feilds")
	public void User_creates_put_request_and_valid_batchid_and_missing_mandatory_feilds() {
	    
	}
	
	@When("User sends HTTPS request for {int} request body from excel sheet {string} and {int} with missing mandatory feilds")
	public void user_sends_https_request_for_request_body_from_excel_sheet_and_with_missing_mandatory_feilds(Integer int2, String string, Integer int1) throws InvalidFormatException, Exception {
		int id= batchid.Batch_Id;
		
		batchrequestN.TestPutBatchInvalidBatchbody(id); 

	}

	@Then("The user receives {int} Bad Request status for missing mandatory feilds")
	public void the_user_receives_bad_reques_status_for_missing_mandatory_feilds(Integer int1) {
		batchrequestN.verify_put_status_InvalidBatchbody();
	   	}

	@Given("User create delete request with invalid batchid")
	public void user_create_delete_request_with_invalid_batchid() {
	    
	}
	
	@When("User sends HTTPS request with Invalid {int}")
	public void User_sends_HTTPS_request_with_Invalid_(Integer int1) {
		batchrequestN.TestdeletebyInvalidBatchid(int1);
	}
	
	@Then("The user receives {int} Bad Request status for Invalid batchid")
	public void the_user_receives_bad_reques_status_for_Invalid_batchid(Integer int1) {
		batchrequestN.verify_delete_status_Invalid_Batchid();
	}
	

}
