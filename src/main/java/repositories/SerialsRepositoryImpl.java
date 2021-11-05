package repositories;

import models.Film;
import models.Serial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SerialsRepositoryImpl implements SerialsRepository {

    private Connection connection;

    private final String INSERT_INTO_SERIALS = "insert into serial(image_url, description) values(?, ?);";
    private final String FIND_SERIAL_BY_ID = "select * from serial where id=?;";
    private final String FIND_SERIAL_ALL = "select * from serial";

    public SerialsRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Serial> findAll() {
        ResultSet resultSet = null;
        List<Serial> serials = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_SERIAL_ALL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Serial serial = new Serial();
                serial.setId(resultSet.getInt("id"));
                serial.setImageURL(resultSet.getString("image_url"));
                serial.setDescription(resultSet.getString("description"));
                serial.setName(resultSet.getString("name"));
                serials.add(serial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serials;
    }

    @Override
    public Optional<Serial> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Serial save(Serial serial) {
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(INSERT_INTO_SERIALS);
            preparedStatement.setString(1, serial.getImageURL());
            preparedStatement.setString(2, serial.getDescription());

            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                serial.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serial;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Serial findByName(String name) {
        return null;
    }
}
