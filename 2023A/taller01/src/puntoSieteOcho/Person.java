package puntoSieteOcho;

public class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.age = age;
		setName(name);
		setAge(age);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
