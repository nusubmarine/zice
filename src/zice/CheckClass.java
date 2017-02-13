package zice;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CheckClass {

	public static void main(String[] args) {
		CheckClass checkClass=new CheckClass();
		System.out.println(checkClass.check());
	}

	public boolean check() {
		InputStream inputStream=new BufferedInputStream((this.getClass().getResourceAsStream("Shoppingcart.class")));
		byte[] b=new byte[4];
		try {
			inputStream.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String string="";
		for(int i=0;i<4;i++){
			string+=Integer.toHexString(b[i]).substring(6, 8); 
		}
		if (string.equals("cafebabe")) {
			return true;
		}
		return false;
	}
}
