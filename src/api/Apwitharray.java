package api;

import org.testng.Assert;

import files.Resuablemethods;
import io.restassured.path.json.JsonPath;


public class Apwitharray {
	public static void main(String[] args) {
	JsonPath a =new JsonPath(Resuablemethods.CoursePrice());
	int k = a.getInt("courses.size()");
	//System.out.println(k);
	int pramt = a.get("dashboard.purchaseAmount");
	//System.out.println(pramt);
	String s = a.get("courses[0].title");
	//System.out.println(s);
for (int i=0;i<k;i++)
{
	String z = a.get("courses["+i+"].title");
	int x = a.get("courses["+i+"].price");
	System.out.println(z +" ," + x);
}
for (int i=0;i<k;i++)
{
	String z = a.get("courses["+i+"].title");
	if(z.equalsIgnoreCase("RPA"))
	{
		int c = a.get("courses["+i+"].copies");
		System.out.println("no of RPa coppies sold "+ c);
		break;
	}
	}

int tind =0;
for (int i=0;i<k;i++)
	
{
	int p = a.get("courses["+i+"].price");
	int c = a.get("courses["+i+"].copies");
	
	int ind =p*c;
	 tind = tind+ind;
		
	}System.out.println("sum of all the copies sold "+ tind);
	
	Assert.assertEquals(tind, pramt);
}

}
