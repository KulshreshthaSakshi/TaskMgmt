package com.example.TaskMgmt.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private String email;
    private String fname;
    private String lname;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Note> notes;

    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TrashNote> trash;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SharedNote> shared;

    public User() {}

    

	

	public User(String email, String fname, String lname, String password) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	
	public List<TrashNote> getTrash() {
		return trash;
	}

	public void setTrash(List<TrashNote> trash) {
		this.trash = trash;
	}

	public List<SharedNote> getShared() {
		return shared;
	}

	public void setShared(List<SharedNote> shared) {
		this.shared = shared;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", fname=" + fname + ", lname=" + lname + ", password=" + password + ", notes="
				+ notes +  ", trash=" + trash + ", shared=" + shared + "]";
	}

    
}
