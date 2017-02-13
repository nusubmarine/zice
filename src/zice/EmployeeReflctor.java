package zice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class EmployeeReflctor {
	Class cls=null;
	
	public static void main(String[] args) {
		EmployeeReflctor employeeReflctor=new EmployeeReflctor();
		Object object=employeeReflctor.create();
		employeeReflctor.sayHello(object);
		System.out.println(employeeReflctor.getId(object));
		employeeReflctor.getFields();
	}
	
	public Object create(){
		
		try {
			cls= Class.forName("zice.Employee");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object obj =null;
		Constructor constructor=null;
		try {
			constructor=cls.getDeclaredConstructor(new Class[]{String.class,int.class});
			try {
				obj=constructor.newInstance(new Object[]{"li",34});
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	public void sayHello(Object obj) {
		try {
			Method method=cls.getDeclaredMethod("sayHello");
			try {
				method.invoke(obj);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getId(Object obj) {
		String string="";
		try {
			Method method=cls.getDeclaredMethod("getID");
			method.setAccessible(true);
			try {
				string= (String) method.invoke(obj);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
	
	public void getFields() {
		Field[] fields=cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(Modifier.toString(fields[i].getModifiers())+" "+fields[i].getType().getSimpleName()+" "+fields[i].getName());
		}
	}
}
