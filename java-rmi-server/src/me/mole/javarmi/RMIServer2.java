package me.mole.javarmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 受害者RMI服务器
 */
public class RMIServer2 {
    public static void main(String[] args) {
        try {
            // 实例化服务端远程对象
            ServicesImpl obj = new ServicesImpl();
            Registry registry = null;
            try {
                //如果需要使用RMI的动态加载功能，需要开启RMISecurityManager，并配置policy以允许从远程加载类库
                System.setProperty("java.security.policy",
                        RMIServer2.class.getClassLoader().getResource("perm.policy").getFile());
                RMISecurityManager securityManager = new RMISecurityManager();
                System.setSecurityManager(securityManager);

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
