package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Film;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmsRepositoryImpl implements FilmsRepository {

    private Connection connection;
    private JdbcTemplate template;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String INSERT_INTO_FILMS = "insert into film(image_url, description) values(?, ?);";
    private final String FIND_FILM_BY_ID = "select * from \"film\" where id=?;";
    private final String DELETE_FILM_BY_ID = "select * from \"film\" where id=?;";
    private final String FIND_FILM_ALL = "select * from film";


    public FilmsRepositoryImpl(Connection connection) {
        this.connection = connection;
    }
    public FilmsRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.template = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
    public Film findById(int id) {
        ResultSet resultSet = null;
        Film film;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_FILM_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                film = new Film();
                film.setId(resultSet.getInt("id"));
                film.setImageURL(resultSet.getString("image_url"));
                film.setDescription(resultSet.getString("description"));
                film.setName(resultSet.getString("name"));
                return film;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
    public void deleteById(int id) {

    }

    @Override
    public Film findByName(String name) {
        return null;
    }
}
