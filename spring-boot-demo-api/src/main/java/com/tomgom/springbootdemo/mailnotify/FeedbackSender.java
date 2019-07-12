package com.tomgom.springbootdemo.mailnotify;

public interface FeedbackSender {
    void sendFeedback(String from, String name, String feedback);
}
