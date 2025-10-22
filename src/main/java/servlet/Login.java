package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AuthLogic;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession(); 
	    AuthLogic auth = new AuthLogic();
	    
	    String path;
	    if (auth.isLoggedIn(session)) {
	        path = "WEB-INF/jsp/mypage.jsp";
	    } else {
	        path = "WEB-INF/jsp/login.jsp";
	    }

	    request.getRequestDispatcher(path).forward(request, response);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

	    String email = request.getParameter("email");
	    String pass = request.getParameter("pass");

	    String path;
	    HttpSession session;

	    if (email == null || email.isEmpty() || pass == null || pass.isEmpty()) {
	        request.setAttribute("errorMsg", "メールアドレスとパスワードは必ず入力してください。");
	        path = "WEB-INF/jsp/login.jsp";
	    } else {
	        AuthLogic auth = new AuthLogic();
	        User user = auth.login(email, pass);

	        if (user != null) {
	            session = request.getSession();
	            session.setAttribute("loginUser", user);
	            path = "WEB-INF/jsp/mypage.jsp";
	        } else {
	            request.setAttribute("errorMsg", "ログインに失敗しました。");
	            path = "WEB-INF/jsp/login.jsp";
	        }
	    }

	    request.getRequestDispatcher(path).forward(request, response);
	}

}
