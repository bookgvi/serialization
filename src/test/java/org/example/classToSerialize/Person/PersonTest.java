package org.example.classToSerialize.Person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

class PersonTest {
    @Test
    public void test_simple_Serialization() throws IOException, ClassNotFoundException {
        Person p = Person.INSTANCE;
        p.setFirstName("firstName");
        p.setLastName("lastName");

        String serializationHolderFileName = "C:\\Users\\book\\IdeaProjects\\serialization\\src\\test\\resorces\\personSimpleSerial.text";
        try (FileOutputStream fileOutputStream = new FileOutputStream(serializationHolderFileName)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(p);
            objectOutputStream.flush();
        }
        Person deserializePerson;
        try(FileInputStream fileInputStream = new FileInputStream(serializationHolderFileName)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserializePerson = (Person) objectInputStream.readObject();
        }
        Assertions.assertNotNull(deserializePerson);
        Assertions.assertEquals(p.getFirstName(), deserializePerson.getFirstName());
        Assertions.assertEquals(p.getLastName(), deserializePerson.getLastName());
        Assertions.assertEquals(p.getAge(), deserializePerson.getAge());
        Assertions.assertSame(p, deserializePerson);
    }
}