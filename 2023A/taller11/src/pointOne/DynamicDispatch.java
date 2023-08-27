package pointOne;

class DynamicDispatch {
	DynamicDispatch() {
		A a = new A();
		B b = new B();
		C c = new C();
		A ref;

		ref = b;
		ref.callthis();
		ref = c;
		ref.callthis();

		ref = a;
		ref.callthis();
	}
	
	// public static void main(String args[]) {
	// 	A a = new A();
	// 	B b = new B();
	// 	C c = new C();
	// 	A ref;

	// 	ref = b;
	// 	ref.callthis();
	// 	ref = c;
	// 	ref.callthis();

	// 	ref = a;
	// 	ref.callthis();
	// }
}
