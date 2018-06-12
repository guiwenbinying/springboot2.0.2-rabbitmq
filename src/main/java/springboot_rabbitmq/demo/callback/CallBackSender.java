package springboot_rabbitmq.demo.callback;
import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @Author:庄桂滨
 * @Description
 * @Date:Created in 下午 1:09 2018/6/12 0012
 * @Modified By
 * 用的是topic的topicMessagesReceiver
 */
@Component
public class CallBackSender implements  RabbitTemplate.ConfirmCallback {
    @Autowired
    private RabbitTemplate rabbitTemplatenew;
    public void send() {

        rabbitTemplatenew.setConfirmCallback(this);
        String msg="callbackSender : i am callback sender";
        System.out.println(msg );
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        System.out.println("callbackSender UUID: " + correlationData.getId());
        this.rabbitTemplatenew.convertAndSend("exchange", "topic.messages", msg, correlationData);
    }

    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        // TODO Auto-generated method stub
        System.out.println("callbakck confirm: " + correlationData.getId());
    }
}
