package com.example.demo;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class TwilioSmsSender implements Channel {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendSms(MessageRequest messageRequest) {
        if (isPhoneNumberValid(messageRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(messageRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = messageRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms {}", messageRequest);
        } else {
            throw new IllegalArgumentException(
                    "Phone number [" + messageRequest.getPhoneNumber() + "] is not a valid number"
            );
        }
    }

    @Override
	public void sendWhatsapp(@Valid MessageRequest messageRequest) {
    	  Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());
          Message message = Message.creator(
                  new com.twilio.type.PhoneNumber("whatsapp:"+messageRequest.getPhoneNumber()),
                  new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                  "Hello there!")
              .create();

          System.out.println(message.getSid());
	}
    
    private boolean isPhoneNumberValid(String phoneNumber) {
        return true;
    }

	
}
