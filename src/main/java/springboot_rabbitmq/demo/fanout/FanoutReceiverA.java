package springboot_rabbitmq.demo.fanout;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * @Author:庄桂滨
 * @Description
 * @Date:Created in 下午 1:00 2018/6/12 0012
 * @Modified By
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverA  : " + msg);
    }

}
