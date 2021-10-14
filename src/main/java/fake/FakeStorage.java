package fake;

import models.User;
import java.util.ArrayList;
import java.util.List;


public class FakeStorage {
    // переменная, которая хранит ссылку на единственный экземпляр объекта класса FakeStorage
    private static final FakeStorage storage;

    // статически инициализатор, создающий объект класса FakeStorage. Вызывается один раз при загрузке класса в JVM
    static {
        storage = new FakeStorage();
    }

    // поле-список, хранящее список пользователей системы
    private List<User> users;

    // приватный констуктор, выполняющий инициализацию списка
    private FakeStorage() {
        this.users = new ArrayList<>();
        User user1 = new User("Oleg", "1212", "oleg@google.com");
        User user2 = new User("Victor", "1212", "viktor@google.com");
        User user3 = new User("Sergey", "1212", "sergey@google.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    // метод, предоставляющий доступ к объекту класса
    public static FakeStorage storage() {
        return storage;
    }

    // метод, возвращающий список пользователей
    public List<User> users() {
        return users;
    }
}
