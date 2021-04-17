package edu.miu.cs.wap.MyServletProject.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}, description = "ApplicationHintCountFilter", urlPatterns = { "/","/*" })
public class ApplicationHintCountFilter implements Filter {

    private Integer totalHitCountApp = 0;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AppInfo-Log: Initializing " + filterConfig.getFilterName());
        filterConfig.getServletContext().setAttribute("totalHitCountApp", totalHitCountApp);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AppInfo-Log: Called doFilter via " + ((HttpServletRequest)servletRequest).getRequestURI());
        totalHitCountApp = (Integer) servletRequest.getServletContext().getAttribute("totalHitCountApp");
        servletRequest.getServletContext().setAttribute("totalHitCountApp", incrementHitCountApp());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    private synchronized int incrementHitCountApp(){
        return ++totalHitCountApp;
    }

    @Override
    public void destroy() {
    }
}
