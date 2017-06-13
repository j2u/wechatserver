package com.imchen.mapper;

import com.imchen.domain.WeChatMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by imch1n on 6/11/17.
 */
@Repository
public interface WeChatMessageMapper {
    List<WeChatMessage> getAll();
    WeChatMessage getOne(String msgId);
    void insert(WeChatMessage message);
    void update(WeChatMessage message);
    void delete(String msgId);
}
