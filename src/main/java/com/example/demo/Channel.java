package com.example.demo;

import javax.validation.Valid;

import com.twilio.rest.api.v2010.account.Message;

public interface Channel {

	Message sendSms(@Valid MessageRequest messageRequest);

	Message sendWhatsapp(@Valid MessageRequest messageRequest);

}
