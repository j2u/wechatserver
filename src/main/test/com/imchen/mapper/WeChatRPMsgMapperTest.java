package com.imchen.mapper;

import com.imchen.Application;
import com.imchen.domain.WeChatReplyMsg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by imchen on 2017/6/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class WeChatRPMsgMapperTest {

    @Autowired
    WeChatRPMsgMapper mapper;

    @Test
    public void getAll() throws Exception {
        List<WeChatReplyMsg> list=mapper.getAll();
        System.out.println("lsit size:"+list.size());
    }

    @Test
    public void getByMsgId() throws Exception {
        WeChatReplyMsg msg = mapper.getByMsgId("fasjfjasg");
        System.out.println(msg.toString());
    }

    @Test
    public void insert() throws Exception {
        WeChatReplyMsg msg = new WeChatReplyMsg();
        msg.setContent("test");
        msg.setDescription("afdlsaf激發經濟結構");
        msg.setHqMusicUrl("fasfadfqqrwweqr");
        msg.setMediaId("asjflasjfsadf");
        msg.setRecMsgId("fadsfeeeee");
        msg.setMsgId("test2");
        msg.setMsgType("text");
        msg.setTitle("title");
        msg.setThumbMediaId("thhfhhf");
        msg.setReplyUid("uiuiuiui");
        msg.setMusicUrl("124312424214");
        mapper.insert(msg);
    }

    @Test
    public void update() throws Exception {
        WeChatReplyMsg msg = new WeChatReplyMsg();
        msg.setId(4);
        msg.setContent("testupdate");
        msg.setDescription("afdlsaf激發經濟結構");
        msg.setHqMusicUrl("fasfadfqqrwweqr");
        msg.setMediaId("asjflasjfsadf");
        msg.setRecMsgId("fadsfeeeee");
        msg.setMsgId("fasjfjasg");
        msg.setMsgType("textuuuuddd");
        msg.setTitle("title");
        msg.setThumbMediaId("thhfhhf");
        msg.setReplyUid("uiuiuiui");
        msg.setMusicUrl("124312424214");
        mapper.update(msg);
    }

    @Test
    public void delete() throws Exception {
        mapper.delete("test1");
    }

}