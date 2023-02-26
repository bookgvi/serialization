package org.example.extend;

public class Parent implements IParent {
    public Parent() {
        displayMsg();
    }

    @Override
    public void displayMsg() {
        System.out.println("Parent...");
    }
}
