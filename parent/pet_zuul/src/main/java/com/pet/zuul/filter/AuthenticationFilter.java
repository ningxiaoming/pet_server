package com.pet.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
//import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 统一鉴权拦截器
 */
@Component
public class AuthenticationFilter extends ZuulFilter {
//
//    @Autowired
//    public RedisUtil redisUtil;

//    @Value("${jwt.secret}")
//    private String secret;

    /**
     * 为了不和数镜冲突，先列出需要过滤的服务
     */
    /*private static final Set<String> FILTER_PATHS = new HashSet<>(Arrays.asList(
            "/auth"
    ));*/

    /**
     * 放行的url
     */
/*    private static final Set<String> ALLOWED_PATHS = new HashSet<>(Arrays.asList(
            "/eo/v2/api-docs",
            "/user/v2/api-docs",
            "/oss/v2/api-docs",
            "/auth/v2/api-docs",
            "/qrcode",
            "/auth/user/login",

            "/user/user/dataCode",
            "/user/user/reg",
            "/user/user/loginByPhone",
            "/user/user/login",
            "/user/user/code1",
            "/user/user/code",
            "/user/user/isCode",
            "/user/user/backPassword",
            "/user/user/findName",
            "/user/user/addExperienceUser",

            "/user/wechat/wechatReg",
            "/user/wechat/wechatLogin",
            "/user/wechat/callBackLogin",
            "/user/wechat/bindWeChat",
            "/user/integral/bindWeChat",
            "/user/integral/follow"
    ));
 */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        if (!ctx.sendZuulResponse()) {
            return false;
        }
        // Boolean isFilter = false;
        Boolean isAllowed = true;
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
//        String requestPath = request.getRequestURI();
        String requestUrl = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        /*for (String filterPath : FILTER_PATHS) {
            if (requestUrl.startsWith(filterPath)) {
                isFilter = true;
            }
        }*/
//        if (null!=token){
//            isAllowed = false;
//            return isAllowed;
//        }
//        for (String allowedPath : ALLOWED_PATHS) {
//            if (requestUrl.startsWith(allowedPath)) {
//                isAllowed = false;
//            }
//        }
        return isAllowed;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletResponse response = ctx.getResponse();
//        HttpServletRequest request = ctx.getRequest();
//        String token = request.getHeader("token");
//        if (StringUtils.isEmpty(token)) {
//            token = request.getParameter("token");
//        }
//        // 验证token
//        if (StringUtils.isEmpty(token) || !JwtUtil.verify(token, secret)) {
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            ctx.setSendZuulResponse(false);
//            return response;
//        }
//        //验证重复登陆
//        String userId = JwtUtil.getUserId(token);
//        String sessionIdC = JwtUtil.getJti(token);
//        String sessionIdS = (String) redisUtil.get(JwtUtil.REDIS_PREFIX + userId);
//        if (!sessionIdC.equals(sessionIdS)) {
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            ctx.setSendZuulResponse(false);
//            return response;
//        }
//        String refreshToken = JwtUtil.refresh(token, secret);
        response.setHeader("Access-Control-Expose-Headers", "token");
        response.setHeader("token", "123");

        return null;
    }
}
