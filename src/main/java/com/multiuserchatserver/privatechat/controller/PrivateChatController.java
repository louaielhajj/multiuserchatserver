package com.multiuserchatserver.privatechat.controller;


import com.multiuserchatserver.privatechat.entity.PrivateChat;
import com.multiuserchatserver.privatechat.exception.PrivateChatException;
import com.multiuserchatserver.privatechat.service.PrivateChatService;
import com.multiuserchatserver.user.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/privatechat")
public class PrivateChatController {


    private PrivateChatService privateChatService;
    public PrivateChatController(PrivateChatService privateChatService){
        this.privateChatService=privateChatService;
    }
    @GetMapping("/test")
    public String test(){
        return "It's working";

    }
    @GetMapping("/{sourceUserId}/{destUserId}")
    public PrivateChat getPrivateChatForUserIds(@PathVariable long sourceUserId, @PathVariable long destUserId) {
        return privateChatService.getPrivateChatFor(sourceUserId,destUserId);
    }
    @PostMapping("/{sourceUserId}/{destUserId}")
    public PrivateChat createPrivateChatForUserIds(@PathVariable long sourceUserId, @PathVariable long destUserId) throws Exception{
        try {
            return privateChatService.createPrivateChatForUsers(sourceUserId, destUserId);
        }catch(PrivateChatException e){
            throw new Exception(e.getMessage());
        }
    }

}
