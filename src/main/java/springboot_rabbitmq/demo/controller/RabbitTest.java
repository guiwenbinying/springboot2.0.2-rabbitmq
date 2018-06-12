package springboot_rabbitmq.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_rabbitmq.demo.callback.CallBackSender;
import springboot_rabbitmq.demo.fanout.FanoutSender;
import springboot_rabbitmq.demo.hello.HelloSender1;
import springboot_rabbitmq.demo.hello.HelloSender2;
import springboot_rabbitmq.demo.topic.TopicSender;
import springboot_rabbitmq.demo.user.UserSender;

/**
 * @Author:庄桂滨
 * @Description
 * @Date:Created in 上午 10:50 2018/6/12 0012
 * @Modified By
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {
    @Autowired
    private HelloSender1 helloSender1;

    @Autowired
    private HelloSender2 helloSender2;

    @Autowired
    private UserSender userSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private CallBackSender callBackSender;

    //单生产者单消费者
    @PostMapping("/hello")
    public void hello(){
        helloSender1.send();
    }

    //单生产者多消费者
    @PostMapping("/oneToMany")
    public void oneToMany(){
        for (int i =0;i<10;i++){
            helloSender1.send("hellomsg:"+i);
        }
    }
    /**
     * 多生产者-多消费者
     */
    @PostMapping("/manyToMany")
    public void manyToMany() {
        for(int i=0;i<10;i++){
            helloSender1.send("hellomsg:"+i);
            helloSender2.send("hellomsg:"+i);
        }

    }

    /**
     * 实体类传输测试
     */
    @PostMapping("/userTest")
    public void userTest() {
        userSender.send();
    }

    /**
     * topic exchange类型rabbitmq测试
     */
    @PostMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }

    /**
     * fanout exchange类型rabbitmq测试
     */
    @PostMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }

    @PostMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }
}
