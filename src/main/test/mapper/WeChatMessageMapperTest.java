package mapper;

import com.imchen.Application;
import com.imchen.domain.WeChatMessage;
import com.imchen.mapper.WeChatMessageMapper;
import com.imchen.utils.WeChatUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by imch1n on 6/11/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class WeChatMessageMapperTest {

    @Autowired
    WeChatMessageMapper mapper;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        List<WeChatMessage> list=mapper.getAll();
        System.out.println(list.size());
    }

    @Test
    public void getOne() throws Exception {
        WeChatMessage message=mapper.getOne("1241241241");
        System.out.println(message.toString());
    }

    @Test
    public void insert() throws Exception {
        WeChatMessage message=new WeChatMessage();
        message.setContent("test message fasfasf");
        message.setMsgType("text");
        message.setMsgId("542352");
        message.setFromUserName("uuuu");
        message.setToUserName("imchen");
        message.setDescription("fdasfasfasf");
        message.setCreateTime(WeChatUtil.millisToDate(System.currentTimeMillis()));
        message.setArticleCount("2");
        message.setFormat("mp3");
        message.setLabel("fasfsdafw1");
        message.setLocation_X("413124.1");
        message.setLocation_Y("663453.1");
        message.setPicUrl("143safasfa");
        message.setMediaId("heragaeg");
        message.setThumbMediaId("qrwegq");
        message.setUrl("fweqgwq");
        message.setScale("12");
        message.setReplyTime(WeChatUtil.millisToDate(System.currentTimeMillis()));
        message.setRecognition("fsafafggg");
        message.setTitle("erqrwfe");
        mapper.insert(message);
    }

    @Test
    public void update() throws Exception {
        WeChatMessage message=new WeChatMessage();
        message.setContent("update test");
        message.setMsgId("1241991241");
        mapper.update(message);
    }

    @Test
    public void delete() throws Exception {
        mapper.delete("542352");
    }

}