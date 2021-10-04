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
		//id abc가 아니라면 NotExistIDException발생
		if(!id.equals("abc"))
			throw new NotExistIDException("아이디가 존재하지 않습니다.");
		//pw 123가 아니라면 WrongPasswordException발생
		if(!pw.equals("123"))
			throw new WrongPasswordException("패스워드가 일치하지 않습니다.");

	}

}
