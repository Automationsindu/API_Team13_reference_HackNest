package api.Actions;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;

import io.restassured.response.Response;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import com.github.javafaker.Faker;
import api.CRUDOperations.*;
import api.Payloads.*;
import api.Utilities.Loggerload;
import enums.Env_Var;
import io.restassured.path.json.JsonPath;

public class User_TestCases {
	
	Response response;
	Response afterupdateresponse;
	String extractresponse;
	JsonPath jsonPathEvaluator;
	Faker faker;
	Env_Var progmid=new Env_Var();
	Env_Var batchid=new Env_Var();
	Env_Var usrid=new Env_Var();
	Env_Var fName=new Env_Var();
	Env_Var lName=new Env_Var();
	Env_Var Tz=new Env_Var();
	Env_Var vStatus=new Env_Var();
	
	
	
	
	public void TestPostUser(String userComments,String userEduPg,String userEduUg,
			String userLinkedinUrl,String userLocation,String roleId,String userRoleStatus,
			String userTimeZone,String userVisaStatus) throws FileNotFoundException
	
	{
		User_POJO userpayload=new User_POJO();
		faker=new Faker();
		User_Role_Pojo userrolepayload =new User_Role_Pojo();
		userpayload.setUserComments(userComments);
		userpayload.setUserEduPg(userEduPg);
		userpayload.setUserEduUg(userEduUg);
		userpayload.setUserFirstName(faker.name().firstName());
		userpayload.setUserLastName(faker.name().lastName());
		userpayload.setUserLinkedinUrl(userLinkedinUrl);
		userpayload.setUserLocation(userLocation);
		userpayload.setUserMiddleName(faker.name().nameWithMiddle());
		userpayload.setUserPhoneNumber(faker.number().numberBetween(1000000000L, 9999999999L));
		userrolepayload.setRoleId(roleId);
		userrolepayload.setUserRoleStatus(userRoleStatus);
		
		userpayload.setUserTimeZone(userTimeZone);
		userpayload.setUserVisaStatus(userVisaStatus);
		List<User_Role_Pojo> UserList=new ArrayList<User_Role_Pojo>();
		UserList.add(userrolepayload);
		userpayload.setUserRoleMaps(UserList);
		
		response= User_CRUD.createUser(userpayload);
		response.then().log().all();
		System.out.println(response.path("userPhoneNumber").toString());
		extractresponse=response.then().log().all().extract().response().asString();
		JsonPath js= new JsonPath(extractresponse);
		String userid=js.getString("userId");
		System.out.println("User Id is" +userid);
		usrid.User_Id=userid;
		String uFName= js.getString("userFirstName");
		
		fName.first_name=uFName;
		String uLName=js.getString("userLastName");
		lName.last_name=uLName;
		
		String uTZone=js.getString("userTimeZone");
		Tz.time_zone=uTZone;
		
		String uVStatus=js.getString("userVisaStatus");
		vStatus.visa_status=uVStatus;
		
		
		
		
	}
		
		public int verify_post_status() {
			int code;
			code=response.getStatusCode();
			Assert.assertEquals(response.getStatusCode(),code);
			Assert.assertEquals(response.header("Content-Type"), "application/json");
			Assert.assertEquals(response.header("Connection"), "keep-alive");
			System.out.println("All assertions passed");
			return code;
			
		}	
		
		public void getUserById(String uid)
		{
			response= User_CRUD.get_userId(uid);
			System.out.println(response.getStatusCode());
		}
		
		public void code_status(int rcode)
		{
			//Assert.assertEquals(response.getStatusCode(), rcode);
		}
		
