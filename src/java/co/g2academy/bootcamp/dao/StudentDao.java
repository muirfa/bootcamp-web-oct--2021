/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.dao;

import co.g2academy.bootcamp.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Asus
 */
public class StudentDao {
     private JdbcConnection jdbc =  new JdbcConnection();
     
     public List<Student> getStudents(){
         try {
            Statement statement = jdbc.createConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String selectQuery = "select * from T_STUDENT";
            ResultSet rs = statement.executeQuery(selectQuery);
            List<Student> students = new ArrayList<>();
            while (rs.next()) {
                students.add(mapResultSetToStudent(rs));
            }
            return students;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Collections.emptyList();
     }
     
     public void save(Student student){
         try {
            if (student.getId() == null) {
                String insertSql = "insert into T_STUDENT(fullname, address, status, physics, calculus, biology) values (?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = jdbc.createConnection().prepareStatement(insertSql);
                ps.setString(1, student.getFullname());
                ps.setString(2, student.getAddress());
                ps.setString(3, student.getStatus());
                ps.setInt(4, student.getPhysics());
                ps.setInt(5, student.getCalculus());
                ps.setInt(6, student.getBiology());
                ps.executeUpdate();
            } 
            else {
                String updateSql = "update T_STUDENT set fullname=?, address=?, status=?, physics=?, calculus=?, biology=? where id=?";
                PreparedStatement ps = jdbc.createConnection().prepareStatement(updateSql);
                ps.setString(1, student.getFullname());
                ps.setString(2, student.getAddress());
                ps.setString(3, student.getStatus());
                ps.setInt(4, student.getPhysics());
                ps.setInt(5, student.getCalculus());
                ps.setInt(6, student.getBiology());
                ps.setInt(7, student.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     
     public void delete(Integer id){
         try {
            String deleteSql = "delete from T_STUDENT where id=?";
            PreparedStatement ps = jdbc.createConnection().prepareStatement(deleteSql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
     
     public Student getStudentById(Integer id){
         try {
            String studentByidSql = "select * from T_STUDENT where id=?";
            PreparedStatement ps = jdbc.createConnection().prepareStatement(studentByidSql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToStudent(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
     }
     
     public Student mapResultSetToStudent(ResultSet rs) throws SQLException {
        Student s = new Student();
        s.setId(rs.getInt("id"));
        s.setFullname(rs.getString("fullname"));
        s.setAddress(rs.getString("address"));
        s.setStatus(rs.getString("status"));
        s.setPhysics(rs.getInt("physics"));
        s.setCalculus(rs.getInt("calculus"));
        s.setBiology(rs.getInt("biology"));
        return s;
    }
}
