package fr.doranco.rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperationsInterface extends Remote {

	public long add(int a, int b) throws RemoteException;
	public long substract(int a, int b)throws RemoteException;
	public int divide(int a, int b)throws RemoteException;
	public long multiply(int a, int b)throws RemoteException;
}
