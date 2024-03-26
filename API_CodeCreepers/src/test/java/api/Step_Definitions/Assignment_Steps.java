package api.Step_Definitions;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.Actions.Assignment_Submit_TestCases;
import api.Actions.*;
import api.CRUDOperations.*;
import api.Payloads.*;

import io.restassured.response.Response;
import api.Utilities.ExcelReader;

import api.Actions.*;
import enums.Env_Var;
public class Assignment_Steps {

	Assignment_TestCases atc=new Assignment_TestCases();
	Env_Var asid=new Env_Var();
	
	@When("User sends HTTPS request and request body with mandatory and additional fields from the assignment excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_mandatory_and_additional_fields_from_the_assignment_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	   
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		//String assignmentId=testData.get(RowNumber).get("assignmentId");
		String assignmentDescription=testData.get(RowNumber).get("assignmentDescription");
		//String assignmentName=testData.get(RowNumber).get("assignmentName");
		String batchId=testData.get(RowNumber).get("batchId");
		String comments=testData.get(RowNumber).get("comments");
		String createdBy=testData.get(RowNumber).get("createdBy");
		String graderId=testData.get(RowNumber).get("graderId");
		String pathAttachment1=testData.get(RowNumber).get("pathAttachment1");
		String pathAttachment2=testData.get(RowNumber).get("pathAttachment2");
		String pathAttachment3=testData.get(RowNumber).get("pathAttachment3");
		String pathAttachment4=testData.get(RowNumber).get("pathAttachment4");
		String pathAttachment5=testData.get(RowNumber).get("pathAttachment5");
		
		atc.TestPostAssignment(assignmentDescription, batchId, comments, createdBy, graderId, pathAttachment1, pathAttachment2, pathAttachment3, pathAttachment4, pathAttachment5);
	}

	@Then("User receives {int} created status with response body for the assignment module post request")
	public void user_receives_created_status_with_response_body_for_the_assignment_module_post_request(Integer int1) {
		atc.verify_post_Assign_status();
	   
	}
	
	@When("User sends HTTPS Request with a valid Assignment {int}")
	public void user_sends_https_request_with_a_valid_Assignment(Integer int1) {
	    int id= asid.Assignment_Id;
	    atc.Get_Assignment_ID(id);
	}


	@Then("User receives {int} OK Status with response body for GET assignment")
	public void user_receives_ok_status_with_response_body_for_get_assignment(Integer int1) {
	   
		atc.verify_get_Assign_status();
	}
	
	@When("User sends HTTPS GET Request to retrieve all assignments")
	public void user_sends_https_get_request_to_retrieve_all_assignments() {
	   atc.Get_All_Assignments();
	}
	@Then("User receives {int} OK Status with response body for Get All")
	public void user_receives_ok_status_with_response_body_for_get_all(Integer int1) {
	   atc.verify_get_Assign_status();
	}
	@When("User sends HTTPS Request with a valid Batch {int}")
	public void user_sends_https_request_with_a_valid_batch(Integer int1) {
		 int id1= asid.Batch_Id;
		    atc.Get_Assignment_BatchID(id1);
	}
	
	@Then("User receives {int} OK Status with response body for GET assignment using batchid")
	public void user_receives_ok_status_with_response_body_for_get_assignment_using_batchid(Integer int1) {
	    atc.verify_get_Assign_status();
	}
	
	@When("User sends HTTPS PUT Request and  request Body with mandatory and additional  fields from the assignment excel sheet {string} and {int}")
	public void user_sends_https_put_request_and_request_body_with_mandatory_and_additional_fields_from_the_assignment_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		//String assignmentId=testData.get(RowNumber).get("assignmentId");
		String assignmentDescription=testData.get(RowNumber).get("assignmentDescription");
		//String assignmentName=testData.get(RowNumber).get("assignmentName");
		String batchId=testData.get(RowNumber).get("batchId");
		String comments=testData.get(RowNumber).get("comments");
		String createdBy=testData.get(RowNumber).get("createdBy");
		String graderId=testData.get(RowNumber).get("graderId");
		String pathAttachment1=testData.get(RowNumber).get("pathAttachment1");
		String pathAttachment2=testData.get(RowNumber).get("pathAttachment2");
		String pathAttachment3=testData.get(RowNumber).get("pathAttachment3");
		String pathAttachment4=testData.get(RowNumber).get("pathAttachment4");
		String pathAttachment5=testData.get(RowNumber).get("pathAttachment5");
atc.TestPutAssign(assignmentDescription, batchId, comments, createdBy, graderId, pathAttachment1, pathAttachment2, pathAttachment3, pathAttachment4, pathAttachment5);		
	}

	@Then("User receives {int} OK Status with updated value in response body for the PUT request")
	public void user_receives_ok_status_with_updated_value_in_response_body_for_the_put_request(Integer int1) {
	   atc.verify_put_Assign_status();
	}




}
