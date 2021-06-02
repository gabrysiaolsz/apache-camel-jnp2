package com.example.apachecameljnp;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.telegram.model.MessageResult;
import org.apache.camel.component.telegram.model.OutgoingTextMessage;

public class SendMessageUsage implements TelegramMethodUsage {
    private String msg;
    public SendMessageUsage() {
        msg = "Bot uruchomiony";
    }

    CamelContext c;

    public void setMsg(String msg) {
        this.msg = msg;
        if(c != null) {
            run(c);
        }
    }



    @Override
    public void run(CamelContext context) {
        c = context;
        ProducerTemplate template = context.createProducerTemplate();
        OutgoingTextMessage outMsg = new OutgoingTextMessage();
        outMsg.setText(msg);
        MessageResult msgResult = template.requestBody("direct:start", outMsg, MessageResult.class);
        System.out.println(msgResult);
    }
}
