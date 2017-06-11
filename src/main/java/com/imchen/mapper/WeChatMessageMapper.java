package com.imchen.mapper;

import com.imchen.domain.WeChatMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by imch1n on 6/11/17.
 */
public interface WeChatMessageMapper {
    List<WeChatMessage> getAll();
    WeChatMessage getOne(String msgId);
    void insert(WeChatMessage message);
    void update(WeChatMessage message);
    void delete(String msgId);
}
