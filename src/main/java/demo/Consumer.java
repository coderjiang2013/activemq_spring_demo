package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by jiangjunguo on 16-3-30.
 */
public class Consumer {
    public Consumer(){   }

    private JmsTemplate jmsTemplate;
    private Destination destination;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Destination getDestination() {
        return destination;
    }

    public void receive() throws JMSException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("activemq-config.xml");
        while(true){
            TextMessage message = (TextMessage) this.jmsTemplate.receive(destination);
            if(null != message){
                System.out.println("Receive:" + message.getText());
            }else{
                break;
            }
        }

    }

}
