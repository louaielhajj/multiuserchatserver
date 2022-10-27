package com.multiuserchatserver.privatechat.entity;


import com.multiuserchatserver.user.entity.User;

import javax.persistence.*;

@Entity
public class PrivateChat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "source_user_id")
    private User sourceUser;
    @ManyToOne
    @JoinColumn(name = "dest_user_id")
    private User destUser;

    public User getDestUser() {
        return destUser;
    }

    public void setDestUser(User destUser) {
        this.destUser = destUser;
    }

    public User getSourceUser() {
        return sourceUser;
    }

    public void setSourceUser(User sourceUser) {
        this.sourceUser = sourceUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
