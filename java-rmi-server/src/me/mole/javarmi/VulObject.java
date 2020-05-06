package me.mole.javarmi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class VulObject implements Serializable {
    private static final long serialVersionUID = 7398165783113471324L;
    private String param;

    public void setParam(String param) {
        this.param = param;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Runtime.getRuntime().exec(this.param);
    }
}
