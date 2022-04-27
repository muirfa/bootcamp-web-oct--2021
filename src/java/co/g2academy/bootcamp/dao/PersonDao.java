/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.dao;

import co.g2academy.bootcamp.entity.Person;
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
public class PersonDao {
    private JdbcConnection jdbc =  new JdbcConnection();
    
    public List<Person> getPersons() {
        try {
            Statement statement = jdbc.createConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String selectQuery = "select * from T_PERSON";
            ResultSet rs = statement.executeQuery(selectQuery);
            List<Person> persons = new ArrayList<>();
            while (rs.next()) {
                persons.add(mapResultSetToPerson(rs));
            }
            return persons;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Collections.emptyList();
    }

    public void save(Person person) {
        try {
            if (person.getId() == null) {
                String insertSql = "insert into T_PERSON(name, password) values (?, ?)";
                PreparedStatement ps = jdbc.createConnection().prepareStatement(insertSql);
                ps.setString(1, person.getName());
                ps.setString(2, person.getPassword());
                ps.executeUpdate();
            } else {
                String updateSql = "update T_PERSON set name=?, password=? where id=?";
                PreparedStatement ps = jdbc.createConnection().prepareStatement(updateSql);
                ps.setString(1, person.getName());
                ps.setString(2, person.getPassword());
                ps.setInt(3, person.getId());
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            String deleteSql = "delete from T_PERSON where id=?";
            PreparedStatement ps = jdbc.createConnection().prepareStatement(deleteSql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Person getPersonById(Integer id) {
        try {
            String personByidSql = "select * from T_PERSON where id=?";
            PreparedStatement ps = jdbc.createConnection().prepareStatement(personByidSql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToPerson(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Person getPersonByName(String name) {
        try {
            String personByIdSql = "select * from T_PERSON where name=?";
            PreparedStatement ps = jdbc.createConnection().prepareStatement(personByIdSql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToPerson(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Person mapResultSetToPerson(ResultSet rs) throws SQLException {
        Person p = new Person();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setPassword(rs.getString("password"));
        return p;
    }
}
