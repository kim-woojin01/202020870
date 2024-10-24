package kr.ac.kku.cs.wp.kim_woojin01;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import User.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kku.cs.wp.kim_woojin01.data.UserData;

/*@WebServlet(
    urlPatterns = {"/login", "/logout"}
)*/

public class LoginControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String context = req.getServletContext().getContextPath();
        String uriStr = req.getRequestURI().replaceAll(context, "");

        log("in service: " + uriStr);

        if (uriStr.equals("/login")) {
            req.getRequestDispatcher("/WEB-INF/view/auth/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String context = req.getServletContext().getContextPath();
        String uriStr = req.getRequestURI().replaceAll(context, "");

        log("in post: " + uriStr);

        if (uriStr.equals("/login")) {
            Map<String, User> users = UserData.getInstance().getData();
            String id = req.getParameter("username");
            String password = req.getParameter("password");
            User user = users.get(id);

            if (user == null) {
                req.setAttribute("error", "login_fail");
                req.getRequestDispatcher("/WEB-INF/view/auth/login.jsp").forward(req, resp);
            } else {
                log(password);
                log(user.getPassword());

                if (!password.equals(user.getPassword())) {
                    req.setAttribute("error", "login_fail");
                    req.getRequestDispatcher("/WEB-INF/view/auth/login.jsp").forward(req, resp);
                } else {
                    HttpSession session = req.getSession();
                    Account ac = new Account();
                    ac.setId(id);
                    ac.setUsername(password);
                    ac.setRoles(Collections.singletonList(user.getId()));  // 수정된 부분
                    ac.setEmail(user.getEmail());
                    session.setAttribute("user", ac);
                    resp.sendRedirect(context);
                }
            }
        } else if (uriStr.equals("/logout")) {
            HttpSession session = req.getSession();
            if (session != null) {
                session.invalidate();
            }
            resp.sendRedirect(context + "/login");
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}