package app;

public class SoundableEx {

	//static은 객체생성없이 쓰고 싶을 때 사용, 메모리에서 계속 사용(정적인 영역)
	//dynamic영역 -> 객체생성 o , new 사용
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