		@SuppressWarnings("static-access")
		public void TestUpdateUser(String roleId,String userRoleProgramBatchStatus)
		{
			User_Proj_Batch_Pojo userpayload=new User_Proj_Batch_Pojo();
			User_Map_Prog_Batch_Pojo userbatchpayload=new User_Map_Prog_Batch_Pojo();
			userpayload.setProgramId(progmid.Program_Id);
			userpayload.setRoleId(roleId);
			userpayload.setUserId(usrid.User_Id);
			userbatchpayload.setBatchId(batchid.Batch_Id);
			userbatchpayload.setUserRoleProgramBatchStatus(userRoleProgramBatchStatus);
			List<User_Map_Prog_Batch_Pojo> UserList=new ArrayList<User_Map_Prog_Batch_Pojo>();
			UserList.add(userbatchpayload);
			userpayload.setUserRoleProgramBatches(UserList);
			System.out.println("The value of userId is "+ usrid.User_Id );
		    response= User_CRUD.updateUser(usrid.User_Id,userpayload);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
		}
		
		public void Update_status(int code)
		{
		
			
			code=response.getStatusCode();
			System.out.println("The status code is "+ code);
		}
		
		public void Get_user_ID(String uid)
		{
			
				//Loggerload.info("*********************** Retriving Assignment *************");

				response= User_CRUD.get_userId(uid);
				response.then().log().all();
				System.out.println(response.getStatusCode());
				

			}


		public void TestUpdateUserById(String uuid)
		
		
		{
			User_Update_By_Id_POJO payload1= new User_Update_By_Id_POJO();
			faker=new Faker();
			payload1.setUserComments("CodeCreepers "+faker.number().randomDigit());
			payload1.setUserEduPg("string1");
			payload1.setUserEduUg("string2");
			payload1.setUserFirstName(fName.first_name);
			payload1.setUserId(usrid.User_Id);
			payload1.setUserLastName(faker.name().lastName());
			payload1.setUserLinkedinUrl("string3");
			payload1.setUserLocation("string4");
			payload1.setUserPhoneNumber(faker.number().numberBetween(1000000000L, 9999999999L));
			payload1.setUserTimeZone(Tz.time_zone);
			payload1.setUserVisaStatus(vStatus.visa_status);
			
			response= User_CRUD.updateUserById(usrid.User_Id, payload1);
			response.then().log().all();
			
			
			
			
		}
		
		public void status_TestUpdateUserById()
		{
		
			int code;
			code=response.getStatusCode();
			Assert.assertEquals(code, 200);
		}
		
		public void TestUpdateUserRoles(String uuidd)
		{
			System.out.println("The roleStatus updated for the id id "+ uuidd);
			User_Update_Roles_POJO payload2= new User_Update_Roles_POJO();
			payload2.setRoleId("R01");
			payload2.setUserRoleStatus("Dormant");
			response= User_CRUD.updateUserRoles(uuidd, payload2);
			response.then().log().all();
			
		}
		
		
    //************Negative Scenarios******************************
		
		public void negative1_TestPostUser(String userComments,String userEduPg,String userEduUg,
				String userLinkedinUrl,String userLocation,String roleId,String userRoleStatus,
				String userTimeZone,String userVisaStatus)
		{
			User_POJO userpayload=new User_POJO();
			Faker faker=new Faker();
			User_Role_Pojo userrolepayload =new User_Role_Pojo();
			userpayload.setUserComments("CodeCreepers");
			userpayload.setUserEduPg("string");
			userpayload.setUserEduUg("string1");
			userpayload.setUserFirstName(faker.name().firstName());
			userpayload.setUserLastName(faker.name().lastName());
			userpayload.setUserLinkedinUrl("string2");
			userpayload.setUserLocation("string3");
			userpayload.setUserMiddleName("string4");
			userpayload.setUserPhoneNumber(756321789);
			
			userrolepayload.setRoleId("R01");
			userrolepayload.setUserRoleStatus("Active");
			
			userpayload.setUserTimeZone("CST");
			userpayload.setUserVisaStatus("H4-EAD");
			List<User_Role_Pojo> UserList=new ArrayList<User_Role_Pojo>();
			UserList.add(userrolepayload);
			userpayload.setUserRoleMaps(UserList);
	
			//Loggerload.info("*********************** Creating User *************");
			response= User_CRUD.negative1_createUser(userpayload);
			response.then().log().all();
			extractresponse=response.then().log().all().extract().response().asString();
			
			
		}
		
		public int verify_Negative1post_status() {
			
			int code;
			code=response.getStatusCode();
			Assert.assertEquals(code, 400);
			//Loggerload.info("*********************** User is Created ****************");
			return code;

		}
		
