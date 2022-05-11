package com.ActiveMq.Client;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created：Jeffrey
 * date   ：2020/8/2 14:01
 */
public class JMSConsumer {
    private static final String ACTIVEMQ_URL = "tcp://192.168.0.104:61616";
    private static final String QUEUE = "queue01";

    public static void main(String[] args) {
        try {
            //1.创建连接工厂
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
            //2.获得连接，启动访问
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            //3.创建会话Session (ActiveMQSession) :事务和签收
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //4.Session创建Destination目的地-->Queue
            Queue queue = session.createQueue(QUEUE);
            //5.Session创建消费者，queue存在ConsumerInfo里
            MessageConsumer messageConsumer = session.createConsumer(queue);
            while (true) {
                //消费者接收Message,进行消费
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if (null != textMessage) {
                    System.out.println("===消费者接收到消息===" + textMessage.getText());
                } else {
                    break;
                }
            }
            //6.关闭资源
            messageConsumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


}
