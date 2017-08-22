/**
  *The ShoppingCart class that stores IceCreamOrders in a cart
  *and allows ice cream orders to be added to or removed from the cart, or any of the
  *ice cream orders in the cart be listed or revised. The capacity of the
  *cart is limited to a maximum of 5 ice cream orders.
  */

import java.text.DecimalFormat;//Imports the function DecimalFormat is the class text
import java.util.Scanner;//Imports the function Scanner is the class util
public class ShoppingCart 
{
	private static final int MAXCAPACITY=5;//Declare and initialize a static and constant variable
	private IceCreamOrder [] IceCream;//Declare a private array of IceCreamOrder type
	private int numberUsed;//Declare a private int variable 	
	public ShoppingCart()//Creates an empty shopping cart with the maximum capacity allowed.
	{
		IceCream=new IceCreamOrder[MAXCAPACITY];
		numberUsed=0;
	}
	public void add(IceCreamOrder order)//Adds the supplied ice cream order to the cart, keeping track of the number of orders in it
	{
		if(numberUsed==MAXCAPACITY)//If the list is full, it prints an error message and ignores the request.
		{
			System.out.println("Error. Max capacity of your orders is 5.");
		}
		else
		{
			IceCream[numberUsed]=new IceCreamOrder(order.getflavor(),order.getvessel(),order.getamount(),order.getunitPrice(),order.getquantity());
			numberUsed++;
		}
	}
	public void remove(int position)//Removes an order at a specified position from the cart.
	{
		//If the list is empty or the specified position is out of range, it prints an error message and ignores the request.
		if(numberUsed==0||position<0||position>numberUsed)
		{
			System.out.println("Error: Illegal or unused position.");
		}
		else if(!isFull())//If the cart is not full, the selected item will be replaced by the next item.And the number of orders will be tracked.
		{
		  for(int i=position-1;i<numberUsed;i++)//The associated index of array shall be the position-1			
			  IceCream[i]=IceCream[i+1];		
		      numberUsed--;	
		}
		/**If the cart is full, the user chose a item except the fifth item,the selected item will be replaced by 
		 * the next item.But the last(fifth)item shall not be replaced by the next item because the "sixth" item 
		 * is out of bound of array.And the number of orders will be tracked.
		 */
		else if(isFull()&&position<MAXCAPACITY)
		{
		  for(int i=position-1;i<numberUsed-1;i++)				
			 IceCream[i]=IceCream[i+1];		
			 numberUsed--;	
		}
		/**If the cart is full, the user chose the fifth item,the fifth item shall initialize to null again because
		 * the "sixth" item is out of bound of array.And the number of orders will be tracked.
		 */
		else if(isFull()&&position==MAXCAPACITY)
		{
			IceCream[position-1]=new IceCreamOrder();
			numberUsed--;
		}
	}
	public String toString()//Returns a string representation of all ice cream orders in the cart
	{
		DecimalFormat df=new DecimalFormat("#.00");
		String all=null;
		for(int i=0;i<numberUsed;i++)
			all+=(IceCream[i].getquantity()+" orders of "+IceCream[i].getamount()+" of "+IceCream[i].getflavor()+" ice cream in a "+IceCream[i].getvessel()+" for $"+df.format(IceCream[i].price())+" = "+IceCream[i].getquantity()+" * "+df.format(IceCream[i].getunitPrice())+"\n"); 
	    return all;
	}
	public boolean isEmpty()//Determines whether this cart is empty.
	{
		return (numberUsed==0);
	}
	public boolean isFull()//Determines whether this cart is full.
	{
		return (numberUsed==MAXCAPACITY);
	}
	public IceCreamOrder get(int position)//Returns the order placed at the supplied position in the cart.
	{
		if(position<0||position>numberUsed)
		{
			System.out.println("Error: Illegal or unsued position.");
			return null;
		}
		else
		return IceCream[position];
	}
	public int size()//Returns the number of orders currently in the cart.
	{
		return numberUsed;
	}
}
