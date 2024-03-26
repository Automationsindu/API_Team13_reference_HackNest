package api.Actions;
import org.testng.Assert;

import api.CRUDOperations.Program_Batch_CRUD;
import api.Payloads.Program_Batch_POJO;
import api.Utilities.Loggerload;
import enums.Env_Var;
import io.restassured.response.Response;

public class Program_Batch_Negative_TestCases {
	Response response;
	String extractresponse;
	Env_Var progmid=new Env_Var();
	Env_Var batchid=new Env_Var();
	Env_Var batchname=new Env_Var();



	public void TestPostBatchExistingBatchname(String batchDescription,String batchName,String batchNoOfClasses,String batchStatus)
	{
		Program_Batch_POJO batchpayload=new Program_Batch_POJO();
		batchpayload.setBatchDescription(batchDescription);
		batchpayload.setBatchName(batchName);
		batchpayload.setBatchNoOfClasses(Integer.parseInt(batchNoOfClasses));
		batchpayload.setBatchStatus(batchStatus);
		batchpayload.setProgramId(progmid.Program_Id);
		System.out.println("Program Id used in batch module is : " +progmid.Program_Id);
		
		
		//Loggerload.info("*********************** Creating Batch *************");
		response= Program_Batch_CRUD.createbatch(batchpayload);
		response.then().log().all();
		extractresponse=response.then().log().all().extract().response().asString();
		
}
	public void verify_post_status_Existing_Batchname() {
		
		Assert.assertEquals(response.getStatusCode(), 400);
		//Loggerload.info("*********************** Batch Already exists ****************");

	}
	
	public void TestPostBatchMissingFields(String batchDescription,String batchName,String batchNoOfClasses,String batchStatus)
	{
		Program_Batch_POJO batchpayload=new Program_Batch_POJO();
		batchpayload.setBatchDescription(batchDescription);
		//batchpayload.setBatchName(batchName);
		//batchpayload.setBatchNoOfClasses(Integer.parseInt(batchNoOfClasses));
		batchpayload.setBatchStatus(batchStatus);
		
		//Loggerload.info("*********************** Creating Batch *************");
		response= Program_Batch_CRUD.createbatch(batchpayload);
		response.then().log().all();
		
	}

	public void verify_post_status_Missing_Fields() {
		
		Assert.assertEquals(response.getStatusCode(), 400);
		//Loggerload.info("*********************** Batch Missing Mandatory Fields   ****************");
	}
	
	public void TestgetbyInvalidBatchid(int batchId)
	{
		
		
		//Loggerload.info("*********************** Creating Batch *************");
		response= Program_Batch_CRUD.getBatchbyBatcheID(batchId);
		response.then().log().all().statusCode(404);
		
	}

	public void verify_get_status_Invalid_Batchid() {
		
		Assert.assertEquals(response.getStatusCode(), 404);
		//Loggerload.info("*********************** Batch Missing Mandatory Fields   ****************");
	}
	
	public void TestgetbyInvalidBatchname(String batchname)
	{
		
		//Loggerload.info("*********************** Creating Batch *************");
		response= Program_Batch_CRUD.getBatchbyBatchName(batchname);
		response.then().log().all().statusCode(404);
		
	}

	public void verify_get_status_Invalid_Batchname() {
		
		Assert.assertEquals(response.getStatusCode(), 404);
		//Loggerload.info("*********************** Batch Missing Mandatory Fields   ****************");
	}
	
	public void TestgetbyInvalidProgramId(int programid)
	{
		
		//Loggerload.info("*********************** Creating Batch *************");
		response= Program_Batch_CRUD.getBatchbyProgramId(programid);
		response.then().log().all().statusCode(404);
		
	}

	public void verify_get_status_Invalid_Programid() {
		
		Assert.assertEquals(response.getStatusCode(), 404);
		//Loggerload.info("*********************** Batch Missing Mandatory Fields   ****************");
	}
	
	public void TestPutBatchInvalidBatchID(String batchDescription, String batchNoOfClasses, String batchStatus , int ID) {
		
		Program_Batch_POJO batchpayload=new Program_Batch_POJO();
		batchpayload.setBatchDescription(batchDescription);
		//batchpayload.setBatchId(batchid.Batch_Id);
		//response= Program_Batch_CRUD.putBatch(batchpayload, ID);
		batchpayload.setBatchName(batchname.Batch_Name);
		batchpayload.setBatchNoOfClasses(Integer.parseInt(batchNoOfClasses));
		batchpayload.setBatchStatus(batchStatus);
		batchpayload.setProgramId(progmid.Program_Id);
	
		//Loggerload.info("*********************** Retriving All Users *************");
		response= Program_Batch_CRUD.putBatch(batchpayload,ID);
		response.then().log().all().statusCode(404);
	}

	public void verify_put_status_InvalidBatchID() {
		
		Assert.assertEquals(response.getStatusCode(), 404);
		//Loggerload.info("*********************** All Batches ****************");

	}

public void TestPutBatchInvalidBatchbody(int ID) {
		
		Program_Batch_POJO batchpayload=new Program_Batch_POJO();
	
		//batchpayload.setBatchId(batchid.Batch_Id);
		response= Program_Batch_CRUD.putBatch(batchpayload, ID);
		batchpayload.setBatchName(batchname.Batch_Name);
		//Loggerload.info("*********************** Retriving All Users *************");
		//response= Program_Batch_CRUD.putBatch(batchpayload,ID);
		response.then().log().all().statusCode(400);
	}

	public void verify_put_status_InvalidBatchbody() {
		
		Assert.assertEquals(response.getStatusCode(), 400);
		//Loggerload.info("*********************** All Batches ****************");

	}

	public void TestdeletebyInvalidBatchid(int batchId)
	{
	
		//Loggerload.info("*********************** Creating Batch *************");
		response= Program_Batch_CRUD.DeletebyInvalidBatchID(batchId);
		response.then().log().all().statusCode(404);
		
	}

	public void verify_delete_status_Invalid_Batchid() {
		
		Assert.assertEquals(response.getStatusCode(), 404);
		//Loggerload.info("*********************** Batch Missing Mandatory Fields   ****************");
	}

	
}
