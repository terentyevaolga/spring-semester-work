package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Auth;
import ru.kpfu.itis.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class AuthRepositoryImpl implements AuthRepository {

    private Connection connection;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final String SQL_FIND_BY_COOKIE_VALUE = "SELECT *, auth.id as auth_id, users.id as user_id FROM auth INNER JOIN users ON auth.user_id=users.id WHERE auth.cookie_value=?";
    private final String SQL_INSERT_AUTH = "INSERT INTO auth (user_id, cookie_value) VALUES (?, ?)";

    public AuthRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public AuthRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Auth findByCookieValue(String cookieValue) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_COOKIE_VALUE);
            preparedStatement.setString(1, cookieValue);
            resultSet = preparedStatement.executeQuery();
            return authRowMapper.rowMap(resultSet);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public Optional<Auth> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Auth save(Auth auth) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_AUTH, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, auth.getUser().getId());
            preparedStatement.setString(2, auth.getCookieValue());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auth;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public String encode(CharSequence charSequence) {
        return null;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }

    private final RowMapper<Auth> authRowMapper = (resultSet) -> {
        if (resultSet.next()) {
            Auth auth = new Auth();
            auth.setId(resultSet.getLong("auth_id"));
            auth.setCookieValue(resultSet.getString("cookie_value"));

            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setName(resultSet.getString("name"));
            user.setEmail(resultSet.getString("email"));
            user.setPasswordHash(resultSet.getString("password_hash"));

            auth.setUser(user);
            return auth;
        } else {
            return null;
        }
    };
}
