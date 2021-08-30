package fr.doranco.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import fr.doranco.rmi.interfaces.RMIInterface;

public class MessageServer extends UnicastRemoteObject implements RMIInterface {

	private static final long serialVersionUID = 1L;

	protected MessageServer() throws RemoteException {
		super();
	}

	@Override
	public String helloTo(String name) throws RemoteException {
		
		if (name == null ) {
			System.err.println("Le client a contacté le serveur !");
			return "J'ai bien reçu le message du client.";
		}
		
		return "Salut " +name + " !";
	}
	
	
	public static void main(String[] args) {
		
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("Message", new MessageServer());
			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: ");
			e.printStackTrace();
			System.exit(1);

		}

	}

}
