package me.afua.simpledirectormovie;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    //Enter details about the movie

    @NotEmpty //Make sure that the title is not empty
    private String title;

    private long year;

    @Lob //allow the user to enter large amounts of text into this field
    private String description;

    //Add a relationship with the director:

    @ManyToOne()
    //This establishes a relationship in which many moves can SHARE one director
    private Director theDirector;


    //Make sure the default constructor is available

    public Movie() {

    }

    //Note that an overloaded constructor is optional.


    //Define the getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Gets the director associated with the movie. This is a COMPLETE director object, so you can look INTO that object to retrieve values
    public Director getTheDirector() {
        return theDirector;
    }

    public void setTheDirector(Director theDirector) {
        this.theDirector = theDirector;
    }
}
