package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
public class StudentDao {
	public static boolean insertStudentToDB(Student st) {
		boolean f=false;
		try {
		// JDBC code
		Connection con=CP.createC();
		if(con != null) {
		String insert="Insert into Students(sname,sphone,scity) values(?,?,?)";
		// PreparedStatement
		PreparedStatement pstmt=con.prepareStatement(insert);
		//send the values of parameter
		pstmt.setString(1, st.getSname());
		pstmt.setString(2, st.getSphone());
		pstmt.setString(3, st.getScity());
		
		// Execute
		pstmt.executeUpdate();
		f=true;
		
		}else {
			System.out.println("Conncection is not Established");
		}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return f;
		
	}
	public static boolean deleteStudentById(int id) {
        boolean deleted = false;
        try {
            Connection con = CP.createC();
            if (con != null) {
                String delete = "DELETE FROM Students WHERE studentId=?";
                PreparedStatement ps = con.prepareStatement(delete);
                ps.setInt(1, id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    deleted = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleted;
    }

    public static void displayAllStudents() {
        try {
            Connection con = CP.createC();
            if (con != null) {
                String selectAll = "SELECT * FROM Students";
                PreparedStatement ps = con.prepareStatement(selectAll);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int sid = rs.getInt("studentId");
                    String sname = rs.getString("sname");
                    String sphone = rs.getString("sphone");
                    String scity = rs.getString("scity");

                    Student student = new Student( sname, sphone, scity);
                    System.out.println(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
