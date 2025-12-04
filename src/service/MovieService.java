package service;

import dao.MovieDAO;
import model.Movie;

public class MovieService {

    private MovieDAO movieDAO = new MovieDAO();

    // Add movie through DAO
    public void addMovie(Movie m) {
        movieDAO.addMovie(m);
    }

    // Check if movie exists
    public boolean movieExists(String title, String language) {
        return movieDAO.movieExists(title, language);
    }
}
