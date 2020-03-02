package com.ycxy.steelsales.test;

public class Test {
    int a;
    int b;
    int c;

    @Override
    public String toString() {
        return "Test{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public Test() {

    }

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Test(int a, int b, int c) {
        this(a, b);
        this.c = c;
    }

    public static void main(String[] args) {

        System.out.println(new Test(1, 1,1));
    }
}
