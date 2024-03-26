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

public class Program_Negative_Steps {
	
	

	
		Program_TestCases actions = new Program_TestCases();

		@When("User sends HTTPS request,request body with existing program name from the excel sheet {string} and {int}")
		public void user_sends_HTTPS_request_request_body_with_existing_program_name_from_the_excel_sheet_and(
				String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", sheetName);
			String programName = testData.get(rowNumber).get("ProgramName");
			String programDescription = testData.get(rowNumber).get("ProgramDescription");
			String programStatus = testData.get(rowNumber).get("ProgramStatus");
			
			actions.testExPostProgram(programName, programDescription, programStatus);
		}
		
		@Then("The user submits the post request and verifies the status 400")
		public void the_user_submits_the_post_request_and_verifies_the_status_code() {
			actions.verify_post_status(400);
		}

		@When("User sends HTTPS request,request body with missing mandatory fields from the excel sheet {string} and {int}")
		public void user_sends_HTTPS_request_request_body_with_missing_mandatory_fields_from_the_excel_sheet_and(
				String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", sheetName);
			String programName = testData.get(rowNumber).get("ProgramName");
			String programDescription = testData.get(rowNumber).get("ProgramDescription");
			String programStatus = testData.get(rowNumber).get("ProgramStatus");
			actions.testExPostProgram(programName, programDescription, programStatus);
		}

		@When("User sends HTTPS request to get request by invalid program id  from the excel sheet {string} and {int}")
		public void user_sends_HTTPS_request_to_get_request_by_programid_from_the_excel_sheet(String sheetName,
				int rowNumber) throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", sheetName);
			String programId = testData.get(rowNumber).get("ProgramId");
			actions.testGetRequestByProgramId(Integer.parseInt(programId));
		}

		@Then("The user submits the get request and verifies the status 404")
		public void the_user_submits_the_get_request_and_verifies_the_status_code() {
			actions.verify_get_status(404);
		}
		
		@When("User sends HTTPS request with missing mandatory fields to update program by program name from the excel sheet {string} and {int}")
		public void user_sends_HTTPS_request_with_mandatory_fields_to_update_request_by_program_name_from_the_excel_sheet_and(
				String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", sheetName);

			String programDescription = testData.get(rowNumber).get("ProgramDescription");
			String programStatus = testData.get(rowNumber).get("ProgramStatus");
			actions.testUpdateProgramByProgramName(Env_Var.Program_Name, programDescription, programStatus);
		}
		
		@Then("The user submits the update request and verifies the status 500")
		public void the_user_submits_the_update_request_and_verifies_the_status_code() {
			actions.verify_update_request_by_program_name_status(500);
		}

		@When("User sends HTTPS request with invalid program id to update program from the excel sheet {string} and {int}")
		public void user_sends_HTTPS_request_with_missing_mandatory_fields_from_the_excel_sheet_and(String sheetName,
				Integer rowNumber) throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", sheetName);

			String programName = testData.get(rowNumber).get("ProgramName");
			String programDescription = testData.get(rowNumber).get("ProgramDescription");
			String programStatus = testData.get(rowNumber).get("ProgramStatus");
			String programIdFromExcel = testData.get(rowNumber).get("ProgramId");
			actions.testUpdateProgramByProgramId_Neg(programName, programDescription, programStatus,
					Integer.parseInt(programIdFromExcel));
		}
		
		@Then("The user submits the update request and verifies the status 404")
		public void the_user_submits_the_update_request_and_verifies_the_status_code_404() {
			actions.verify_update_request_by_program_name_status(404);
		}

		@When("User sends HTTPS request with invalid program name to update program from the excel sheet {string} and {int}")
		public void user_sends_HTTPS_request_with_invalid_program_nameto_update_program_from_the_excel_sheet_and(
				String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", sheetName);

			String programName = testData.get(rowNumber).get("ProgramName");
			String programDescription = testData.get(rowNumber).get("ProgramDescription");
			String programStatus = testData.get(rowNumber).get("ProgramStatus");
			actions.testUpdateProgramByProgramName(programName, programDescription, programStatus);
		}

		@When("User sends HTTPS request with missing mandatory fields to update program by program id from the excel sheet {string} and {int}")
		public void user_sends_HTTPS_request_with_missing_mandatory_fields_to_update_request_by_id_from_the_excel_sheet_and(
				String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
			ExcelReader reader = new ExcelReader();
			List<Map<String, String>> testData = reader.getData(".\\TestData\\Test_Data.xlsx", sheetName);

			String programName = testData.get(rowNumber).get("ProgramName");
			String programDescription = testData.get(rowNumber).get("ProgramDescription");
			String programStatus = testData.get(rowNumber).get("ProgramStatus");

			actions.testUpdateProgramByProgramId_Neg(programName, programDescription, programStatus, Env_Var.Program_Id);
		}

//		@When("User sends HTTPS request to delete request by programName")
//		public void user_sends_HTTPS_request_to_delete_request_by_programName() throws InvalidFormatException, IOException {
//			actions.TestdeleterequestbyprogramName(Env_Var.Program_Name);
//		}
	//
//		@Then("The user submits the delete request and verifies the status 200")
//		public void the_user_submits_the_delete_request_and_verifies_the_status_code() {
//			actions.verify_delete_request_by_program_name_status(200);
//		}
	//
//		@When("User sends HTTPS request to delete request by programId")
//		public void user_sends_HTTPS_request_to_delete_request_by_programId() throws InvalidFormatException, IOException {
//			actions.TestdeleterequestbyprogramId(Env_Var.Program_Id);
//		}
	//	
//		@Then("The user submits the delete request and verifies the status 404")
//		public void the_user_submits_the_delete_request_and_verifies_the_status_code_404() {
//			actions.verify_delete_request_by_program_name_status(404);
//		}

}
