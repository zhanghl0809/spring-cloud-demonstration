package com.ybwx.manager.admin.security;

import com.ybwx.common.enums.ResultStatusEnum;
import com.ybwx.common.util.json.JSONSnakeUtils;
import com.ybwx.common.util.vo.ResultVO;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 匿名访问走这个
 */
@Component
public class UrlAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(200);
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(JSONSnakeUtils.writeValue(new ResultVO(ResultStatusEnum.NOT_LOGGED_IN)));
    }
}
