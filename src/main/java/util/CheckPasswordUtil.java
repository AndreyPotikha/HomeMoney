package util;

import model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.UserService;
import service.impl.UserServiceImpl;

public class CheckPasswordUtil {

    public boolean checkPassword(String enterPassword, String dataUserPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(enterPassword, dataUserPassword)) {
            return true;
        }
        return false;
    }
}
