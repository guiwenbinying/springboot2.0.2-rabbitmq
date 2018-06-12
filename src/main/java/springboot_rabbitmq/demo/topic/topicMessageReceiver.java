package springboot_rabbitmq.demo.topic;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @Author:庄桂滨
 * @Description
 * @Date:Created in 下午 12:52 2018/6/12 0012
 * @Modified By
 */
@Component
@RabbitListener(queues = "topic.message")
public class topicMessageReceiver {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessageReceiver  : " +msg);
    }
}
