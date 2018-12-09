package com.but.simple.controller;

import com.but.simple.entity.Message;
import com.but.simple.entity.User;
import com.but.simple.repository.MessageRepository;
import com.but.simple.utils.Utils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MessageController {
    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String text,
                      @RequestParam String tag,
                      Map<String, Object> model) {
        String time = Utils.dateNow();

        Message message = new Message(text, tag, time, user);

        messageRepository.save(message);

        Iterable<Message> messages = messageRepository.findAll();

        model.put("messages", messages);

        return "main";
    }
}
