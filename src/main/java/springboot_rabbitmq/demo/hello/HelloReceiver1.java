package springboot_rabbitmq.demo.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @Author:庄桂滨
 * @Description
 * @Date:Created in 上午 10:48 2018/6/12 0012
 * @Modified By
 * 消费者
 */

@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver1 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }
}
