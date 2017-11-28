package test;

public class OverloadMethodTest {

  static class A {
    public void m1(A pA) {
      System.out.println("m1 de A");
    }

    public static void s1() {
      System.out.println("s1 de A");
    }
  }

  static class B extends A {
    //@Override
    public void m1(B pB) {
      System.out.println("m1 de B");
    }

    public static void s1() {
      System.out.println("s1 de B");
    }

  }

  public static void main(String[] args) {
    A a = new A();
    A b1 = new B();
    B b2 = new B();
    b1.m1(b2);
    a.m1(b2);

    B b3 = (B) b1;
    a.s1();
    b1.s1();
    b2.s1();
    b3.s1();
  }

}
