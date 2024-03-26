package api.CRUDOperations;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import org.testng.ITestContext;

import api.Payloads.*;
import enums.Env_Var;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Assignment_CRUD {
	Env_Var assignmentid=new Env_Var();
	int assignid=assignmentid.Assignment_Id;
	static ResourceBundle getURL()
	{
		ResourceBundle endurl=ResourceBundle.getBundle("EndUrls");
		return endurl;
	}
	//To Perform CRUD for User Modules
	
	public static Response createAssignment(Assignment_POJO userpayload)
	{
		String post_url=getURL().getString("Assignment_Post_Url");
		Response id=given().auth().none()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(userpayload)
		
		.when()
		.post(post_url);
		
		System.out.println(id);
		//context.setAttribute("user_id", id);
		
		
		return id;
	}

	
	public static Response getUsingAsID(int id)
	{
		
		String get_url=getURL().getString("Assignment_Get_AsId_Url");
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("assignmentId", id)
				
				
				
				.when()
				.get(get_url);
				
				return response;
		}
	
	public static Response getAll_Assignments()
	{
		String get_url=getURL().getString("Assignment_Get_AllAs_Url");
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				
				
				
				.when()
				.get(get_url);
				
				return response;
	}
	
	public static Response getUsingAsBatch(int bid)
	{
		
		String get_url=getURL().getString("Assignment_Get_BatchId_Url");
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("batchID", bid)
				
				
				
				.when()
				.get(get_url);
				
				return response;
		}
	
	
	public static Response updateAssignment(int asid,Assignment_POJO payload)
	{
		Env_Var.Assignment_Id=asid;
		String put_url=getURL().getString("Assignment_Update_Url");
		Response response=given().auth().none()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("assignmentID", asid)
		.body(payload)
		
		
		.when()
		.put(put_url);
		
		return response;
	}
	
	public static Response updateInvalidAssignment(int asid,Assignment_POJO payload)
	{
		//Env_Var.Assignment_Id=asid;
		String put_url=getURL().getString("Assignment_Update_Url");
		Response response=given().auth().none()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("assignmentID", asid)
		.body(payload)
		
		
		.when()
		.put(put_url);
		
		return response;
	}
	
	public static Response DeletebyAssignId(int aid )
	{
		String del_url=getURL().getString("Assignment_Delete_Url");
		aid=Env_Var.Assignment_Id;
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("assignmentID", aid)
				
				.when()
				.delete(del_url);
				
				return response;
	}
	
	public static Response DeletebyInvalidAssignId(int aid )
	{
		String del_url=getURL().getString("Assignment_Delete_Url");
		//aid=Env_Var.Assignment_Id;
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("assignmentID", aid)
				
				.when()
				.delete(del_url);
				
				return response;
	}
}
