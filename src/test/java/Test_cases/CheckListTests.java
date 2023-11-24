package Test_cases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Base_Class.baseTest;
import utils.path;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resubale_method.methods;

public class CheckListTests extends baseTest 
{

	HashMap<String, String> Param;
	HashMap<String, String> Header;

	String checkListId;
	String a;

	@Test(priority = 11)
	public void createChecklist() throws Exception 
	{

		log.info("-----------------------------Creating Checklist----------------------------");

		Param = methods.createCheckListParams();
		Header = methods.headerParam();

		Response res = httprequest.headers(Header).queryParams(Param).when().post(path.checkLists()).then()
				.assertThat().statusCode(200).extract().response();
		res.prettyPeek();

		JsonPath js = methods.rawToJson(res);
		checkListId = (String) js.get("id");

	}

	@Test(priority = 12)
	public void updateCheckList() throws Exception {

		log.info("-----------------------------Update CheckList------------------------------");

		Param = methods.getPutParams();
		Header = methods.headerParam();

		Response res = httprequest.headers(Header).queryParams(Param).when().put(path.checkLists() + checkListId)
				.then().assertThat().statusCode(200).extract().response();
		res.prettyPeek();

	}

	@Test(priority = 13)
	public void getCheckList() throws Exception {

		log.info("----------------------------get checklist--------------------------------");

		Response res = httprequest.queryParam("key", methods.key).queryParam("token", methods.token)
				.when().get(path.card() + checkListId);
		res.prettyPeek();
	}

	@Test(priority = 14)
	public void getTheCardAChecklistIsOn() throws Exception {

		log.info("-----------------------------Get the card checklist is on------------------------------");

		Param = methods.getPutParams();
		Header = methods.headerParam();

		Response res = httprequest.headers(Header).queryParams(Param).when()
				.get(path.checkLists() + checkListId + "/cards").then().assertThat().statusCode(200).extract()
				.response();
		res.prettyPeek();

	}

	@Test(priority = 15)
	public void deleteCheckList() {

		log.info("-----------------------------Delete a Checklist-----------------------------");

		Response res = httprequest.queryParam("key", methods.key).queryParam("token", methods.token)
				.when().delete(path.checkLists() + checkListId);
		res.prettyPeek();

	}

}
