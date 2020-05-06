package me.mole.javarmi;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 受害者RMI客户端
 */
public class RMIClient1 {
    public static void main(String[] args) throws Exception {
        //如果需要使用RMI的动态加载功能，需要开启RMISecurityManager，并配置policy以允许从远程加载类库
        System.setProperty("java.security.policy",
                RMIClient1.class.getClassLoader().getResource("perm.policy").getFile());
        RMISecurityManager securityManager = new RMISecurityManager();
        System.setSecurityManager(securityManager);

        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9999);
        // 获取远程对象的引用
        Services services = (Services) registry.lookup("Services");
        Message message = new Message();
        message.setMessage("hahaha");

        services.sendMessage(message);
    }
}
