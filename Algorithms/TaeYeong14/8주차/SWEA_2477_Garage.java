import java.io.*;
import java.util.*;
 
public class SWEA_2477_Garage {
    static int N,M,K,A,B,ans,ai[],bi[];
    static ArrayDeque<int[]> tk=new ArrayDeque<>();//접수는 순서대로
    static PriorityQueue<int[]> repair=new PriorityQueue<>((o1,o2)->(o1[1]!=o2[1])? Integer.compare(o1[1],o2[1]):Integer.compare(o1[2],o2[2]));//접수완료후 정비에 도착시간,접수창구번호가빠른순
     
    static void reception(){
        int time=0;
        int[] wait=new int[N+1];//접수는 N
        NEXT:while(!tk.isEmpty()){
            if(time<tk.peek()[1]){
               time=tk.peek()[1];
            }
            for(int i=1; i<=N; i++){
                if(wait[i]<=time){
                   wait[i]=time+ai[i];
                   int[] p=tk.poll();
                   repair.offer(new int[]{p[0],wait[i],i,i==A? 1:0});
                   continue NEXT;
                }
            }
            time++;
        }
    }
    static void repair(){
        int time=0;
        int[] wait=new int[M+1];//수리는 M
        NEXT:while(!repair.isEmpty()){
            if(time<repair.peek()[1]){
               time=repair.peek()[1];
            }
            for(int i=1; i<=M; i++){
                if(wait[i]<=time){
                   wait[i]=time+bi[i];
                   int[] p=repair.poll();
                   if(i==B && p[3]==1) ans+=p[0];
                   continue NEXT;
                }
            }
            time++;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            N=sc.nextInt();
            M=sc.nextInt();
            K=sc.nextInt();
            A=sc.nextInt();
            B=sc.nextInt();
            ai=new int[N+1]; for(int i=1; i<=N; i++) ai[i]=sc.nextInt();
            bi=new int[M+1]; for(int i=1; i<=M; i++) bi[i]=sc.nextInt();
            for(int k=1; k<=K; k++) tk.offer(new int[]{k,sc.nextInt(),0,0});//고객번호0,도착시간1,접수창구2,같은A접수창구면3
            ans=0;
            reception();
            repair();
            System.out.println("#"+tc+" "+(ans==0? -1:ans));
        }
        sc.close();
    }
}
