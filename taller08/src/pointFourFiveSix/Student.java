package pointFourFiveSix;

import java.util.Scanner;

public class Student {
	private Scanner sc = new Scanner(System.in);
	
	String name = "";
	int credits = 0;
	float gradePointAverage = 0.0f;
	int qualityPoints = 0;

	Student(String name, int credits, int qualityPoints) {
		setName(name);
		setCredits(credits);
		setQualityPoints(qualityPoints);
		
		updateGradePointAverage();
	}
	
	public void inputCreditsAndQualityPoints() {
		System.out.print("Please enter the number of credits for this course: ");
		int credits = sc.nextInt();
		setCredits(credits);
		
		System.out.print("Please enter the quality points for this course: ");
		int qualityPoints = sc.nextInt();
		setQualityPoints(qualityPoints);
		
		updateGradePointAverage();
	}
	
	private void updateGradePointAverage() {
		setGradePointAverage(getQualityPoints() / getCredits());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public float getGradePointAverage() {
		updateGradePointAverage();
		return gradePointAverage;
	}

	public void setGradePointAverage(float gradePointAverage) {
		this.gradePointAverage = gradePointAverage;
	}

	public int getQualityPoints() {
		return qualityPoints;
	}

	public void setQualityPoints(int qualityPoints) {
		this.qualityPoints = qualityPoints;
	}

}
