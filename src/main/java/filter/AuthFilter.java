package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import repository.MapRepository;

import java.io.IOException;

//30!!!
@WebFilter(urlPatterns = {
        "/todo",
        "/about-me",
        "/tasks"})
public class AuthFilter implements Filter {
private MapRepository mapRepository;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        mapRepository= MapRepository.getInstance();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        String username = (String) session.getAttribute("username");
        if (username != null&& mapRepository.isUsernameContains(username)) {
            chain.doFilter(request, response);
            System.out.println("filter");
            return;
        }
        request.getRequestDispatcher("/login").forward(request,response);
    }
}