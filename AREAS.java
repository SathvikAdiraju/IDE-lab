import java.util.Scanner;
public class Area {
	
	public static void main(String[] args) 
	{
		 Scanner s=new Scanner(System.in);
         
         System.out.println("MENU:");
         System.out.println("1.Area of a Circle");
         System.out.println("2.Area of a Square");
         System.out.println("3.Area of a Rectangle");
         System.out.println("4.Area of Triangle");
         System.out.println("5.Exit");


         System.out.println("Enter your option:");
         int op=s.nextInt();

         switch(op)
         {
               case 1: System.out.println("Enter radius for cirlce area:");
                           float r=s.nextFloat();
                           float ac=3.14f*r*r;
                          System.out.println("Area:"+ac);
                          break;

              case 2: System.out.println("Enter side:");
                           int x=s.nextInt();
                           int as=x*x;
                          System.out.println("Area:"+as);
                          break;

             case 3: System.out.println("Enter length and breadth:");
                           int l=s.nextInt();
                           int b=s.nextInt();
                           int ar=l*b;
                          System.out.println("Area:"+ar);
                          break;
             case 4: System.out.println("Enter breadth and height:");
             int hg=s.nextInt();
             int br=s.nextInt();
             int ara=(hg*br)/2;
             
            System.out.println("Area:"+ara);
            break;


              default:System.out.println("Exit");
             }
	     
}
}