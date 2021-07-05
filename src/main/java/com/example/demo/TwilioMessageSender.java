package com.example.demo;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service("twilio")
public class TwilioMessageSender implements Channel {

	private static final Logger LOGGER = LoggerFactory.getLogger(TwilioMessageSender.class);

	private final TwilioConfiguration twilioConfiguration;

	@Autowired
	public TwilioMessageSender(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
	}

	@Override
	public Message sendSms(MessageRequest messageRequest) {
		Message message = Message.creator(new PhoneNumber(messageRequest.getPhoneNumber()),
				new PhoneNumber(twilioConfiguration.getTrialNumber()), messageRequest.getMessage()).create();
		LOGGER.info("Send sms {}", messageRequest, message.getStatus());
		return message;
	}

	@Override
	public Message sendWhatsapp(@Valid MessageRequest messageRequest) {
		Message message = Message
				.creator(new com.twilio.type.PhoneNumber("whatsapp:" + messageRequest.getPhoneNumber()),
						new com.twilio.type.PhoneNumber("whatsapp:" + twilioConfiguration.getTrialNumber()),
						messageRequest.getMessage())
				.create();
		LOGGER.info("Send whatsapp {}", messageRequest, message.getStatus());
		return message;
	}

}
