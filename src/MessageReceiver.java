
	import javax.jms.Connection;
	import javax.jms.ConnectionFactory;
	import javax.jms.Destination;
	import javax.jms.JMSException;
	import javax.jms.Message;
	import javax.jms.MessageConsumer;
	import javax.jms.Session;
	import javax.jms.TextMessage;
	 
	import org.apache.activemq.ActiveMQConnection;
	import org.apache.activemq.ActiveMQConnectionFactory;
	 
	public class MessageReceiver {
	 
	   
	    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	    // default broker URL is : tcp://localhost:61616"
	 
	    
	    private static String subject = "QUEUE1";
	 
	    public static void main(String[] args) throws JMSException {
	        // Getting JMS connection from the server
	        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
	        Connection connection = connectionFactory.createConnection();
	        connection.start();
	 
	        // Creating session for sending messages
	        Session session = connection.createSession(false,
	                Session.AUTO_ACKNOWLEDGE);
	 
	      
	        Destination destination = session.createQueue(subject);
	 
	        // MessageConsumer is used for receiving (consuming) messages
	        MessageConsumer consumer = session.createConsumer(destination);
	 
	        // Here we receive the message.
	        Message message = consumer.receive();
	 
	        // We will be using TestMessage in our example. MessageProducer sent us a TextMessage
	        // so we must cast to it to get access to its .getText() method.
	        if (message instanceof TextMessage) {
	            TextMessage textMessage = (TextMessage) message;
	            System.out.println("Received message '" + textMessage.getText() + "'");
	        }
	        connection.close();
	    }
	}


Vhanges donenhweohdweaspjf;wsa[
