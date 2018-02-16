package servlet;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.CheckPasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserService userService = new UserServiceImpl();
        List<User> allUser = userService.getAll();
        CheckPasswordUtil checkPasswordUtil = new CheckPasswordUtil();
        int counterOfUser = allUser.size();

        for (User user : allUser) {
            if (user.getEmail().equals(email)) {
                if (checkPasswordUtil.checkPassword(password, user.getPassword())) {
                    req.setAttribute("id", user.getId());
                    req.getRequestDispatcher("main_page.jsp").forward(req, resp);
                    counterOfUser--;
                }
            }
        }

        if (counterOfUser == allUser.size()) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
