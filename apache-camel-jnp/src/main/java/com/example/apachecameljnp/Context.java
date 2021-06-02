package com.example.apachecameljnp;

import org.apache.camel.CamelContext;
import org.apache.camel.StartupListener;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Context {
    public CamelContext context;

    public Context() {
        context = new DefaultCamelContext();
        context.start();
    }

    public void addRoutes(RouteBuilder rb) throws Exception {
        context.addRoutes(rb);
    }

    public void addStartupListener(StartupListener sl) throws Exception {
        context.addStartupListener(sl);
    }
}
