package model;

import dao.UsersDAO;

public class RegisterUserLogic {
    public boolean execute(User user) {
        UsersDAO dao = new UsersDAO();
        User u = dao.create(user.getEmail(), user.getPass(), user.getName());

        return u != null;
    }
}
