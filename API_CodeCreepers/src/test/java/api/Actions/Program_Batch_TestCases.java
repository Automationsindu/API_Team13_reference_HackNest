package api.Actions;
import org.testng.Assert;

import com.github.javafaker.Faker;

import api.CRUDOperations.*;
import api.Payloads.Program_Batch_POJO;
import api.Utilities.Loggerload;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.logging.Logger;

import enums.Env_Var;

public class Program_Batch_TestCases {
	
	Response response;
	String extractresponse;
	Env_Var progmid=new Env_Var();
	Env_Var batchid=new Env_Var();
	Env_Var batchname=new Env_Var();
	Faker faker=new Faker();


	public void TestPostBatch(String batchDescription,String batchName,String batchNoOfClasses,String batchStatus)
	{
		Program_Batch_POJO batchpayload=new Program_Batch_POJO();
		batchpayload.setBatchDescription(batchDescription);
		batchpayload.setBatchName("Jul23-Code_Creeper07-JavaBatch"+ faker.number().numberBetween(10, 10000));
		batchpayload.setBatchNoOfClasses(Integer.parseInt(batchNoOfClasses));
		batchpayload.setBatchStatus(batchStatus);
		batchpayload.setProgramId(progmid.Program_Id);
		System.out.println("Program Id used in batch module is : " +progmid.Program_Id);
		
		
		Loggerload.info("*********************** Creating Batch *************");
		response= Program_Batch_CRUD.createbatch(batchpayload);
		response.then().log().all();
		extractresponse=response.then().log().all().extract().response().asString();
		
		JsonPath js= new JsonPath(extractresponse);
		int batid=js.getInt("batchId");
		String batname=js.getString("batchName");
		
		System.out.println("Batch Id is" +batid);
		batchid.Batch_Id=batid;
		System.out.println("Batch Name is" +batname);
		batchname.Batch_Name=batname;
		
		
	}
	
public void verify_post_status() {
		
		Assert.assertEquals(response.getStatusCode(), 201);
		Loggerload.info("*********************** Batch is Created ****************");

	}
public void TestGetallBatch() {
	
	Loggerload.info("*********************** Retriving All Batches *************");
	response= Program_Batch_CRUD.getAllBatches();
	response.then().statusCode(200);
}

public void verify_get_all_batches_status() {
	
	Assert.assertEquals(response.getStatusCode(), 200);
	Loggerload.info("*********************** All Batches Retrived ****************");

}
public void TestGetBatchbyID(int batchID) {
	
	//Loggerload.info("*********************** Retriving All Users *************");
	response= Program_Batch_CRUD.getBatchbyBatcheID(batchID);
	response.then().log().all().statusCode(200);
}

public void verify_get_batch_by_ID_status() {
	
	Assert.assertEquals(response.getStatusCode(), 200);
	Loggerload.info("*********************** All Batches by BatchId ****************");

}
public void TestGetBatchbyname(String batname) {
	
	Loggerload.info("*********************** Retriving Batch by name *************");
	response= Program_Batch_CRUD.getBatchbyBatchName(batname);
	response.then().log().all().statusCode(200);
}

public void verify_get_batch_by_name_status() {
	
	Assert.assertEquals(response.getStatusCode(), 200);
	Loggerload.info("*********************** All Batches ****************");

}
public void TestGetBatchbyprogramid(int progmid) {
	
	Loggerload.info("*********************** Retriving All batches by progid *************");
	response= Program_Batch_CRUD.getBatchbyProgramId(progmid);
	response.then().log().all().statusCode(200);
}

public void verify_get_batch_by_programid_status() {
	
	Assert.assertEquals(response.getStatusCode(), 200);
	Loggerload.info("*********************** All Batches ****************");

}

public void TestPutBatch(String batchDescription, String batchNoOfClasses, String batchStatus , int ID) {
	
	Program_Batch_POJO batchpayload=new Program_Batch_POJO();
	batchpayload.setBatchDescription(batchDescription);
	batchpayload.setBatchId(batchid.Batch_Id);
	batchpayload.setBatchName(batchname.Batch_Name);
	batchpayload.setBatchNoOfClasses(Integer.parseInt(batchNoOfClasses));
	batchpayload.setBatchStatus(batchStatus);
	batchpayload.setProgramId(progmid.Program_Id);

	System.out.println("Program Id used in batch module is : " +progmid.Program_Id);
	
	
	
	Loggerload.info("*********************** Update batch by progid *************");
	response= Program_Batch_CRUD.putBatch(batchpayload,ID);
	response.then().log().all().statusCode(200);
}

public void verify_put_status() {
	
	Assert.assertEquals(response.getStatusCode(), 200);
	Loggerload.info("*********************** Update Success ****************");

}

public void TestDeleteBatch(int id )
{
	Loggerload.info("*********************** Deleting Batch *************");

	response= Program_Batch_CRUD.DeletebyBatchID(id);
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


}
