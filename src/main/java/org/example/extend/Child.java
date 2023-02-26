package org.example.extend;

public class Child extends Parent {
    public Child() {
//        displayMsg();
    }

    @Override
    public void displayMsg() {
        System.out.println("Child...");
    }
}
