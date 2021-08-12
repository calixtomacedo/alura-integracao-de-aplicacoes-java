package br.com.cmdev.jms.topics;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.InitialContext;

import org.apache.activemq.ActiveMQConnectionFactory;

import br.com.cmdev.jms.model.Pedido;

public class TopicJMSConsumerComercial {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		InitialContext context = new InitialContext();
		//ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		//System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		
		ActiveMQConnectionFactory factory = (ActiveMQConnectionFactory) context.lookup("ConnectionFactory");
		factory.setTrustAllPackages(true);

		Connection connection = factory.createConnection();
		connection.setClientID("comercial");
		
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Topic topic = (Topic) context.lookup("loja");
		MessageConsumer consumer = session.createDurableSubscriber(topic, "assinatura");

		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message message) {
				//TextMessage textMessage = (TextMessage) message;
				ObjectMessage objectMessage = (ObjectMessage) message;
				try {
					Pedido pedido = (Pedido) objectMessage.getObject();
					System.out.println(pedido.getCodigo());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});

		new Scanner(System.in).nextLine();

		session.close();
		connection.close();
		context.close();
	}

}
