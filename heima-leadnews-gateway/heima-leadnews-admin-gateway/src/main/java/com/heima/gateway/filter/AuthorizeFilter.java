package com.heima.gateway.filter;

import com.heima.gateway.util.AppJwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AuthorizeFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取request和response对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //2.判断是否是登录
        if(request.getURI().getPath().contains("/login")){
            //放行
            return chain.filter(exchange);
        }

        //3.获取token
        String token = request.getHeaders().getFirst("token");

        //4.判断token是否存在
        if(StringUtils.isBlank(token)){
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //5.判断token是否有效
        try {
            Claims claimsBody = AppJwtUtil.getClaimsBody(token);
            //是否是过期
            int result = AppJwtUtil.verifyToken(claimsBody);
            if(result == 1 || result  == 2){
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }

            //----------从token中获取用户信息
            Object userId = claimsBody.get("id");

            //存储header中
            ServerHttpRequest serverHttpRequest = request.mutate().headers(httpHeaders -> {
                httpHeaders.add("userId", userId + "");
            }).build();
            //重置请求
            exchange.mutate().request(serverHttpRequest);

            //----------

        } catch (Exception e) {
            e.printStackTrace();
        }

        //6.放行
        return chain.filter(exchange);
    }

    /**
     * 优先级设置  值越小  优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }

//    /**
//     * 过滤器执行的逻辑
//     *
//     * @param exchange
//     * @param chain
//     * @return
//     */
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        // 获取请求对象和响应对象
//        ServerHttpRequest request = exchange.getRequest();
//        ServerHttpResponse response = exchange.getResponse();
//        // 获取请求地址
//        String path = request.getURI().getPath();
//        // 判断请求地址是否需要鉴权,判断地址中是否包含 login
//        if (path.contains("login")) {
//            // 包含login直接放行
//            return chain.filter(exchange);
//        }
//        // 不包含的话需要判断请求头中是否有token
//        String token = request.getHeaders().getFirst("token");
//        // 没有token返回401未授权
//        if (StringUtils.isEmpty(token)) {
//            response.setStatusCode(HttpStatus.UNAUTHORIZED);
//            return response.setComplete();
//        }
//        // 有token,需要判断token是否有效
//        try {
//            Claims claimsBody = AppJwtUtil.getClaimsBody(token);
//            // token有效,解析token,将用户信息保存到请求头中,转发给后端的微服务
//            int result = AppJwtUtil.verifyToken(claimsBody);
//            if (result == 0 || result == -1) {
//                Object userId = claimsBody.get("userId");
//                // 修改请求头
//                request.mutate().header("userId", userId.toString());
//                return chain.filter(exchange);
//            }
//        } catch (Exception e) {
//            // 记录异常日志
//            log.error(e.getMessage());
//            e.printStackTrace();
//        }
//
//        response.setStatusCode(HttpStatus.UNAUTHORIZED);
//        return response.setComplete();
//    }
//
//    /**
//     * 过滤器执行的顺序,数值越小,优先级越高
//     *
//     * @return
//     */
//    @Override
//    public int getOrder() {
//        return 0;
//    }
}
