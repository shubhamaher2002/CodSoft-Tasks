import java.util.Scanner;
class Student {
	int roll_no;
	String name;
	int m[]=new int[5];
	int total,i;
	float avg;
    void Accept(){
       @SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
       System.out.println ("Enter Name");
       name=sc.nextLine();
       System.out.println ("Enter Roll_no");
       roll_no=sc.nextInt();
       for(i=0;i<5;i++) {
           System.out.println ("Enter Marks for subject :"+(i+1));
           m[i]=sc.nextInt();
       }
    } 
    void cal() {  
    	total=0;
        for(i=0;i<5;i++) {
        	total=total+m[i];
        }  
        avg=total/5; 
    }    
    void display() {
    	System.out.println ("\n Name:" +name);
        System.out.println ("roll no:" +roll_no);
        System.out.println ("total:" +total);
        System.out.println ("avg:" +avg);
        if(avg<35) {
        	System.out.println ("Grade: Fail");
        }
        else if(avg>=35 && avg<45) {
        	System.out.println ("Grade: C ");
        }
        else if(avg>=45 && avg<55) {
        	System.out.println ("Grade: B");
        }
        else if(avg>=55 && avg<65) {
        	System.out.println ("Grade: A");
        }
        else {
        	System.out.println ("Grade: A+");
        }  
     }
}
public class Grade_Calc {
    public static void main (String[] args) {
    	Student s[]=new Student[5];
    	int i;
    	@SuppressWarnings("resource")
    	Scanner sc =new Scanner(System.in);
    	System.out.println ("Enter How many student");
    	int n=sc.nextInt();
    	for(i=0;i<n;i++) {
    		s[i]=new Student();
    		s[i].Accept();
    		s[i].cal();
    	}
    	for(i=0;i<n;i++) {
    		s[i].display();
    	}
    	//highest score
    	double temp=s[0].avg;
    	int t=0;
    	for(i=0;i<n;i++) {
    		if(temp<s[i].avg) {
    			temp=s[i].avg;
    			t=i;
    		}
    	}
    	System.out.println ("\n\n***Highest Score Student is*** ");
    	s[t].display();
    } 
}