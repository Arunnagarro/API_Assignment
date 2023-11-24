package Test_cases;

import java.util.HashMap;

import org.testng.annotations.Test;

import Base_Class.baseTest;
import utils.path;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resubale_method.methods;

public class CardTests extends baseTest 
{

	HashMap<String, String> Param;
	HashMap<String, String> Header;

	String cardId;
	String labelId;

	@Test(priority = 5)
	public void create_card() throws Exception 
	{

		log.info("----------------------------Creating a card----------------------------");
		Param = methods.createCardParams();
		Header = methods.headerParam();

		Response res = httprequest.headers(Header).queryParams(Param).when().post(path.card()).then().assertThat()
				.statusCode(200).extract().response();
		res.prettyPeek();

		JsonPath js = methods.rawToJson(res);
		cardId = (String) js.get("id");
		System.out.println("card id " + cardId);
	}

	@Test(priority = 6)
	public void updateCard() throws Exception 
	{

		log.info("--------------------------Updating a card-------------------------------");

		Param = methods.getPutParams();
		Header = methods.headerParam();

		Response res = httprequest.headers(Header).queryParams(Param).when().put(path.card() + cardId).then()
				.assertThat().statusCode(200).extract().response();
		res.prettyPeek();
	}

	@Test(priority = 7)
	public void getCard() throws Exception {

		log.info("----------------------------get a card-------------------------------");

		Response res = httprequest.queryParam("key", methods.key).queryParam("token", methods.token)
				.when().get(path.card() + cardId);
		res.prettyPeek();
	}

	@Test(priority = 8)
	public void create_a_new_label() throws Exception {

		log.info("----------------------------Create a new label------------------------------");

		Header = methods.headerParam();
		Param = methods.getCreateLabelParams();

		Response res = httprequest.headers(Header).queryParams(Param).when().post(path.addCardLabel(cardId))
				.then().assertThat().statusCode(200).extract().response();
		res.prettyPeek();

		JsonPath js = methods.rawToJson(res);
		labelId = (String) js.get("id");

	}

	@Test(priority = 9)
	public void deleteLabel() throws Exception {

		log.info("----------------------------Delete Label-----------------------------");

		Header = methods.headerParam();
		Param = methods.removeLabelParams();

		Response res = httprequest.headers(Header).queryParams(Param).when()
				.delete(path.card() + cardId + "/idLabels/" + labelId);
		res.prettyPeek();

	}

	@Test(priority = 10)
	public void deleteCard() {

		log.info("-----------------------------Delete card------------------------------");

		Response res = httprequest.queryParam("key", methods.key).queryParam("token", methods.token)
				.when().delete(path.card() + cardId);
		res.prettyPeek();

	}

}
