package com.joyscrum.filters;


import com.joyscrum.GetSystemConfiguration;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Created by Jorge Mota
 * on 4/1/17.
 */
@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(final ContainerRequestContext requestContext,
                       final ContainerResponseContext cres) throws IOException {
        if (GetSystemConfiguration.getValue().isCORSAllowed()) {
            String origin = requestContext.getHeaderString("Origin");

            if (origin == null) {
                origin = requestContext.getHeaderString("origin");
                if (origin == null) {
                    origin = "*";
                }
            }
            cres.getHeaders().add("Access-Control-Allow-Origin", origin);
            cres.getHeaders().add("Access-Control-Allow-Headers", " origin, content-type, accept, Origin, X-Requested-With, Content-Type, Accept, Authorization");
            cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
            cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            cres.getHeaders().add("Access-Control-Max-Age", "1209600");
            cres.getHeaders().add("Access-Control-Expose-Headers", "accept, Origin, X-Requested-With, Content-Type, Accept, jwt,Authorization");

        }
    }

}