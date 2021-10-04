package api;

public class Member2 {

	private String name;
	private int age;
	public Member2(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member2) {
			Member2 member = (Member2)obj;//Ä³½ºÆÃ
			return member.name.equals(this.name)&&(member.age == age);
			
			
		}
		return false;
	}
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}
	
}
