package api.Step_Definitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import api.Actions.User_TestCases;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.Actions.*;
import api.CRUDOperations.*;
import api.Payloads.*;
import io.restassured.response.Response;
import api.Utilities.ExcelReader;
import api.Actions.User_TestCases;

public class User_Negative_Steps {
	
	User_TestCases utc=new User_TestCases();
	static ExcelReader reader;
	
	
	@When("User sends HTTPSrequest from the user excel sheet {string} and {int} for negative Post")
	public void user_sends_http_srequest_from_the_user_excel_sheet_and_for_negative_post(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		String userComments=testData.get(RowNumber).get("userComments");
		String userEduPg=testData.get(RowNumber).get("userEduPg");
		String userEduUg=testData.get(RowNumber).get("userEduUg");
		String userLinkedinUrl=testData.get(RowNumber).get("userLinkedinUrl");
		String userLocation=testData.get(RowNumber).get("userLocation");
		String userMiddleName=testData.get(RowNumber).get("userMiddleName");
		String userPhoneNumber=testData.get(RowNumber).get("userPhoneNumber");
		String roleId=testData.get(RowNumber).get("roleId");
		String userRoleStatus=testData.get(RowNumber).get("userRoleStatus");
		String userTimeZone=testData.get(RowNumber).get("userTimeZone");
		String userVisaStatus=testData.get(RowNumber).get("userVisaStatus");
		utc.negative1_TestPostUser(userComments, userEduPg, userEduUg, userLinkedinUrl, userLocation, roleId, userRoleStatus, userTimeZone, userVisaStatus);
		
		
	}

