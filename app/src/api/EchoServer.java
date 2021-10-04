package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
//	private Socket socket;//클라이언트 소켓
	private ServerSocket server;//서버 소켓
	public EchoServer(int port) throws IOException{
		server = new ServerSocket(port);//서버에서 통신할 수 있는 포트를 만들어야 한다.
	}
	//서버는 클라이언트의 요청을 기다린다.
	public void service() throws IOException{
		System.out.println("EchoServer is ready");
		
		Socket socket = server.accept();//통신할 수 있는 소켓을 만든다.
		//모든 데이터는 binary데이터만 전송할 수 있다. -> 객체 직렬화 가능
		InputStream is = socket.getInputStream();
		OutputStream os = socket.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		PrintWriter out = new PrintWriter(os,true);
		while(true) {
			String msg = br.readLine();
			System.out.println(msg);
			if(msg.equals("bye")) {
				break;
			}
			out.println("-->>"+msg);

		}
		
		
	}
	public void close() throws IOException{
		server.close();
	}
	public static void main(String[] args) {
		try {
			EchoServer es = new EchoServer(9999);
			es.service();
			es.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
