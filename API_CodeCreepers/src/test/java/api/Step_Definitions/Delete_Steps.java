package api.Step_Definitions;
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

import api.Actions.*;
import enums.Env_Var;
public class Delete_Steps {
	
	Assignment_Submit_TestCases asdel=new Assignment_Submit_TestCases();
	Assignment_TestCases adel=new Assignment_TestCases();
	User_TestCases udel=new User_TestCases();
	Program_Batch_TestCases pbdel=new Program_Batch_TestCases();
	Program_TestCases pdel=new Program_TestCases();




	@When("User sends HTTPS Delete Request for valid submission {int}")
	public void user_sends_https_delete_request_for_valid_submission(Integer int1) {
	    int1=Env_Var.Submission_Id;
	    asdel.TestDeleteSubmission(int1);
	    
	}


	@Then("User receives {int} Ok status with message")
	public void user_receives_ok_status_with_message(Integer int1) {
	    asdel.verify_del_status();
	}
	
	@When("User sends HTTPS Delete Request for valid assignment {int}")
	public void user_sends_https_delete_request_for_valid_assignment(Integer int2) {
	    int2=Env_Var.Assignment_Id;
	    adel.TestDeleteAssignment(int2);
	    
	}
	
	@Then("User receives {int} Ok status with message with valid assignmentid")
	public void user_receives_ok_status_with_message_with_valid_assignmentid(Integer int1) {
	adel.verify_del_status();    
	}
	@When("User sends HTTPS Delete Request for valid User {string}")
	public void user_sends_https_delete_request_for_valid_user(String string) {
	string=Env_Var.User_Id;
		udel.TestDeleteUser(string);
	}
	@Then("User receives {int} Ok status with message with valid userid")
	public void user_receives_ok_status_with_message_with_valid_userid(Integer int1) {
	    udel.verify_del_status();
	}
	@When("User sends HTTPS Delete Request for valid Batch {int}")
	public void user_sends_https_delete_request_for_valid_batch(Integer int4) {
	    int4=Env_Var.Batch_Id;
	    pbdel.TestDeleteBatch(int4);
	}
	@Then("User receives {int} Ok status with message with valid batchid")
	public void user_receives_ok_status_with_message_with_valid_batchid(Integer int1) {
	    pbdel.verify_del_status();
	}
	
	
	@When("User sends HTTPS Delete Request for valid Program {int}")
	public void user_sends_https_delete_request_for_valid_program(Integer int3) {
	   
		int3=Env_Var.Program_Id;
		pdel.TestdeleterequestbyprogramId(int3);
	}
	

@Then("User receives {int} Ok status with message with valid programid")
public void user_receives_ok_status_with_message_with_valid_programid(Integer int1) {
   pdel.verify_delete_request_by_program_Id_status(int1);
}

@When("User sends HTTPS Request to delete program by program name from the excel sheet {string} and {int}")
public void user_sends_https_request_to_delete_program_by_program_name_from_the_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	ExcelReader reader = new ExcelReader();
	List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);

	String programname = testData.get(RowNumber).get("programName");
	pdel.TestdeleterequestbyprogramName(programname);
}

@Then("The user submits the update request and verifies the status {int} for successful deletion")
public void the_user_submits_the_update_request_and_verifies_the_status_for_successful_deletion(Integer int1) {
    pdel.verify_delete_request_by_program_name_status(int1);
}




}
