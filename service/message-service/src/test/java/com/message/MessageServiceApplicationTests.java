package com.message;

import com.message.MessageServiceApplication;
import com.message.amqp.MessageSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MessageServiceApplication.class)
public class MessageServiceApplicationTests {

    @Autowired
    MessageSend messageSend;
    @Test
    public void hello() throws Exception {
        messageSend.send();
    }

}

