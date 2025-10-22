package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Goods;

@WebServlet("/CartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータ取得
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);

        // セッションからカートリスト取得
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<Cart> cartlist = (List<Cart>) session.getAttribute("cartlist");

        // カートリストが存在する場合のみ処理
        if (cartlist != null) {
            for (int i = 0; i < cartlist.size(); i++) {
                Cart cart = cartlist.get(i);
                Goods goods = cart.getGoods();

                if (goods.getId() == id) {
                    cartlist.remove(i); // 該当商品削除
                    break; // ループを抜ける
                }
            }
            // 更新後のカートリストをセッションに保存
            session.setAttribute("cartlist", cartlist);
        }

        // cart.jsp にフォワード
        request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);
    }
}
