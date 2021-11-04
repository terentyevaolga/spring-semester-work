package repositories;

import models.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilmsRepositoryImpl implements FilmsRepository {

    private Connection connection;

    private final String INSERT_INTO_FILMS = "insert into film(image_url, description) values(?, ?);";
    private final String FIND_FILM_BY_ID = "select * from \"film\" where id=?;";
    private final String FIND_FILM_ALL = "select * from film;";

    public FilmsRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Film> findAll() {
        ResultSet resultSet = null;
        List<Film> films = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_FILM_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Film film = new Film();
                film.setId(resultSet.getInt("id"));
                film.setImageURL(resultSet.getString("image_url"));
                film.setDescription(resultSet.getString("description"));
                film.setName(resultSet.getString("name"));
                films.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return films;
    }

    @Override
    public Optional<Film> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Film save(Film film) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_INTO_FILMS);
            preparedStatement.setString(1, film.getImageURL());
            preparedStatement.setString(2, film.getDescription());

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                film.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return film;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Film findByName(String name) {
        return null;
    }
}
