package kr.ac.kku.cs.wp.kim_woojin01;
import User.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kku.cs.wp.kim_woojin01.data.UserData;
import User.User;

public class UserControllerServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자 데이터 가져오기
        Map<String, User> usersMap = UserData.getInstance().getData();
        List<User> users = new ArrayList<>(usersMap.values());

        // 사용자 목록을 request에 설정
        req.setAttribute("users", users);

        // JSP 페이지로 포워딩
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/userList.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자 데이터 가져오기
        Map<String, User> usersMap = UserData.getInstance().getData();
        List<User> users = new ArrayList<>(usersMap.values());

        // 사용자 목록을 request에 설정
        req.setAttribute("users", users);

        // JSP 페이지로 포워딩
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/userList.jsp");
        rd.forward(req, resp);
    }
}