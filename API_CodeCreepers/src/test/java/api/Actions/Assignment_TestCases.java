package api.Actions;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.testng.Assert;
import com.github.javafaker.Faker;
import api.CRUDOperations.*;
import api.Payloads.*;
import api.Utilities.Loggerload;
import enums.Env_Var;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import api.Utilities.Loggerload;

public class Assignment_TestCases {
	
	Response response;
	String extractresponse;
	JsonPath jsonPathEvaluator;
	Faker faker;
	Env_Var assignmentid=new Env_Var();
	Env_Var progmid=new Env_Var();
	Env_Var batchid=new Env_Var();
	Env_Var usrid=new Env_Var();

	public String date;
	public void TestPostAssignment(String assignmentDescription,String batchId,String comments,String createdBy,
			String graderId,String pathAttachment1,String pathAttachment2,
			String pathAttachment3,String pathAttachment4,String pathAttachment5)
	{
		
		Assignment_POJO userpayload=new Assignment_POJO();
		faker=new Faker();
		userpayload.setAssignmentDescription(assignmentDescription);
		userpayload.setAssignmentName("Jul23-Code_Creeper07-JavaAssignment"+faker.number().numberBetween(10, 10000));
		userpayload.setBatchId(batchid.Batch_Id);
		userpayload.setComments(comments);
		userpayload.setCreatedBy(createdBy);
//		Calendar cal=Calendar.getInstance();
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		cal.add(Calendar.SECOND, 5);
//		String duedate=formatter.format(cal.getTime());
		LocalDateTime currentDate = LocalDateTime.now();
		//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
		String duedate= currentDate.plusSeconds(2).toString();
		userpayload.setDueDate(duedate);
		userpayload.setGraderId(graderId);
		userpayload.setPathAttachment1(pathAttachment1);
		userpayload.setPathAttachment2(pathAttachment2);
		userpayload.setPathAttachment3(pathAttachment3);
		userpayload.setPathAttachment4(pathAttachment4);
		userpayload.setPathAttachment5(pathAttachment5);
		
		
		
		

		
		Loggerload.info("*********************** Creating Assignment Id *************");
		response= Assignment_CRUD.createAssignment(userpayload);
		extractresponse=response.then().log().all().extract().response().asString();
		JsonPath js= new JsonPath(extractresponse);
		int assignid=js.getInt("assignmentId");
		
		System.out.println("Assign Id is" +assignid);
		assignmentid.Assignment_Id=assignid;
		
		String aasignname=js.getString("assignmentName");
		System.out.println("Assignment Name:"+aasignname);
		Env_Var.Assignment_Name=aasignname;
		
		
	}
	
	public int verify_post_Assign_status() {
		
		int code;
		code=response.getStatusCode();
		Assert.assertEquals(code, 201);
		Loggerload.info("*********************** Assignment Id is Created ****************");
		return code;

	}
	
	//Negative Testing Post for existing Value
	
