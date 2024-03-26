package api.CRUDOperations;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static org.hamcrest.Matchers.*;
import api.Payloads.Assignment_Submit_POJO;
import enums.Env_Var;
import api.Payloads.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class User_CRUD {
	
	RestAssured restAssured;
	static RequestSpecification requestSpecification=  RestAssured.given().baseUri("https://lms-api-hackathon-june2023-930a8b0f895d.herokuapp.com/lms");
	static Response response;
	
	static ResourceBundle getURL()
	{
		ResourceBundle endurl=ResourceBundle.getBundle("EndUrls");
		return endurl;
	}
	//To Perform CRUD for User Modules
	
	//To perform all CRUD operations for user module
	
			public static Response createUser(User_POJO userReqPayload ) 
		{
				String User_Post_Url= getURL().getString("User_Post_Url");
				Response response= RestAssured.given(requestSpecification).auth().none()
				.contentType(ContentType.JSON)
						.accept(ContentType.JSON).body(userReqPayload)
				 .when().post(User_Post_Url).then().log().all().extract().response();
				 
				
				System.out.println ("The content type in response is " + response.contentType());
			
				System.out.println("Rsponse code is : "+response.statusCode());
				System.out.println("The response time in MS is "+ response.time());
				return response;
				
		}
		
			public static Response get_userId(String uid)
			{
				String User_Get_Url__Id= getURL().getString("User_Get_Url__Id");
				
				 response= RestAssured.given(requestSpecification).auth().none()
						 .contentType(ContentType.JSON)
						 //.pathParam("userId", uid)
				.when().get(User_Get_Url__Id+ uid);
				//then().log().all().extract().response();
				return response;
				 //
				
			
			}
			

			
			public static void getAllUsers()
			{
				String User_Get_Url_AllUsers= getURL().getString("User_Get_Url_AllUsers");
				response= RestAssured.given(requestSpecification).auth().none()
						   .when().get(User_Get_Url_AllUsers);
						 //  .then().log().all().extract().response();
				System.out.println("All the user has been fetched but not diplayed");
				
				//Fetching one field under the response and checking the boolean value
				 List<String> userCommentsList = response.path("userComments");
				 String userCommentsList1 = response.path("userComments").toString();
				 System.out.println("The class is "+userCommentsList1.getClass());
				 System.out.println ("The boolean value is "+ userCommentsList.contains("Api_Creepers_R01"));
				 System.out.println("The response code is "+ response.getStatusCode());
				 response.then().statusCode(200);
				 response.then().contentType("");
				 //response.then().header(userCommentsList1, null);
				 response.then().body("find{it.userId=='U8208'}.userFirstName", equalTo("APIValidators_682 User"));
				// response.then().body("find { it.userId == 'U8840' }.userPhoneNumber", equalTo(3091105502));
				 response.then().body("userId", hasItems("U8426", "U8427", "U8847"));
			
			}
			public static void getAllStaff()
			{
				String User_Get_Url_Staff= getURL().getString("User_Get_Url_Staff");
				response= RestAssured.given(requestSpecification).auth().none()
						   .when().get(User_Get_Url_Staff)
						   .then().log().all().extract().response();
				
				System.out.println("The response is "+ response);
				System.out.println("The response code is "+ response.getStatusCode());
			}
			
			public static void getAllUsers_Roles()
			{
				String User_Get_Url__Roles= getURL().getString("User_Get_Url__Roles");
				response= RestAssured.given(requestSpecification).auth().none()
						   .when().get(User_Get_Url__Roles);
						  // .then().log().all().extract().response();
				System.out.println("All the user has been fetched based on roles but not diplayed");
				System.out.println("The response code is "+ response.getStatusCode());
										
			}
			
			public static Response updateUser(String userId,User_Proj_Batch_Pojo payload)
			{
				String update_url=getURL().getString("User_Update_Url");
				response= RestAssured.given(requestSpecification).auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("userId", userId)
				.body(payload).log().all()
				
				
				.when()
				.put(update_url);
				
				return response;
			}
			public static Response updateUserById(String userId,User_Update_By_Id_POJO payload1)
			{
				String User_Update_Url_id=getURL().getString("User_Update_Url_id");
				userId=Env_Var.User_Id;
				response= RestAssured.given(requestSpecification).auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("userId", userId)
				.body(payload1).log().all()
				
				.when()
				.put(User_Update_Url_id);
				
				return response;
			}
			
			public static Response updateUserRoles(String uuidd, User_Update_Roles_POJO payload2)
			{
				
				String User_Update_Url_RoleStatus=getURL().getString("User_Update_Url_RoleStatus");
				
				response= RestAssured.given(requestSpecification).auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				//.pathParam("userID",uuidd )
				.body(payload2).log().all()
				
				
				.when()
				.put(User_Update_Url_RoleStatus + uuidd);
				
				return response;
			}
				
			//****Negative Scenarios***********
			
			public static Response negative1_createUser(User_POJO userpayload)
			{
				String post_url=getURL().getString("User_Post_Url");
				response= RestAssured.given(requestSpecification).auth().none()
				//Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(userpayload)
				
				.when()
				.post(post_url);
				
				return response;
			}
				
			public static Response negative2_createUser(UserRole_POJO_Negative Nuserpayload)
			{
				String post_url=getURL().getString("User_Post_Url");
				response= RestAssured.given(requestSpecification).auth().none()
				//Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Nuserpayload)
				
				.when()
				.post(post_url);
				
				return response;
			}
		

			public static Response get_Invalid_userId(String uid)
				{
					String User_Get_Url__Id= getURL().getString("User_Get_Url__Id");
					
					 return response= RestAssured.given(requestSpecification).auth().none()
							 .contentType(ContentType.JSON)
							 //.pathParam("userId", uid)
					.when().get(User_Get_Url__Id+ uid);
			
				}
			
			public static Response update_Invalid_UserById(String uuid,User_Update_By_Id_POJO payload1)
			{
				String User_Update_Url_id=getURL().getString("User_Update_Url_id");
				
				response= RestAssured.given(requestSpecification).auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("userId", uuid)
				.body(payload1).log().all()
				
				.when()
				.put(User_Update_Url_id);
				
				return response;
			}
			
			public static Response deleteUser_negative(String dId)
			{
				String User_Delete_Url_Neg=getURL().getString("User_Delete_Url_Neg");
				response= RestAssured.given(requestSpecification).auth().none()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.when().delete(User_Delete_Url_Neg+dId );
				return response;
				
			}
			
			public static Response negative3_missing_createUser(User_POJO userpayload)
			{
				String post_url=getURL().getString("User_Post_Url");
				response= RestAssured.given(requestSpecification).auth().none()
				//Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(userpayload)
				
				.when()
				.post(post_url);
				
				return response;
			}
			public static Response Negative_updateUser(User_Proj_Batch_Pojo payload)
			{
				String update_url=getURL().getString("User_Update_Url");
				response= RestAssured.given(requestSpecification).auth().none()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				//.pathParam("userId", userId)
				.body(payload).log().all()
				
				
				.when()
				.put(update_url+"U24");
				
				return response;
			}
	public static Response DeletebyUserID(String uid )
	{
		String del_url=getURL().getString("User_Delete_Url");
		uid=Env_Var.User_Id;
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("userID", uid)
				
				.when()
				.delete(del_url);
				
				return response;
	}
	
	
	
	public static Response DeletebyInvalidUserId(String aid )
	{
		String del_url=getURL().getString("User_Delete_Url");
		
		Response response=given().auth().none()
				.contentType(ContentType.JSON)
				.pathParam("userID", aid)
				
				.when()
				.delete(del_url);
				
				return response;
	}

}
