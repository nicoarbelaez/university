package pointTwo;

public class PointTwo {
	public PointTwo() {
		System.out.println(
				"Una clase abstracta es una clase que puede contener uno o más métodos abstractos, pero también puede tener métodos concretos. Por otro lado, una interfaz es un tipo de clase que solo puede tener métodos abstractos, los cuales actúan como un contrato que cualquier clase que implemente esa interfaz debe cumplir");
		System.out.println(
				"La utilización de una clase abstracta es apropiada cuando se desea proporcionar una base común para un conjunto de subclases relacionadas. Es decir, una clase abstracta puede ser utilizada como un modelo para otras clases que desean heredar de ella, pero no se quiere crear instancias directamente de la clase abstracta. Esto asegura que las subclases compartan un conjunto común de métodos y propiedades.");
		System.out.println(
				"Por otro lado, una interfaz se utiliza cuando se desea tener polimorfismo en el código, desvinculando totalmente la herencia de las clases para evitar que una modificación en una clase padre afecte a sus subclases. Cualquier clase que implemente una interfaz debe implementar todos los métodos abstractos definidos por la interfaz, lo que garantiza una consistencia en el comportamiento de las clases que implementan la interfaz.");
	}
}
