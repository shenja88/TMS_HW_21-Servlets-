package by.voluevich.dao;

import by.voluevich.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final List<User> USERS = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return USERS;
    }

    @Override
    public boolean editInfo(User user, String oldPass, String newPass, String newName) {
        if (user.getPassword().equals(oldPass)) {
            user.setPassword(newPass);
            user.setName(newName);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean save(User user) {
        if (!isExist(user)) {
            USERS.add(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isExist(User user) {
        return USERS.contains(user);
    }
}
