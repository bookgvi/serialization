package org.example.extend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParentTest {

    @Test
    void displayMsg() {
//        IParent parent = new Parent();
        IParent child = new Child();

//        parent.displayMsg();
//        child.displayMsg();
    }
}