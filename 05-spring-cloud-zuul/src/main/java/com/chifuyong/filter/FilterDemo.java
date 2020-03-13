package com.chifuyong.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: chify
 * @Date: 07/03/2020 09:01
 * @Description: 服务过滤
 */
@Component
public class FilterDemo extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(FilterDemo.class);

    /*
    * 返回过滤器的类型。有pre、route、post、error等几种取值，分别对应上文的几种过滤器。
    * pre：路由之前
    * routing：路由之时
    * post： 路由之后
    * error：发送错误调用
    * */
    @Override
    public String filterType() {
        return "pre";
    }

    /*
    * 返回一个int值来指定过滤器的执行顺序，不同的过滤器允许返回相同的数字。
    * */
    @Override
    public int filterOrder() {
        return 0;
    }

    /*
    * 返回一个boolean值来判断该过滤器是否要执行，true表示执行，false表示不执行。
    * */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        String strUrl = request.getRequestURL().toString();
        if(strUrl.contains("hello1")) {
            log.warn("RequestUrl contatins hello1");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("RequestUrl contatins hello1");
            }catch (Exception e){}

            return null;
        }
        log.info("RequestUrl not contatins hello1");
        return null;
    }
}
