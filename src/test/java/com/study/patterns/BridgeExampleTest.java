package com.study.patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BridgeExampleTest {

    @Test
    void combinesNotificationAndSenderIndependently() {
        BridgeExample.Notification email =
                new BridgeExample.EmailNotification(new BridgeExample.EmailSender());
        BridgeExample.Notification sms =
                new BridgeExample.SmsNotification(new BridgeExample.SmsSender());

        assertEquals("email:[hello]", email.notify("hello"));
        assertEquals("sms:HELLO", sms.notify("hello"));
    }
}
