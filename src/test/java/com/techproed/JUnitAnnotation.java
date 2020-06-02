package com.techproed;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitAnnotation {
    //On A Junit projects, we can use @Test annotation to run a test
    //create a void method name:test1
    //By Default, Junit runs the test in alphabetical order
    //It doesn't run from top to bottom
    @Test  //@Test annotation helps us create test cases.We can run test cases without main method
    public void test1(){
        System.out.println("Printing Test 1");
    }

    //I want to run test2 method before any other method
    @Before
    public void test2(){
        System.out.println("Printing Test 2");
    }

    @Ignore//Ignoring the test case
    @Test
    public void test3(){
        System.out.println("Printing Test 3");
    }
}
