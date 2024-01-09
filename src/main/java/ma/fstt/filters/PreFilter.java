package ma.fstt.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreFilter extends ZuulFilter {

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
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        javax.servlet.http.HttpServletRequest request = ctx.getRequest();

        System.out.println(
                "Request Method : " + request.getMethod() + " Request URL : " + request.getRequestURL().toString());

        /*
         * Adding authorization header to zuul request header as zuul omits
         * sensitive headers
         */
        if (request.getHeader("Authorization") != null) {
            ctx.addZuulRequestHeader("Authorization", request.getHeader("Authorization"));
        }
        return null;
    }

}
