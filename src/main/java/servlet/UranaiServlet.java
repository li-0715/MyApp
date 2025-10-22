package servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Fortune;
import model.User; // ← これが追加された import！

@WebServlet("/UranaiServlet")
public class UranaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String[] luckArray = { "超スッキリ(^▽^)/", "スッキリ", "まぁまぁスッキリ", "最悪" };
		int index = new Random().nextInt(luckArray.length);
		String selectedLuck = luckArray[index];

		String today = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd(E) HH:mm:ss"));

		String name = "ゲスト";
		HttpSession session = request.getSession();
		if (session != null && session.getAttribute("loginUser") != null) {
			User loginUser = (User) session.getAttribute("loginUser");
			name = loginUser.getName();
		}

		Fortune fortune = new Fortune();
		fortune.setName(name);
		fortune.setLuck(selectedLuck);
		fortune.setToday(today);

		request.setAttribute("fortune", fortune);

		request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);
	}
}
