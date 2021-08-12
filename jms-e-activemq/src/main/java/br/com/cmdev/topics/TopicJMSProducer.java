package br.com.cmdev.topics;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;

import br.com.cmdev.model.Pedido;
import br.com.cmdev.model.PedidoFactory;

public class TopicJMSProducer {

	public static void main(String[] args) throws Exception {

		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");

		Connection connection = factory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination topic = (Destination) context.lookup("loja");

		MessageProducer producer = session.createProducer(topic);

		Pedido pedido = new PedidoFactory().geraPedidoComValores();
/*	
		StringWriter writer = new StringWriter();
		JAXB.marshal(pedido, writer);
		String xml = writer.toString();
		System.out.println(xml);
*/	
		//Message message = session.createTextMessage(xml);
		Message message = session.createObjectMessage(pedido);
		//message.setBooleanProperty("ebook", true);
		producer.send(message);

		session.close();
		connection.close();
		context.close();
	}

}
