package api;

public class ExceptionEx2 {

	//public static void main(String[] args) throws Exception{
		public static void main(String[] args){

		try {
		login("abc","123");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
		
	}
	
	public static void login(String id, String pw) throws NotExistIDException, WrongPasswordException{
		//id abc�� �ƴ϶�� NotExistIDException�߻�
		if(!id.equals("abc"))
			throw new NotExistIDException("���̵� �������� �ʽ��ϴ�.");
		//pw 123�� �ƴ϶�� WrongPasswordException�߻�
		if(!pw.equals("123"))
			throw new WrongPasswordException("�н����尡 ��ġ���� �ʽ��ϴ�.");

	}

}
