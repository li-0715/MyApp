package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AuthLogic;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    // セッション取得
	    HttpSession session = request.getSession(false); 
	    if (session != null) {
	        // ログアウト処理
	        AuthLogic auth = new AuthLogic();
	        auth.logout(session);

	        // 🔽 ここでカート情報も削除する
	        session.removeAttribute("cartlist");
	    }

	    // logout.jsp にフォワード
	    request.getRequestDispatcher("WEB-INF/jsp/logout.jsp").forward(request, response);
	}
}
