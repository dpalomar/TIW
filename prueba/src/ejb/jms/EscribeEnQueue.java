package ejb.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

import servlets.UsuarioServlet;
import dominios.Direccion;
/**
 * Esta clase muestra distintos ejemplos de codigo.
 * Por un lado y comentado esta el codigo clasico de acceso a recursos JMS via JNDI
 * Por otro se hace uso de CDI y se muestra como inyectar recursos {@link Queue} y {@link JMSContext}
 * que hacen mucho mas simple la distribucion del codigo
 * Para que funcione correctamente esta clase debe ser Inyectada en el {@link UsuarioServlet} y no cargada manualmente.
 * Tambien hay que incluir un fichero <em>beans.xml</em> vacio en el directorio <strong>WEB-INF</strong>
 * @author David Palomar
 * @see UsuarioServlet
 */
public class EscribeEnQueue {

	// Usando CDI no es necesario inyectar el ConnectionFactory
	 // @Resource(name = "jms/_tiwConnectionFactory")	
	 // private  ConnectionFactory connectionFactory;
	
	  @Resource(lookup = "jms/pedido")
	  private  Queue queue;
	  @Inject
	  private JMSContext jmsContext;

	  public void enviar(Direccion direccion)
	  {
//FIXME: Codigo legado  de acceso  tradicional via JNDI
		  
//	    MessageProducer messageProducer;
//	    ObjectMessage mensaje;
	    
//	    try
//	    {
////	        ConnectionFactory connectionFactory = null;
////	        
////	        //Get the JNDI Context
////	  
////	            Context jndiContext = new InitialContext();
////	             
////	            //Create the Connection Factory
////	            connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/_tiwConnectionFactory");
////	            Queue queue = (Queue) jndiContext.lookup("jms/pedido"); 
//	
//	      Connection connection = connectionFactory.createConnection();
//	      Session session = connection.createSession(false,
//	        Session.AUTO_ACKNOWLEDGE);
//	      
//	
//	      messageProducer = session.createProducer(queue);
//	      mensaje = session.createObjectMessage();
//	      mensaje.setObject(direccion);
//
//	
//	      messageProducer.send(mensaje);
//	      messageProducer.close();
//	      session.close();
//	      connection.close();
//	    
//	    }
//	    catch (JMSException e)
//	    {
//	      e.printStackTrace();
//	    }
	   
			jmsContext.createProducer().send(queue, direccion);
		
	  }

	}
	