	public void TestPostExistingAssignment(String assignmentName,String assignmentDescription,String batchId,String comments,String createdBy,
			String graderId,String pathAttachment1,String pathAttachment2,
			String pathAttachment3,String pathAttachment4,String pathAttachment5)
	{
		
		Assignment_POJO userpayload=new Assignment_POJO();
		faker=new Faker();
		userpayload.setAssignmentId(assignmentid.Assignment_Id);
		userpayload.setAssignmentDescription(assignmentDescription);
		userpayload.setAssignmentName(assignmentName);
		userpayload.setBatchId(batchid.Batch_Id);
		userpayload.setComments(comments);
		userpayload.setCreatedBy(createdBy);
//		Calendar cal=Calendar.getInstance();
//		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		cal.add(Calendar.SECOND, 5);
//		String duedate=formatter.format(cal.getTime());
		LocalDateTime currentDate = LocalDateTime.now();
		//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
		String duedate= currentDate.plusSeconds(2).toString();
		userpayload.setDueDate(duedate);
		userpayload.setGraderId(graderId);
		userpayload.setPathAttachment1(pathAttachment1);
		userpayload.setPathAttachment2(pathAttachment2);
		userpayload.setPathAttachment3(pathAttachment3);
		userpayload.setPathAttachment4(pathAttachment4);
		userpayload.setPathAttachment5(pathAttachment5);
		
		
		
		

		
		Loggerload.info("*********************** Creating Assignment Id for existing values *************");
		response= Assignment_CRUD.createAssignment(userpayload);
		response.then().log().all();
		
		
	}
	
public int verify_post_Negative_Assign_status() {
		
		int code;
		code=response.getStatusCode();
		Assert.assertEquals(code, 400);
		Loggerload.info("*********************** BadRequest ****************");
		return code;

	}

//Negative Post Missing Mandatory

public void TestPostMissingAssignment(String assignmentDescription,String batchId,String comments,String createdBy,
		String graderId,String pathAttachment1,String pathAttachment2,
		String pathAttachment3,String pathAttachment4,String pathAttachment5)
{
	
	Assignment_POJO userpayload=new Assignment_POJO();
	faker=new Faker();
	//userpayload.setAssignmentDescription(assignmentDescription);
	//userpayload.setAssignmentName(Env_Var.Assignment_Name);
	//userpayload.setBatchId(batchid.Batch_Id);
	userpayload.setComments(comments);
	userpayload.setCreatedBy(createdBy);
//	Calendar cal=Calendar.getInstance();
//	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	cal.add(Calendar.SECOND, 5);
//	String duedate=formatter.format(cal.getTime());
	LocalDateTime currentDate = LocalDateTime.now();
	//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
	String duedate= currentDate.plusSeconds(2).toString();
	userpayload.setDueDate(duedate);
	//userpayload.setGraderId(graderId);
	userpayload.setPathAttachment1(pathAttachment1);
	userpayload.setPathAttachment2(pathAttachment2);
	userpayload.setPathAttachment3(pathAttachment3);
	userpayload.setPathAttachment4(pathAttachment4);
	userpayload.setPathAttachment5(pathAttachment5);
	
	
	
	

	
	Loggerload.info("*********************** Creating Assignment Id for existing values *************");
	response= Assignment_CRUD.createAssignment(userpayload);
	response.then().log().all();
	
	
}

