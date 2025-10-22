package model;

import dao.UsersDAO;
import jakarta.servlet.http.HttpSession;

public class AuthLogic {

    public User login(String email, String pass) {
        UsersDAO dao = new UsersDAO();
        return dao.findByLogin(email, pass);
    }

    public void logout(HttpSession session) {
        if (isLoggedIn(session)) {
            session.removeAttribute("loginUser");
            session.removeAttribute("cart"); // カート情報も削除
        }
    }

    public boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("loginUser") != null;
    }
}
