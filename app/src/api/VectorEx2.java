package api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class VectorEx2{

	public static void main(String[] args) {
		/*
		List list2 = new Vector();
		list2.add("A");
		list2.add("B");
		list2.add("C");
		list2.add(10);
		list2.add(new Integer(10));
		int sum = 10 + new Integer(10);
		System.out.println(sum);
		*/
		
		//기본 타입을 객체화해서 넣어야한다, 자동으로 객체화해서 들어간다.
		//타입을 명시했을 때, 캐스팅할 필요 없음.
		
		List<Board> list = new Vector<>();
		Calendar cal = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append(cal.get(Calendar.YEAR));
		sb.append("년");
		sb.append(cal.get(Calendar.MONTH)+1);
		sb.append("월");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy.MM.dd a HH:mm:ss");
//		Math.random();
//		Random ran = new Random();
//		
		
		list.add(new Board("제목1","내용1","글쓴이1",sb.toString()));
		list.add(new Board("제목2","내용2","글쓴이2",sdf.format(date)));
		list.add(new Board("제목3","내용3","글쓴이3",""));
		list.add(new Board("제목4","내용4","글쓴이4",""));
		list.add(new Board("제목5","내용5","글쓴이5",""));
		list.remove(2);
		
		System.out.println(list.indexOf("제목1"));
		
		for(Board b : list) {
			System.out.println(b.getSubject()+" "+b.getContent()+ " "+b.getWriter()+
					" "+b.calendar);
			
		}
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getSubject() + "\t"+list.get(i).getContent()
					+"\t"+list.get(i).getWriter());
		}



	}

}
