package ejb.jms;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import dominios.Direccion;

public class EscribeEnQueue {

	  @Resource(mappedName = "jms/_tiwConnectionFactory")
	  private static ConnectionFactory connectionFactory;
	  @Resource(mappedName = "jms/pedido")
	  private static Queue queue;

	  public void enviar(Direccion direccion)
	  {
	    MessageProducer messageProducer;
	    ObjectMessage mensaje;
	    
	    try
	    {
	      Connection connection = connectionFactory.createConnection();
	      Session session = connection.createSession(false,
	        Session.AUTO_ACKNOWLEDGE);
	      messageProducer = session.createProducer(queue);
	      mensaje = session.createObjectMessage();
	      mensaje.setObject(direccion);

	
	      messageProducer.send(mensaje);

	      messageProducer.close();
	      session.close();
	      connection.close();
	    }
	    catch (JMSException e)
	    {
	      e.printStackTrace();
	    }
	  }
	
	}
	
