package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.rest.api.v2010.account.Message;

@RestController
@RequestMapping("api/message")
public class Controller {

	private final Service service;

	@Autowired
	public Controller(Service service) {
		this.service = service;
	}

	@PostMapping("/sms")
	public Message sendSms(@Valid @RequestBody MessageRequest messageRequest) {
		return service.sendSms(messageRequest);
	}

	@PostMapping("/whatsapp")
	public Message sendWhatsapp(@Valid @RequestBody MessageRequest messageRequest) {
		return service.sendWhatsapp(messageRequest);
	}
}
