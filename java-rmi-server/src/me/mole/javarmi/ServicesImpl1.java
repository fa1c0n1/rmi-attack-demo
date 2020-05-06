package me.mole.javarmi;

import me.mole.remoteclass.ExportObject;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServicesImpl1 extends UnicastRemoteObject implements Services {
    public ServicesImpl1() throws RemoteException {
    }

    @Override
    public Object sendMessage(Message msg) throws RemoteException {
        //这里在服务端将返回值设置为了远程对象接口Object的子类，这个ExportObject在客户端是不存在的
        return new ExportObject();
    }
}
