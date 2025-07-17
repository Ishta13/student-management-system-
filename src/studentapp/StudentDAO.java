package studentapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private Connection conn;

    public StudentDAO() {
        conn = DBConnection.getConnection();
    }

    // ✅ Add Student
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getCourse());

            stmt.executeUpdate();
            System.out.println("✅ Student Added Successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Get All Students
    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course")
                );
                studentList.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    // ✅ Update Student
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, email = ?, course = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getCourse());
            stmt.setInt(4, student.getId());

            stmt.executeUpdate();
            System.out.println("✅ Student Updated Successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ Delete Student
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Student Deleted Successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
