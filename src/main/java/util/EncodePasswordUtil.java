package util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePasswordUtil {

    public String securityRegistration(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

}
