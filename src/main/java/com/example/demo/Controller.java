package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/message")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping("/sms")
    public void sendSms(@Valid @RequestBody MessageRequest messageRequest) {
        service.sendSms(messageRequest);
    }
    
    @PostMapping("/whatsapp")
    public void sendWhatsapp(@Valid @RequestBody MessageRequest messageRequest) {
        service.sendWhatsapp(messageRequest);
    }
}
