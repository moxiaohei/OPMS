/**
 * 
 */
package com.opms.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ZhiWeiChang
 * 异常处理
 *
 */
@Controller
public class MyException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object arg2,
			Exception ex) {
		 if(ex instanceof AuthorizationException){ 
	            return new ModelAndView("500");  
	        }
		return null;
	}
	
}
