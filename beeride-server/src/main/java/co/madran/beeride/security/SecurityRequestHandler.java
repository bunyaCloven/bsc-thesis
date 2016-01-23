package co.madran.beeride.security;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** Session related requests are handled here */
public @Controller
class SecurityRequestHandler {
	/** Logs out from current session. */
	public @RequestMapping("/logout")
	void logout(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException {
		request.logout();
		response.setStatus(HttpServletResponse.SC_OK);
	}

	/** sends requesting ajax requests to main page with timeout flag */
	public @RequestMapping("/timeout")
	void afterLogoutAjaxResponse(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		try (Writer out = response.getWriter()) {
			if (isAjaxRequest(request)) {
				out.write("window.location='login?timeout'");
			} else {
				response.sendRedirect("login?timeout");
			}
		}
	}

	/** @return iff the request is an ajax call */
	public static boolean isAjaxRequest(final HttpServletRequest request) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}
}
