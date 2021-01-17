package pl.coderslab.users.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class CodingFilter implements Filter {
    public void destroy() {
    }

    private String charsetEncoding = "utf-8";
    private String contentType = "text/html";

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
//        request.setCharacterEncoding(charsetEncoding);
//        response.setContentType(contentType);
//        response.setCharacterEncoding(charsetEncoding);
        filterChain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
