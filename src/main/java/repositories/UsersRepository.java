package repositories;

import models.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll();
    void save(User user);
    //существует ли пользоватедь с таким именем и с таким паролем
    boolean isExist(String name, String password);

}
