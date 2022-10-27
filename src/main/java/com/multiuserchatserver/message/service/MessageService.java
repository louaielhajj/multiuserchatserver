package com.multiuserchatserver.message.service;


import com.multiuserchatserver.message.entity.Message;
import com.multiuserchatserver.message.repository.MessageRepository;
import com.multiuserchatserver.privatechat.entity.PrivateChat;
import com.multiuserchatserver.privatechat.service.PrivateChatService;
import com.multiuserchatserver.user.entity.User;
import com.multiuserchatserver.user.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;
    private PrivateChatService privateChatService;
    private UserService userService;
    public MessageService (MessageRepository messageRepository, PrivateChatService privateChatService, UserService userService){
        this.messageRepository=messageRepository;
        this.privateChatService=privateChatService;
        this.userService=userService;
    }
    public List<Message> getMessagesByPrivateChat(long privateChatId){
        PrivateChat privatechat=privateChatService.getPrivateChatById(privateChatId);
        return messageRepository.findByChat(privatechat);
    }
    public Message createMessage(long privateChatId, long ownerUserId, String message){
        PrivateChat privatechat=privateChatService.getPrivateChatById(privateChatId);
        User ownerUser=userService.getUserbyId(ownerUserId);
        if(ownerUser==null || privatechat==null){
            //todo throw exception
        }
        Message m=new Message();
        m.setTimestamp(LocalDateTime.now());
        m.setChat(privatechat);
        m.setOwnerUser(ownerUser);
        m.setContent(message);
        return messageRepository.save(m);
    }
}
