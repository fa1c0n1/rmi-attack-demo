package me.mole.javarmi;

import java.rmi.RemoteException;

public interface Services extends java.rmi.Remote {
    Object sendMessage(Message msg) throws RemoteException;
}


