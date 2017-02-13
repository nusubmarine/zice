package zice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AccountServiceHandler implements InvocationHandler {

	private Object object;  
	
	public AccountServiceHandler(Object object){
		this.object=object;
	}
	
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		Transaction transaction=new Transaction();
		transaction.beginTx();
		Object result = arg1.invoke(arg0, arg2);
		transaction.commitTx();
		return result;
	}

}
