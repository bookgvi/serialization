package org.example.classToSerialize.Person;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

public class PersonWithProxySerialization implements java.io.Serializable {

    private static final long serialVersionUID = -7312581291730081794L;
    public static final PersonWithProxySerialization INSTANCE = new PersonWithProxySerialization();

    private PersonWithProxySerialization() {

    }

    private static class SerializationProxy implements java.io.Serializable {
        public SerializationProxy(PersonWithProxySerialization p) {
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream inputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required...");
    }
}
