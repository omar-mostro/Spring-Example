package com.ejemplo.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component("RequestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    //Creamos el log en Spring
    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);


    //se ejcuta antes de entrar al controlador
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    //se ejecuta antes de mostrar la vista en el navegador
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long startTime = (long) request.getAttribute("startTime");
        LOG.info("REQUEST URL: "+ request.getRequestURL().toString()+" -- TOTAL TIME: "+ (System.currentTimeMillis() - startTime) + " ms");
    }
}
