package mylab.student.entity;

import mylab.student.exception.*;

public class Student {
	private int studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student() {
		System.out.println("새로운 학생 정보가 생성되었습니다.");
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) 
			throws InvalidGradeException {
		System.out.println(grade + "학년으로 변경을 시도합니다.");
		if( grade > 4 || grade < 0 ) {
			throw new InvalidGradeException("학년은 1~4 사이의 값이어야 합니다.");
		}
		this.grade = grade;
		System.out.println(grade + "학년으로 변경을 완료하였습니다.");
	}
	
}
