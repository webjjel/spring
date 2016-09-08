package kr.co.saramin.security;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import kr.co.saramin.mysite.vo.UserVo;
import kr.co.saramin.security.annotation.AuthUser;

public class AuthUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer arg1, NativeWebRequest arg2,
			WebDataBinderFactory arg3) throws Exception {

		if (supportsParameter(parameter) == false) {
			return WebArgumentResolver.UNRESOLVED;
		}
		
		
		
		return null;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if (parameter.getParameterAnnotation(AuthUser.class) == null) {
			return false;
		}
		
		if (parameter.getParameterType().equals(UserVo.class) == false) {
			return false;
		}
		
		return true;
	}

}
