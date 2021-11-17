package com.epam.tc.hw5.cucumber.context;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Data {
    private static Data instance;
    private final Map<String, User> users = new HashMap<>();

    private Data() {
        users.put("ROMAN IOVLEV", new User("Roman", "Jdi1234"));
    }

    public static class User {
        String login;
        String password;

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public User getUser(String username) {
        User user = users.get(username);
        if (user == null) {
            throw new NoSuchElementException();
        }
        return user;
    }
}
