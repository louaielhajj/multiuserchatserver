package com.multiuserchatserver.message.controller;


import com.multiuserchatserver.message.entity.Message;
import com.multiuserchatserver.message.service.MessageService;
import com.multiuserchatserver.privatechat.entity.PrivateChat;
import com.multiuserchatserver.privatechat.exception.PrivateChatException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/message")
public class MessageController {
    private MessageService messageService;
    public MessageController(MessageService messageService){
        this.messageService=messageService;

    }
    @GetMapping("/test")
    public String test(){
        return "It's working";

    }
    @GetMapping("/{privateChatId}")
    public List<Message> getPrivateChatMessages(@PathVariable long privateChatId) {
        return messageService.getMessagesByPrivateChat(privateChatId);
    }
    @PostMapping("/{privateChatId}")
    public Message createPrivateChatMessage(@PathVariable long privateChatId, @RequestParam long userId,@RequestParam String message) throws Exception{
        return messageService.createMessage(privateChatId,userId,message);
    }


}
