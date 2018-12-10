package com.but.simple.service;

import com.but.simple.entity.Message;
import com.but.simple.entity.User;
import com.but.simple.repository.MessageRepository;
import com.but.simple.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void add(User user, String text, String tag, Map<String, Object> model) {
        String time = Utils.dateNow();

        Message message = new Message(text, tag, time, user);
        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();

        model.put("messages", messages);
    }

    public void main(Map<String, Object> model){
        Iterable<Message> messages = messageRepository.findAll();

        model.put("messages", messages);
    }
}
