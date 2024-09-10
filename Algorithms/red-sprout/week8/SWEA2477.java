import java.io.*;
import java.util.*;
  
class Solution {
    static class Person {
        int time;
        int num;
        int receptionNum;
        int repairNum;
          
        Person(int time, int num) {
            this.time = time;
            this.num = num;
            this.receptionNum = 0;
            this.repairNum = 0;
        }
    }
      
    static class Desk {
        int remainTime;
        Person person;
    }
      
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        Queue<Person> receptionQ = new ArrayDeque<>();
        Queue<Person> repairQ = new ArrayDeque<>();
          
        for(int test = 1; test <= T; test++) {
            sb.append("#").append(test).append(" ");
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
              
            int[] receptionTime = new int[N + 1];
            int[] repairTime = new int[M + 1];
            Desk[] reception = new Desk[N + 1];
            Desk[] repair = new Desk[M + 1];
            Person[] people = new Person[K + 1];
              
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                receptionTime[i] = Integer.parseInt(st.nextToken());
                reception[i] = new Desk();
            }
              
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= M; i++) {
                repairTime[i] = Integer.parseInt(st.nextToken());
                repair[i] = new Desk();
            }
              
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++) {
                people[i] = new Person(Integer.parseInt(st.nextToken()), i);
            }
              
            int idx = 1;
            int cnt = 0;
            int passed = people[1].time;
            while(cnt < K) {             
                while(true) {
                    if(idx > K) break;
                    if(people[idx].time == passed) {
                        receptionQ.offer(people[idx++]);
                    } else {
                        break;
                    }
                }
                  
                for(int i = 1; i <= N; i++) {
                    Desk d = reception[i];
                    if(d.person != null && --d.remainTime <= 0) {
                        repairQ.offer(d.person);
                        d.person = null;
                    }
                    if(d.person == null && !receptionQ.isEmpty()) {
                        Person p = receptionQ.peek();
                        if(p.time <= passed) {
                            d.person = receptionQ.poll();
                            d.person.receptionNum = i;
                            d.remainTime = receptionTime[i];
                        }
                    }
                }
  
                for(int i = 1; i <= M; i++) {
                    Desk d = repair[i];
                    if(d.person != null && --d.remainTime <= 0) {
                        if(d.person.receptionNum == A && d.person.repairNum == B) {
                            answer += d.person.num;
                        }
                        cnt++;
                        d.person = null;
                    }
                    if(d.person == null && !repairQ.isEmpty()) {
                        Person p = repairQ.peek();
                        if(p.time <= passed) {
                            d.person = repairQ.poll();
                            d.person.repairNum = i;
                            d.remainTime = repairTime[i];
                        }
                    }
                }
  
                passed++;
            }
            sb.append(answer > 0 ? answer : -1).append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
