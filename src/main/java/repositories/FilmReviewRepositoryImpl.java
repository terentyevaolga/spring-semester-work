package repositories;

import models.Film;
import models.FilmReview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmReviewRepositoryImpl implements FilmReviewRepository {

    private Connection connection;

    private final String INSERT_INTO_FILMS = "insert into \"reviews_about_film\"(user_name, text, film_id) values(?, ?, ?);";
    private final String FIND_REVIEW_BY_ID = "select * from reviews_about_film;";


    public FilmReviewRepositoryImpl(Connection connection) { this.connection = connection;}

    @Override
    public List<FilmReview> findAll(Film film) {
        ResultSet resultSet;
        List<FilmReview> reviews = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_REVIEW_BY_ID);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                FilmReview filmReview = new FilmReview();
                filmReview.setId(resultSet.getInt("id"));
                filmReview.setUserName(resultSet.getString("user_name"));
                filmReview.setText(resultSet.getString("text"));
                filmReview.setFilmId(resultSet.getInt("film_id"));
                if (filmReview.getFilmId() == film.getId()) reviews.add(filmReview);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public FilmReview save(FilmReview filmsReview) {
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(INSERT_INTO_FILMS);
            preparedStatement.setString(1, filmsReview.getUserName());
            preparedStatement.setString(2, filmsReview.getText());
            preparedStatement.setInt(3, filmsReview.getFilmId());

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                filmsReview.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filmsReview;
    }
}
