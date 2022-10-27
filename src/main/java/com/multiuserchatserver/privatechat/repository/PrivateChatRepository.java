package com.multiuserchatserver.privatechat.repository;

import com.multiuserchatserver.privatechat.entity.PrivateChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PrivateChatRepository extends JpaRepository<PrivateChat,Long> {
    @Query("Select  pc from PrivateChat pc where sourceUser.id in (:ids) and destUser.id in (:ids)")
    public Optional <PrivateChat> getChat(@Param("ids")List<Long> ids);
}
