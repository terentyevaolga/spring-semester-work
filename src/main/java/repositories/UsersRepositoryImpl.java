package repositories;

import models.Review;
import models.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository {

    private Connection connection;

    private final String INSERT_INTO_USERDATA = "insert into userdata(name, email, passwordHash) values(?, ?, ?)";
    private final String FIND_USER_BY_NAME = "select * from userdata where name=?;";
    private final String INSERT_INTO_REVIEWS_ABOUT_SITE = "insert into reviews_about_site(userPhone, reviewText) values (?, ?)";

    public UsersRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public UsersRepositoryImpl() {

    }

    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_INTO_USERDATA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPasswordHash());

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                user.setId(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Review save(Review review) {
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(INSERT_INTO_REVIEWS_ABOUT_SITE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, review.getUserPhone());
            preparedStatement.setString(2, review.getUserReviewText());

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                review.setId(resultSet.getLong("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return review;
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public User findByName(String name) {
        ResultSet resultSet = null;
        User user = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_NAME);
            preparedStatement.setString(1, name);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPasswordHash(resultSet.getString("passwordHash"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
