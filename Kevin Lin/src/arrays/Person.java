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
	
	public Person(String first, String last, Borough home) {
		this.lastName = last;
		this.firstName = first;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
		
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
		return "My name is "+firstName+ " " + lastName+ " and I live in " +home+". I like to "+hobby;
	}
}

