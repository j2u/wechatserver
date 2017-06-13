package com.imchen.mapper;

import com.imchen.domain.WeChatReplyMsg;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by imchen on 2017/6/13.
 */
@Repository
public interface WeChatRPMsgMapper {
    List<WeChatReplyMsg> getAll();
    WeChatReplyMsg getByMsgId(String msgId);
    void insert(WeChatReplyMsg replyMsg);
    void update(WeChatReplyMsg id);
    void delete(String msgId);
}
