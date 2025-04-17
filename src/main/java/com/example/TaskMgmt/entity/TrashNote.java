package com.example.TaskMgmt.entity;

import jakarta.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class TrashNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(length = 5000)
    private String Content;

    @Temporal(TemporalType.DATE)
    private Date addDate;

    @Temporal(TemporalType.DATE)
    private Date eventDate;

    @Temporal(TemporalType.DATE)
    private Date delDate;

    private String time;

    @ManyToOne
    @JoinColumn(name = "user_email")
    private User user;

    public TrashNote() {}

    public TrashNote(Note note) {
        this.title = note.getTitle();
        this.Content = note.getContent();
        this.addDate = note.getAddDate();
        setEventDate(note.getEventDate());
        this.time = note.getTime();
        this.user = note.getUser();
        this.delDate = new Date();
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

    public String getDelDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(delDate);
    }

    public void setDelDate(String delDateStr) {
        try {
            this.delDate = new SimpleDateFormat("yyyy-MM-dd").parse(delDateStr);
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
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}

	@Override
	public String toString() {
		return "TrashNote [ID=" + id + ", title=" + title + ", Content=" + Content + ", addDate=" + addDate
				+ ", eventDate=" + eventDate + ", delDate=" + delDate + ", time=" + time + ", user=" + user + "]";
	}

    
}
