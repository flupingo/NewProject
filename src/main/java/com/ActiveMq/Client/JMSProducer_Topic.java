package com.ActiveMq.Client;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created：Jeffrey
 * date   ：2020/8/2 21:25
 */
public class JMSProducer_Topic {
    private static final String ACTIVEMQ_URL = "tcp://192.168.0.104:61616";
    private static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) {
        try {
            //1.创建连接工厂
            ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
            //2.获得连接，启动访问
            Connection connection = activeMQConnectionFactory.createConnection();
            connection.start();
            //3.创建会话session :事务和签收
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //4.创建目的地-->Topic
            Topic topic = session.createTopic(TOPIC_NAME);
            //5.创建消息生产者
            MessageProducer messageProducer = session.createProducer(topic);
            //6.通过使用messageProducer生产3条消息发送到MQ队列
            for (int i = 0; i < 3; i++) {
                //7.创建消息
                TextMessage textMessage = session.createTextMessage("TopicMessage===" + i);
                //8.通过messageProducer发送给MQ
                messageProducer.send(textMessage);
            }
            //9.关闭资源
            messageProducer.close();
            session.close();
            connection.close();
            System.out.println("====消息发布完成====");
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }

}
