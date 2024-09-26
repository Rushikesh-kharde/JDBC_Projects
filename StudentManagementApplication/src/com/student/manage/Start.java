package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws IOException, NumberFormatException {
		System.out.println("!!-- Welcome to Student Management System --!!");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to Add Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to Exit App");
			
			int c=Integer.parseInt(br.readLine());
			if(c == 1) {
				// Add Student
//				System.out.println("Enter User ID :");
//				int sid=Integer.parseInt(br.readLine());
				
				System.out.println("Enter User Name :");
				String sname=br.readLine();
				
				System.out.println("Enter User Phone :");
				String sphone=br.readLine();
				
				System.out.println("Enter User City :");
				String scity=br.readLine();
				
				//Create Student object to store student
				Student st = new Student(sname, sphone, scity);
				boolean answer= StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student data is Inserted");
				}else {
					System.out.println("Something went wrong try again !!");
				}
				System.out.println(st);
			}else if(c == 2) {
				// Delete Student
				System.out.println("Enter Student ID to Delete: ");
				int sid=Integer.parseInt(br.readLine());
				boolean deleted = StudentDao.deleteStudentById(sid);
			if (deleted) {
				System.out.println("Student deleted successfully!");
			} else {
				System.out.println("Student not found or deletion failed!");
			}
			}else if(c == 3) {
				// Display Student
				StudentDao.displayAllStudents();
			}else if(c == 4) {
				// Exit from Application
				break;
			}else {
				System.out.println("Choose Appropriate option");
			}
		}
		System.out.println("!! Thank You For Using Application !!");
}
	}


