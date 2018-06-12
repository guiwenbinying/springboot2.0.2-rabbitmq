package springboot_rabbitmq.demo.user;

import java.io.Serializable;

/**
 * @Author:庄桂滨
 * @Description
 * @Date:Created in 下午 12:24 2018/6/12 0012
 * @Modified By
 * springboot完美的支持对象的发送和接收，不需要格外的配置。

实体类（必须实现序列化接口）：
 */
public class User implements Serializable{
    private String name;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
