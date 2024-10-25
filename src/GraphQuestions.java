import java.util.ArrayList;
import java.util.Scanner;

public class GraphQuestions {


    public static int[][] undirectedGraph(Scanner sc ,int n,int edges){

        int [][] adjMatrix = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            int u= sc.nextInt();
            int v=sc.nextInt();
            adjMatrix[u][v]=1;
            adjMatrix[v][u]=1;
        }
        return adjMatrix;
    }
    public static ArrayList<ArrayList<Integer>> undirectedGraphArrayList(Scanner sc ,int n,int edges){

        ArrayList<ArrayList<Integer>> ajdList=new ArrayList<>();
        for(int i=0;i<=n;i++){
            ajdList.add(new ArrayList<>());
        }
        for(int i=0;i<=n;i++){
            int u= sc.nextInt();
            int v=sc.nextInt();
            ajdList.get(u).add(v);
            ajdList.get(v).add(u);
        }
        return ajdList;
    }

    public static void main(String[] args){

    }

}
