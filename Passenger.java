/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ba1507475p2kauflightreservation;


/** 
Name: RawanFahadAlasmi
ID: 1507475
Section: BA
Course Name: Programming II (COCS203)  
Assignment Number: 2 
*/

public class Passenger {
    
    private String name;
    private int age;
    private char gender;
    private String phone;
    
    public Passenger(String name, int age, char gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }
        
    public Passenger(){}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void printPassenger(){
        
            System.out.print("Passenger Name :" + name);
            System.out.print("  Gender : " + gender);
            System.out.print("  Age : " + age);
    }
       
    
}
