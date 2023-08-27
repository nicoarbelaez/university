package puntoCinco;
public class Student {
	// variables de instancia
	private String fName;
	private String lName;
	private int stuId;
	private boolean stuStatus;

	// constructor
	public Student(String firstName, String lastName, int studentId, boolean studentStatus) {
		this.fName = firstName;
		this.lName = lastName;
		this.stuId = studentId;
		this.stuStatus = studentStatus;
	}

	// métodos
	public String getFName() {
		return this.fName;
	}

	public void setFName(String firstName) {
		this.fName = firstName;
	}

	public String getLName() {
		return this.lName;
	}

	public void setLName(String lastName) {
		this.lName = lastName;
	}

	public int getStuId() {
		return this.stuId;
	}

	public void setStuId(int studentId) {
		this.stuId = studentId;
	}

	public String getStuStatus() {

		if (this.stuStatus) {
			return "Active";
		}
		return "Inactive";
	}

	public void setStuStatus(boolean studentStatus) {
		this.stuStatus = studentStatus;
	}
}
