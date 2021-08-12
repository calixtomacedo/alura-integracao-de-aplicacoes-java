package br.com.cmdev.queues;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class QueueJMSProducer {

	public static void main(String[] args) throws Exception {

		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

		Connection connection = factory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination queue = (Destination) context.lookup("financeiro");
		
		MessageProducer producer = session.createProducer(queue);
		
		for (int i = 0; i <= 1000; i++) {
			Message message = session.createTextMessage("<pedido><id>"+ i +"</id></pedido>");
			producer.send(message);
		}
		
		session.close();
		connection.close();
		context.close();
	}

}
