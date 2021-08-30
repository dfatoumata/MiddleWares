package fr.doranco.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class OperationsServer {
	
	public static void main(String[] args) {
		
		try {
			Operations operations = new Operations();
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("MesOperations", operations);
			System.err.println("Operations Server is ready.");
			
		} catch (RemoteException e) {
			System.err.println("Operations Server failed : " + e);
			System.exit(1);
		}
		
	}

}
