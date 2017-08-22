/**
  *The IceCreamStore class that stores a ShoppingCart and uses predefined menus to
  *interact with the customer. It provides services that allow the customer to create an
  *order and place it in the shopping cart as well as allowing the customer to manipulate
  *the orders in the shopping cart.
  */

import java.util.Scanner;//Imports the function Scanner is the class util
import java.text.DecimalFormat;//Imports the function DecimalFormat is the class text
public class IceCreamStore 
{
	//Declare and initialize the following instance variables
	public boolean runloop=false;
	public int choice=0;
	private static final int MAXCAPACITY=5;
	//Create two objects and give references to Sc and Ico accordingly.
    ShoppingCart Sc=new ShoppingCart();
    IceCreamOrder Ico=new IceCreamOrder();
	public void placeOrder()//The method creates an order using IceCreamOrder's default constructor and places that order in the cart.
	{
		do//the do-while loop for Step A
		{
		   System.out.println("Placing an order is as easy as ABC, and D.");
		   System.out.println("Step A: Select your favorite flavour");
		   System.out.println("  (1) Avocado\n  (2) Banana\n  (3) Chocolate\n  (4) Hazelnut\n  (5) Lemon\n  (6) Mango\n  (7) Mocha\n  (8) Vanilla");
		   System.out.print("?-> Enter an option number: ");			
		   choice=choice();
		   System.out.println();
		   if(choice<1||choice>8)//if the user input an integer beyond the range of list, the do-while loop will run and asks the user to input an integer again.
			   runloop=true;
		   else
			   runloop=false;
		}while(runloop);
		Ico.setflavor(choice);//Calls the method setflavor(int flavor_choice) in he class IceCreamOrder and set the value of flavor.
		do//the do-while loop for Step B
		 {
		   System.out.println("Step B: Select a vessel for your ice cream:");
		   System.out.println("  (1) Cone\n  (2) Cup\n  (3) Sundae");
		   System.out.print("?-> Enter an option number: ");
		   choice=choice();
		   System.out.println();
		   if(choice<1||choice>3)//if the user input an integer beyond the range of list, the do-while loop will run and asks the user to input an integer again.
			   runloop=true;
		   else
			   runloop=false;
		 }while(runloop); 
		Ico.setvessel(choice);//Calls the method setvessel(int vessel_choice) in he class IceCreamOrder and set the value of vessel.
		do//the do-while loop for Step C
		{
		   System.out.println("Step C: How much ice cream?");
		   System.out.println("  (1) Single Scoop\n  (2) Double Scoop\n  (3) Triple Scoop");
		   System.out.print("?-> Enter an option number: ");	
		   choice=choice();
		   System.out.println();
		   if(choice<1||choice>3)//if the user input an integer beyond the range of list, the do-while loop will run and asks the user to input an integer again.
			   runloop=true;
		   else
			   runloop=false;
		}while(runloop); 
		Ico.setamount(choice);//Calls the method setamount(int amount_choice) in he class IceCreamOrder and set the value of amount.
		do//the do-while loop for Step D
		{
		   System.out.println("Step D: How many order of your current selection?");
		   System.out.println("  (1) One\n  (2) Two\n  (3) Three\n  (4) Four\n  (5) Five\n  (6) Six\n  (7) Seven\n  (8) Eight\n  (9) Nine\n  (10) Ten");
		   System.out.print("?-> Enter how many orders: ");
		   choice=choice();
		   System.out.println();
		   if(choice<1||choice>10)//if the user input an integer beyond the range of list, the do-while loop will run and asks the user to input an integer again.
			   runloop=true;
		   else
			   runloop=false;
		}while(runloop); 
		Ico.setquantity(choice);//Calls the method setquantity(int quantity_choice) in he class IceCreamOrder and set the value of quantity.
		Ico.setunitPrice();//Calls the method setunitPrice() in he class IceCreamOrder and set the value of unitPrice.		
		Sc.add(Ico);//Calls the method add(IceCreamOrder order) in he class ShoppingCart and adds all the above values in array IceCream[numberUsed].
		if(Sc.size()<MAXCAPACITY)//if the cart is not full, program executes the following statement.
			topmenu_notempty();
		else if(Sc.size()==MAXCAPACITY)//if the cart is not full, program executes the following statement.
			topmenu_full();
	}
	/**Displays a list of all of the orders in the cart as options, prompts for and
	 * reads the option number associated with the order to be deleted, and then removes
	 * that order from the cart. To avoid forcing the user to having to remove an order, the
	 * method always adds an exit option at the end of the option list displayed by the menu.
     */
	public void deleteOrder()
	{
		do
		{
		System.out.println("You have selected to remove an order from your cart");
		System.out.println("What would you like to do?");
		int i=0;//i shall be initialized outside of for loop for i will also be used outside for loop.
		for(i=0;i<Sc.size();i++)//output list of selected menu
		{
			System.out.print("  ("+(i+1)+") ");
			System.out.println(Sc.get(i));
		}
		System.out.println("  ("+(i+1)+")"+" Exit this menu");
		System.out.print("?-> Enter an option number: ");
		choice=choice();
		System.out.println();
		if(choice<i+1&&choice>0)//choice of (i+1) indicates "Exit this menu",if
		{
		    Sc.remove(choice);//invokes method remove() from ShoppingCart and the value of "choice" will be inserted in the method.
		    System.out.println("The order you selected was deleted");
		    if(Sc.isEmpty())//if the shopping cart will be empty after remove,program shall execute topmenu_empty() as requirement.
		    	topmenu_empty();
		    else//if the shopping cart will be not empty after remove,program shall execute topmenu_empty() as requirement.
		        topmenu_notempty();		    
		}
		else if(choice==i+1&&!Sc.isFull())//if the user choose to "Exit this menu" and the shopping cart is not full right now, program executes following statement.
			topmenu_notempty();
		else if(choice==i+1&&Sc.isFull())//if the user choose to "Exit this menu" and the shopping cart is full right now, program executes following statement.
			topmenu_full();	
		else if(choice>i+1||choice<0)//if the user input an integer beyond the range of (i+1), program shall output error message and and return null and run loop.
		{
			Sc.remove(choice);
			runloop=true;
		}
		}while(runloop);
	}
	public double computeTotalPrice()//Returns the total price of all the items in the cart.
	{
		double TotalPrice=0;
		for(int i=0;i<Sc.size();i++)
			TotalPrice+=Sc.get(i).price();
		return TotalPrice;
	}
	public void printTotalPrice()//Prints the total price of all the items in the cart.
	{
		DecimalFormat df=new DecimalFormat("#.00");//reserve two decimal points.
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Total price of all your orders in the cart: $"+df.format(computeTotalPrice()));
		System.out.println("------------------------------------------------------------------------------");
		if(Sc.size()<MAXCAPACITY&&choice!=5)//If the cart is not full,and the user did not choose "Proceed to checkout", program execute the following statement.
			topmenu_notempty();
		else if(Sc.isFull()&&choice!=5)//If the cart is full,and the user did not choose "Proceed to checkout", program execute the following statement.
			topmenu_full();	
		//If the user choose "Proceed to checkout",program will execute initialization in the method checkout().
	}
	public void reviewOrders()
	{
		System.out.println("Your current selections of our scrumptious ice creams");
		System.out.println("-----------------------------------------------------------------------------");
		//output all the items in the cart.
		for(int i=0;i<Sc.size();i++)
			System.out.println(Sc.get(i));
		System.out.println("-----------------------------------------------------------------------------");		
		//The following if-else control chooses of the further executions.
		if(Sc.isFull()&&choice!=MAXCAPACITY)
			topmenu_full();
		else if(Sc.isEmpty()&&choice!=MAXCAPACITY)
		    topmenu_empty();
		else if(choice!=MAXCAPACITY)
			topmenu_notempty();
	}
	public void checkout()//the method collects payment and arranges for pickup or delivery. 
	{
		reviewOrders();//invokes the method firstly for review
		printTotalPrice();//then invokes the method for review
		Sc=new ShoppingCart();//the cart shall be initialized to empty after checkout.
		topmenu_empty();//then the program will show the top menu as beginning 		
	}
	public void run()//driver code will execute from here; then it will execute the other private and public methods.
	{    		
		topmenu_empty();						
	}			
	private int choice()//The private method return an integer from the user's input
	{
		Scanner keyboard=new Scanner(System.in);
		choice=keyboard.nextInt();
		return choice;
	}		
	private void topmenu_empty()//The private method displays top menu for choose and execute the option accordingly when the shopping cart is empty.
	{
		do
		{
		 System.out.println("Your Shopping Cart is empty.");
		 System.out.println("You have only two options: 1 or 6");
		 System.out.println("  (1) Place an order\n  (2) Delete an order\n  (3) Price the cart\n  (4) List the cart\n  (5) Proceed to checkout\n  (6) Exit this menu");
		 System.out.println("Please enter 1 or 6");
		 System.out.print("?-> Enter an option number: ");	
		 choice=choice();
		 System.out.println();
		 if(choice==1)//The cart is empty, the user is asked to input only 1 and 6, if the user input 1, the program will execute options(choice) and the do-while loop will not execute again.
			 runloop=false;
		 else if(choice==6)//if the user chose 6("Exit this menu"), the program shall end up.
		 {
			 System.out.println("Cheers!");
			 System.exit(0);
		 }
		 else//The cart is empty now, if the user input an integer not equals to 1 or 6, the do-while loop shall execute again.
			 runloop=true;
		}while(runloop);
		options(choice);
	}
	private void topmenu_notempty()//The private method displays top menu for choose and execute the option accordingly when the shopping cart is not full.
	{
		do
		{
		 System.out.println("Your Shopping Cart contains "+Sc.size()+" ice cream order(s)");
		 System.out.println("What would you like to do?");
		 System.out.println("  (1) Place an order\n  (2) Delete an order\n  (3) Price the cart\n  (4) List the cart\n  (5) Proceed to checkout\n  (6) Exit this menu");
		 System.out.println("Please enter 1 or 6");
		 System.out.print("?-> Enter an option number: ");	
		 choice=choice();
		 System.out.println();
		 if(choice<1||choice>6)//if the user input an integer beyond the range of list, the do-while loop will run and asks the user to input an integer again.
			 runloop=true;
		 else if(choice==6)//if the user chose 6("Exit this menu"), the program shall end up.
		 {
			 System.out.println("Cheers!");
			 System.exit(0);
		 }
		 else//if the user input an integer inside the range of (list-1), the do-while loop will not execute again.
			 runloop=false;
		}while(runloop);
		options(choice);
	}
	private void topmenu_full()//The private method displays top menu for choose and execute the option accordingly when the shopping cart is full.
	{
		do
		{
		 System.out.println("Your Shopping Cart is full with "+Sc.size()+" ice cream order(s)");
		 System.out.println("What would you like to do?");
		 System.out.println("  (1) Place an order\n  (2) Delete an order\n  (3) Price the cart\n  (4) List the cart\n  (5) Proceed to checkout\n  (6) Exit this menu");
		 System.out.println("Please select option 2, 3, 4, 5, or 6");
		 System.out.print("?-> Enter an option number: ");	
		 choice=choice();
		 System.out.println();
		 if(choice<1||choice>6)//if the user input an integer beyond the range of list(and the first choose), the do-while loop will run and asks the user to input an integer again.
			 runloop=true;
		/**if the user chose to add one more order again, program invokes add(IceCreamOrder order) method in ShoppingCart to
		 * prints an error message and the do-while loop will run and asks the user to input an integer again.
		 */
		 else if(choice==1)
		 {
			 Sc.add(Ico);
			 runloop=true;
		 }
		 else if(choice==6)//if the user chose 6("Exit this menu"), the program shall end up.
		 {
			 System.out.println("Cheers!");
			 System.exit(0);
		 }
		 else//if the user input an integer inside the range of (2, 3, 4, 5), the do-while loop will not execute again.
			 runloop=false;
		}while(runloop);
		options(choice);//ask the user for further option
	}	
	private void options(int choice)//the method for the user's choices for top menu
	{
		switch(choice)
		{
		  case 1: 
			  placeOrder();break;
		  case 2:
			  deleteOrder();break;
		  case 3:
			  printTotalPrice();break;
		  case 4:
			  reviewOrders();break;
		  case 5:
			  checkout();break;
		  case 6://if the user chose 6("Exit this menu"), the program shall end up.
		  {
			  System.out.println("Cheers!");
			  System.exit(0);
		  }
		}
	}	
}
