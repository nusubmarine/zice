package zice;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		ProxyTest proxyTest=new ProxyTest();
		proxyTest.test();
	}

	public void test() {
		AccountService accountService=new AccountServiceImpl();
		AccountServiceHandler accountServiceHandler=new AccountServiceHandler(accountService);
		AccountService proxyAccountService=(AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), 
				accountService.getClass().getInterfaces(), accountServiceHandler);
		proxyAccountService.transfer("lihao","patchouli",10000);
		proxyAccountService.query("li");
	}
}
