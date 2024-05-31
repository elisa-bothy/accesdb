/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entities.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe pour passer de l'espace object à l'espace relationnel.
 * Implémente le CRUD sur la table person en utilisant l'entité Person
 * 
 * @author Elisa Bothy
 */
public class PersonDAO {
    Connection connection;

    public PersonDAO() throws SQLException {
        connection = MariadbConnection.getInstance();
    }
    
    public Person read(Integer id){
        Person obj = null;
        String sql = "SELECT * FROM person WHERE id_person=?";
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql); 
            pstmt.setInt(1, id);//le premier ? prend la valeur id 
            // que j'ai mis en paramètre
            ResultSet rs = pstmt.executeQuery();
            if (rs.first()){
                obj = new Person();
                obj.setId_person(rs.getInt("id_person"));
                obj.setLogin(rs.getString("login"));
                obj.setPwd(rs.getString("pwd"));
                obj.setId_role(rs.getInt("id_role"));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la lecture :" + ex.getMessage());
        }
       return obj;
    }
    
    public void create(Person obj){
        String sql = "INSERT INTO person (login, pwd, id_role) " + "VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = connection
                    .prepareStatement(
                            sql,
                            PreparedStatement.RETURN_GENERATED_KEYS
                    );
            pstmt.setString(1, obj.getLogin());
            pstmt.setString(2, obj.getPwd());
            pstmt.setLong(3, obj.getId_role());
            int nbLines = pstmt.executeUpdate();
            if(nbLines == 1){
                ResultSet autoGeneratedKeys = pstmt.getGeneratedKeys();
                autoGeneratedKeys.first();
                int id = autoGeneratedKeys.getInt(1);
                obj.setId_person(id);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'insertion :" + ex.getMessage());
        }
    }
    
    public void update (Person obj){
        String sql ="UPDATE person SET id_role=?, login=?, pwd=? " + "WHERE id_person=?";
        
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, obj.getId_role());
            pstmt.setString(2, obj.getLogin());
            pstmt.setString(3, obj.getPwd());
            pstmt.setInt(4, obj.getId_person());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'update :" + ex.getMessage());
        }
        
    }
    
    public void delete(Integer id){
        String sql = "DELETE FROM person WHERE id_person=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erreur lors du delete :" + ex.getMessage());
        }
    }
    
    public int count(){
        int count = 0;
        String sql = "SELECT COUNT(*) AS c FROM person";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if(rs.first()){
                count = rs.getInt("c");
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors du comptage :" + ex.getMessage());
        }
        return count;
    }
    
    public Collection<Person> list(){
        ArrayList<Person> list = new ArrayList<>();
        String sql = "SELECT * FROM person";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Person p = new Person();
                p.setId_person(rs.getInt("id_person"));
                p.setLogin(rs.getString("login"));
                p.setPwd(rs.getString("pwd"));
                p.setId_role(rs.getLong("id_role"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors du listage :" + ex.getMessage());
        }
        return list;
    }
    
}
