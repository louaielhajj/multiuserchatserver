package com.multiuserchatserver.privatechat.service;


import com.multiuserchatserver.privatechat.entity.PrivateChat;
import com.multiuserchatserver.privatechat.exception.PrivateChatException;
import com.multiuserchatserver.privatechat.repository.PrivateChatRepository;
import com.multiuserchatserver.user.entity.User;
import com.multiuserchatserver.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class PrivateChatService {

    private PrivateChatRepository privateChatRepository;
    private UserService userService;
    public PrivateChatService (PrivateChatRepository privateChatRepository, UserService userService){
        this.privateChatRepository=privateChatRepository;
        this.userService=userService;
    }

    public PrivateChat getPrivateChatFor(long sourceUserId,long destUserId){
        Optional<PrivateChat> o= privateChatRepository.getChat(Arrays.asList(sourceUserId,destUserId));
        if(o.isEmpty())return null;
        return o.get();
    }
    public PrivateChat getPrivateChatById(long privateChatId){
        Optional<PrivateChat> o= privateChatRepository.findById(privateChatId);
        if(o.isEmpty())return null;
        return o.get();
    }
    public PrivateChat createPrivateChatForUsers(long sourceUserId, long destUserId)throws PrivateChatException{
        PrivateChat pc=new PrivateChat();
        User sourceUser=userService.getUserbyId(sourceUserId);
        User destUser=userService.getUserbyId(destUserId);
        if(sourceUser==null || destUser==null){
            throw new PrivateChatException("Missing Users");
        }
        pc.setDestUser(destUser);
        pc.setSourceUser(sourceUser);
        return privateChatRepository.save(pc);
    }

}