	@Then("User receives {int} Bad Request Status with message and boolean success details for invalid user req")
	public void user_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
	    utc.verify_Negative1post_status();
	}
	
	@When("User sends HTTPS Request and request Body  \\(missing mandatory fields) {string} and {int} for negative Post")
	public void user_sends_https_request_and_request_body_missing_mandatory_fields_and_for_negative_post(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		 reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		String userComments=testData.get(RowNumber).get("userComments");
		String userEduPg=testData.get(RowNumber).get("userEduPg");
		String userEduUg=testData.get(RowNumber).get("userEduUg");
		String userLinkedinUrl=testData.get(RowNumber).get("userLinkedinUrl");
		String userLocation=testData.get(RowNumber).get("userLocation");
		String userMiddleName=testData.get(RowNumber).get("userMiddleName");
		
		String roleId=testData.get(RowNumber).get("roleId");
		String userRoleStatus=testData.get(RowNumber).get("userRoleStatus");
		String userTimeZone=testData.get(RowNumber).get("userTimeZone");
		String userVisaStatus=testData.get(RowNumber).get("userVisaStatus");
		utc.negative2_TestPostUser(userComments, userEduPg, userEduUg, userLinkedinUrl, userLocation, roleId, userRoleStatus, userTimeZone, userVisaStatus);
	}
	
	@Given("User creates GET Request for the LMS API endpoint with Invalid {string}")
	public void user_creates_get_request_for_the_lms_api_endpoint_with_invalid(String uid) {
	    utc.Get_Invalid_user_ID(uid);
	}
	
	@When("User sends HTTPS Request and  request Body with missing mandatory fields {string} from the user excel {string} and {int}")
	public void user_sends_https_request_and_request_body_with_missing_mandatory_fields_from_the_user_excel_and(String SheetName, int RowNumber, String int1) throws InvalidFormatException, IOException {
		reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		String userComments=testData.get(RowNumber).get("userComments");
		String userEduPg=testData.get(RowNumber).get("userEduPg");
		String userEduUg=testData.get(RowNumber).get("userEduUg");
		String userLinkedinUrl=testData.get(RowNumber).get("userLinkedinUrl");
		String userLocation=testData.get(RowNumber).get("userLocation");
		String userMiddleName=testData.get(RowNumber).get("userMiddleName");
		
		String roleId=testData.get(RowNumber).get("roleId");
		String userRoleStatus=testData.get(RowNumber).get("userRoleStatus");
		String userTimeZone=testData.get(RowNumber).get("userTimeZone");
		String userVisaStatus=testData.get(RowNumber).get("userVisaStatus");
		utc.TestUpdate_missing(int1,userComments, userEduPg, userEduUg, userLinkedinUrl, userLocation, roleId, userRoleStatus, userTimeZone, userVisaStatus);
	}
	@Then("User receives {int} Not Found  Status with response body for user update")
	public void user_receives_not_found_status_with_response_body_for_user_update(Integer int1) {
	   // utc.Get_Invalid_code(int1);
	}

	@When("User sends HTTPS Request and request Body with mandatory fields {string}")
    public void User_sends_HTTPS_Request_and_request_Body_with_mandatory_fields(String string) {
	  
	   utc.missig_mandatory(string);
	}
	
	 

	@Given("User creates PUT Request for the LMS API endpoint  and Valid")
	public void user_creates_put_request_for_the_lms_api_endpoint_and_valid() {
	   System.out.println("User checking the put request with some invalid fields");
	}

	
	
	
	@Given("User creates DELETE Request for the LMS API endpoint  and  invalid {string}")
	public void user_creates_delete_request_for_the_lms_api_endpoint_and_invalid(String string) {
	    utc.negative_delete(string);
	}

	@Then("User receives {int} Not Found Status with message and boolean success details for invalid user req")
	public void user_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
	    utc.verify_delete_User_status();
	}

	@Given("User creates POST Request for the LMS API endpoint missing")
	public void user_creates_post_request_for_the_lms_api_endpoint_missing() {
		System.out.println("user is trying to create a User missing mandatory fields in request body");
	}


	@When("User sends HTTPS Request and  request Body with mandatory ,additional  fields {string} and {int}")
	public void user_sends_https_request_and_request_body_with_mandatory_additional_fields_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		String userComments=testData.get(RowNumber).get("userComments");
		String userEduPg=testData.get(RowNumber).get("userEduPg");
		String userEduUg=testData.get(RowNumber).get("userEduUg");
		String userLinkedinUrl=testData.get(RowNumber).get("userLinkedinUrl");
		String userLocation=testData.get(RowNumber).get("userLocation");
		String userMiddleName=testData.get(RowNumber).get("userMiddleName");
		String userPhoneNumber=testData.get(RowNumber).get("userPhoneNumber");
		//String roleId=testData.get(RowNumber).get("roleId");
		String userRoleStatus=testData.get(RowNumber).get("userRoleStatus");
		String userTimeZone=testData.get(RowNumber).get("userTimeZone");
		String userVisaStatus=testData.get(RowNumber).get("userVisaStatus");
		utc.negative3_missing_TestPostUser(userComments, userEduPg, userEduUg, userLinkedinUrl, userLocation, userRoleStatus, userTimeZone, userVisaStatus);
	}

	@Then("User receives {int} Bad Request Status with message and boolean success details invalid missing field")
	public void user_receives_bad_request_status_with_message_and_boolean_success_details_invalid_missing_field(Integer int1) {
	    utc.verify_missing_TestPostUser(int1);
	}

	@When("User sends HTTPS PUT Request and  request Body with mandatory fields from the user excel {string} and {int}")
	public void user_sends_https_put_request_and_request_body_with_mandatory_fields_from_the_user_excel_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		//String programId=testData.get(RowNumber).get("programId");
		String roleId=testData.get(RowNumber).get("roleId");
		//String userId=testData.get(RowNumber).get("userId");
		String batchId=testData.get(RowNumber).get("batchId");
		String userRoleProgramBatchStatus=testData.get(RowNumber).get("userRoleProgramBatchStatus");
		utc.Negative_TestUpdateUser( roleId, userRoleProgramBatchStatus);
	}

	

	@Then("User receives {int} Not Found Status with message and boolean success detailst")
	public void user_receives_not_found_status_with_message_and_boolean_success_detailst(Integer int1) {
	    utc.Update__invalidId_status(0);
	}

}
