package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("prateek@gmail.com")
				.firstName("Prateek")
				.lastName("Singh")
				//.guardianName("Asha")
				//.guardianEmail("asha@gmail.com")
				//.guardianMobile("9999999999")
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian = Guardian.builder()
				.email("subhash@gmail.com")
				.name("Asha")
				.mobile("9999956324")
				.build();
		
		Student student = Student.builder()
				.firstName("Sanket")
				.emailId("sanket@gmail.com")
				.lastName("Singh")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudent() {
		List<Student> studentList = studentRepository.findAll();
		
		System.out.println("studentList = " + studentList);
	}
	
	@Test
	public void printStudentByFirstName() {
		
		List<Student> students = studentRepository.findByFirstName("Sanket");
		
		System.out.println("students = " + students);
	}
	
	@Test
	public void printStudentByFirstNameContaining() {
		
		List<Student> students = studentRepository.findByFirstNameContaining("e");
		
		System.out.println("students = " + students);
	}
	
	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("Asha");
		
		System.out.println("students = " + students);
	}
	
	@Test
	public void printgetStudentByEmailAddress() {
		Student student = studentRepository.getStudentByEmailAddress("prateek@gmail.com");
		
		System.out.println("student = " + student);
	}
	
	@Test
	public void printgetStudentFirstNameByEmailAddress() {
		String firstName = studentRepository.getStudentFirstNameByEmailAddress("prateek@gmail.com");
		
		System.out.println("student first name = " + firstName);
	}
	
	@Test
	public void printGetStudentByEmailAddressNative() {
		Student student = studentRepository.getStudentByEmailAddressNative("prateek@gmail.com");
		
		System.out.println("student = " + student);
	}
	
	@Test
	public void printgetStudentByEmailAddressNativeNameParam() {
		Student student = studentRepository.getStudentByEmailAddressNativeNameParam("prateek@gmail.com");
		
		System.out.println("student = " + student);
	}
	
	@Test
	public void updateStudentnameByEmailIdTest() {
		studentRepository.updateStudentnameByEmailId("Akhilesh", "prateek@gmail.com");
	}
}
