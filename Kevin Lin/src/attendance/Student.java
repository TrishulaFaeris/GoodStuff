package attendance;

public class Student implements Attendee{
	public String fName;
	public String lName;
	public String statment;
	public boolean isHere;
	
	public Student(String first, String last) {
		fName = first;
		lName = last;
		isHere = false;
		
	}

	public boolean isPresent() {
		/*if(!isHere) {
			return false;
		}
		else {
			return true;
		}
		*/	
		return isHere;
	}

	public void setPresent(boolean present) {
		/*if(!present) {
			isHere = false;		
		}
		else {
			isHere = true;		
		}
		*/
		isHere = present;
	}

	public String getFirstName() {
		return fName;
	}

	public String getLastName() {
		return lName;
	}

	public boolean matches(String last) {
		if(lName.equalsIgnoreCase(last)){
			return true;
		}
		else {
			return false;
		}
	}

	public String getReportString() {
		statment = lName;
		while(statment.length()<20) {
			statment += "";
		}
		statment += fName;
		while(statment.length()<40) {
			statment +="";
		}
		if(!this.isPresent()) {
			statment += "ABSENT";
		}
		else {
			statment += "PRESENT";
		}
		return statment;
	}

	public boolean mathces(String first, String last) {
		String fullName = fName + lName;
		String inputName = first + last;
		if(fullName.equalsIgnoreCase(inputName)) {
			return true;
		}
		else
		{
			return false;
		}
	}


}
