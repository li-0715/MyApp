package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Goods;
import model.ListLogic;

@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * GET: カート追加画面 or メニューからの遷移処理
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータ取得
        String idParam = request.getParameter("id");

        if (idParam == null) {
            // メニューから遷移した場合
            request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);
        } else {
            // 「カートに追加」から遷移した場合
            try {
                int id = Integer.parseInt(idParam); // id を int に変換
                ListLogic logic = new ListLogic();
                Goods goods = logic.get(id); // 商品取得

                // リクエストスコープに goods を保存
                request.setAttribute("goods", goods);

                // cartadd.jsp にフォワード
                request.getRequestDispatcher("WEB-INF/jsp/cartadd.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                // 変換失敗時 → カート画面へ
                request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);
            }
        }
    }

    /**
     * POST: カートに商品を追加
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータ取得
        String idParam = request.getParameter("id");
        String numParam = request.getParameter("num");

        try {
            int id = Integer.parseInt(idParam);
            int num = Integer.parseInt(numParam);

            // 商品を取得
            ListLogic logic = new ListLogic();
            Goods goods = logic.get(id);

            // カートインスタンス作成
            Cart cart = new Cart(goods, num);

            // セッションスコープから cartlist を取得
            HttpSession session = request.getSession();
            @SuppressWarnings("unchecked")
            List<Cart> cartList = (List<Cart>) session.getAttribute("cartlist");

            if (cartList == null) {
                cartList = new ArrayList<>();
            }

            // カートに追加
            cartList.add(cart);

            // セッションに保存
            session.setAttribute("cartlist", cartList);

            // cart.jsp にフォワード
            request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            // エラー時もカート画面に戻す
            request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);
        }
    }
}
