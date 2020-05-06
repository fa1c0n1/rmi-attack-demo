package me.mole.remoteclass;

import me.mole.javarmi.Message;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.io.Serializable;
import java.util.Hashtable;

public class ExportObject1 extends Message implements ObjectFactory, Serializable {
    private static final long serialVersionUID = 4223894761476211986L;

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return null;
    }
}
