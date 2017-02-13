package zice;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @author lihao
 *
 */
public class Shoppingcart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shoppingcart shoppingcart=new Shoppingcart();
		System.out.println("total:"+shoppingcart.sumPrice());
	}

	public double sumPrice() {
		double total=0;
		DataInputStream dataInput=null;
		dataInput=new DataInputStream((this.getClass().getResourceAsStream("/shoppingcart.data")));
		boolean flag=true;
		while(flag){
			try {
				double price=dataInput.readDouble();
				System.out.println("price:"+price);
				int number=dataInput.readInt();
				System.out.println("number:"+number);
				String decription=dataInput.readUTF();
				System.out.println("decription:"+decription);
				total+=price*number;
			} 
			catch (EOFException e) {
				flag=false;
				System.out.println("eof");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return total;
	}
}
