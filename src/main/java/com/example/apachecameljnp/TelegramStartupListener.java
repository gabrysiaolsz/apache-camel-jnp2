package com.example.apachecameljnp;

import org.apache.camel.CamelContext;
import org.apache.camel.StartupListener;

public class TelegramStartupListener implements StartupListener {

    SendMessageUsage messageUsage;

    public TelegramStartupListener() {
        super();
        messageUsage = new SendMessageUsage();
    }

    public void setMessage(String message) {
        messageUsage.setMsg(message);
    }

    @Override
    public void onCamelContextStarted(CamelContext context, boolean alreadyStarted) throws Exception {
        messageUsage.run(context);
    }
}
