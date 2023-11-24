package resubale_method;

import java.util.HashMap;

import utils.propertyReader;
import excelReader.Exceldata;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class methods {
	static propertyReader ob = new propertyReader();
	// hash map declare for querryParam
	public static HashMap<String, String> params = new HashMap();
	// hash map declare for header
	public static HashMap<String, String> headers = new HashMap();
	
	//variable taken from properties file
	public static String key = ob.getProperty("Api_key");
	public static String token = ob.getProperty("token");
	public static String color = ob.getProperty("color");
	public static String idList = ob.getProperty("idList");
	public static String idBoard = ob.getProperty("idBoard");
	public static String idCard = ob.getProperty("idCard");

	public static JsonPath rawToJson(Response res)
	{
		String responsee = (res).asString();
		JsonPath x = new JsonPath(responsee);
		return x;
	}

	public static HashMap<String, String> headerParam() 
	{

		// header parameters
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");

		return headers;
	}

	public static HashMap<String, String> getParams() throws Exception
	{
		
		// different parameters for different methods
		Exceldata excel = new Exceldata();
		String name = excel.getCellData(0, 1);
		params.put("key", key);
		params.put("token", token);
		params.put("name", name);

		return params;
	}

	public static HashMap<String, String> getPutParams() throws Exception 
	{

		Exceldata excel = new Exceldata();
		String New_name = excel.getCellData(0, 1);
		params.put("key", key);
		params.put("token", token);
		params.put("name", New_name);

		return params;
	}

	public static HashMap<String, String> createCardParams()
	{

		params.put("idList", idList);
		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> getCreateLabelParams() throws Exception 
	{

		Exceldata excel = new Exceldata();
		String cardName = excel.getCellData(0, 1);
		params.put("name", cardName);
		params.put("color", color);
		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> removeLabelParams() 
	{

		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> createListParams() throws Exception 
	{

		Exceldata excel = new Exceldata();
		String name = excel.getCellData(0, 1);
		params.put("name", name);
		params.put("idBoard", idBoard);
		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> archiveListParam()
	{

		params.put("closed", "true");
		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> createCheckListParams() throws Exception
	{

		Exceldata excel = new Exceldata();
		String name = excel.getCellData(0, 1);
		params.put("name", name);
		params.put("idCard", idCard);
		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> createOrganizations() throws Exception 
	{

		Exceldata excel = new Exceldata();
		String displayName = excel.getCellData(3, 1);
		params.put("displayName", displayName);
		params.put("key", key);
		params.put("token", token);
		return params;

	}

	public static HashMap<String, String> updateOrganizations() throws Exception
	{

		Exceldata excel = new Exceldata();
		String displayName = excel.getCellData(1, 1);
		params.put("displayName", displayName);
		params.put("key", key);
		params.put("token", token);
		return params;

	}

}
