package com.lmlx.app.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.lmlx.app.constant.Constant;
import com.lmlx.app.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author jiahao jin
 * @create 2020-12-30 10:57
 */

@Slf4j
public class CheckLoginOutInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception {
        //检查签名
		if(!validCheck(req, obj)){
			return false;
		}
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object handler, Exception arg3)
            throws Exception {

    }

	private boolean validCheck(HttpServletRequest request, Object handler) throws Exception {
		if (needCheck(handler)) {
            String token = request.getHeader("Authorization");
            System.out.println(JwtUtil.isOverdue(token));
            if(JwtUtil.isOverdue(token)) {
                throw new RuntimeException(Constant.ERROR.ERROR_00100003);
            }
//
		}
		return true;
	}

    private boolean needCheck(Object handler){
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            CheckLoginOut checkLoginOut = method.getAnnotation(CheckLoginOut.class);
            if(null != checkLoginOut){
                return checkLoginOut.value();
            }
        }
        return false;
    }

}