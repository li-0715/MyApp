package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.RegisterUserLogic;
import model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forwardPath = null;

        String action = request.getParameter("action");

        if (action == null) {
            forwardPath = "WEB-INF/jsp/registerForm.jsp";
        } 
        else if (action.equals("done")) {

            HttpSession session = request.getSession();
            User registerUser = (User) session.getAttribute("registerUser");

            RegisterUserLogic logic = new RegisterUserLogic();
            if (logic.execute(registerUser)) {
                // 登録成功したらセッションから削除
                session.removeAttribute("registerUser");
            }

            forwardPath = "WEB-INF/jsp/registerDone.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("id");  
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if (email == null || email.isEmpty() ||
                name == null || name.isEmpty() ||
                pass == null || pass.isEmpty()) {

            request.setAttribute("msg", "入力内容に不備があります");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerForm.jsp");
            dispatcher.forward(request, response);

        } else {
            User registerUser = new User(email, name, pass);
            HttpSession session = request.getSession();
            session.setAttribute("registerUser", registerUser);

            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
            dispatcher.forward(request, response);
        }
    }
}
