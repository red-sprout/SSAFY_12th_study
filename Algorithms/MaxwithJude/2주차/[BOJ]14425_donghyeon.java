public class Main{
    public static void main(String[] args) throws IOException{
2weekBoj14425
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> li = new ArrayList<String>();
        List<String> li2 = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for(int i = 0; i < N; i++){
            li.add(br.readLine());
        }

        for(int k = 0; k<M; k++){
            li2.add(br.readLine());
        }

        for(int i = 0; i < N ; i++){
            for(int k = 0 ; k < M ; k++){
                if(li.get(i).equals(li2.get(k))){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        
    }
}
