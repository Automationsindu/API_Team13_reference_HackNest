package api.Step_Definitions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import api.Actions.Program_Batch_TestCases;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import api.Payloads.*;
import api.Utilities.ExcelReader;
import enums.Env_Var;
import io.restassured.response.Response;


public class Program_Batch_Steps {

	
	Program_Batch_TestCases batchrequest = new Program_Batch_TestCases();
	Env_Var batchid=new Env_Var();
	Env_Var batchname=new Env_Var();
	Env_Var pgID=new Env_Var();
	
	@Given("User create post request")
	public void User_create_post_request() {
		
	}

	@When("User sends HTTPS request, request body from excel sheet {string} and {int}")
	public void user_sends_https_request_request_body_from_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		String batchDescription=testData.get(RowNumber).get("batchDescription");
		String batchName=testData.get(RowNumber).get("batchName");
		String batchNoOfClasses=testData.get(RowNumber).get("batchNoOfClasses");
		String batchStatus=testData.get(RowNumber).get("batchStatus");
		
		System.out.println("Below are the values that are read from XL sheet :" );
		System.out.println("batchDescription : " +batchDescription);
		System.out.println("batchName : " +batchName);
		System.out.println("batchNoOfClasses : " +batchNoOfClasses);
		System.out.println("batchStatus : " +batchStatus);
		//faker.number().numberBetween(1000000000L, 9999999999L);
		
		batchrequest.TestPostBatch(batchDescription, batchName, batchNoOfClasses, batchStatus);
		
	}

	@Then("The user receives {int} status code")
	public void the_user_receives_status_code(Integer int1) {
		batchrequest.verify_post_status();
	}
	
	@Given("User create get all request")
	public void user_create_get_all_request() {
	    
	}

	@When("User sends HTTPS request")
	public void user_sends_https_request() {
	    batchrequest.TestGetallBatch();
	}

	@Then("User receives {int} OK status with response body")
	public void user_receives_ok_status_with_response_body(Integer int1) {
	    batchrequest.verify_get_all_batches_status();
	}
	
	@Given("User create get request with valid batchid")
	public void user_create_get_request_with_valid_batchid() {
	   
	}
	
	@When("User sends HTTPS Request with a valid {int}")
	public void user_sends_https_request_with_a_valid(Integer int1) {
	    int id= batchid.Batch_Id;
	    batchrequest.TestGetBatchbyID(id);
	}

	@Then("User receives {int} OK status with response body by batchid")
	public void user_receives_ok_status_with_response_body_by_batchid(Integer int1) {
	    batchrequest.verify_get_batch_by_ID_status();
	}

	@Given("User create get request with valid batchname")
	public void user_create_get_request_with_valid_batchname() {
	    
	}
	
	@When("User sends HTTPS request by valid {string}")
	public void user_sends_https_request_by_valid_(String str1) {
		String batnm=batchname.Batch_Name;
	    batchrequest.TestGetBatchbyname(batnm);
	}

	@Then("User receives {int} OK status with response body by valid batchname")
	public void user_receives_ok_status_with_response_body_by_valid_batchname(Integer int1) {
	    batchrequest.verify_get_batch_by_name_status();
	}

	@Given("User create get request with valid programid")
	public void user_create_get_request_with_valid_programid() {
	    
	}
	
	@When("User sends HTTPS request by valid programid with {int}")
	public void user_sends_https_request_by_valid_programid_with_(Integer int1) {
		int progmid=pgID.Program_Id;
	    batchrequest.TestGetBatchbyprogramid(progmid);
	}

	@Then("User receives {int} OK status with response body by valid programid")
	public void user_receives_ok_status_with_response_body_by_valid_programid(Integer int1) {
	    batchrequest.verify_get_batch_by_programid_status();
	}
	
	@Given("User create put request and valid batchid")
	public void user_create_put_request_and_valid_batchid() {
	   
	}
	
	@When("User sends HTTPS put request for {int} request body from excel sheet {string} and {int}")
	public void user_sends_https_put_request_for_request_body_from_excel_sheet_and(Integer Int2, String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		String batchDescription=testData.get(RowNumber).get("batchDescription");
		String batchNoOfClasses=testData.get(RowNumber).get("batchNoOfClasses");
		String batchStatus=testData.get(RowNumber).get("batchStatus");

		int id= batchid.Batch_Id;
		
		System.out.println("batchDescription : " +batchDescription);
		System.out.println("batchNoOfClasses : " +batchNoOfClasses);
		System.out.println("batchStatus : " +batchStatus);
		
		batchrequest.TestPutBatch(batchDescription, batchNoOfClasses, batchStatus, id);
		
	}

	@Then("The user receives {int} status and updated response body")
	public void the_user_receives_status_and_updated_response_body(Integer int1) {
		
		batchrequest.verify_put_status();
	    
	}


}
