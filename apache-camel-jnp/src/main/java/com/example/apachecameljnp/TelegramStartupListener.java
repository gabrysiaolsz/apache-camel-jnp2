package com.example.apachecameljnp;

import org.apache.camel.CamelContext;
import org.apache.camel.StartupListener;

public class TelegramStartupListener implements StartupListener {

    public TelegramStartupListener() {
        super();
    }

    @Override
    public void onCamelContextStarted(CamelContext context, boolean alreadyStarted) throws Exception {
        new SendMessageUsage().run(context);
    }
}
