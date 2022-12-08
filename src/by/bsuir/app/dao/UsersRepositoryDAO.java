package by.bsuir.app.dao;

import by.bsuir.code.lab4.entity.User;

public interface UsersRepositoryDAO {
    User getAccountByLogin(String login);
    void add(User user);
}
