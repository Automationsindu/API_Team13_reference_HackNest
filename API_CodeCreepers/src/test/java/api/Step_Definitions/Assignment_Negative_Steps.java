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

public class Assignment_Negative_Steps {
	Assignment_TestCases atc=new Assignment_TestCases();
	Env_Var asid=new Env_Var();
	
	@When("User sends HTTPS Request and  request Body with mandatory and additional  fields for an existing id from the excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_mandatory_and_additional_fields_for_an_existing_id_from_the_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		//String assignmentId=testData.get(RowNumber).get("assignmentId");
		String assignmentDescription=testData.get(RowNumber).get("assignmentDescription");
		String assignmentName=testData.get(RowNumber).get("assignmentName");
		String batchId=testData.get(RowNumber).get("batchId");
		String comments=testData.get(RowNumber).get("comments");
		String createdBy=testData.get(RowNumber).get("createdBy");
		String graderId=testData.get(RowNumber).get("graderId");
		String pathAttachment1=testData.get(RowNumber).get("pathAttachment1");
		String pathAttachment2=testData.get(RowNumber).get("pathAttachment2");
		String pathAttachment3=testData.get(RowNumber).get("pathAttachment3");
		String pathAttachment4=testData.get(RowNumber).get("pathAttachment4");
		String pathAttachment5=testData.get(RowNumber).get("pathAttachment5");
		atc.TestPostExistingAssignment(assignmentName,assignmentDescription, batchId, comments, createdBy, graderId, pathAttachment1, pathAttachment2, pathAttachment3, pathAttachment4, pathAttachment5);
	}

	@Then("User receives {int} Bad Request Status with message and boolean success details with invalid Assignment Request")
	public void user_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
	    atc.verify_post_Negative_Assign_status();
	}

	@When("User sends HTTPS Request and  request Body with missing mandatory and additional  fields for an id from the excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_missing_mandatory_and_additional_fields_for_an_id_from_the_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
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
		atc.TestPostMissingAssignment(assignmentDescription, batchId, comments, createdBy, graderId, pathAttachment1, pathAttachment2, pathAttachment3, pathAttachment4, pathAttachment5);
	}
	
	@When("User sends HTTPS Get Request with invalid Assignment {int} in the request")
	public void user_sends_https_get_request_with_invalid_assignment_in_the_request(Integer int1) {
	    atc.Get_Assignment_ID(int1);
	}
	@Then("User receives {int} Not Found Status with message and boolean success details for Get Request with invalid Assignmentid")
	public void user_receives_not_found_status_with_message_and_boolean_success_details_for_get_request_with_invalid_assignmentid(Integer int1) {
		atc.verify_get_All_invalid_status();
	    
	}
	@When("User sends HTTPS Get Request with invalid Batch {int} in the request")
	public void user_sends_https_get_request_with_invalid_batch_in_the_request(Integer int1) {
	    atc.Get_Assignment_BatchID(int1);
	}
	@Then("User receives {int} Not Found Status with message and boolean success details for Get Request with invalid BatchId")
	public void user_receives_not_found_status_with_message_and_boolean_success_details_for_get_request_with_invalid_batch_id(Integer int1) {
	    atc.verify_get_All_invalid_status();
	}
	@When("User sends HTTPS PUT Request  and  request Body  with invalid assignment Id {int} mandatory and additional fields from excel sheet {string} and {int}")
	public void user_sends_https_put_request_and_request_body_with_invalid_assignment_id_mandatory_and_additional_fields_from_excel_sheet_and(Integer int1, String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
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
		atc.TestPutInvalidAssign(int1, assignmentDescription, batchId, comments, createdBy, graderId, pathAttachment1, pathAttachment2, pathAttachment3, pathAttachment4, pathAttachment5);
	}
	@Then("User receives {int} Not Found Status with message and boolean success details for put Request with invalid Assignmentid")
	public void user_receives_not_found_status_with_message_and_boolean_success_details_for_put_request_with_invalid_assignmentid(Integer int1) {
	    atc.verify_get_All_invalid_status();
	}

	@When("User sends HTTPS Request  and request Body with missing mandatory fields  with valid assignment Id {int} mandatory and additional fields from excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_missing_mandatory_fields_with_valid_assignment_id_mandatory_and_additional_fields_from_excel_sheet_and(Integer int1, String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	    
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
		atc.TestPutMissingAssign(int1, assignmentDescription, batchId, comments, createdBy, graderId, pathAttachment1, pathAttachment2, pathAttachment3, pathAttachment4, pathAttachment5);
		
	}
	@Then("User receives {int} Bad request with message and boolean success details for put Request with valid Assignmentid")
	public void user_receives_bad_request_with_message_and_boolean_success_details_for_put_request_with_valid_assignmentid(Integer int1) {
	   atc.verify_Missingput_status();
	}
	
	@When("User sends HTTPS Delete Request for invalid assignment {int}")
	public void user_sends_https_delete_request_for_invalid_assignment(Integer int1) {
	    atc.TestDeleteInvalidAssignment(int1);
	}

	@Then("User receives {int} Not Found Status with message and boolean success details for invalid Assignment ID")
	public void user_receives_not_found_status_with_message_and_boolean_success_details_for_invalid_assignment_id(Integer int1) {
	    atc.verify_invalid_del_status();
	}


}