		public void negative2_TestPostUser(String userComments,String userEduPg,String userEduUg,
				String userLinkedinUrl,String userLocation,String roleId,String userRoleStatus,
				String userTimeZone,String userVisaStatus)
		{
			UserRole_POJO_Negative Nuserpayload=new UserRole_POJO_Negative();
			Faker faker=new Faker();
			User_Role_Pojo userrolepayload =new User_Role_Pojo();
			Nuserpayload.setUserComments("CodeCreepers");
			Nuserpayload.setUserEduPg("string");
			Nuserpayload.setUserEduUg("string1");
			Nuserpayload.setUserFirstName(faker.name().firstName());
			Nuserpayload.setUserLastName(faker.name().lastName());
			Nuserpayload.setUserLinkedinUrl("string2");
			Nuserpayload.setUserLocation("string3");
			Nuserpayload.setUserMiddleName("string4");
		
			
			userrolepayload.setRoleId("R01");
			userrolepayload.setUserRoleStatus("Active");
			
			Nuserpayload.setUserTimeZone("CST");
			Nuserpayload.setUserVisaStatus("H4-EAD");
			List<User_Role_Pojo> UserList=new ArrayList<User_Role_Pojo>();
			UserList.add(userrolepayload);
			Nuserpayload.setUserRoleMaps(UserList);
	
			//Loggerload.info("*********************** Creating User *************");
			response= User_CRUD.negative2_createUser(Nuserpayload);
			response.then().log().all();
			extractresponse=response.then().log().all().extract().response().asString();
			
			
		}
		
		public void Get_Invalid_user_ID(String uid)
		{
			
				//Loggerload.info("*********************** Retriving Assignment *************");

				response= User_CRUD.get_userId(uid);
				response.then().log().all();
				int cde= response.getStatusCode();
				//Get_Invalid_code(cde);
				
				
		
			}
		
		
		public void Get_Invalid_code(int err_code)
		{
			
		System.out.println("The status code is "+ response.getStatusCode());
		
		//String err_msg= response.jsonPath().get("message");
		//System.out.println("captured message : "+ err_msg);
		}
		
		public void missig_mandatory(String string)
		
		
		{
			User_Update_By_Id_POJO payload1= new User_Update_By_Id_POJO();
			faker=new Faker();
			payload1.setUserComments("CodeCreepers "+faker.number().randomDigit());
			payload1.setUserEduPg("string1");
			payload1.setUserEduUg("string2");
			payload1.setUserFirstName(fName.first_name);
			payload1.setUserId(string);
			payload1.setUserLastName(faker.name().lastName());
			payload1.setUserLinkedinUrl("string3");
			payload1.setUserLocation("string4");
			payload1.setUserPhoneNumber(faker.number().numberBetween(1000000000L, 9999999999L));
			payload1.setUserTimeZone(Tz.time_zone);
			payload1.setUserVisaStatus(vStatus.visa_status);
			
			response= User_CRUD.update_Invalid_UserById(string, payload1);
			response.then().log().all();
		}
		
	public void TestUpdate_missing(String uuid,String userComments,String userEduPg,String userEduUg,
			String userLinkedinUrl,String userLocation,String roleId,String userRoleStatus,
			String userTimeZone,String userVisaStatus)
			{
		User_Update_By_Id_POJO payload1= new User_Update_By_Id_POJO();
		faker=new Faker();
			payload1.setUserComments("CodeCreepers "+faker.number().randomDigit());
			payload1.setUserEduPg("string1");
			payload1.setUserEduUg("string2");
			//payload1.setUserFirstName(fName.first_name);
			payload1.setUserId(uuid);
			//payload1.setUserLastName(faker.name().lastName());
			payload1.setUserLinkedinUrl("string3");
			payload1.setUserLocation("string4");
			//payload1.setUserPhoneNumber(faker.number().numberBetween(1000000000L, 9999999999L));
			payload1.setUserTimeZone(Tz.time_zone);
			//payload1.setUserVisaStatus(vStatus.visa_status);
	
			response= User_CRUD.update_Invalid_UserById(uuid, payload1);
			response.then().log().all();
}

