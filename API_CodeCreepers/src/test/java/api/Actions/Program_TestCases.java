package api.Actions;

import java.util.Date;


import org.testng.Assert;

import com.github.javafaker.Faker;
import java.util.logging.Logger;
import api.CRUDOperations.Program_CRUD;
import api.Payloads.Program_POJO;
import api.Utilities.Loggerload;
import enums.Env_Var;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Program_TestCases 
{
	Response response;
	//HashMap<String, String> programMap = new HashMap<>();
	Faker faker;
	String extractresponse;
	public void testPostProgram(String programDescription,String programStatus)
	{
		Program_POJO ProgramPayload=new Program_POJO();
		faker=new Faker();
		ProgramPayload.setProgramName("Jul23-Code_Creeper07-JavaSelenium"+faker.number().numberBetween(10, 10000));
		ProgramPayload.setProgramDescription(programDescription);
		ProgramPayload.setProgramStatus(programStatus);
		
	
	Loggerload.info("*********************** Creating Praogram  *************");
	response= Program_CRUD.createProgram(ProgramPayload);
	response.then().log().all();
	}
	
	public void testExPostProgram(String ProgramName,String programDescription,String programStatus)
	{
		Program_POJO ProgramPayload=new Program_POJO();
		faker=new Faker();
		ProgramPayload.setProgramName(ProgramName);
		ProgramPayload.setProgramDescription(programDescription);
		ProgramPayload.setProgramStatus(programStatus);
		
	
	Loggerload.info("*********************** Creating Praogram  *************");
	response= Program_CRUD.createProgram(ProgramPayload);
	response.then().log().all();
	}
	
public void verify_post_status(int statusCode)
 {
		
		Assert.assertEquals(response.getStatusCode(), statusCode);
		if(response.getStatusCode() == 201)
		{
			Program_POJO program_POJO =  response.getBody().as(Program_POJO.class);
			Loggerload.info("*********************** Program is Created ****************");
			//return program_POJO.getProgramId();
//			if(Env_Var.Program_Name != null)
//				Env_Var.Program_Id = program_POJO.getProgramId();
//			
//			if(Env_Var.Program_Name == null)
//				Env_Var.Program_Name = program_POJO.getProgramName();
			extractresponse=response.then().log().all().extract().response().asString();
			JsonPath js= new JsonPath(extractresponse);
			int progid=js.getInt("programId");
			String progname=js.getString("programName");
			
			System.out.println("prog Id is" +progid);
			System.out.println("Programe Name:"+progname);
			Env_Var.Program_Id=progid;
			Env_Var.Program_Name=progname;
		}
		

	}
public void TestgetAllProgram()
{

	
	Loggerload.info("*********************** get all Praograms  *************");
	response= Program_CRUD.getAllProgram();
//	response.then().log().all();
	
}
public void verify_get_status(int statusCode)
{
		
		Assert.assertEquals(response.getStatusCode(), statusCode);
		Loggerload.info("*********************** get all programs ****************");

	}

public void testGetRequestByProgramId(int id)
{

	
	Loggerload.info("*********************** get program  *************");
	response= Program_CRUD.getrequestprogramId(id);
	response.then().log().all();
	
}
public void verify_get_request_by_program_id_status(int statusCode)
{
		
		Assert.assertEquals(response.getStatusCode(), statusCode);
		Loggerload.info("*********************** get reuest by programId ****************");

	}
public void testUpdateProgramByProgramId(String programDescription,String programStatus,int programId)
{
	Program_POJO ProgramPayload=new Program_POJO();
	faker=new Faker();
	ProgramPayload.setProgramName(Env_Var.Program_Name);
	ProgramPayload.setProgramDescription(programDescription);
	ProgramPayload.setProgramStatus(programStatus);
	ProgramPayload.setProgramId(programId);

Loggerload.info("*********************** update Praogram  *************");
response= Program_CRUD.updaterequestbyProgramId(ProgramPayload,programId);
response.then().log().all();
}

public void testUpdateProgramByProgramId_Neg(String programName,String programDescription,String programStatus,int programId)
{
	Program_POJO ProgramPayload=new Program_POJO();
	faker=new Faker();
	ProgramPayload.setProgramName(programName);
	ProgramPayload.setProgramDescription(programDescription);
	ProgramPayload.setProgramStatus(programStatus);
	ProgramPayload.setProgramId(programId);

Loggerload.info("*********************** update Praogram  *************");
response= Program_CRUD.updaterequestbyProgramId(ProgramPayload,programId);
response.then().log().all();
}

public void verify_update_request_status(int statusCode)
{
	
	Assert.assertEquals(response.getStatusCode(), statusCode);
	Loggerload.info("*********************** Program is updated ****************");

}

public void testUpdateProgramByProgramName(String programName,String programDescription,String programStatus)
{
	Program_POJO ProgramPayload=new Program_POJO();
	ProgramPayload.setProgramName(programName);
	ProgramPayload.setProgramDescription(programDescription);
	ProgramPayload.setProgramStatus(programStatus);

Loggerload.info("*********************** update Praogram  *************");
response= Program_CRUD.updaterequestbyProgramName(ProgramPayload);
response.then().log().all();
}

public void verify_update_request_by_program_name_status(int statusCode)
{
	
	Assert.assertEquals(response.getStatusCode(), statusCode);
	Loggerload.info("*********************** Program is updated ****************");

}

public void TestdeleterequestbyprogramName(String programname)
{

	
	Loggerload.info("*********************** delete valid programname  *************");
	response= Program_CRUD.deleterequestbyprogramName(programname);
	response.then().log().all();
	
}
public void verify_delete_request_by_program_name_status(int statusCode)
{
		
		Assert.assertEquals(response.getStatusCode(), statusCode);
		Loggerload.info("*********************** delete reuest by programname ****************");

	}


public void TestdeleterequestbyprogramId(int programId)
{

	
	Loggerload.info("*********************** delete  programId  *************");
	response= Program_CRUD.deleterequestbyprogramid(programId);
	response.then().log().all();
	
}
public void verify_delete_request_by_program_Id_status(int statusCode)
{
		
		Assert.assertEquals(response.getStatusCode(), statusCode);
		Loggerload.info("*********************** delete reuest by programId ****************");

	}



}
