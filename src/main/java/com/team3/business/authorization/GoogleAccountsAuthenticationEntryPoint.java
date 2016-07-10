package com.team3.business.authorization;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class GoogleAccountsAuthenticationEntryPoint implements AuthenticationEntryPoint {
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
      throws IOException, ServletException {
    UserService userService = UserServiceFactory.getUserService();

    response.sendRedirect(userService.createLoginURL(request.getRequestURI()));
  }
}
