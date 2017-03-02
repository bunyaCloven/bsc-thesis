package co.madran.beeride.security;

import co.madran.beeride.model.dao.UserRepository;
import co.madran.beeride.model.domain.User;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/** Session related requests are handled here. */
@Controller
public class SecurityRequestHandler {
  @Autowired
  UserRepository userRepository;

  @ResponseBody
  @RequestMapping(value = "/cologin")
  public ResponseEntity<Void> getRoot(Model model) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /** Sends requesting ajax requests to main page with timeout flag. */
  @RequestMapping("/timeout")
  public void afterLogoutAjaxResponse(final HttpServletRequest request,
      final HttpServletResponse response) throws IOException {
    try (Writer out = response.getWriter()) {
      if (isAjaxRequest(request)) {
        out.write("window.location='login?timeout'");
      } else {
        response.sendRedirect("login?timeout");
      }
    }
  }

  /**
   * @return iff the request is an ajax call.
   */
  public static boolean isAjaxRequest(final HttpServletRequest request) {
    return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
  }

  @ResponseBody
  @RequestMapping(value = "/signup")
  public ResponseEntity<Void> signup(@RequestParam String username,
      @RequestParam String email, @RequestParam String password,
      @RequestParam String password2) {
    HttpStatus status;
    String uname = username.split(",")[1];
    if (password.equals(password2) && email.contains("@")
        && userRepository.findByUsername(uname) == null) {
      status = HttpStatus.OK;
      User user = new User();
      user.setUsername(uname);
      user.setEmail(email);
      user.setPassword(password);
      userRepository.save(user);
    } else {
      status = HttpStatus.CONFLICT;
    }
    return new ResponseEntity<>(status);
  }
}
