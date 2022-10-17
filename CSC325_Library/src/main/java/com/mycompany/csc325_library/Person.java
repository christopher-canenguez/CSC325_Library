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
    
    private String firstName;
    private String lastName;
   

    /**
     *Parameterized Constructor:
     *stores the parameters into the appropriate instance variables
     * @param firtName
     * @param lastName
     */
  


    public Person(String fName, String lName) {
        firstName = fName;
        lastName = lName;
    }
    
    
        /**
     *Getter and setters for person attributes
     * @return
     */
 

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    /**
     *ToString method
     */
 
   @Override
    public String toString() {
        String personInfo = "Person Information - " + "firstName: " + firstName + ", lastName: " + lastName + " ";
        return personInfo;
    }
    
    
}
