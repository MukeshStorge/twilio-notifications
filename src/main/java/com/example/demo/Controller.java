package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/sms")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping
    public void sendSms(@Valid @RequestBody MessageRequest messageRequest) {
        service.sendSms(messageRequest);
    }
    @PostMapping
    
    public void sendWhatsapp(@Valid @RequestBody MessageRequest messageRequest) {
        service.sendWhatsapp(messageRequest);
    }
}
