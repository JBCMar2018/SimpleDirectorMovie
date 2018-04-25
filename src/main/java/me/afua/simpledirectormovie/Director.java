package me.afua.simpledirectormovie;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String fullName;

    private String genre;

    //Each Director has many movies
    //In the movies object (table), the director is labelled "theDirector", so put his/her
    //ID in that field when you show who directed the movie. See the movie table for details
    @OneToMany(mappedBy = "theDirector")
    Set <Movie>myMovies;

    public Director() {
        //Don't forget to instantiate the hash set so that you can add to it!
        myMovies = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Movie> getMyMovies() {
        return myMovies;
    }

    public void setMyMovies(Set<Movie> myMovies) {
        this.myMovies = myMovies;
    }
}
