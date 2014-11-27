package ejb.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import dominios.Direccion;
import dominios.Usuario;
import es.uc3m.tiw.ejb.PruebasBeanRemote;

/**
 * Message-Driven Bean implementation class for: PruebaMDB
 */
@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"), @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "jms/pedido")
		}, 
		mappedName = "jms/pedido")
public class PruebaMDB implements MessageListener {

	@EJB(name="pruebas")
	private PruebasBeanRemote servicio;
	
    /**
     * Default constructor. 
     */
    public PruebaMDB() {
        // TODO Auto-generated constructor stub
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        Usuario usuario = servicio.buscaUsuario(1L); //se asume para el ejemplo que sera el primer usuario creado
        
        ObjectMessage om =  (ObjectMessage) message;
        try {
			Direccion direccion = om.getBody(Direccion.class);
			usuario.setDireccion(direccion);
			servicio.actualizarUnUsuarioConDireccion(usuario); 
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
        
    }

}
