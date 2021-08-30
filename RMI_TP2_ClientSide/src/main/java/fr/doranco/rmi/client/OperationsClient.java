package fr.doranco.rmi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import fr.doranco.rmi.interfaces.OperationsInterface;

public final class OperationsClient {

	private static OperationsInterface operations;
	
	public OperationsClient() throws MalformedURLException, RemoteException, NotBoundException {
		operations = (OperationsInterface) Naming.lookup("//localhost:1099/MesOperations");
	}

	public long add(int a, int b) throws RemoteException {
		return operations.add(a, b);
	}

	public long substract(int a, int b) throws RemoteException {
		return operations.substract(a, b);
	}

	public long multiply(int a, int b) throws RemoteException {
		return operations.multiply(a, b);
	}

	public int divide(int a, int b) throws RemoteException {
		return operations.divide(a, b);
	}

}