	public void negative_delete(String delStr)
	{
		response=User_CRUD.deleteUser_negative(delStr);
		
	}
	public void verify_delete_User_status() {

		Assert.assertEquals(response.getStatusCode(), 404);

		//Loggerload.info("*********************** All Batches ****************");

		}
	
	public void negative3_missing_TestPostUser(String userComments,String userEduPg,String userEduUg,
			String userLinkedinUrl,String userLocation,String userRoleStatus,
			String userTimeZone,String userVisaStatus)
	{
		User_POJO userpayload=new User_POJO();
		Faker faker=new Faker();
		User_Role_Pojo userrolepayload =new User_Role_Pojo();
		userpayload.setUserComments("CodeCreepers");
		userpayload.setUserEduPg("string");
		userpayload.setUserEduUg("string1");
		userpayload.setUserFirstName(faker.name().firstName());
		userpayload.setUserLastName(faker.name().lastName());
		userpayload.setUserLinkedinUrl("string2");
		userpayload.setUserLocation("string3");
		userpayload.setUserMiddleName("string4");
		userpayload.setUserPhoneNumber(faker.number().numberBetween(1000000000L, 9999999999L));
	
		
		//userrolepayload.setRoleId("R01");
		userrolepayload.setUserRoleStatus("Active");
		
		userpayload.setUserTimeZone("CST");
		userpayload.setUserVisaStatus("H4-EAD");
		List<User_Role_Pojo> UserList=new ArrayList<User_Role_Pojo>();
		UserList.add(userrolepayload);
		userpayload.setUserRoleMaps(UserList);

		//Loggerload.info("*********************** Creating User *************");
		response= User_CRUD.negative3_missing_createUser(userpayload);
		response.then().log().all();
		extractresponse=response.then().log().all().extract().response().asString();
		
		
	}
	
	public void verify_missing_TestPostUser(int cde) {

		System.out.println("The status code is "+ response.getStatusCode());
		

		//Loggerload.info("*********************** All Batches ****************");

		}
	
	public void Negative_TestUpdateUser(String roleId,String userRoleProgramBatchStatus)
	{
		User_Proj_Batch_Pojo userpayload=new User_Proj_Batch_Pojo();
		User_Map_Prog_Batch_Pojo userbatchpayload=new User_Map_Prog_Batch_Pojo();
		userpayload.setProgramId(progmid.Program_Id);
		userpayload.setRoleId(roleId);
		userpayload.setUserId("U24");
		userbatchpayload.setBatchId(batchid.Batch_Id);
		userbatchpayload.setUserRoleProgramBatchStatus(userRoleProgramBatchStatus);
		List<User_Map_Prog_Batch_Pojo> UserList=new ArrayList<User_Map_Prog_Batch_Pojo>();
		UserList.add(userbatchpayload);
		userpayload.setUserRoleProgramBatches(UserList);
		
	    response= User_CRUD.Negative_updateUser(userpayload);
		response.then().log().all();
		//Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	public void Update__invalidId_status(int code)
	{
	
		
		code=response.getStatusCode();
		System.out.println("The status code is "+ code);
	}
	
	public void TestDeleteUser(String id )
	{
		Loggerload.info("*********************** Deleting Submission *************");

		response= User_CRUD.DeletebyUserID(id);
		//afterdelresponse.then().log().all();
		

	}
	public void TestDeleteInvalidUser(String id )
	{
		Loggerload.info("*********************** Deleting Submission *************");

		response= User_CRUD.DeletebyInvalidUserId(id);
		//afterdelresponse.then().log().all();
		

	}

	public int verify_del_status()
	{
		int code;
		code=response.getStatusCode();
		Assert.assertEquals(code, 200);	
		Loggerload.info("*********************** Deletion Successful *************");
		return code;
	}

	public int verify_invalid_del_status()
	{
		int code;
		code=response.getStatusCode();
		Assert.assertEquals(code, 404);	
		Loggerload.info("*********************** Deletion unSuccessful *************");
		return code;
	}




}
