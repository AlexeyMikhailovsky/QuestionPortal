package by.htp.main.QuestionPortal.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalExceptionHandler extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView doResolveException(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/customer/error" );
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
}
