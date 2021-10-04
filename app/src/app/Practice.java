package app;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student student = new Student(24,"±èÅÂÀº",4);
		student.setAge(32);
		System.out.println(student.getAge());
	}

}

class Student{
	int age;
	String name;
	int grade;
	Scanner scanner = new Scanner(System.in);


	public Student(int age, String name, int grade) {
		this.age = age;
		this.name = name;
		this.grade = grade;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}