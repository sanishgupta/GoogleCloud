package com.dev.todo.app.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * A Model class to store the ToDo information element 
 * 
 * @author Sanish.Gupta
 *
 */
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;

    private String summary;
    private String description;
    private String url;
    private String status;
    boolean finished;

    public Todo(String author, String summary, String description,
            String url, String status) {
        this.author = author;
        this.summary = summary;
        this.description = description;
        this.url = url;
        this.status = status;
        finished = false;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortDescription() {
        return summary;
    }

    public void setShortDescription(String shortDescription) {
        this.summary = shortDescription;
    }

    public String getLongDescription() {
        return description;
    }

    public void setLongDescription(String longDescription) {
        this.description = longDescription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
    

}