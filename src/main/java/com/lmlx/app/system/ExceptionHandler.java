package com.lmlx.app.system;

import com.lmlx.app.model.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jiahao jin
 * @create 2020-12-29 10:01
 */
@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AjaxResult doException(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        request.setAttribute("ex", e);
        e.printStackTrace();
        return AjaxResult.markError(e.getMessage());
    }
}
