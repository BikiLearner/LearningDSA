//Strivers A2Z DSA Course/Sheet
//https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/
//patterns

/* Four steps for pattern
*   1) For the outer loops count the no of line
*   2) For inner loops focus on the columns and connect them somehow to the rows
*   3) Print inside the inner for loop
*   4) Observe symmetry (Optional)
* */
public class LearningPattern {

    public static void pattern1(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern2(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pattern3(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void pattern4(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void pattern5(int n){
        for(int i=n;i>=0;i--){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void pattern6(int n){
        for(int i=n;i>=0;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void pattern7(int n){
        for(int i=1;i<=n;i++){
            for (int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern8(int n){
        for(int i=n;i>=0;i--){
            for (int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=1;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void pattern9(int n){
        pattern7(n);
        pattern8(n);
    }
    public static void pattern10(int n){
        pattern2(n);
        pattern5(n);
    }

    public static void pattern11(int n){
        for (int i=1;i<=n;i++){
            for(int j=i;j>=1;j--){
                System.out.print((j % 2));
            }
            System.out.println();
        }
    }
    public static void pattern12(int n){
        for (int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            for(int j=1;j<=(n-i)*2;j++){
                System.out.print(" ");
            }
            for(int j=i;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void pattern13(int n){
        int count=0;
        for (int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(++count + " ");
            }
            System.out.println();
        }
    }
    public static void pattern14(int n){
        int count=0;
        for (int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print((char) (65+j) + " ");
            }
            System.out.println();
        }
    }
    //pattern 15 16 same

    public static void pattern17(int n){
        int count=0;
        for (int i=0;i<n;i++){
            for(int j=0;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print((char) (65+j));
            }
            for(int j=i;j>0;j--){
                System.out.print((char) (65+(j-1)));
            }
            System.out.println();
        }
    }

    public static void pattern18(int n){
        for(int i=0;i<n;i++){
            for (int j=n-1;j>=i;j--){
                System.out.println("*");
            }
            for (int j=n-1;j>=i;j--){
                System.out.println("*");
            }
        }
    }

}
