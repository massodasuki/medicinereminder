package com.unifreelancer.masso.medicinereminder;

import java.util.Date;

/**
 * Created by Masso on 8/14/2017.
 */

public class ChatPharmacist {
    private String messageText;
    private String messageUser;
    private long messageTime;

    public ChatPharmacist (String messageText, String messageUser)
    {
        this.messageText = messageText;
        this.messageUser = messageUser;

        messageTime = new Date().getTime();

    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
