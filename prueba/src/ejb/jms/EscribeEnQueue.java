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


	  @Resource(lookup = "jms/pedido")
	  private  Queue queue;
	  @Inject
	  private JMSContext jmsContext;

	  public void enviar(Direccion direccion)
	  {

	   
			jmsContext.createProducer().send(queue, direccion);
		
	  }

	}
	
