/**
  *The IceCreamOrder class that represents an order to buy a given ice cream in a given
  *quantity, such as 3 orders of Single Scoop of Vanilla ice cream in a cup each for $2.99.
  */

import java.text.DecimalFormat;//Imports the function DecimalFormat is the class text
public class IceCreamOrder 
{
   //Declare the following instance variables
   private String flavor;
   private String vessel;
   private String amount;
   private double unitPrice;
   private int quantity;
   /**A default constructor. It initializes all of the instance variables of this object based on
     *the input values it receives from the customer in four steps:
     */
   public IceCreamOrder()
   {
	   this.flavor=null;
	   this.vessel=null;
	   this.amount=null;
	   this.unitPrice=0.0;
	   this.quantity=0;
   }
   //A normal constructor. Initializes the instance variables with supplied values.
   public IceCreamOrder(String flavor, String vessel,String amount,double unitPrice, int quantity)
   {
	   this.flavor=flavor;
	   this.vessel=vessel;
	   this.amount=amount;
	   this.unitPrice=unitPrice;
	   this.quantity=quantity;
   }
   /**A normal constructor. Delegates initialization tasks to the constructor above with
     *quantity set to 1.
     */
   public IceCreamOrder(String flavor, String vessel,String amount,double unitPrice)
   {
	   this.flavor=flavor;
	   this.vessel=vessel;
	   this.amount=amount;
	   this.unitPrice=unitPrice;
	   this.quantity=1;
   }
   //The following get method return the values accordingly.
   public String getflavor()
   {
	   return flavor;
   }
   public String getvessel()
   {
	   return vessel;
   }
   public String getamount()
   {
	   return amount;
   }
   public int getquantity()
   {
	   return quantity;
   }
   public double getunitPrice()
   {
	   return unitPrice;
   }
   //The method set the value of flavor according to the user's choice
   public void setflavor(int flavor_choice)
   {
	   switch(flavor_choice)
	   {
	     case 1:
	    	 flavor="Avocado";break;
	     case 2:
	    	 flavor="Banana";break;
	     case 3:
	    	 flavor="Chocolate";break;
	     case 4:
	    	 flavor="Hazelnut";break;
	     case 5:
	    	 flavor="Lemon";break;
	     case 6:
	    	 flavor="Mango";break;
	     case 7:
	    	 flavor="Mocha";break;
	     case 8:
	    	 flavor="Vanilla";break;
	   }
   }
 //The method set the value of vessel according to the user's choice
   public void setvessel(int vessel_choice)
   {
	   switch(vessel_choice)
	   {
	     case 1:
	    	 vessel="Cone";break;
	     case 2:
	    	 vessel="Cup";break;
	     case 3:
	    	 vessel="Sundae";break;
	     
	   }
   }
 //The method set the value of amount according to the user's choice
   public void setamount(int amount_choice)
   {
	   switch(amount_choice)
	   {
	     case 1:
	    	 amount="Single Scoop";break;
	     case 2:
	    	 amount="Double Scoop";break;
	     case 3:
	    	 amount="Triple Scoop";break;     
	   }
   }
 //The method set the value of quantity according to the user's choice
   public void setquantity(int quantity_choice)
   {
	   quantity=quantity_choice;
   }
   //The method returns quantity * unitPrice
   public double price()
   {
	   return quantity*unitPrice;
   }
 //The method set the value of unitPrice according to the user's choice(vessel and amount).
   public void setunitPrice()
   {
	   if(vessel.equalsIgnoreCase("Cup")&&amount.equalsIgnoreCase("Single Scoop"))
		   unitPrice=2.99;
	   else if(vessel.equalsIgnoreCase("Cone")&&amount.equalsIgnoreCase("Single Scoop"))
		   unitPrice=3.49;
	   else if(vessel.equalsIgnoreCase("Sundae")&&amount.equalsIgnoreCase("Single Scoop"))
		   unitPrice=4.15;
	   else if(vessel.equalsIgnoreCase("Cup")&&amount.equalsIgnoreCase("Double Scoop"))
		   unitPrice=3.99;
	   else if(vessel.equalsIgnoreCase("Cone")&&amount.equalsIgnoreCase("Double Scoop"))
		   unitPrice=4.49;
	   else if(vessel.equalsIgnoreCase("Sundae")&&amount.equalsIgnoreCase("Double Scoop"))
		   unitPrice=5.25;
	   else if(vessel.equalsIgnoreCase("Cup")&&amount.equalsIgnoreCase("Triple Scoop"))
		   unitPrice=4.99;
	   else if(vessel.equalsIgnoreCase("Cone")&&amount.equalsIgnoreCase("Triple Scoop"))
		   unitPrice=5.49;
	   else if(vessel.equalsIgnoreCase("Sundae")&&amount.equalsIgnoreCase("Triple Scoop"))
		   unitPrice=6.25;	  
   }
   //The method return a value of string as requirement.
   public String toString()
   {
	   DecimalFormat df=new DecimalFormat("#.00");
	   return quantity+" orders of "+amount+" of "+flavor+" ice cream in a "+vessel+" for $"+df.format(price())+" = "+quantity+" * "+df.format(unitPrice);
   }
}
