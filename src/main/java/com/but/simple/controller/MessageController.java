package com.but.simple.controller;

import com.but.simple.entity.Message;
import com.but.simple.entity.User;
import com.but.simple.repository.MessageRepository;
import com.but.simple.service.MessageService;
import com.but.simple.utils.Utils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        messageService.main(model);

        return "main";
    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String text,
                      @RequestParam String tag,
                      Map<String, Object> model) {
        messageService.add(user, text, tag, model);

        return "main";
    }
}
