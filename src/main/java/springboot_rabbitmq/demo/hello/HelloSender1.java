package springboot_rabbitmq.demo.hello;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author:庄桂滨
 * @Description:最简单的hello生产和消费实现（单生产者和单消费者）
 * @Date:Created in 上午 10:43 2018/6/12 0012
 * 生产者
 * @Modified By
 */
@Component
public class HelloSender1 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    //单生产者单消费者
    public void send() {
        String sendMsg = "hello1 " + new Date();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }
    //单生产者多消费者
    public void send(String msg){
        String sendMsg = msg + new Date();
        System.out.println("sender1:"+sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue",sendMsg);
    }


}
