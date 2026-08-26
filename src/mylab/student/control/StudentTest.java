package mylab.student.control;

import mylab.student.exception.*;
import mylab.student.entity.*;

public class StudentTest {
	public static void main(String[] args) {
		try {
				Student student = new Student();
				
				student.setName("김민수");
				student.setMajor("컴퓨터공학과");
				student.setGrade(3);
				student.setStudentId(2371159);
				
				System.out.println("학번 : " + student.getStudentId());
				System.out.println("이름 :  " + student.getName());
				System.out.println("전공 : " + student.getMajor());
				System.out.println("학년 : " + student.getGrade());
				
				student.setGrade(5);
				
			} 
			catch(InvalidGradeException e) {
				System.out.println("Error 메시지 = " + e.getMessage());
			}
	}
}


