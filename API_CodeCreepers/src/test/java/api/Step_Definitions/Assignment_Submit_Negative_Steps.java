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

public class Assignment_Submit_Negative_Steps {
	
	Assignment_Submit_TestCases ast=new Assignment_Submit_TestCases();
	
	@When("User sends HTTPS POST request and request body with mandatory and additional fields from the assignment submit excel sheet {string} and {int}")
	public void user_sends_https_post_request_and_request_body_with_mandatory_and_additional_fields_from_the_assignment_submit_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		//String assignmentId=testData.get(RowNumber).get("assignmentId");
		//String userId=testData.get(RowNumber).get("userId");
		String subDesc=testData.get(RowNumber).get("subDesc");
		String subComments=testData.get(RowNumber).get("subComments");
		String subPathAttach1=testData.get(RowNumber).get("subPathAttach1");
		String subPathAttach2=testData.get(RowNumber).get("subPathAttach2");
		String subPathAttach3=testData.get(RowNumber).get("subPathAttach3");
		String subPathAttach4=testData.get(RowNumber).get("subPathAttach4");
		String subPathAttach5=testData.get(RowNumber).get("subPathAttach5");
		String gradedBy=testData.get(RowNumber).get("gradedBy");
		String grade=testData.get(RowNumber).get("grade");
		ast.TestPostExistingSubmission(subDesc, subComments, subPathAttach1, subPathAttach2, subPathAttach3, subPathAttach4, subPathAttach5, gradedBy, grade);
		
		
		
	}

	@When("User sends HTTPS POST request and request body with missing mandatory fields from the assignment submit excel sheet {string} and {int}")
	public void user_sends_https_post_request_and_request_body_with_missing_mandatory_fields_from_the_assignment_submit_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	   
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		//String assignmentId=testData.get(RowNumber).get("assignmentId");
		//String userId=testData.get(RowNumber).get("userId");
		//String subDesc=testData.get(RowNumber).get("subDesc");
		String subComments=testData.get(RowNumber).get("subComments");
		String subPathAttach1=testData.get(RowNumber).get("subPathAttach1");
		String subPathAttach2=testData.get(RowNumber).get("subPathAttach2");
		String subPathAttach3=testData.get(RowNumber).get("subPathAttach3");
		String subPathAttach4=testData.get(RowNumber).get("subPathAttach4");
		String subPathAttach5=testData.get(RowNumber).get("subPathAttach5");
		String gradedBy=testData.get(RowNumber).get("gradedBy");
		String grade=testData.get(RowNumber).get("grade");
		ast.Missing_TestPostSubmission(subComments, subPathAttach1, subPathAttach2, subPathAttach3, subPathAttach4, subPathAttach5,gradedBy,grade);
		
	}
	@Then("User receives {int} Bad Request with response body for the assignment submit module invalid post request")
	public void user_receives_bad_request_with_response_body_for_the_assignment_submit_module_invalid_post_request(Integer int1) {
	    ast.verify_existing_post_Sub_status();
	}
	
	@When("User sends HTTPS Get Request with invalid Assignment ID {int}")
	public void user_sends_https_get_request_with_invalid_assignment_id(Integer int1) {
	   ast.Get_Grades_AssignId(int1);
	}

	@Then("User receives {int} Not Found Status with message and boolean success details for invalid Submission request")
	public void user_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
		ast.verify_get_All_invalid_status();
	   
	}
	@When("User sends HTTPS Get Request with invalid Student ID {string}")
	public void user_sends_https_get_request_with_invalid_student_id(String string) {
	    ast.Get_Grades_StudId(string);
	}
	
	@When("User sends HTTPS Get Request with invalid batch ID {int}")
	public void user_sends_https_get_request_with_invalid_batch_id(Integer int1) {
	    ast.Get_Grades_BatchId(int1);
	}

	@When("User sends HTTPS Get Request to retrieve submission with invalid batch ID {int}")
	public void user_sends_https_get_request_to_retrieve_submission_with_invalid_batch_id(Integer int1) {
	    ast.Get_Submission_BatchId(int1);
	}

	@When("User sends HTTPS Get Request to retrieve submission with invalid user ID {string}")
	public void user_sends_https_get_request_to_retrieve_submission_with_invalid_user_id(String string) {
	    ast.Get_Submission_UserId(string);
	}
	@When("User sends HTTPS PUT Request  and  request Body  with invalid submission Id {int} mandatory and additional fields from excel sheet {string} and {int}")
	public void user_sends_https_put_request_and_request_body_with_invalid_submission_id_mandatory_and_additional_fields_from_excel_sheet_and(Integer int1, String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		//String assignmentId=testData.get(RowNumber).get("assignmentId");
		//String userId=testData.get(RowNumber).get("userId");
		String subDesc=testData.get(RowNumber).get("subDesc");
		String subComments=testData.get(RowNumber).get("subComments");
		String subPathAttach1=testData.get(RowNumber).get("subPathAttach1");
		String subPathAttach2=testData.get(RowNumber).get("subPathAttach2");
		String subPathAttach3=testData.get(RowNumber).get("subPathAttach3");
		String subPathAttach4=testData.get(RowNumber).get("subPathAttach4");
		String subPathAttach5=testData.get(RowNumber).get("subPathAttach5");
		String gradedBy=testData.get(RowNumber).get("gradedBy");
		String grade=testData.get(RowNumber).get("grade");
		ast.TestNegativePutGrade(int1, subDesc, subComments, subPathAttach1, subPathAttach2, subPathAttach3, subPathAttach4, subPathAttach5, gradedBy, grade);
	}

	@When("User sends HTTPS Request  and request Body with missing mandatory fields  with valid submission Id {int} mandatory and additional fields from excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_missing_mandatory_fields_with_valid_submission_id_mandatory_and_additional_fields_from_excel_sheet_and(Integer int1, String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String,String>> testData=reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		//String assignmentId=testData.get(RowNumber).get("assignmentId");
		//String userId=testData.get(RowNumber).get("userId");
		String subDesc=testData.get(RowNumber).get("subDesc");
		String subComments=testData.get(RowNumber).get("subComments");
		String subPathAttach1=testData.get(RowNumber).get("subPathAttach1");
		String subPathAttach2=testData.get(RowNumber).get("subPathAttach2");
		String subPathAttach3=testData.get(RowNumber).get("subPathAttach3");
		String subPathAttach4=testData.get(RowNumber).get("subPathAttach4");
		String subPathAttach5=testData.get(RowNumber).get("subPathAttach5");
		String gradedBy=testData.get(RowNumber).get("gradedBy");
		String grade=testData.get(RowNumber).get("grade");
		ast.TestNegativeMissingPutGrade(int1, subDesc, subComments, subPathAttach1, subPathAttach2, subPathAttach3, subPathAttach4, subPathAttach5, gradedBy, grade);
	
	}

	@Then("User receives {int} Bad request with message and boolean success details for invalid Submission request")
	public void user_receives_bad_request_with_message_and_boolean_success_details(Integer int1) {
	    ast.verify_Missingput_status();
	}

	@When("User sends HTTPS Delete Request for invalid Submission {int}")
	public void user_sends_https_delete_request_for_invalid_submission(Integer int1) {
	    ast.TestDeleteInvalidSubmission(int1);
	}

	@Then("User receives {int} Not Found Status with message and boolean success details for invalid Submission ID")
	public void user_receives_not_found_status_with_message_and_boolean_success_details_for_invalid_submission_id(Integer int1) {
	   ast.verify_invalid_del_status();
	}


}
	
	
