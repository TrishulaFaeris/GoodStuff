package arrays;

public class Person {
	public static final String[] FIRST_START = {"R","K", "Ko", "Em", "Ka", "M"};
	public static final String[] FIRST_MIDDLE = {"e","as", "zu", "i", "yu", "i"};
	public static final String[] FIRST_END = {"m","lia", "ki", "n", "ne", "o"};
	
	public static final String[] LAST_START = {"Tr","Br", "L", "Gr", "Sh"};
	public static final String[] LAST_MIDDLE = {"om","as", "u", "i", "o"};
	public static final String[] LAST_END = {"son","an", "end", "tu", "ya"};
	private String firstName;
	private String lastName;
	private Borough home;
	
	public Person(String first, String last, Borough home) {
		this.lastName = last;
		this.firstName = first;
		this.home = home;
	}
	public String toString() {
		return "My name is "+firstName+ " " + lastName+ " and I live in " +home+".";
	}
}

