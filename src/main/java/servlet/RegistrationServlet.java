package servlet;

import model.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.EncodePasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final String busy = "Этот email уже занят";
    private final String submit = "Пароль не совпадает";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String submit_password = req.getParameter("submit_password");
        UserService userService = new UserServiceImpl();
        int counterOfEmail = 0;

        if (password.equals(submit_password)) {

            List<User> all = userService.getAll();

            for (User elem : all) {
                if (elem.getEmail().equals(email)) {
                    req.setAttribute("busy", busy);
                    req.getRequestDispatcher("new_registration.jsp").forward(req, resp);
                    counterOfEmail++;
                }
            }
        } else {
            req.setAttribute("submit", submit);
            counterOfEmail++;
            req.getRequestDispatcher("new_registration.jsp").forward(req,resp);
        }
        if (counterOfEmail == 0) {
            EncodePasswordUtil encodePasswordUtil = new EncodePasswordUtil();
            String securityPassword = encodePasswordUtil.securityRegistration(password);

            User user = new User();
            user.setEmail(email);
            user.setPassword(securityPassword);
            User saveUser = userService.save(user);

            HttpSession session = req.getSession();
            session.setAttribute("userEmail", saveUser.getEmail());
            session.setAttribute("userId", saveUser.getId());

            req.getRequestDispatcher("main_page.jsp").forward(req, resp);

        }

    }
}
