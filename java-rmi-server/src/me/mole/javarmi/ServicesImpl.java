package me.mole.javarmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServicesImpl extends UnicastRemoteObject implements Services {
    public ServicesImpl() throws RemoteException {
    }

    @Override
    public Object sendMessage(Message msg) throws RemoteException {
        return msg.getMessage();
    }
}
