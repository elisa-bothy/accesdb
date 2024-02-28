/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fr.ldnr.elisa.accesdb;

import dao.PersonDAO;
import dao.RoleDAO;
import entities.Person;
import entities.Role;
import java.util.Collection;

/**
 *
 * @author Elisa Bothy
 */
public class MainClass {

    public static void main(String[] args) {
        //récupérer un DAO sur la table person
        PersonDAO pdao = new PersonDAO();
        //Compter les lignes
        System.out.println("nb de lignes" + pdao.count());
        //Lire une occurence de la table person
        Person p = pdao.read(2);
        System.out.println("p2 = " + p);
         //afficher la liste
        show(pdao.list());
        //Créer une personne
        Person prout = new Person();
        prout.setId_role(2);
        prout.setLogin("Ulysse");
        prout.setPwd("Vatenguerre");
        //Persister l'objet Person dans la table person
        System.out.println("prout = " + prout);
        pdao.create(prout);
        System.out.println("prout = " + prout);
        //afficher la liste
        System.out.println("nb de lignes" + pdao.count());
        show(pdao.list());
        //Modifier l'objet p
        p.setId_role(1);
        p.setPwd("password");
        //L'update en DB
        pdao.update(p);
        // Supprimer prout
        pdao.delete(prout.getId_person());
        //afficher la liste
        System.out.println("nb de lignes" + pdao.count());
        show(pdao.list());
        dao.MariadbConnection.closeConnection();
    }
    private static void show (Collection<Person> list){
        for(Person p :list){
            System.out.println("p = " + p);
        }
    }
    
}
