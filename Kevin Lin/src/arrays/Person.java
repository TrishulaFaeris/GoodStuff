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
	private Hobby hobby;
	private Person[] friends;
	private String nickname;
	
	public Person(String first, String last, Borough home) {
		this.lastName = last;
		this.firstName = first;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
		this.nickname = createNickname(firstName);
		
	}
	
	public static String createNickname(String name) {
		String nickname = "";
		int timesVow = 0;
		int pos2Vow = 0;
		for(int i = 0; i < name.length()-1; i++) {
			if(isVowel(name.substring(i,i+1))) {
				timesVow++;
			}
			if(timesVow == 2) {
				pos2Vow = i;
			}
		}
		if(timesVow == 1) {
			return name;
		}
		else
		{
			nickname = name.substring(0,pos2Vow);
		}
		return nickname;
	}
	public static boolean isVowel(String p) {
		if(p.equalsIgnoreCase("a") 
			|| p.equalsIgnoreCase("e")
			|| p.equalsIgnoreCase("i")
			|| p.equalsIgnoreCase("o")
			|| p.equalsIgnoreCase("u")) {
			return true;
		}
		return false;
	}
	public void mingle(Person[] people) {
		for(Person p : people) {
			if(p != this) {
				p = betterFriend(p, friends[0]);
				addFriendToFirstPlace(p);
			}
		}
		
	}
	private Person betterFriend(Person p, Person q) {
		if(p == null) {
			return q;
		}
		if(q == null) {
			return p;
		}
		if(p.getClass() == this.getClass()) {
			return p;
		}
		if(q.getClass() == this.getClass()) {
			return q;
		}
		if(q.getClass() == this.getClass() && (p.getClass() == this.getClass())) {
			if (q.hobby == this.hobby) {
				return q;
			}
			return p;
		}
		
		return p;
	}

	public void printFriends() {
		System.out.println("Ny name is " +firstName+lastName+ " and these are my friends:");
	}
	public void addFriendToFirstPlace(Person p) {
		for(int i = friends.length-1; i > 0; i--) {
			friends[i] = friends[i-1];
		}
		friends[0] = p;
	}
	public String toString() {
		return "My name is "+firstName+ " " + lastName+ ". Call me "+nickname+".";
	}

	public String setFirstName(String string) {
		this.firstName = string;
		return firstName;
	}


}

