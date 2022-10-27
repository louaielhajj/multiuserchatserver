package com.multiuserchatserver.message.repository;

import com.multiuserchatserver.message.entity.Message;
import com.multiuserchatserver.privatechat.entity.PrivateChat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {
    public List<Message> findByChat(PrivateChat privateChat);
}
