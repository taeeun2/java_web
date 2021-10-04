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
		
		//�⺻ Ÿ���� ��üȭ�ؼ� �־���Ѵ�, �ڵ����� ��üȭ�ؼ� ����.
		//Ÿ���� ������� ��, ĳ������ �ʿ� ����.
		
		List<Board> list = new Vector<>();
		Calendar cal = Calendar.getInstance();
		StringBuilder sb = new StringBuilder();
		sb.append(cal.get(Calendar.YEAR));
		sb.append("��");
		sb.append(cal.get(Calendar.MONTH)+1);
		sb.append("��");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy.MM.dd a HH:mm:ss");
//		Math.random();
//		Random ran = new Random();
//		
		
		list.add(new Board("����1","����1","�۾���1",sb.toString()));
		list.add(new Board("����2","����2","�۾���2",sdf.format(date)));
		list.add(new Board("����3","����3","�۾���3",""));
		list.add(new Board("����4","����4","�۾���4",""));
		list.add(new Board("����5","����5","�۾���5",""));
		list.remove(2);
		
		System.out.println(list.indexOf("����1"));
		
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
