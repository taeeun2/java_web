package api;

public class ThreadEx extends Thread{

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(0);//�۾� �ӵ� ����
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�۾�1");
		}
	}
	
	public static void main(String[] args) {
		new ThreadEx().start();
		System.out.println("�����۾�");
	}

}
