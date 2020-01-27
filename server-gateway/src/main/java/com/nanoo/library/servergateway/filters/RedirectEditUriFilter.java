package com.nanoo.library.servergateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

/**
 * @author nanoo
 * @create 25/01/2020 - 14:29
 */
public class RedirectEditUriFilter implements GatewayFilter, Ordered {
    
    private Logger log = LoggerFactory.getLogger(RedirectEditUriFilter.class);
    
    /**
     * Get the order value of this object.
     * <p>Higher values are interpreted as lower priority. As a consequence,
     * the object with the lowest value has the highest priority (somewhat
     * analogous to Servlet {@code load-on-startup} values).
     * <p>Same order values will result in arbitrary sort positions for the
     * affected objects.
     *
     * @return the order value
     *
     * @see #HIGHEST_PRECEDENCE
     * @see #LOWEST_PRECEDENCE
     */
    @Override
    public int getOrder() {
        return 0;
    }
    
    /**
     * Process the Web request and (optionally) delegate to the next {@code WebFilter}
     * through the given {@link GatewayFilterChain}.
     *
     * @param exchange the current server exchange
     * @param chain    provides a way to delegate to the next filter
     * @return {@code Mono<Void>} to indicate when request processing is complete
     */
    @Override     // TODO
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        try {
            
            String target = exchange.getRequest().getURI().toString();
            StringBuilder redirection = new StringBuilder("/ms-consistency-manager");
            
            String[] targetPieces = target.split("/");
            if (targetPieces[1].equalsIgnoreCase("edit")){
                if(targetPieces[2].equalsIgnoreCase("account")){
                    for (int i=1,j=targetPieces.length ; i<j ; i++){
                        redirection.append("/").append(targetPieces[i]);
                    }
                    exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, new URI(redirection.toString()));
                }else {
                    return Mono.empty(); // TODO add other redirection
                }
            }else{
                return Mono.empty();
            }
            
        } catch (Exception e) {
           log.error(e.getMessage());
        }
        return chain.filter(exchange);
    }
    
}
