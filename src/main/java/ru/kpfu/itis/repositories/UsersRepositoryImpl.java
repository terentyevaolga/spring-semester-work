package ru.kpfu.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Review;
import ru.kpfu.itis.models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final RowMapper<User> userRowMapper = ((resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .email(resultSet.getString("email"))
            .passwordHash(resultSet.getString("passwordhash"))
            .build());

    //language=SQL
    private static final String INSERT_INTO_USERDATA = "insert into userdata(name, email, passwordhash) values(?, ?, ?)";
    private static final String FIND_USER_BY_NAME = "select * from userdata where name=?;";
    private static final String FIND_ALL_USERS = "select * from \"userdata\";";
    private static final String FIND_USER_BY_ID = "select * from \"userdata\" where id=?;";
    private static final String INSERT_INTO_REVIEWS_ABOUT_SITE = "insert into reviews_about_site(userPhone, reviewText) values (?, ?)";

    @Override
    public User save(User user) {
        user.setPasswordHash(new BCryptPasswordEncoder().encode(user.getPasswordHash()));
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(
                INSERT_INTO_USERDATA,
                namedParameters,
                keyHolder,
                new String[]{"id"}
        );
        user.setId((long) keyHolder.getKey().intValue());
        return user;
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> users) {
        List<User> userList = new ArrayList<>();
        users.forEach(userList::add);
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(userList.toArray());
        namedParameterJdbcTemplate.batchUpdate(INSERT_INTO_USERDATA, batch);
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(FIND_USER_BY_ID, userRowMapper); //почему то не работает метод
        } catch (DataAccessException e) {
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<User> findAll(int nothing) {
        return jdbcTemplate.query(FIND_ALL_USERS, userRowMapper);
    }

    @Override
    public Iterable<User> findAll() {
        return findAll(0);
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> longs) {
        List<User> result = new ArrayList<>();
        longs.forEach(myLong -> result.add(findById(myLong).get()));
        return result;
    }

    @Override
    public long count() {
        return findAll(0).size();
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public Review save(Review review) {
        return null;
    }

    @Override
    public void delete(User entity) {
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {
    }

    @Override
    public void deleteAll() {

    }
}