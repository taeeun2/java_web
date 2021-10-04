package app;

public class SoundableEx {

	//static�� ��ü�������� ���� ���� �� ���, �޸𸮿��� ��� ���(������ ����)
	//dynamic���� -> ��ü���� o , new ���
	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
		Cow cow = (Cow)soundable;
		cow.method();
	}
	public static void main(String[] args) {
	
		printSound(new Dog());
		printSound(new Cow());
		
	}

}
