package api.Actions;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.testng.Assert;

import com.github.javafaker.Faker;
import java.util.logging.Logger;
import api.Utilities.Loggerload;
import api.CRUDOperations.*;
import api.Payloads.*;
import api.Utilities.Loggerload;
import enums.Env_Var;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Assignment_Submit_TestCases {
	
	Response response;
	String extractresponse;
	Env_Var assignmentid=new Env_Var();
	Env_Var submissioinid=new Env_Var();
	Env_Var progmid=new Env_Var();
	Env_Var batchid=new Env_Var();
	Env_Var usrid=new Env_Var();

	
	public void TestPostSubmission(String subDesc,String subComments,String subPathAttach1,
			String subPathAttach2,String subPathAttach3,String subPathAttach4,
			String subPathAttach5,String gradedBy,String grade)
	{
		Assignment_Submit_POJO userpayload=new Assignment_Submit_POJO();
		userpayload.setAssignmentId(assignmentid.Assignment_Id);
		userpayload.setUserId(usrid.User_Id);
		userpayload.setSubDesc(subDesc);
		userpayload.setSubComments(subComments);
		userpayload.setSubPathAttach1(subPathAttach1);
		userpayload.setSubPathAttach2(subPathAttach2);
		userpayload.setSubPathAttach3(subPathAttach3);
		userpayload.setSubPathAttach4(subPathAttach4);
		userpayload.setSubPathAttach5(subPathAttach5);
		LocalDateTime currentDate = LocalDateTime.now();
		String subdate= currentDate.plusSeconds(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		userpayload.setSubDateTime(subdate);
		userpayload.setGradedBy(gradedBy);
		userpayload.setGrade(Integer.parseInt(grade));
		String gradedDateTime= currentDate.plusSeconds(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		userpayload.setGradedDateTime(gradedDateTime);
		//userpayload.setGrade(-1);

		
		
		

		
		Loggerload.info("*********************** Creating Assignment Submission *************");
		response= Assignment_Submit_CRUD.createSubmission(userpayload);
		response.then().log().all();
		extractresponse=response.then().log().all().extract().response().asString();
		JsonPath js= new JsonPath(extractresponse);
		int subid=js.getInt("submissionId");
		
		System.out.println("Submission Id is" +subid);
		submissioinid.Submission_Id=subid;
		
	}
	
public int verify_post_Submission_status() {
	
		int code;
		code=response.getStatusCode();
		Assert.assertEquals(code, 201);
		Loggerload.info("*********************** SubId Created ****************");
		return code;

	}

//Negative
public void TestPostExistingSubmission(String subDesc,String subComments,String subPathAttach1,
		String subPathAttach2,String subPathAttach3,String subPathAttach4,
		String subPathAttach5,String gradedBy,String grade)
{
	Assignment_Submit_POJO userpayload=new Assignment_Submit_POJO();
	userpayload.setAssignmentId(assignmentid.Assignment_Id);
	userpayload.setUserId(usrid.User_Id);
	userpayload.setSubDesc(subDesc);
	userpayload.setSubComments(subComments);
	userpayload.setSubPathAttach1(subPathAttach1);
	userpayload.setSubPathAttach2(subPathAttach2);
	userpayload.setSubPathAttach3(subPathAttach3);
	userpayload.setSubPathAttach4(subPathAttach4);
	userpayload.setSubPathAttach5(subPathAttach5);
	LocalDateTime currentDate = LocalDateTime.now();
	String subdate= currentDate.plusSeconds(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setSubDateTime(subdate);
	userpayload.setGradedBy(gradedBy);
	userpayload.setGrade(Integer.parseInt(grade));
	String gradedDateTime= currentDate.plusSeconds(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setGradedDateTime(gradedDateTime);
	//userpayload.setGrade(-1);

	
	
	

	
	Loggerload.info("*********************** Assignment Submission Creation with Existing Id *************");
	response= Assignment_Submit_CRUD.createSubmission(userpayload);
	response.then().log().all();
	
	
}

//Negative
public int verify_existing_post_Sub_status() {
	
	int code;
	code=response.getStatusCode();
	Assert.assertEquals(code, 400);
	Loggerload.info("*********************** Sub Id Exists Bad Request****************");
	return code;

}

//Negative
public void Missing_TestPostSubmission(String subComments,String subPathAttach1,
		String subPathAttach2,String subPathAttach3,String subPathAttach4,
		String subPathAttach5,String gradedBy,String grade)
{
	Assignment_Submit_POJO userpayload=new Assignment_Submit_POJO();
	Faker faker=new Faker();
	userpayload.setAssignmentId(assignmentid.Assignment_Id);
	//userpayload.setUserId(userId);
	//userpayload.setSubDesc(subDesc);
	userpayload.setSubComments(subComments);
	userpayload.setSubPathAttach1(subPathAttach1);
	userpayload.setSubPathAttach2(subPathAttach2);
	userpayload.setSubPathAttach3(subPathAttach3);
	userpayload.setSubPathAttach4(subPathAttach4);
	userpayload.setSubPathAttach5(subPathAttach5);
	LocalDateTime currentDate = LocalDateTime.now();
	String subdate= currentDate.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setSubDateTime(subdate);
	userpayload.setGradedBy(gradedBy);
	userpayload.setGrade(Integer.parseInt(grade));
	String gradedDateTime= currentDate.plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setGradedDateTime(gradedDateTime);
	//userpayload.setGrade(-1);

	
	
	

	
	Loggerload.info("*********************** Missing Mandatory Field Post request SubId Creation *************");
	response= Assignment_Submit_CRUD.createSubmission(userpayload);
	response.then().log().all();
	
}




public void Get_All_Grades()
{
	Loggerload.info("*********************** Retriving All Assisment submission with grades *************");
	response= Assignment_Submit_CRUD.getAllSubmission();
	response.then().log().all();
}
public int verify_get_All_status() {
	
	int code;
	code=response.getStatusCode();
	Assert.assertEquals(code, 200);
	Loggerload.info("*********************** Submission Details Retrived Successfully****************");
	return code;

}

public int verify_get_All_invalid_status() {
	
	int code;
	code=response.getStatusCode();
	Assert.assertEquals(code, 404);
	Loggerload.info("*********************** Submission Details Invalid****************");
	return code;

}

public void Get_Grades_BatchId(int batchId)
{
	
		Loggerload.info("*********************** Grades by batchId *************");

		response= Assignment_Submit_CRUD.getGradesbyBatchId(batchId);
		response.then().log().all();

	}
public int verify_invalid_get_status() {
	
	int code;
	code=response.getStatusCode();
	Assert.assertEquals(code, 404);
	Loggerload.info("*********************** Ivalid Get Request****************");
	return code;

}

public void Get_Grades_StudId(String studID)
{
	
		Loggerload.info("*********************** Retriving grades by StudId *************");

		response= Assignment_Submit_CRUD.getGradesbyStudId(studID);
		response.then().log().all();

	}

public void TestPutGrade(String subDesc,String subComments,String subPathAttach1,
		String subPathAttach2,String subPathAttach3,String subPathAttach4,
		String subPathAttach5,String gradedBy,String grade)
{
	Assignment_Submit_POJO userpayload=new Assignment_Submit_POJO();
	userpayload.setAssignmentId(Env_Var.Assignment_Id);
	userpayload.setUserId(Env_Var.User_Id);
	userpayload.setSubDesc(subDesc);
	userpayload.setSubComments(subComments);
	userpayload.setSubPathAttach1(subPathAttach1);
	userpayload.setSubPathAttach2(subPathAttach2);
	userpayload.setSubPathAttach3(subPathAttach3);
	userpayload.setSubPathAttach4(subPathAttach4);
	userpayload.setSubPathAttach5(subPathAttach5);
	LocalDateTime currentDate = LocalDateTime.now();
	String subdate= currentDate.plusSeconds(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setSubDateTime(subdate);
	userpayload.setGradedBy(gradedBy);
	userpayload.setGrade(Integer.parseInt(grade));
	String gradedDateTime= currentDate.plusSeconds(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setGradedDateTime(gradedDateTime);
	Loggerload.info("***********************Update the Submission grade**** *************");
	response= Assignment_Submit_CRUD.updateSubmissionGrades(Env_Var.Submission_Id,userpayload);
	response.then().log().all();
}
public int verify_Gradeput_status() {
	
	int code;
	code=response.getStatusCode();
	Assert.assertEquals(code, 200);
	Loggerload.info("*********************** Grade Updated!!! ****************");
	return code;

}

//Negative Put Invalid Submission Id

public void TestNegativePutGrade(int subid,String subDesc,String subComments,String subPathAttach1,
		String subPathAttach2,String subPathAttach3,String subPathAttach4,
		String subPathAttach5,String gradedBy,String grade)
{
	
	Assignment_Submit_POJO userpayload=new Assignment_Submit_POJO();
	userpayload.setAssignmentId(Env_Var.Assignment_Id);
	userpayload.setUserId(Env_Var.User_Id);
	userpayload.setSubDesc(subDesc);
	userpayload.setSubComments(subComments);
	userpayload.setSubPathAttach1(subPathAttach1);
	userpayload.setSubPathAttach2(subPathAttach2);
	userpayload.setSubPathAttach3(subPathAttach3);
	userpayload.setSubPathAttach4(subPathAttach4);
	userpayload.setSubPathAttach5(subPathAttach5);
	LocalDateTime currentDate = LocalDateTime.now();
	String subdate= currentDate.plusSeconds(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setSubDateTime(subdate);
	userpayload.setGradedBy(gradedBy);
	userpayload.setGrade(Integer.parseInt(grade));
	String gradedDateTime= currentDate.plusSeconds(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setGradedDateTime(gradedDateTime);
	Loggerload.info("***********************Update the Submission grade**** *************");
	response= Assignment_Submit_CRUD.updateNegativeSubmissionGrades(subid,userpayload);
	response.then().log().all();
}

//Negative PUT Missing Mandatory 

public void TestNegativeMissingPutGrade(int subid,String subDesc,String subComments,String subPathAttach1,
		String subPathAttach2,String subPathAttach3,String subPathAttach4,
		String subPathAttach5,String gradedBy,String grade)
{
	
	Assignment_Submit_POJO userpayload=new Assignment_Submit_POJO();
	userpayload.setAssignmentId(Env_Var.Assignment_Id);
	userpayload.setUserId(Env_Var.User_Id);
	userpayload.setSubDesc(subDesc);
	userpayload.setSubComments(subComments);
	userpayload.setSubPathAttach1(subPathAttach1);
	userpayload.setSubPathAttach2(subPathAttach2);
	userpayload.setSubPathAttach3(subPathAttach3);
	userpayload.setSubPathAttach4(subPathAttach4);
	userpayload.setSubPathAttach5(subPathAttach5);
	LocalDateTime currentDate = LocalDateTime.now();
	String subdate= currentDate.plusSeconds(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setSubDateTime(subdate);
	//userpayload.setGradedBy(gradedBy);
	//userpayload.setGrade(Integer.parseInt(grade));
	String gradedDateTime= currentDate.plusSeconds(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setGradedDateTime(gradedDateTime);
	Loggerload.info("***********************Update the Submission grade**** *************");
	response= Assignment_Submit_CRUD.updateNegativeSubmissionGrades(subid,userpayload);
	response.then().log().all();
}
public int verify_Missingput_status() {
	
	int code;
	code=response.getStatusCode();
	Assert.assertEquals(code, 400);
	Loggerload.info("*********************** BadRequest!!! ****************");
	return code;

}

public void Get_Submission_UserId(String userid)
{
	
		Loggerload.info("*********************** Retriving submission Through UserId *************");

		response= Assignment_Submit_CRUD.getSubmissionbyUserId(userid);
		response.then().log().all();

	}
public void Get_Submission_BatchId(int batchid)
{
	
		Loggerload.info("*********************** Retriving submission Through BatchId  *************");

		response= Assignment_Submit_CRUD.getSubmissionbybatchId(batchid);
		response.then().log().all();

	}
public void Get_Grades_AssignId(int aid)
{
	
		Loggerload.info("*********************** Retriving submission Through AssignId  *************");

		response= Assignment_Submit_CRUD.getGradesbyAssignId(aid);
		response.then().log().all();

	}
public void TestPutResubmit(String subDesc,String subComments,String subPathAttach1,
		String subPathAttach2,String subPathAttach3,String subPathAttach4,
		String subPathAttach5,String gradedBy,String grade)
{
	Assignment_Submit_POJO userpayload=new Assignment_Submit_POJO();
	userpayload.setAssignmentId(Env_Var.Assignment_Id);
	userpayload.setUserId(Env_Var.User_Id);
	userpayload.setSubDesc(subDesc);
	userpayload.setSubComments(subComments);
	userpayload.setSubPathAttach1(subPathAttach1);
	userpayload.setSubPathAttach2(subPathAttach2);
	userpayload.setSubPathAttach3(subPathAttach3);
	userpayload.setSubPathAttach4(subPathAttach4);
	userpayload.setSubPathAttach5(subPathAttach5);
	LocalDateTime currentDate = LocalDateTime.now();
	String subdate= currentDate.plusSeconds(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setSubDateTime(subdate);
	userpayload.setGradedBy(gradedBy);
	userpayload.setGrade(Integer.parseInt(grade));
	String gradedDateTime= currentDate.plusSeconds(10).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	userpayload.setGradedDateTime(gradedDateTime);
	Loggerload.info("***********************Update to Resubmit assignment**** *************");
	response= Assignment_Submit_CRUD.updateSubmissionResubmit(Env_Var.Assignment_Id,userpayload);
	response.then().log().all();
}
public int verify_Resubmitput_status() {
	
	int code;
	code=response.getStatusCode();
	Assert.assertEquals(code, 200);
	Loggerload.info("*********************** Resubmit Updated Success!! ****************");
	return code;

}

public void TestDeleteSubmission(int id )
{
	Loggerload.info("*********************** Deleting Submission *************");

	response= Assignment_Submit_CRUD.DeletebySubId(id);
	//afterdelresponse.then().log().all();
	

}
public void TestDeleteInvalidSubmission(int id )
{
	Loggerload.info("*********************** Deleting Submission *************");

	response= Assignment_Submit_CRUD.DeletebyInvalidSubId(id);
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


