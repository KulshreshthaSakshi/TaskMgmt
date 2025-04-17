package com.example.TaskMgmt.entity;

import jakarta.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class SharedNote {
    @Id
    private int ID;

    private String Title;

    @Column(length = 5000)
    private String Content;

    @Temporal(TemporalType.DATE)
    private Date addDate;

    @Temporal(TemporalType.DATE)
    private Date eventDate;

    private String time;

    @ManyToOne
    @JoinColumn(name = "user_email")
    private User user;

    @OneToOne
    private Note note;

    public SharedNote() {}

    public SharedNote(Note n) {
        this.ID = n.getID();
        this.Title = n.getTitle();
        this.Content = n.getContent();
        this.addDate = new Date();
        setEventDate(n.getEventDate());
        this.time = n.getTime();
        this.user = n.getUser();
        this.note = n;
    }

    public String getEventDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(eventDate);
    }

    public void setEventDate(String eventDateStr) {
        try {
            this.eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(eventDateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	@Override
	public String toString() {
		return "SharedNote [ID=" + ID + ", Title=" + Title + ", Content=" + Content + ", addDate=" + addDate
				+ ", eventDate=" + eventDate + ", time=" + time + ", user=" + user + ", note=" + note + "]";
	}

    
}
