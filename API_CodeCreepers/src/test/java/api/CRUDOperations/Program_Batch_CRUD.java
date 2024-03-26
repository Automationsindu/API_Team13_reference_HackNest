package api.CRUDOperations;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.Payloads.*;
import api.Payloads.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import api.Actions.Program_Batch_TestCases;
import api.Payloads.Program_Batch_POJO;
import enums.Env_Var;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Program_Batch_CRUD {
	
	
	//method created for getting urls from property file
	
		static ResourceBundle getURL()
		{
			ResourceBundle endurl=ResourceBundle.getBundle("EndUrls");
			return endurl;
		}
		//To Perform CRUD for Batch Modules
		
		public static Response createbatch(Program_Batch_POJO payload)
		{
			String Program_Batch_post_url=getURL().getString("Program_Batch_Post_Url");
			Response response=RestAssured.given().auth().none()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
			
			.when()
			.post(Program_Batch_post_url);
		
			return response;
			
		}
		
		public static Response getAllBatches() {
			String get_url=getURL().getString("Program_Batch_Get_All_Url");
			Response response=given().auth().none()
					.contentType(ContentType.JSON)
					
					.when()
					.get(get_url);
					
					return response;
		}
		
		public static Response getBatchbyBatcheID(int batchId) {
			String get_url=getURL().getString("Program_Batch_Get_By_BatchId_Url");
			Response response=given().auth().none()
					.contentType(ContentType.JSON)
					.pathParam("batchId", batchId)
					.when()
					.get(get_url);
					
					return response;
		}
		
		public static Response getBatchbyBatchName(String batnm) {
			String get_url=getURL().getString("Program_Batch_Get_By_BatchName_Url");
			Response response=given().auth().none()
					.contentType(ContentType.JSON)
					.pathParam("batchName", batnm)
					.when()
					.get(get_url);
					
					return response;
		}
		
		public static Response getBatchbyProgramId(int progmid) {
			String get_url=getURL().getString("Program_Batch_Get_By_ProgramId_Url");
			Response response=given().auth().none()
					.contentType(ContentType.JSON)
					.pathParam("programId", progmid)
					.when()
					.get(get_url);
					
					return response;
		}
		
		public static Response putBatch(Program_Batch_POJO payload , int batchId) {
			String get_url=getURL().getString("Program_Batch_Update_Url");
			Response response=given().auth().none()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
					.pathParam("batchId", batchId)
					.when()
					.put(get_url);
					
					return response;
		}
		public static Response DeletebyBatchID(int bid )
		{
			String del_url=getURL().getString("Program_Batch_Delete_Url");
			bid=Env_Var.Batch_Id;
			Response response=given().auth().none()
					.contentType(ContentType.JSON)
					.pathParam("id", bid)
					
					.when()
					.delete(del_url);
					
					return response;
		}
		
		public static Response DeletebyInvalidBatchID(int bid )
		{
			String del_url=getURL().getString("Program_Batch_Delete_Url");
			//bid=Env_Var.Batch_Id;
			Response response=given().auth().none()
					.contentType(ContentType.JSON)
					.pathParam("id", bid)
					
					.when()
					.delete(del_url);
					
					return response;
		}
		
		

}