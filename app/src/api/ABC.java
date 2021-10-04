package api;

public class ABC {

	public String msg = "A";
	public void print() {
		BC bc = new BC();
		bc.print();
	}
	public class BC{//내부 클래스 정의 가능
		public String msg = "B";
		public void print() {
			C c = new C();
			c.print();
		}
		public class C{
			public String msg = "C";
			public void print() {
				System.out.println(msg);
				System.out.println(this.msg);
				System.out.println(BC.this.msg);
				System.out.println(ABC.this.msg);

			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new ABC().print();

		new ABC().new BC().print();

		new ABC().new BC().new C().print();
	}

}
