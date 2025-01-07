package nana;

import java.io.*;
import java.util.*;

public class Code_메이즈러너 {
	
    static int[][][][] peopleMap;
    static int[][][] wallMap;
    static Pair exit;
    static int N, M, K, exitCnt, moveCnt;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        peopleMap = new int[N][N][K + 1][2];
        wallMap = new int[N][N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                wallMap[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            peopleMap[y][x][0][1] += 1;
        }

        st = new StringTokenizer(br.readLine());
        int exitY = Integer.parseInt(st.nextToken()) - 1;
        int exitX = Integer.parseInt(st.nextToken()) - 1;
        exit = new Pair(exitY, exitX);
        wallMap[exit.y][exit.x][0] = -1;

        for (int i = 1; i <= K; i++) {
            step1_MovePeople(i);
            if (exitCnt == M) break;
            step2_SpinMap(i);
        }
        System.out.println(moveCnt);
        System.out.print((exit.y) + 1 + " " + (exit.x + 1));
    }

    static void step1_MovePeople(int turn) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (peopleMap[i][j][turn - 1][1] > 0) {
                    boolean move = false; // 이동여부 판단
                    for (int k = 0; k < 4; k++) {
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];
                        // 출구로 나갔거나 아니거나 일단 이동, 출구로 나갔으면 복사X, 못나갔으면 복사O
                        if (canGo(i, j, nextY, nextX, turn - 1)) {
                            if (nextY == exit.y && nextX == exit.x) {
                                exitCnt += peopleMap[i][j][turn - 1][1];
                            } else {
                                peopleMap[nextY][nextX][turn][0] += peopleMap[i][j][turn - 1][1];
                            }
                            moveCnt += peopleMap[i][j][turn - 1][1];
                            move = true;
                            break;
                        }
                    }
                    // 이동 못한 경우, 기존 위치 그대로 복사
                    if (!move) {
                        peopleMap[i][j][turn][0] += peopleMap[i][j][turn - 1][1];
                    }
                }
            }
        }
    }

    static boolean canGo(int curY, int curX, int nextY, int nextX, int turn) {
        if (outOfRange(nextY, nextX)) return false;
        if (wallMap[nextY][nextX][turn] > 0) return false;
        if (checkDistance(nextY, nextX) >= checkDistance(curY, curX)) return false;
        return true;
    }

    static boolean outOfRange(int y, int x) {
        return y < 0 || x < 0 || y >= N || x >= N;
    }

    static int checkDistance(int y, int x) {
        return Math.abs(exit.y - y) + Math.abs(exit.x - x);
    }

    static void step2_SpinMap(int turn) {
        Pair[] smallestBox = findSmallestBox(turn);
        Pair start = smallestBox[0];
        Pair end = smallestBox[1];
        spinning(turn, start, end);

    }

    static Pair[] findSmallestBox(int turn) {
        Pair[] result = new Pair[2];

        // 정사각형 사이즈 2부터 N까지 늘려보면서 찾기
        for (int i = 2; i <= N; i++) {
            // 시작 y, x 좌표
            for (int j = 0; j <= N - i; j++) {
                for (int k = 0; k <= N - i; k++) {
                    // 실제 탐색구간
                    int endY = j + i - 1;
                    int endX = k + i - 1;
                    boolean containExit = false;
                    boolean containHuman = false;
                    for (int l = j; l <= endY; l++) {
                        for (int m = k; m <= endX; m++) {
                            if (peopleMap[l][m][turn][0] > 0) containHuman = true;
                            if (exit.y == l && exit.x == m) containExit = true;
                            if (containHuman && containExit) {
                                result[0] = new Pair(j, k);
                                result[1] = new Pair(endY, endX);
                                return result;
                            }
                        }
                    }
                }
            }
        }
        //예외 체크
        return result;
    }

    static void spinning(int turn, Pair start, Pair end) {
        //1. 현재 턴으로 wallMap 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                wallMap[i][j][turn] = wallMap[i][j][turn - 1];
                peopleMap[i][j][turn][1] = peopleMap[i][j][turn][0];
            }
        }
        //2. 정사각형 사이즈 체크하고 tmpBox 만들기

        int size = end.y - start.y + 1;
        int[][] tmpBox = new int[size][size];
        int[][] tmpPeople = new int[size][size];

        //3. 구했던 정사각형을 tmpBox로 복사 -> 좌측 최상단으로 박스를 이동시키기 위함
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tmpBox[i][j] = wallMap[i + start.y][j + start.x][turn];
                tmpPeople[i][j] = peopleMap[i + start.y][j + start.x][turn][1];
            }
        }
        //4. tmpBox 회전 후 원본에 적용
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                wallMap[i + start.y][j + start.x][turn] = tmpBox[size - 1 - j][i];
                peopleMap[i + start.y][j + start.x][turn][1] = tmpPeople[size - 1 - j][i];

                if (wallMap[i + start.y][j + start.x][turn] != 0 && wallMap[i + start.y][j + start.x][turn] != -1) {
                    wallMap[i + start.y][j + start.x][turn]--;
                }
                if (wallMap[i + start.y][j + start.x][turn] == -1) {
                    exit.y = i + start.y;
                    exit.x = j + start.x;
                }
            }
        }
    }

    static class Pair {
        int y;
        int x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}