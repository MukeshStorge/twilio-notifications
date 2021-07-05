package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.twilio.rest.api.v2010.account.Message;
@org.springframework.stereotype.Service
public class Service {

    private final Channel channel;

    @Autowired
    public Service(@Qualifier("twilio") TwilioMessageSender smsSender) {
        this.channel = smsSender;
    }

    public Message sendSms(MessageRequest messageRequest) {
    	return channel.sendSms(messageRequest);
    }

	public Message sendWhatsapp(@Valid MessageRequest messageRequest) {
		return channel.sendWhatsapp(messageRequest);
	}
}
