package com.mycompany.csc325_library;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *Title: Person Class
 * Description: Contains attributes of a person object 
 * @author kulsomzaraei
 */
public class Person {
    
    /**
     Instance Variables:
     */
    
    private String name;
   

    /**
     *Parameterized Constructor:
     *stores the parameters into the appropriate instance variables
     * @param name
     */
  


    public Person(String name1) {
        name = name1;
    }
    
    
        /**
     *Getter and setters for person attributes
     * @return
     */
 

    public void setName(String name) {
        this.name = name;
    }

    public String getname() {
        return name;
    }


    
    /**
     *ToString method
     */
 
   @Override
    public String toString() {
        String personInfo = "Person Information - " + "Name: " + name;
        return personInfo;
    }
    
    
}
