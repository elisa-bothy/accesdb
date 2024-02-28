/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Elisa Bothy
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id_person;
    private String login;
    private String pwd;
    private long id_role;

    public Person() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("id_person=").append(id_person);
        sb.append(", login=").append(login);
        sb.append(", pwd=").append(pwd);
        sb.append(", id_role=").append(id_role);
        sb.append('}');
        return sb.toString();
    }


    public Integer getId_person() {
        return id_person;
    }

    public void setId_person(Integer id_person) {
        this.id_person = id_person;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public long getId_role() {
        return id_role;
    }

    public void setId_role(long id_role) {
        this.id_role = id_role;
    }
    
    
}
