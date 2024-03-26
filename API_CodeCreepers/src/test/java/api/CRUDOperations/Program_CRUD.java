package api.CRUDOperations;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.Payloads.Assignment_Submit_POJO;
import api.Payloads.Program_POJO;
import enums.Env_Var;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Program_CRUD {
	
	static ResourceBundle getURL()
	{
		ResourceBundle endurl=ResourceBundle.getBundle("EndUrls");
		return endurl;
	}
	//To Perform CRUD for User Modules
	
	public static Response createProgram(Program_POJO  payload)
	{
		String url=getURL().getString("program_post_saveprogram_url");
		Response response= given().auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(url);
		
			return response;
	}
	
	public static Response getAllProgram()
	{
		String url=getURL().getString("program_get_all_program_url");
		Response response= given().auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				
				.when()
				.get(url);
		
			return response;
	}
	
	
	public static Response getrequestprogramId(int id)
	{
		String url=getURL().getString("program_get_by_program_id_url");
		Response response= given().auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParams("programId", id)
				.when()
				.get(url);
		
			return response;
	}
	
	public static Response updaterequestbyProgramId(Program_POJO  payload,int id)
	{
		String url=getURL().getString("program_put_request_by_program_id_url");
		Response response= given().auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParams("programId",id)
				.when()
				.put(url);
		
			return response;
	}
	
	
	public static Response updaterequestbyProgramName(Program_POJO  payload)
	{
		String url=getURL().getString("program_put_request_by_program_name_url");
		Response response= given().auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParams("programName",payload.getProgramName())
				.when()
				.put(url);
		
			return response;
	}
	
	
	public static Response deleterequestbyprogramName(String programName)
	{
		String url=getURL().getString("delete_put_program_by_name_url");
		programName=Env_Var.Program_Name;

		Response response= given().auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParams("programName",programName)
				.when()
				.delete(url);
		
			return response;
	}
	
	
	
	public static Response deleterequestbyprogramid(int programId)
	{
		String url=getURL().getString("delete_put_program_by_id_url");
		programId=Env_Var.Program_Id;
		Response response= given().auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParams("programId",programId)
				.when()
				.delete(url);
		
			return response;
	}
	

}
