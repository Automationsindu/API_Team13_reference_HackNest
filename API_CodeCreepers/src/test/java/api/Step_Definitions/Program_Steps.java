package api.Step_Definitions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.github.javafaker.Faker;

import api.Actions.Program_TestCases;
import api.Utilities.ExcelReader;
import enums.Env_Var;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Program_Steps {

	Program_TestCases actions = new Program_TestCases();

	Faker faker = new Faker();

	@When("User sends HTTPS request,request body to create program from the excel sheet {string} and {int}")
	public void user_sends_HTTPS_request_request_body_from_the_excel_sheet_and(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);
		//String programName = testData.get(RowNumber).get("ProgramName");
		String programDescription = testData.get(RowNumber).get("programDescription");
		String programStatus = testData.get(RowNumber).get("programStatus");
		actions.testPostProgram( programDescription, programStatus);
	}

	@Then("The user submits the post request and verifies the status 201")
	public void the_user_submits_the_post_request_and_verifies_the_status_code() {
		actions.verify_post_status(201);
	}

	@When("User sends HTTPS request to get all programs")
	public void user_sends_HTTPS_request_to_get_all_programs() {
		actions.TestgetAllProgram();
	}

	@Then("The user submits the get request and verifies the status 200")
	public void the_user_submits_the_get_request_and_verifies_the_status_code() {
		actions.verify_get_status(200);
	}

	@When("User sends HTTPS request to get request by valid programid")
	public void user_sends_HTTPS_request_to_get_request_by_programid() throws InvalidFormatException, IOException {
		actions.testGetRequestByProgramId(Env_Var.Program_Id);
	}

	@When("User sends HTTPS request with mandatory fields to update a request by program id from the excel sheet {string} and {int}")
	public void user_sends_HTTPS_request_with_mandatory_fields_to_update_a_request_by_program_id_from_the_excel_sheet_and(
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);

		//String programName = testData.get(RowNumber).get("ProgramName");
		String programDescription = testData.get(RowNumber).get("programDescription");
		String programStatus = testData.get(RowNumber).get("programStatus");
		actions.testUpdateProgramByProgramId( programDescription, programStatus, Env_Var.Program_Id);
	}

	@Then("The user submits the update request and verifies the status 200")
	public void the_user_submits_the_update_request_and_verifies_the_status_code() {
		actions.verify_update_request_by_program_name_status(200);
	}

	@When("User sends HTTPS request with mandatory fields to update program by program name from the excel sheet {string} and {int}")
	public void user_sends_HTTPS_request_with_mandatory_fields_to_update_a_request_by_program_name_from_the_excel_sheet_and(
			String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", SheetName);

		String programDescription = testData.get(RowNumber).get("programDescription");
		String programStatus = testData.get(RowNumber).get("programStatus");
		actions.testUpdateProgramByProgramName(Env_Var.Program_Name, programDescription, programStatus);
	}
	

}