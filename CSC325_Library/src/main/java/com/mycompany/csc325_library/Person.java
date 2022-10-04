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
    private String personID;

    /**
     *Parameterized Constructor:
     *stores the parameters into the appropriate instance variables
     * @param firtName
     * @param lastName
     * @param personID
     */
    public void setPersonID(String personID) {
        this.personID = personID;
    }


    public Person(String fName, String lName, String id) {
        firstName = fName;
        lastName = lName;
        personID = id;
    }
    
    
        /**
     *Getter and setters for person attributes
     * @return
     */
    public String getFirstName(){
        return firstName;
    
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonID() {
        return personID;
    }
    
    
    /**
     *ToString method
     */
 
   @Override
    public String toString() {
        String personString = "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", personID=" + personID + '}';
        return personString;
    }
    
    
}
