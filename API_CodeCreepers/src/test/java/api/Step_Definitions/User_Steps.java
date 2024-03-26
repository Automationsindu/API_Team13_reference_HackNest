package api.Step_Definitions;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import api.Actions.User_TestCases;
import api.Actions.*;
import api.CRUDOperations.*;
import api.Payloads.*;
import io.restassured.response.Response;
import api.Utilities.ExcelReader;
import enums.Env_Var;
import api.Actions.User_TestCases;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class User_Steps {
	User_TestCases utc= new User_TestCases();

	@When("User sends HTTPS request and request body with mandatory and additional fields from the user excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_mandatory_and_additional_fields_from_the_user_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
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
		utc.TestPostUser(userComments, userEduPg, userEduUg, userLinkedinUrl, userLocation,roleId,userRoleStatus, userTimeZone, userVisaStatus);
		
	}

	@Then("User receives {int} created status with response body for the user module post request")
	public void user_receives_created_status_with_response_body_for_the_user_module_post_request(Integer int1) {
	   utc.verify_post_status();
	}
	
	// Scenario 2:GET user- Check if user able to retrieve a user with valid User ID
	
	@Given("User creates GET Request for the LMS API endpoint with valid {string}")
	public void user_creates_get_request_for_the_lms_api_endpoint_with_valid(String uid) {
		
		utc.Get_user_ID(uid);
		//System.out.println("User created all three UserId's for all the three roles");
	}

	@When("User sends HTTPS Request")
	public void user_sends_https_request() {
		
		System.out.println("The user is hitting the Api to do necessary actions and validations"); 
	}

	
	@Then("User receives {int} OK Status with response body for get user")
	public void user_receives_ok_status_with_response_body_for_get_user(Integer int1) {
	
		utc.Update_status(int1);
		System.out.println("validations has been performed");
	}
	
	//Scenario 3 :get all users
	
	@Given("User creates GET Request for the LMS API All User endpoint")
	public void user_creates_get_request_for_the_lms_api_all_user_endpoint() {
	    System.out.println("The user is hitting the Api to extract all the users");
	}

	@Then("User fetches all the user and do validations")
	public void User_fetches_all_the_user_and_do_validations()
	{
		User_CRUD.getAllUsers();
	}

	//Scenario 4 : Check if user able to retrieve a user with valid LMS API

	
	@Given("User creates GET Request for the LMS API All Staff endpoint")
	public void user_creates_get_request_for_the_lms_api_all_staff_endpoint() {
	    System.out.println("User trying to get all staff");
	}

	@Then("User fetches all staff and do validations")
	public void user_fetches_all_staff_and_do_validations() {
		User_CRUD.getAllStaff();
	}

	
		// Scenario 5: User creates GET Request for the LMS API for users with the roles
	
	@Given("User creates GET Request for the LMS API for users with the roles")
	public void user_creates_get_request_for_the_lms_api_for_users_with_the_roles() {
	    System.out.println("User trying to get all users based on their roles");
	    
	}

	@Then("User receives the list of users with their roles")
	public void user_receives_the_list_of_users_with_their_roles() {
		User_CRUD.getAllUsers_Roles();
	}
	
	//Scenario 6 : Check if user able to assign user to program / batch with valid User Id and request body
	
	
	@Given("User creates PUT Request for the LMS API endpoint")
	public void user_creates_put_request_for_the_lms_api_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("User trying assign prog and batch to the user");
	}

	@When("User sends HTTPS PUT Request and  request Body with mandatory fields from the user excel sheet {string} and {int}")
	public void user_sends_https_put_request_and_request_body_with_mandatory_fields_from_the_user_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		
		String roleId=testData.get(RowNumber).get("roleId");
		
		String userRoleProgramBatchStatus=testData.get(RowNumber).get("userRoleProgramBatchStatus");
		utc.TestUpdateUser( roleId, userRoleProgramBatchStatus);
	}

	@Then("User receives {int} Ok Status with response message for the user module put request")
	public void user_receives_ok_status_with_response_message_for_the_user_module_put_request(Integer int1) {
		utc.Update_status(int1);
	    
	}
	
	// Scenario  : Check if user able to update a user with valid User ID and request body
	
	


	@Then("User receives {int} OK  Status with response body for user update")
	public void user_receives_ok_status_with_response_body_for_user_update(Integer int1) {
	    utc.status_TestUpdateUserById();
	}

	//Scenario  : Check if user able to update a user with valid User Id and request body

@Given("User creates PUT Request for updating user details in the LMS API endpoint")
public void user_creates_put_request_for_updating_user_details_in_the_lms_api_endpoint() {
    System.out.println("User is updating the role status to Dormant");
}

@When("User sends HTTPS Request and  request Body with mandatory fields {string}")
public void user_sends_https_request_and_request_body_with_mandatory_fields(String uuidd) {
    utc.TestUpdateUserRoles(uuidd);
}


}
