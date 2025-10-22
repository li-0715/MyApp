package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AuthLogic;
import model.Goods;
import model.ListLogic;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		AuthLogic auth = new AuthLogic();

		if (auth.isLoggedIn(session)) {
			ListLogic logic = new ListLogic();
			List<Goods> goodsList = logic.get();

			request.setAttribute("goodsList", goodsList);
			request.getRequestDispatcher("WEB-INF/jsp/list.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// フォームから送信されたキーワードを取得
		String keyword = request.getParameter("keyword");
		if (keyword == null) {
			keyword = "";
		}

		// ListLogicから検索メソッドを呼び出す（キーワードのみ）
		ListLogic logic = new ListLogic();
		List<Goods> goodsList = logic.search(keyword);  // ← 修正済み

		// 検索結果をリクエストスコープにセットしてJSPへフォワード
		request.setAttribute("goodsList", goodsList);
		request.getRequestDispatcher("WEB-INF/jsp/list.jsp").forward(request, response);
	}
}
