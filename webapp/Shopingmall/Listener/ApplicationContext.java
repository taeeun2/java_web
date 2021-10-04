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
		preparedObjects(props);//����
		prepareAnnotationObjects();
		injectDependency();//��ü ����
	}
	
	public Object getBean(String key) {
		return objTable.get(key);
	}
	
	public void preparedObjects(Properties props) throws Exception{
		System.out.println("intialContext");
		Context ctx = new InitialContext();//���ε��� ��ü�� ã�� ���� �ʿ��� ��ü
		for(Object item : props.keySet()) {
			String key = (String) item;
			String value = props.getProperty(key);
			if(key.startsWith("jndi.")) {//jndi�� �����ϸ� ������ �ҽ��� ����.
				System.out.println("������ �ҽ� �о��" + key+ "/"+ctx.lookup(value));
				objTable.put(key, ctx.lookup(value));
			}else {
				objTable.put(key, Class.forName(value).newInstance());//Ŭ���� ������ ��ü�� �����Ѵ�.
			}
		}
	}
	
	private void injectDependency() throws Exception{
		for(String key : objTable.keySet()) {
			if(!key.startsWith("jndi.")) {
				callSetter(objTable.get(key));//Setter�޼ҵ�(setMemberDao) ã��
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
					m.invoke(obj,dependency);//��ü ������ �Ͼ
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