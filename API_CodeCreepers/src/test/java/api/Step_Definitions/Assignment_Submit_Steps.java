package api.Step_Definitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

//import api.Actions.Assignment_Submit_TestCases;
import api.Actions.*;
import api.CRUDOperations.*;
import api.Payloads.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.Utilities.ExcelReader;
import api.Utilities.Loggerload;
import api.Utilities.ResponseHandler;
//import api.Utilities.TestContext;
import enums.Env_Var;
import api.Actions.*;

public class Assignment_Submit_Steps {
	Assignment_Submit_TestCases ast=new Assignment_Submit_TestCases();
	
	Response response;
	
	
	
	
	
	@When("User sends HTTPS request and request body with mandatory and additional fields from the assignment submit excel sheet {string} and {int}")
	public void user_sends_https_request_and_request_body_with_mandatory_and_additional_fields_from_the_assignment_submit_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
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
		ast.TestPostSubmission(  subDesc, subComments, subPathAttach1, subPathAttach2, subPathAttach3, subPathAttach4, subPathAttach5,gradedBy,grade);
		
	}

	@Then("User receives {int} created status with response body for the assignment submit module post request")
	public void user_receives_created_status_with_response_body_for_the_assignment_submit_module_post_request(Integer int1) {

		ast.verify_post_Submission_status();
		

	}
	
	@Then("User receives {int} Bad Request with response body for the assignment submit module post request")
	public void user_receives_bad_request_with_response_body_for_the_assignment_submit_module_post_request(Integer int1) {
	   ast.verify_existing_post_Sub_status();
	}
	
	


	@When("User sends HTTPS GET Request")
	public void user_sends_https_get_request() {
	   
		ast.Get_All_Grades();
	}

	@Then("User receives {int} OK Status with response body")
	public void user_receives_ok_status_with_response_body(Integer int1) {
		
		
		ast.verify_get_All_status();
	   
	}
	
	@When("User sends HTTPS Get Request with a valid Batch {int}")
	public void user_sends_https_get_request_with_a_valid_batch(Integer int1) {
		int id1= Env_Var.Batch_Id;
		ast.Get_Grades_BatchId(id1);
	    
	}
	@Then("User receives {int} OK Status with response body for GET Grades using batchid")
	public void user_receives_ok_status_with_response_body_for_get_grades_using_batchid(Integer int1) {
	   ast.verify_get_All_status();
	}

	
	
	@When("User sends HTTPS Put Request and  request Body with mandatory  fields from the assignment submit excel sheet {string} and {int}")
	public void user_sends_https_put_request_and_request_body_with_mandatory_fields_from_the_assignment_submit_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
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
		//ast.TestPostUser(  subDesc, subComments, subPathAttach1, subPathAttach2, subPathAttach3, subPathAttach4, subPathAttach5,gradedBy,grade);
		ast.TestPutGrade(subDesc, subComments, subPathAttach1, subPathAttach2, subPathAttach3, subPathAttach4, subPathAttach5, gradedBy, grade);
	}

	@Then("User receives {int} OK Status with updated value in response body")
	public void user_receives_ok_status_with_updated_value_in_response_body(Integer int1) {
	   ast.verify_Gradeput_status();
	}
	
	@When("User sends HTTPS Get Request with a valid Stud {string}")
	public void user_sends_https_get_request_with_a_valid_stud(String string) {
	   String usid=Env_Var.User_Id;
	   ast.Get_Grades_StudId(usid);
	}

	@Then("User receives {int} OK Status with response body for GET Grades using studid")
	public void user_receives_ok_status_with_response_body_for_get_grades_using_studid(Integer int1) {
	    ast.verify_get_All_status();
	}
	
	@When("User sends HTTPS Get Request with a valid User {string}")
	public void user_sends_https_get_request_with_a_valid_user(String string) {
		String usid1=Env_Var.User_Id;
	    ast.Get_Submission_UserId(usid1);
	}

	@Then("User receives {int} OK Status with response body for GET submissions using userid")
	public void user_receives_ok_status_with_response_body_for_get_submissions_using_userid(Integer int1) {
	    ast.verify_get_All_status();
	}
	@When("User sends HTTPS Get Request with a valid batchid {int}")
	public void user_sends_https_get_request_with_a_valid_batchid(Integer int1) {
		int bat1=Env_Var.Batch_Id;
	    ast.Get_Submission_BatchId(bat1);
	}

	@Then("User receives {int} OK Status with response body for GET submissions using batchid")
	public void user_receives_ok_status_with_response_body_for_get_submissions_using_batchid(Integer int1) {
	    ast.verify_get_All_status();
	}
	@When("User sends HTTPS Get Request with a valid assignment {int}")
	public void user_sends_https_get_request_with_a_valid_assignment(Integer int1) {
		int aid=Env_Var.Assignment_Id;
	    ast.Get_Grades_AssignId(aid);
	}

	@Then("User receives {int} OK Status with response body for GET submissions using assignmentid")
	public void user_receives_ok_status_with_response_body_for_get_submissions_using_assignmentid(Integer int1) {
	    ast.verify_get_All_status();
	}

	@When("User sends HTTPS Put Request to update submission and  request Body with mandatory  fields from the assignment submit excel sheet {string} and {int}")
	public void user_sends_https_put_request_to_update_submission_and_request_body_with_mandatory_fields_from_the_assignment_submit_excel_sheet_and(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
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
		ast.TestPutResubmit(subDesc, subComments, subPathAttach1, subPathAttach2, subPathAttach3, subPathAttach4, subPathAttach5, gradedBy, grade);
		
	}

	@Then("User receives {int} OK Status with updated submission value in response body")
	public void user_receives_ok_status_with_updated_submission_value_in_response_body(Integer int1) {
		ast.verify_Resubmitput_status();
		
	    
	}



	



}
