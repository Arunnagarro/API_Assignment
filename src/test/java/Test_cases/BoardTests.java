package Test_cases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Base_Class.baseTest;
import utils.path;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resubale_method.methods;

public class BoardTests extends baseTest {

	HashMap<String, String> Param;
	HashMap<String, String> Header;

	String Board_id;

	@Test(priority = 1)
	public void create_board() throws Exception 
	{

		log.info("---------------------------Creating a board--------------------------");

		Param = methods.getParams();
		Header = methods.headerParam();

		Response res = httprequest.headers(Header).queryParams(Param).when().post(path.board()).then()
				.assertThat().statusCode(200).extract().response();
		res.prettyPeek();

		JsonPath js = methods.rawToJson(res);
		Board_id = (String) js.get("id");

	}

	@Test(priority = 2)
	public void update_board() throws Exception 
	{

		log.info("---------------------------Updating a board----------------------------");
		Param = methods.getPutParams();
		Header = methods.headerParam();

		Response res = httprequest.headers(Header).queryParams(Param).when().put(path.board() + Board_id).then()
				.assertThat().statusCode(200).extract().response();
		res.prettyPeek();

	}

	@Test(priority = 3)
	public void get_board() throws Exception 
	{

		log.info("---------------------------Get a board------------------------------");

		Response res = httprequest.queryParam("key", methods.key).queryParam("token", methods.token)
				.when().get(path.board() + Board_id);
		res.prettyPeek();

	}

	@Test(priority = 4)
	public void delete_board() throws Exception {

		log.info("--------------------------Delete a board---------------------------");
		Response res = httprequest.queryParam("key", methods.key).queryParam("token", methods.token)
				.when().delete(path.board() + Board_id);
		res.prettyPeek();

	}

}