	public void Get_Assignment_ID(int id)
	{
		
			Loggerload.info("*********************** Retriving Assignment details *************");

			response= Assignment_CRUD.getUsingAsID(id);
			response.then().log().all();

		}
	
public int verify_get_Assign_status() {
		
		int code;
		code=response.getStatusCode();
		Assert.assertEquals(code, 200);
		Loggerload.info("*********************** Success Assoignment Retrived ****************");
		return code;

	}
public int verify_get_All_invalid_status() {
	
	int code;
	code=response.getStatusCode();
	Assert.assertEquals(code, 404);
	Loggerload.info("*********************** Submission Details Invalid****************");
	return code;

}

public void Get_All_Assignments()
{
	Loggerload.info("*********************** Retriving All Assignment *************");
	response= Assignment_CRUD.getAll_Assignments();
	response.then().log().all();
}
public void Get_Assignment_BatchID(int id)
{
	
		Loggerload.info("*********************** Retriving Assignment by BatchId *************");

		response= Assignment_CRUD.getUsingAsBatch(id);
		response.then().log().all();

	}

public void TestPutAssign(String assignmentDescription,String batchId,String comments,String createdBy,
		String graderId,String pathAttachment1,String pathAttachment2,
		String pathAttachment3,String pathAttachment4,String pathAttachment5)
{
	
	Assignment_POJO userpayload=new Assignment_POJO();
	faker=new Faker();
	userpayload.setAssignmentDescription(assignmentDescription);
	userpayload.setAssignmentName("Jul23-Code_Creeper07-JavaAssignment"+faker.number().numberBetween(10, 10000));
	userpayload.setBatchId(batchid.Batch_Id);
	userpayload.setComments(comments);
	userpayload.setCreatedBy(createdBy);
//	Calendar cal=Calendar.getInstance();
//	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	cal.add(Calendar.SECOND, 5);
//	String duedate=formatter.format(cal.getTime());
	LocalDateTime currentDate = LocalDateTime.now();
	//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
	String duedate= currentDate.plusDays(2).toString();
	userpayload.setDueDate(duedate);
	userpayload.setGraderId(graderId);
	userpayload.setPathAttachment1(pathAttachment1);
	userpayload.setPathAttachment2(pathAttachment2);
	userpayload.setPathAttachment3(pathAttachment3);
	userpayload.setPathAttachment4(pathAttachment4);
	userpayload.setPathAttachment5(pathAttachment5);
	
	Loggerload.info("***********************Updated AssignmentId**** *************");
	response= Assignment_CRUD.updateAssignment(assignmentid.Assignment_Id,userpayload);
	response.then().log().all();
}

public int verify_put_Assign_status() {
	
	int code;
	code=response.getStatusCode();
	Assert.assertEquals(code, 200);
	Loggerload.info("*********************** Assignment Update Successful ****************");
	return code;

}

//Negative Put Invalid assignmentId

public void TestPutInvalidAssign(int asid,String assignmentDescription,String batchId,String comments,String createdBy,
		String graderId,String pathAttachment1,String pathAttachment2,
		String pathAttachment3,String pathAttachment4,String pathAttachment5)
{
	
	Assignment_POJO userpayload=new Assignment_POJO();
	faker=new Faker();
	userpayload.setAssignmentDescription(assignmentDescription);
	userpayload.setAssignmentName("Jul23-Code_Creeper07-JavaAssignment"+faker.number().numberBetween(10, 10000));
	userpayload.setBatchId(batchid.Batch_Id);
	userpayload.setComments(comments);
	userpayload.setCreatedBy(createdBy);
//	Calendar cal=Calendar.getInstance();
//	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	cal.add(Calendar.SECOND, 5);
//	String duedate=formatter.format(cal.getTime());
	LocalDateTime currentDate = LocalDateTime.now();
	//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
	String duedate= currentDate.plusDays(2).toString();
	userpayload.setDueDate(duedate);
	userpayload.setGraderId(graderId);
	userpayload.setPathAttachment1(pathAttachment1);
	userpayload.setPathAttachment2(pathAttachment2);
	userpayload.setPathAttachment3(pathAttachment3);
	userpayload.setPathAttachment4(pathAttachment4);
	userpayload.setPathAttachment5(pathAttachment5);
	
	Loggerload.info("***********************Updated Invalid AssignmentId Failed**** *************");
	response= Assignment_CRUD.updateInvalidAssignment(asid,userpayload);
	response.then().log().all();
}
//Negative Put Missing Fields

public void TestPutMissingAssign(int asid,String assignmentDescription,String batchId,String comments,String createdBy,
		String graderId,String pathAttachment1,String pathAttachment2,
		String pathAttachment3,String pathAttachment4,String pathAttachment5)
{
	
	Assignment_POJO userpayload=new Assignment_POJO();
	faker=new Faker();
	//userpayload.setAssignmentDescription(assignmentDescription);
	//userpayload.setAssignmentName("CodeCreepersTeam3"+faker.number().randomNumber());
	//userpayload.setBatchId(batchid.Batch_Id);
	userpayload.setComments(comments);
	userpayload.setCreatedBy(createdBy);
//	Calendar cal=Calendar.getInstance();
//	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	cal.add(Calendar.SECOND, 5);
//	String duedate=formatter.format(cal.getTime());
	LocalDateTime currentDate = LocalDateTime.now();
	//SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss"))
	String duedate= currentDate.plusDays(2).toString();
	userpayload.setDueDate(duedate);
	//userpayload.setGraderId(graderId);
	userpayload.setPathAttachment1(pathAttachment1);
	userpayload.setPathAttachment2(pathAttachment2);
	userpayload.setPathAttachment3(pathAttachment3);
	userpayload.setPathAttachment4(pathAttachment4);
	userpayload.setPathAttachment5(pathAttachment5);
	
	Loggerload.info("***********************Update AssignmentId Failed Missing Fields**** *************");
	response= Assignment_CRUD.updateInvalidAssignment(asid,userpayload);
	response.then().log().all();
}
public int verify_Missingput_status() {
	
	int code;
	code=response.getStatusCode();
	Assert.assertEquals(code, 400);
	Loggerload.info("*********************** BadRequest!!! ****************");
	return code;

}
public void TestDeleteAssignment(int id )
{
	Loggerload.info("*********************** Deleting Submission *************");

	response= Assignment_CRUD.DeletebyAssignId(id);
	//afterdelresponse.then().log().all();
	

}
public void TestDeleteInvalidAssignment(int id )
{
	Loggerload.info("*********************** Deleting Submission *************");

	response= Assignment_CRUD.DeletebyInvalidAssignId(id);
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
