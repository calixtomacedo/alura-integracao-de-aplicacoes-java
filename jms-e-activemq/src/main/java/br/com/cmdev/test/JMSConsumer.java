package br.com.cmdev.test;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.InitialContext;

public class JMSConsumer {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

		Connection connection = factory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination queue = (Destination) context.lookup("financeiro");
		MessageConsumer consumer = session.createConsumer(queue);

		Message message = consumer.receive();

		System.out.println("Recebendo nossa mensagem: " + message);

		new Scanner(System.in).nextLine();

		session.close();
		connection.close();
		context.close();
	}

}
