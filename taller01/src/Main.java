import puntoCinco.Student;
import puntoSieteOcho.Person;

public class Main {
	public static void main(String[] args) {
		Student student = new Student("Lisa", "Palombo", 123456789, true);
		System.out.println("Student Name: " + student.getFName() + " " + student.getLName());
		System.out.println("Student ID: " + student.getStuId());
		System.out.println("Student Status: " + student.getStuStatus());
	
		System.out.println("---------------------");
		
		puntoCiete();
	}
	
	public static void puntoCiete() {

		Person p1 = new Person("Arial", 37);
		Person p2 = new Person("Joshep", 15);

		if (p1.getAge() == p2.getAge()) {
			System.out.println(p1.getName() + "is the same age as " + p2.getName());
		} else {
			System.out.println(p1.getName() + "is NOT the same age as " + p2.getName());
		}
	}
}
