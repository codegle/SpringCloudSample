package com.example.zuulgateway.filter;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AuthenticationFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String user = request.getParameter("user");
        if (!"admin".equals(user)) {
            requestContext.setResponseBody("Unauthorized");
            requestContext.setSendZuulResponse(false);
        }
        return null;
    }
}
