package br.com.cmdev.log.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
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

		Destination queue = (Destination) context.lookup("LOG");
		
		MessageProducer producer = session.createProducer(queue);
		
		Message message = session.createTextMessage("INFO | ActiveMQ Jolokia REST API available at http://127.0.0.1:8161/api/jolokia/");
		producer.send(message, DeliveryMode.NON_PERSISTENT, 3, 5000);

		session.close();
		connection.close();
		context.close();
	}

}
