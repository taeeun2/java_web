package api;

import java.io.IOException;

/*
 * ���
 * 
 * - ��Ʈ�� : �Ϲ������� ������, ��Ŷ ���� �Ϸ��� ���Ӽ��� ���� �帧�� �ǹ��Ѵ�.(�帣�� ������=���� �帧)
 * - ����� ��Ʈ�� : �����͸� �а� ���� ������ ���α׷��� ������ �𵨸��س��� ��
 * - ���� : �����͸� �ӽ������� ��Ƶδ� ����.
 * 
 * �ڹ��� ����� ��Ʈ�� ����
 * - �ܹ������� �帧.
 * - ���۸� ���� �� �ִ�.
 * - FIFO(First In First Out)�� ����
 * - ����(Character Stream), ����Ʈ(byte Stream)�� �з���.
 * 
 * ����(Character Stream) ���� �ֻ��� ��Ʈ��
 * - Reader class
 * 		�Է� ��Ʈ�� : ���� �ֻ��� ��Ʈ��
 * - Writer class
 * 		��� ��Ʈ�� : ���� �����͸� ����ϱ� ���� ��Ʈ��
 * 
 * ����Ʈ(byte Stream) ����Ʈ �ֻ��� ��Ʈ��
 * - InputStream class
 * 		�Է� ��Ʈ�� : ����Ʈ �����͸� �о� ���̴� ��Ʈ��
 * 		(�Է� �ֻ��� ��Ʈ��)
 * - OutputStream class
 * 		��� ��Ʈ�� : ����Ʈ �����͸� ����ϱ� ���� ��Ʈ��.
 * 		(��� �ֻ��� ��Ʈ��)
 */
public class IOEx {

	public static void main(String[] args) {
		System.out.println("�Է� : ");
		char c = ' ';
		try {
			c = (char)System.in.read();
		}catch(IOException e) {
			e.printStackTrace();//���� ���� ���
		}

		System.out.println("��� : "+c);
	}

}
