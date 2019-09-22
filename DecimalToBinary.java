import java.util.*;
public class DecimalToBinary {
    
    
    //main driver Code 
    public static void main (String []args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Put a Decimal value to convert it to Binary : ");
        double n = sc.nextDouble();//input
        //check for 0
        if (n==0){
            System.out.println(0);
            sc.close();
            return;
        }
        //check for fraction or not 
        int t = (int) n;
        if (n-t==0){
            printNf(n);
            System.out.println();
        }
        //asking for the digit number user want to get after Decimal point
        else{
            System.out.println("How many digit you want after the decimal point ? : ");
            int k = sc.nextInt();
            printF(n,k);
        }
        sc.close();
    }
    /*
     * 
     *
     * Decimal to Binary Converter Code :)
     * By SazzadSowmik
     * 
     * 
     */
    
    //Converter for fraction decimal value 
    
    private static int[] toBinF(double n,int k){
        int arr[]=new int [k];
        int t=(int)n;
        double rem = n-t;
        int i=0;
        double sub=rem;
        while (i<k){
            
            rem=sub*2;
            sub=rem;
            if (sub>1){
                arr[i]=1;
                sub = rem - 1;
            }
            else if (sub<1){
                arr[i]=0;
            }
            else {
                arr[i]=1;
                break;
            }
            i++;
        }
        return arr;
    }
      
    //Convereter for non-fraction decimal value
    
    
    private static int[] toBinNf(double n){
        int t = (int) n;
        int div = t;
        List<Integer> arr = new ArrayList<Integer>();//using dynamic array
        while(div!=0){
            arr.add(div%2);
            div/=2;
        }
        int a[] = new int[arr.size()];
        //putting value of the array from ArrayList(Optional Work)
        for (int i=0;i<a.length;i++){
            a[i]=arr.get(i);
        }
        return a;
    }
    
    //print Binary before the decimal point
    public static void printNf(double n){
        int a[]=toBinNf(n);
        //remember the reverse order 
        for (int i=a.length-1;i>=0;i--){
            System.out.print(a[i]);
        }
        
    }
    
    //print Binary after the decimal point
    public static void printF(double n,int k){
        printNf(n);
        System.out.print(".");
        int a[]=toBinF(n,k);
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println();
    }
    /*
     *N.B. : I just followed the general Simple dividing rule to convert Decimal to Binary ...
     */
}