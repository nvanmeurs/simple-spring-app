package com.tutorial.simple.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UsersDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        Date now = new Date();
        users.add(new User(1, "Nicky", now));
        users.add(new User(2, "Lucio", now));
        users.add(new User(3, "Roland", now));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }

        users.add(user);
        return user;
    }

    public boolean deleteById(int id) {
        return users.removeIf(user -> user.getId() == id);
    }
}
