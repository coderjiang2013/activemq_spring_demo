package demo;

import org.apache.activemq.command.*;

import javax.jms.*;

/**
 * JMS消费者
 * Created by jiangjunguo on 3/29/16.
 */
public class ProxyJMSProducer {

    public ProxyJMSProducer(){ }

    private ConnectionFactory connectionFactory;
    private ActiveMQTopic activeMQTopic;


    private Connection connection;
    private Session session;
    private MessageProducer producer;
    private TextMessage message;

    private void init() throws JMSException {
        connection = this.connectionFactory.createConnection();
        connection.start();

        session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);

        this.producer = this.session.createProducer(this.activeMQTopic);
    }

    public void send(String msg) throws JMSException {

        this.init();

        this.message = session.createTextMessage(msg);

        this.producer.send(this.message);

        this.session.close();

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
