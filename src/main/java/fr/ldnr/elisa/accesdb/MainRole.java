/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ldnr.elisa.accesdb;

import dao.RoleDAO;
import entities.Role;
import java.util.Collection;

/**
 *
 * @author Elisa Bothy
 */
public class MainRole {
     public static void main(String[] args) {
         //role
        
         //récupérer un DAO sur la table role
        RoleDAO rdao = new RoleDAO();
        //Compter les lignes
        System.out.println("nb de lignes" + rdao.count());
        //Lire une occurence de la table person
        Role r = rdao.read(2);
        System.out.println("r2 = " + r);
         //afficher la liste
        show(rdao.list());
        //Créer un role
        Role rage = new Role();
        rage.setDesc("super utilisateur");
        //Persister l'objet Person dans la table person
        System.out.println("rage = " + rage);
        rdao.create(rage);
        System.out.println("rage = " + rage);
        //afficher la liste
        System.out.println("nb de lignes" + rdao.count());
        show(rdao.list());
        //Modifier l'objet r
        r.setDesc("prout");
        //L'update en DB
        rdao.update(r);
        // Supprimer prout
        rdao.delete(rage.getId_role());
        //afficher la liste
        System.out.println("nb de lignes" + rdao.count());
        show(rdao.list());
        dao.MariadbConnection.closeConnection();
     }
     private static void show (Collection<Role> list){
        for(Role r :list){
            System.out.println("r = " + r);
        }
    }
}
