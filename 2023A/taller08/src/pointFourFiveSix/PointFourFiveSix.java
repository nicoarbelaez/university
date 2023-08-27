package pointFourFiveSix;

public class PointFourFiveSix {
	public PointFourFiveSix() {
		Student[] students = new Student[3];
		// Crear los tres estudiantes
		students[0] = new Student("Mary Jones", 14, 46);
		students[1] = new Student("John Stiner", 60, 173);
		students[2] = new Student("Ari Samala", 31, 69);
		
		// Modificar al ultimo estudiante
		int credits = students[2].getCredits();
		int qualityPoints = students[2].getQualityPoints();;
		students[2].setCredits(credits + 3);
		students[2].setQualityPoints(qualityPoints + 52);
		
		students[2].inputCreditsAndQualityPoints();
	}
}
