package com.github.murilorpaula.infrastructure;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
@ApplicationScoped
@Produces(MediaType.TEXT_PLAIN)
public class GreetingResource {
    @GET
    public String hello() {
        return "Hello";
    }
}
