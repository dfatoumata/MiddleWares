package fr.doranco.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.doranco.rmi.interfaces.OperationsInterface;

public class Operations extends UnicastRemoteObject implements OperationsInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Operations() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public long add(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public long substruct(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public long multiply(int a, int b) throws RemoteException {
		return a*b;
	}

	@Override
	public int divide(int a, int b) throws RemoteException {
		if (b==0) {
			throw new RemoteException("Division par 0 est impossible");
		}
		return a/b ;
	}

}
