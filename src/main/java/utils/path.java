package utils;

public class path {
	public static String board() 
	{
		
		//Path file for boards
		String resource = "/1/boards/";
		return resource;
	}

	public static String card()
	{
		
		//Path file for cards
		String resource = "/1/cards/";
		return resource;
	}

	public static String addCardLabel(String label)
	{

		String resource = "/1/cards/" + label + "/labels/";
		return resource;
	}

	public static String lists()
	{

		String resource = "/1/lists/";
		return resource;
	}

	public static String checkLists()
	{

		String resource = "/1/checklists/";
		return resource;
	}

	public static String emoji()
	{

		
		String resource = "/1/emoji/";
		return resource;
	}

	public static String Organization()
	{

		
		String resource = "/1/organizations/";
		return resource;
	}

}
