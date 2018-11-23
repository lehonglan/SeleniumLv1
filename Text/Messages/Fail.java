package Messages;

public class Fail {
	public static String ElementIsNotShown (String element)	{
		return (element + " is not shown as expected");
	}
	
	public static String CompareText (String actual, String expected) {
		return ("\nExpected is: '" + expected + "' displays" + "\nActual is: '" + actual + "' displays" + "\n");
	}
}