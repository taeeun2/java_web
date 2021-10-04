package Listener;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.reflections.Reflections;

import controller.Component;



public class ApplicationContext {

	Hashtable<String, Object> objTable = new Hashtable<String, Object>();

	public ApplicationContext(String propertiesPath) throws Exception{
		Properties props = new Properties();
		props.load(new FileReader(propertiesPath));
		preparedObjects(props);//생성
		prepareAnnotationObjects();
		injectDependency();//객체 적용
	}
	
	public Object getBean(String key) {
		return objTable.get(key);
	}
	
	public void preparedObjects(Properties props) throws Exception{
		System.out.println("intialContext");
		Context ctx = new InitialContext();//바인딩된 객체를 찾기 위해 필요한 객체
		for(Object item : props.keySet()) {
			String key = (String) item;
			String value = props.getProperty(key);
			if(key.startsWith("jndi.")) {//jndi로 시작하면 데이터 소스로 쓴다.
				System.out.println("데이터 소스 읽어옴" + key+ "/"+ctx.lookup(value));
				objTable.put(key, ctx.lookup(value));
			}else {
				objTable.put(key, Class.forName(value).newInstance());//클래스 정보로 객체를 생성한다.
			}
		}
	}
	
	private void injectDependency() throws Exception{
		for(String key : objTable.keySet()) {
			if(!key.startsWith("jndi.")) {
				callSetter(objTable.get(key));//Setter메소드(setMemberDao) 찾기
			}
		}
	}
	
	private void callSetter(Object obj) throws Exception {
		Object dependency = null;
		//Method
		for(Method m : obj.getClass().getMethods()) {
			if(m.getName().startsWith("set")) {
				dependency = findObjectByType(m.getParameterTypes()[0]);
				if(dependency!=null) {
					m.invoke(obj,dependency);//객체 주입이 일어남
				}
			}
		}
	}
	
	private Object findObjectByType(Class<?> type) {
		for(Object obj : objTable.values()) {
			if(type.isInstance(obj)) {
				return obj;
			}
		}
		return null;
	}
	
	private void prepareAnnotationObjects() throws Exception{
		Reflections reflector = new Reflections("");
		Set<Class<?>>list = reflector.getTypesAnnotatedWith(Component.class);
		for(Class<?> clazz : list) {
			String key = clazz.getAnnotation(Component.class).value();
			objTable.put(key, clazz.newInstance());
		}
	}
	
}
