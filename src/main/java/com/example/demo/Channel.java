package com.example.demo;

import javax.validation.Valid;

public interface Channel {

    void sendSms(MessageRequest messageRequest);

	void sendWhatsapp(@Valid MessageRequest messageRequest);

    // or maybe void sendSms(String phoneNumber, String message);
}
