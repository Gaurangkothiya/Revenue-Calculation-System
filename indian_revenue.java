import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
abstract class Industries
{
	
	int MCA21;
	int income;
	int revenue;
	int LabourCost;
	abstract public void TotalCost(); 
	int  TotalRevenue(String filename)
	{
		int sum=0;
		try
		{
			FileReader fileReader = new FileReader(filename);
			int count=0;
			int data = fileReader.read();
			if(data==-1)
				return 0;
			while(data != -1) 
			{
				data = fileReader.read();
	
				if(count==4 && (char)data >= '0' && (char)data <= '9')
				{
					sum = (10 * sum) + (data-48);
				}
		
				if((char)data==' ')
					count++;
				else if((char)data=='#')
				{
					count = 0;
					data = fileReader.read();
					if(data == -1)
					{}	
					else 
					{
						System.out.println("----->" + (char)data + "<---------");
						sum = 0;
					}
				}
			}
			fileReader.close();
		}
		catch(IOException e)
		{
		}
		return sum;
	}
}
class Upstream extends Industries
{
	int RawMaterialcost;
	Upstream(int code,int i,int lc,int rc)
	{
	MCA21=code;
	income=i;
	LabourCost=lc;
	RawMaterialcost=rc;
	}
	
	
	 public void  TotalCost()
		{
			 revenue=income-LabourCost-RawMaterialcost;
			 System.out.println("Revenue of company with MCA code  "+MCA21+ "is :"+revenue ); 
			 try
			 {
			  FileWriter myWriter = new FileWriter("Upstream.txt",true);
			  myWriter.write(Integer.toString(revenue + TotalRevenue("Upstream.txt")));
			  myWriter.write(" #");
			  myWriter.close();
			 }
			 catch(IOException e)
			 {
				 System.out.println("IOException");
			 }
		}
	
}
class Midstream extends Industries
{
  int IntermediateGoodsCost;
  Midstream(int code,int i,int lc,int ic)
	{
	MCA21=code;
	income=i;
	
	LabourCost=lc;
	IntermediateGoodsCost=ic;
	}
  	 public void TotalCost()
		{
			 revenue=income-LabourCost-IntermediateGoodsCost;
			 System.out.println("Revenue of company with MCA code  "+MCA21+ "is :"+revenue ); 
			 try
			 {				 
			  FileWriter myWriter = new FileWriter("Midstream.txt",true);
			  myWriter.write(Integer.toString(revenue + TotalRevenue("Midstream.txt")));
			  myWriter.write(" #");
			  myWriter.close();
			 }
			  catch(IOException e)
			 {
			 }
		}
  
 }
 class Downstream extends Industries
 {
	int TechnologyCost;
	Downstream(int code,int i,int lc,int tc)
	{
	MCA21=code;
	income=i;
	LabourCost=lc;
	TechnologyCost=tc;
	}
		public void  TotalCost()
		{
			revenue=income-LabourCost-TechnologyCost;
			System.out.println();
			System.out.println("Revenue of company with MCA code  "+MCA21+ "is :"+revenue ); 
			try
			{
			FileWriter myWriter = new FileWriter("Downstream.txt",true);
			myWriter.write(Integer.toString(revenue + TotalRevenue("Downstream.txt")));
			myWriter.write(" #");
			myWriter.close();
			}
			  catch(IOException e)
			 {
			 }
		}
 }


class indian_revenue
{  
     public static void main(String args[])
     {
		int MCA21,GrossInc,LCost,IGCost,RMCost,TCost;
        Scanner sc=new Scanner(System.in);
        System.out.println("");
        
	
	    System.out.println(" |  "+" WELCOME TO MINSTRY OF CORPORATE AFFAIRS PORTAL "+"    |");                                    
		System.out.println();
        Industries i1;
		
		
        while(true)
        {
			try
			{
				
            System.out.println("enter your category\n1.upstream\n2.midstream.\n3.downstream\n4.exit\n");
            int x;
            x = sc.nextInt();
            
            if( x==1 )
            {
                 
				File myobj=new File("Upstream.txt");
				
				FileWriter myWriter = new FileWriter("Upstream.txt",true);
				System.out.println();
                System.out.println("Enter MCA21 code");
	            MCA21=sc.nextInt();
				myWriter.write(Integer.toString(MCA21));
				myWriter.write(" ");
				System.out.println();
                System.out.println("Enter gross income");
                GrossInc = sc.nextInt();
				System.out.println();
				myWriter.write(Integer.toString(GrossInc));
				myWriter.write(" ");
                System.out.println("enter labour cost");
                LCost = sc.nextInt();
				myWriter.write(Integer.toString(LCost));
				myWriter.write(" ");
				System.out.println();
                System.out.println("enter raw material cost ");
                RMCost = sc.nextInt();
				myWriter.write(Integer.toString(RMCost));
				myWriter.write(" ");
                myWriter.close();
				 
				i1 = new Upstream(MCA21,GrossInc,LCost,RMCost);
                i1.TotalCost();
				System.out.println("entry done");
					
			}

            else if(x==2)
            {
               
				                 
				File myobj=new File("Midstream.txt");
				System.out.println("Fle path:"+myobj.getAbsolutePath());
				FileWriter myWriter = new FileWriter("Midstream.txt",true);
				System.out.println();
                System.out.println("Enter MCA21 code");
				MCA21=sc.nextInt();
				myWriter.write(Integer.toString(MCA21));
				myWriter.write(" ");
				System.out.println();
                System.out.println("Enter gross income");
                GrossInc = sc.nextInt();
				myWriter.write(Integer.toString(GrossInc));
				myWriter.write(" ");
				System.out.println();
                System.out.println("enter labour cost");
                LCost = sc.nextInt();
				myWriter.write(Integer.toString(LCost));
				System.out.println();
                System.out.println("enter intermediate good cost ");
                IGCost = sc.nextInt();
			    myWriter.write(" ");
				myWriter.write(Integer.toString(IGCost));
                i1 = new Midstream(MCA21,GrossInc,LCost,IGCost);
                i1.TotalCost();
                System.out.println("entry done");
				myWriter.close();
					

            }

            else if(x==3)
            {
              
			                   
				File myobj=new File("Downstream.txt");
				System.out.println("Fle path:"+myobj.getAbsolutePath());
				FileWriter myWriter = new FileWriter("Downstream.txt",true);
				System.out.println();
				System.out.println("Enter MCA21 code");
				MCA21=sc.nextInt();
				myWriter.write(Integer.toString(MCA21));
				myWriter.write(" ");
				System.out.println();
				System.out.println("Enter gross income");
				GrossInc = sc.nextInt();
				myWriter.write(Integer.toString(GrossInc));
				myWriter.write(" ");
				System.out.println();
				System.out.println("enter labour cost");
				LCost = sc.nextInt();
				myWriter.write(Integer.toString(LCost));
				myWriter.write(" ");
				System.out.println("enter Technology cost ");
				TCost = sc.nextInt();
				myWriter.write(Integer.toString(TCost));
				i1 = new Downstream(MCA21,GrossInc,LCost,TCost);
				i1.TotalCost();
                System.out.println("entry done");
				myWriter.close();
				
			}
			else  break;
			}
			catch(InputMismatchException e)
			{
			System.out.println("You have entered invalid input ");
			System.out.println("Please retry");
			sc.next();
			}
			catch(IOException e)
			{
				
			System.out.println("Error occured");
			
			}
		
		}
		
     
            System.out.println("Thank you using  Portal");
	 }
}