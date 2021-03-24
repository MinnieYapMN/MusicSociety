/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


/**
 *
 * @author Ming Nee
 */
public class Member {
    private String studentID;
    private String name;
    private String contactNo;
    private String email;
    private String birthdate;
  

    public Member(String studentID, String name, String contactNo, String email, String birthdate) {
        this.studentID = studentID;
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
        this.birthdate = birthdate;
    }

    /*public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Member{"+ "\nStudent ID =>" + studentID + "\nName => " + name + "\nContact No => " + contactNo + "\nEmail => " + email + "\nBirthdate => " + birthdate + '}';
    }

}
