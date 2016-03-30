package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.JMSException;

/**
 * Created by jiangjunguo on 3/29/16.
 */
public class StartupReceiver {

    public static void main(String[] args) throws JMSException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:activemq-config.xml");

        ProxyJMSConsumer consumer = (ProxyJMSConsumer) ctx.getBean("proxyJMSConsumer");

        consumer.receive();

    }

}
