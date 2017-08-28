package com.kcs.database;

public class User {
	
	
    private int id;
    private String firstName, lastName, email, address, phone, uname, pass;

    public User() {	
	}
    
    public User(String firstName, String lastName, String email, String address, String phone, String uname, String pass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.uname = uname;
        this.pass = pass;
    }
    
    public User(int id, String firstName, String lastName, String email, String address, String phone, String uname, String pass) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.uname = uname;
        this.pass = pass;
    }

	public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}