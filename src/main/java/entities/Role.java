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
public class Role implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Integer id_role;
    private String description;

    public Role() {
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Role{");
        sb.append("id_role=").append(id_role);
        sb.append(", desc=").append(description);
        sb.append('}');
        return sb.toString();
    }
    
    
}
