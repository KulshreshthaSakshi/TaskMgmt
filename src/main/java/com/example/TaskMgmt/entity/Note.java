package com.example.TaskMgmt.entity;

import jakarta.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    public Note() {}

    public Note(String title, String content, Date addDate, String eventDate, String time, User user) {
        this.Title = title;
        this.Content = content;
        this.addDate = addDate;
        setEventDate(eventDate);
        this.time = time;
        this.user = user;
    }

    public Note(TrashNote trashNote) {
		
		this.Title = trashNote.getTitle();
		this.Content = trashNote.getContent();
		this.addDate = trashNote.getAddDate();
		this.setEventDate(trashNote.getEventDate());
		this.time = trashNote.getTime();
		this.user = trashNote.getUser();
	}

	public String getEventDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(eventDate);
    }

    public void setEventDate(String eventDateStr) {
        try {
            this.eventDate = new SimpleDateFormat("yyyy-MM-dd").parse(eventDateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public int getID() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
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

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	@Override
	public String toString() {
		return "Note [ID=" + id + ", Title=" + Title + ", Content=" + Content + ", addDate=" + addDate + ", eventDate="
				+ eventDate + ", time=" + time + ", user=" + user + "]";
	}

    
}