package com.ejemplo.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Esta Clase captura el tiempo de las peticiones
 * desde que entra a la request o se hace una apeticion, hasta que devolvemos una respuesta
 *
 */

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

    //Obtenemos el tiempo  inicial
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        request.setAttribute("inicio", System.currentTimeMillis());

        return true;
    }

    //hacemos la resta para tener el tiempo total
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,  Exception ex) throws Exception{

        long inicio = (long) request.getAttribute("inicio");

        LOG.info(" ** Request URL: "+ request.getRequestURL().toString() + " Tiempo total: "+ (System.currentTimeMillis() - inicio) + " ms");

    }




}
