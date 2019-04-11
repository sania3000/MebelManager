package com.Sydorenko.service.security;
/** Basic security service declaring methods for
 * users logging-in
 * @author Oleksandr Sydorenko
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
