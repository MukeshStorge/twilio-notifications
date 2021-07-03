package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
@org.springframework.stereotype.Service
public class Service {

    private final Channel channel;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.channel = smsSender;
    }

    public void sendSms(MessageRequest messageRequest) {
    	channel.sendSms(messageRequest);
    }

	public void sendWhatsapp(@Valid MessageRequest messageRequest) {
		channel.sendWhatsapp(messageRequest);
	}
}
