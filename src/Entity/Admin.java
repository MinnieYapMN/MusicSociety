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
public class Admin {
    private String username;
    private String password;
    private String adminID;
    private String contactNo;
    private String email;
    private String birthdate;

    public Admin(String username, String password, String adminID, String contactNo, String email, String birthdate) {
        this.username = username;
        this.password = password;
        this.adminID = adminID;
        this.contactNo = contactNo;
        this.email = email;
        this.birthdate = birthdate;
    }


    public String getUsername() {
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
    }

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
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
        return "Admin{" + "\nUsername => " + username + "\nPassword => " + password + "\nAdmin ID => " + adminID + "\nContact No => " + contactNo + "\nEmail => " + email + "\nBirthdate => " + birthdate + '}';
    }
    
}
