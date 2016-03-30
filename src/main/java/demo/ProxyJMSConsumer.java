package demo;

import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.*;

/**
 * JMS消费者
 * Created by jiangjunguo on 3/29/16.
 */
public class ProxyJMSConsumer {

    public ProxyJMSConsumer(){ }

    private ConnectionFactory connectionFactory;
    private ActiveMQTopic activeMQTopic;


    private Connection connection;
    private Session session;
    private MessageConsumer consumer;

    private void init() throws JMSException {
        connection = this.connectionFactory.createConnection();
        connection.start();

        session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

        consumer = this.session.createConsumer(this.activeMQTopic);
    }

    public void receive() throws JMSException {

        this.init();

        while (true){
            TextMessage message = (TextMessage) consumer.receive(100000);

            if(null != message){
                System.out.println(message.getText());
            }else{
                break;
            }

        }
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }

    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public ActiveMQTopic getActiveMQTopic() {
        return activeMQTopic;
    }

    public void setActiveMQTopic(ActiveMQTopic activeMQTopic) {
        this.activeMQTopic = activeMQTopic;
    }
}
