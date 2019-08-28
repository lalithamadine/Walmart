import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
 
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
 
public class MesageSender {
     
  
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
     
    // default broker URL is : tcp://localhost:61616"
    private static String subject = "QUEUE1"; // Queue Name.You can create any/many queue names as per your requirement. 
     
    public static void main(String[] args) throws JMSException {        
        // Getting JMS connection from the server and starting it
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
         
        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);  
         
        
        Destination destination = session.createQueue(subject); 
         
        // MessageProducer is used for sending messages to the queue.
        MessageProducer producer = session.createProducer(destination);
         
        TextMessage message = session
                .createTextMessage("Hello");
         
        producer.send(message);
         
        System.out.println(message.getText());
        connection.close();
    }
}
