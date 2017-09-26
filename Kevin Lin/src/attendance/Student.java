package attendance;

public class Student implements Attendee{

	public Student(String first, String last) {
		// TODO Auto-generated constructor stub
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setPresent(boolean present) {
		// TODO Auto-generated method stub
		
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean mathces(String first, String last) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean matches(String last) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getReportString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matches(String first, String last) {
		// TODO Auto-generated method stub
		return false;
	}

}
