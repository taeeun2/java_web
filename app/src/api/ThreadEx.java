package api;

public class ThreadEx extends Thread{

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(0);//작업 속도 제어
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("작업1");
		}
	}
	
	public static void main(String[] args) {
		new ThreadEx().start();
		System.out.println("메인작업");
	}

}
