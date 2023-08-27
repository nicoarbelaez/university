package pointThree;

public class PointThree {

    public PointThree() {
        System.out.println("A a= new...");
        System.out.println("B b= new...");
        System.out.println("C c= new...");
        System.out.println("D d= new...");
        System.out.println("E e= new...");
        System.out.println("Se incluyen los siguientes métodos:");
        System.out.println("interfaz A especifica method void methodA()");
        System.out.println("clase C tiene el abstract method void methodC()");

        System.out.println("\tCodigo: \t ¿Siempre compila, a veces compila, no compila?");
        System.out.println("a = new B(); \t\t\t Simpre compila");
        System.out.println("d = new C(); \t\t\t No compila");
        System.out.println("b.methodA(); \t\t\t A veces compila");
        System.out.println("e.methodA(); \t\t\t Siempre compila");
        System.out.println("c = new C(); \t\t\t A veces compila");
        System.out.println("(D)c.methodC(); \t\t A veces compila");
    }
}
