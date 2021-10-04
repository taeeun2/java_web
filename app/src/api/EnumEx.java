package api;

/*
 	Ŭ����ó�� ���̰� �ϴ� ���
 	���� ������ �ִ� ������� ��� �ɺ����� ��Ī�� �������� ������ ��
 	EnumŬ�������� ������� �� Ŭ������ ����
 	���ο� �������� �����ϸ�, ���������� Enum Ŭ������ ����� ���ο� Ŭ�������� �������.
 */
public class EnumEx {

	public static void main(String[] args) {
//		ex1)
//		String seoul = City.SEOUL;
//		System.out.println(seoul);
		
		City c1 = City.valueOf("����");
		City[] arr = City.values();
		System.out.println(c1+"\n");
		for(City city : City.values()) {
			System.out.println(city);
		}
		
	
		
	}
// ex2	
	public enum City{
		����, �λ�, �뱸, ����, ����
		//�迭������ ����.
	}

}

class City{
	public static final String SEOUL = "����";
	public final static String BUSAN = "�λ�";
	public final static String DAEGU = "�뱸";
	public final static String GWANGJU = "����";
	public final static String DAEJEON = "����";

}