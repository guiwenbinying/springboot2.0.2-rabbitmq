package springboot_rabbitmq.demo.user;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * @Author:庄桂滨
 * @Description
 * @Date:Created in 下午 12:27 2018/6/12 0012
 * @Modified By
 */

@Component
@RabbitListener(queues = "userQueue")
public class UserReceiver {
    @RabbitHandler
    public void process(User user) {
        System.out.println("user receive  : " + user.getName()+"/"+user.getPass());
    }
}
