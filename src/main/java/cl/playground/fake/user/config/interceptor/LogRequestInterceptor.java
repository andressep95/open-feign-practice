package cl.playground.fake.user.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

public class LogRequestInterceptor implements HandlerInterceptor {

    private Logger log = Logger.getLogger(LogRequestInterceptor.class.getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("start", System.currentTimeMillis());
        log.info(String.format("[%s - %s] Inicio llamado", request.getRequestURI(), request.getMethod()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info(String.format("[%s - %s] Fin llamado, status %s en %sms", request.getRequestURI(), request.getMethod(),
            response.getStatus(), (System.currentTimeMillis() - (Long) request.getAttribute("start"))));
    }
}
