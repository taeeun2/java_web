package api;

public class StringEx {

	public static void main(String[] args) {
		//static������ super�� this�� �� �� ����.
		String a = "A";//�ϳ��� ��ü�� �����Ѵ�.
		String b = "A";
		//�޸𸮿� A��ü �ϳ��� �����ȴ�. -> �޸� ����
		String c = new String("A");//������ A����
		System.out.println(a == b);//a�� b�� ����Ű�� ��ü�� ����.
		System.out.println(a.equals(b));//���� ��(���� ��)
		System.out.println(a == c);//a�� c�� ����Ű�� ��ü�� �ٸ���.
		
		Object o = "abc";//string ��ü�� ����ȯ�Ǿ� ����
		String s = "abc";
		String s2 = "abc";
		String s3 = null;
		System.out.println(o == s);//(o)
		System.out.println(o == s2);//(o)
		if(o instanceof String) {
			System.out.println("string instance");
		}
		String s4 = new String("abc");
		System.out.println(o.toString());
		System.out.println(o == s4);//(x)
		System.out.println(s == s4);//(x)
		System.out.println(o.equals(s4));//(o)
		System.out.println(s3 == s4);//(x)
	}

}
