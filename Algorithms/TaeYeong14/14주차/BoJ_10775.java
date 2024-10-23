import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine()); // 게이트의 수
        int P = Integer.parseInt(br.readLine()); // 비행기의 수

        // 부모 배열 초기화: 각 게이트가 자기 자신을 부모로 가짐
        parent = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        int dockedCount = 0; // 도킹된 비행기의 수

        for (int i = 0; i < P; i++) {
            int gi = Integer.parseInt(br.readLine()); // i번째 비행기의 도킹 가능한 최대 게이트

            // 도킹 가능한 가장 큰 게이트 찾기
            int availableGate = find(gi);

            // 도킹 가능한 게이트가 없으면 공항 폐쇄
            if (availableGate == 0) {
                break;
            }

            // 해당 게이트에 도킹하고, 그 다음 가능한 게이트로 병합
            union(availableGate, availableGate - 1);
            dockedCount++;
        }

        System.out.println(dockedCount); // 도킹된 비행기의 수 출력
    }
    
    // find 함수: 특정 게이트의 대표자를 찾고, 경로 압축을 수행
    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // union 함수: 두 게이트를 하나의 집합으로 합침
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }
}
