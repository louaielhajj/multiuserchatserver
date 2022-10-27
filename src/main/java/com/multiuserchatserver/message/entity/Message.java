package com.multiuserchatserver.message.entity;

import com.multiuserchatserver.user.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import com.multiuserchatserver.privatechat.entity.PrivateChat;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime timestamp;
    private String content;
    @ManyToOne
    @JoinColumn(name = "private_chat_id")
    private PrivateChat chat;

    @ManyToOne
    @JoinColumn(name = "owner_user_id")
    private User ownerUser;

    public PrivateChat getChat() {
        return chat;
    }

    public void setChat(PrivateChat chat) {
        this.chat = chat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(User ownerUser) {
        this.ownerUser = ownerUser;
    }
}
