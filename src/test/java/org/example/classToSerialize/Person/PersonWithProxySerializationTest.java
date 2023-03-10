package org.example.classToSerialize.Person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

class PersonWithProxySerializationTest {

    @Test
    public void test_serialization_proxy_pattern() throws IOException, ClassNotFoundException {
        PersonWithProxySerialization personWithProxySerialization = PersonWithProxySerialization.INSTANCE;

        String serializationHolderFileName = "C:\\Users\\book\\IdeaProjects\\serialization\\src\\test\\resorces\\personSimpleSerial.text";
        try (FileOutputStream fileOutputStream = new FileOutputStream(serializationHolderFileName)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(personWithProxySerialization);
            objectOutputStream.flush();
        }

        PersonWithProxySerialization deserializePerson;
        try (FileInputStream fileInputStream = new FileInputStream(serializationHolderFileName)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserializePerson = (PersonWithProxySerialization) objectInputStream.readObject();
        }

        Assertions.assertSame(personWithProxySerialization, deserializePerson);
    }

    @Test
    public void test_properties_access() throws IOException {
        PersonWithProxySerialization p = PersonWithProxySerialization.INSTANCE;
        Properties props = p.propertiesAccess("application.properties");
        Assertions.assertEquals(props.getProperty("tmpKey"), "tmpVal");
    }
}