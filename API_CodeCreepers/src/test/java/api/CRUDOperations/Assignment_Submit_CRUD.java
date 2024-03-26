package api.CRUDOperations;

import org.json.JSONObject;
import org.json.JSONTokener;
import  org.testng.annotations.Test;

import api.Payloads.Assignment_POJO;
import api.Payloads.Assignment_Submit_POJO;
import enums.Env_Var;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Assignment_Submit_CRUD {
	
	static ResourceBundle getURL()
	{
		ResourceBundle endurl=ResourceBundle.getBundle("EndUrls");
		return endurl;
	}
	//To Perform CRUD for User Modules
	
	public static Response createSubmission(Assignment_Submit_POJO payload)
	{
		String post_url=getURL().getString("Assignment_Submit_Post_Url");
		Response response=given().log().body().auth().none()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post_url);
		
		return response;
	}
	
	public static Response getAllSubmission()
	{
		String get_url=getURL().getString("Assignment_Submit_Get_All_Url");
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				
				
				
				.when()
				.get(get_url);
				
				return response;
	}

	public static Response getGradesbyBatchId(int batchID )
	{
		String get_url=getURL().getString("Assignment_Submit_Get_Grades_By_BatchId_Url");
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("batchID", batchID)
				
				.when()
				.get(get_url);
				
				return response;
	}
	
	public static Response getGradesbyStudId(String userId)
	{
		String get_url=getURL().getString("Assignment_Submit_Get_Grades_By_StudentId_Url");
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("studentID", userId)
				
				.when()
				.get(get_url);
				
				return response;
	}
	
	public static Response updateSubmissionGrades(int subid,Assignment_Submit_POJO payload)
	{
		Env_Var.Submission_Id=subid;
		String put_url=getURL().getString("Assignment_Submit_Update_Grade_Url");
		Response response=given().auth().none()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("submissionId", subid)
		.body(payload)
		
		
		.when()
		.put(put_url);
		
		return response;
	}
	
	//Negative Put
	public static Response updateNegativeSubmissionGrades(int subid,Assignment_Submit_POJO payload)
	{
		//Env_Var.Submission_Id=subid;
		String put_url=getURL().getString("Assignment_Submit_Update_Grade_Url");
		Response response=given().auth().none()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("submissionId", subid)
		.body(payload)
		
		
		.when()
		.put(put_url);
		
		return response;
	}
	public static Response getSubmissionbyUserId(String userId)
	{
		String get_url=getURL().getString("Assignment_Submit_Get_Submittion_By_UserId_Url");
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("userId", userId)
				
				.when()
				.get(get_url);
				
				return response;
	}
	public static Response getSubmissionbybatchId(int batchId)
	{
		String get_url=getURL().getString("Assignment_Submit_Get_Submittion_By_BatchId_Url");
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("batchId", batchId)
				
				.when()
				.get(get_url);
				
				return response;
	}
	public static Response getGradesbyAssignId(int assignid)
	{
		String get_url=getURL().getString("Assignment_Submit_Get_Grades_By_AssignId_Url");
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("assignmentId", assignid)
				
				.when()
				.get(get_url);
				
				return response;
	}
	public static Response updateSubmissionResubmit(int id,Assignment_Submit_POJO payload)
	{
		Env_Var.Assignment_Id=id;
		String put_url=getURL().getString("Assignment_Submit_Update_Resubmit_Url");
		Response response=given().auth().none()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("Id", id)
		.body(payload)
		
		
		.when()
		.put(put_url);
		
		return response;
	}
	
	public static Response DeletebySubId(int subid )
	{
		String del_url=getURL().getString("Assignment_Submit_Delete_Url");
		subid=Env_Var.Submission_Id;
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("Id", subid)
				
				.when()
				.delete(del_url);
				
				return response;
	}
	public static Response DeletebyInvalidSubId(int subid )
	{
		String del_url=getURL().getString("Assignment_Submit_Delete_Url");
		//subid=Env_Var.Submission_Id;
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("Id", subid)
				
				.when()
				.delete(del_url);
				
				return response;
	}
}
