# 자료구조
### 종류
- 배열 (Array)
- 연결리스트 (Linked List)
- 행렬 (Matrix)
- 스택 (Stack) : LIFO
- 큐 (Queue) : FIFO
- 그래프 (graph)
- 트리 (tree)
- 힙 (heap)
---
- 선형 자료구조
  - 리스트
  - 스택
  - 큐
- 색인 자료구조
  - 검색 트리 
    - 이진 검색 트리
    - 균형 검색 트리
  - 해시 테이블
- 효율적인 자료구조
  - 우선순위 큐 : 힙
- 관계 처리 자료구조
  - 그래프

## 추상데이터 타입
- 추상 데이터 타입 (ADT : Abstract Data Type)
   - 세부 사항에서 벗어나 추상적으로 정의한 데이터 타입
   - 어떤 데이터 타입이 어떤 작업으로 이루어지는지만 표현한 것 (유일하지 않음)
```
ADT '리스트'
  작업 :
    i번째 자리에 새 원소 넣기
    원소 x 찾기
    i번째 자리의 원소 삭제하기
```
- 순서 : ADT설계 -> 인터페이스 설계 -> 클래스 설계 -> 사용자 프로그램

## 재귀 알고리즘
- 재귀 알고리즘 = 자기호출 알고리즘
  - 자신과 성격은 똑같지만 크기만 작은 알고리즘들을 호출하는 알고리즘
> 수열
```java
seq(n):
  if (n = 1)
    return 1
  else
    return seq(n-1) + 3
```
- 재귀가 치명적인 경우도 있음
> 피보나치 수열 : 지수함수적 중복 호출로 인해 비효율 발생
```java
# 재귀 버전
fib(n):
  if (n=1 or n=1)
    return 1
  else
    return fib(n-1) + fib(n-2)

# 비재귀 버전
fib_fast(n):
  f[1] <- f[2] <- 1
  for i <- 3 to n
    f[i] <- f[i-1] + f[i-2]
    return f[n]
```
> 팩토리얼
```java
public class Factorial {
  public static int factorial(int n){
    if (n <= 1)
      return 1;
    else 
      return n*factorial(n-1);
  }
  public static void main(String[] args){
    int result;
    result = factorial(4);
    System.out.println(result);
  }
}
```
> 선택정렬
1. 최대 원소를 찾음
2. 최대 원소와 맨 오른쪽 원소를 자리 바꿈
3. 맨 오른쪽 자리를 관심 대상에서 제외
4. 원소가 1개 남을때까지 1~3 반복

### 재귀 알고리즘의 필수 구비조건
- 순환으로 구현된 메소드는 두 부분으로 구성
  - 기본(Base) case : 스스로를 더 이상 호출하지 않는 부분
  - 순환 case : 스스로를 호출하지 않는 부분

## 알고리즘 수행시간, 복잡도
- 입력크기 n에 대해 시간이 얼마나 걸리는지로 표현
  - 정렬 : 정렬할 원소의 수
  - 색인 : 색인에 포함될 원소의 수
- 함수의 증가율
  - 2^n > n^3 > n^2 > nlogn > n > log n

- 알고리즘 범주
  - `상수 시간` : 실행시간이 입력 크기에 의존하지 않음
  - `선형` : 실행시간이 입력의 크기에 비례
    - 배열이 있는 요소를 더한다면 n개 요소에 접근하여 n-1번 더하기 연산 -> 연산의 총 횟수 2n-1이고 n에 비례
  - `이차` : 실행시간이 n^2에 비례

### 알고리즘의 점근적 복잡도
- 입력의 크기가 충분히 클 때의 복잡도
  - 최대, 최악 O(N) : 최고차항의 차수가 n을 넘지 않는 모든 함수의 집합
  - 최소, 최선 Ω(n) : 최고차항의 차수가 n보다 작지 않은 모든 함수의 집합
  - 동일, 항상 Θ(n) : 최고차항의 차수가 항상 n인 모든 함수의 집합

## Java 기초 문법
### 클래스
- 객체(object)를 만들기 위해선 class가 필요
```java
// 클래스
Class Heap
// 필드
private int[] A;
private int numItems;
// 생성자
public Heap(int n) {
  A = new int[n];
  numItem = 0;
}
// 메서드
public boolean isEmpty() {
  return numItems == 0;
}
public void insert(int newItems){
  ...
}
```

### 변수의 타입과 상수
- 정수 타입
  - byte (1byte)
  - short (2byte)
  - int (4byte)
  - long (8byte)
- 실수 타입
  - float (4byte)
  - double (8byte)
- 논리 타입
  - boolean (1bit, true or false)
- 문자 타입
  - char (2byte)

### 함수에 변수나 배열 넘기기
- 복사호출 (복사본이 전달됨)
```java
void twofold(int a){
  a = 2 * a
}

x = 5;
twofold(x);

```
- 참조호출
```java
SampleAccess(int B[], int n){
  B[n] = 8;
}
int[] A = new int[10];
a[5] = 7;
int k = 5;
sampleAccess(A, k);

// 배열 A와 배열 B는 같은 주소를 가리키고 있음
```

### 상속(inheritance)

```java
public class InheritedStack extends LinkedList{
  public InheritedStack() {
    super(); //Linkedlist의 생성자를 호출
  }
  ...
}
```
- `extends` 사용
- LinkedList 내의 모든 내용을 사용 + 새로운 내용 추가
- 상속한 클래스 : super class
- 상속받은 클래스 : 자식 클래스, sub class

### 인터페이스

- 인터페이스
  - `implements` 사용
  - 두 개 이상 동시 구현 가능
    - 상속 : 하나만 가능
```java
public class Float ... implements Comparable<Float>{
  ...
  public int compareTo(Float f) {
    ...
  }
}
```
- Comparable 인터페이스는 CompareTo 메소드를 재정의(붙여서)하여 두 개의 객체를 비교
  - 각각 다른 클래스를 선언할 때마다 객체들을 정렬하기 위해 별도의 비교 메소드를 일일이 선언해야하는 불편함을 덜어줌
- Comparator 인터페이스 안에 Compare 메서드도 있음

### wrapper Class
-  기본 타입을 클래스화함
  - 앞이 대문자로 바뀜
    - byte -> Byte
    - short -> Short
    - int -> Integer
    - char -> Character
    - float -> Float
    ...
    
> 추상메소드 : 내용은 없음

### 컬렉션
- 요소라고 불리는 가변 개수의 객체들의 저장소
- 배열은 원소의 개수가 정해져 있으나, 이와 달리 가변개수의 객체들은 원소의 개수를 바꿀 수 있음
- 요소의 개수에 따라 크기 자동 조절
- 컬렉션은 삭제에 따른 요소의 위치가 자동 이동
- 컬렉션은 자바 인터페이스 : set, list, queue ...
- 컬렉션은 제네릭 기법으로 구현

### 제네릭
- 특정 타입만 다루지 않고, 여러 종류의 타입으로 변할 수 있도록 클래스나 메소드를 일반화시키는 기법
- 클래스나 인터페이스 이름에 `<E>, <K>, <V>` 등 타입 매개변수 포함
- 대표적 사례: `벡터 Vector<E>`
  - `<E>`에서 E에 구체적인 타입을 주어 구체적인 타입만 다루는 벡터로 활용
- 컬렉션의 요소는 객체만 가능
  - int말고 `<Integer>`

`벡터 Vector<E>의 특성`
- 배열을 가변 크기로 다룰 수 있게 하는 컨테이너
- 요소 객체들을 삽입, 삭제, 검색하는 컨테이너
`Vector<Integer> v = new Vector<Integer>();

`ArryList<E>`
- 벡터와 달리 스레드 동기화 기능 없음

### Iterator
- 리스트 구조의 컬렉션에서 요소의 숫자 검색을 위한 인터페이스
  - hasnNext()
  - next()
  - remove()

## 인터페이스

### 리스트가 두 종류인 이유 (ArrayList, LinkedList)
- 프로파일링 : 어떤 응용 프로그램에 어느 클래스가 더 좋을지 결정하는 방법

### 자바 interface
- `interface` : 메서드 집합

### List interface
- `JCF(Java Collection Framework)` : 인터페이스, 추상 클래스 등 객체 그룹을 조작하고 저장할 수 있는 아키텍쳐를 제공. 
  - 데이터 구조에서 수행할 수 있는 다양한 작업으로 구성된 클래스와 인터페이스 그룹인 컬렉션 프레임워크.
  - 모든 데이터 구조에서 일관되게 작동하고 효율적으로 작업을 수행하는 공통 인터페이스
- `Collection` : 객체 그룹. 두 개 이상의 객체로 구성된 단일 단위
- `Framework` : 기성 기능 인터페이스 또는 아키텍쳐가 있는 소프트웨어

  [참고 사이트](https://www.softwaretestinghelp.com/java/java-collections-framework/#:~:text=Java%20Collections%20Framework%20(JCF)%20contains,manipulate%20a%20group%20of%20objects.)

- ArrayList와 LinkedList는 List로 동작하는 메서드를 공유
- 라이브러리를 사용할 때 코드는 List와 같은 인터페이스에 의존하고 ArrayList 클래스와 같은 특정 구현에 의존해서는 안됨
  - 나중에 구현이 변경되어도 인터페이스를 사용하는 코드는 그대로 사용 가능

## 리스트
- 일련의 동일한 타입의 항목(item)들
- `리스트의 구현`
  - 1차원 배열
  - 단순연결리스트
  - 이중연결리스트 : 순방향, 역방향으로 연결
  - 환형연결리스트 : 노드의 시작과 끝이 연결(원형 구조)

## 배열 (Array)
- 동일한 타입의 원소들이 연속적인 메모리 공간에 할당되어 각 항목이 하나의 원소에 저장되는 기본적인 자료구조
### 특징
-  특정 원소에 접근할 때에는 배열의 인덱스를 이용하여 O(1) 시간에 접근 가능
- 새 항목이 배열 중간에 삽입 또는 삭제되면, 뒤 따르는 항목들을 한 칸씩 뒤로 또는 앞으로 이동시켜야 하므로 삽입이나 삭제 연산은 항상 O(1) 시간에 수행할 수 없음 --> 최악의 경우 O(N) 시간이 걸림
- `1차원 배열의 일반적인 표현`

    array a
    |0|1|2|3|4|5|6|7|
    |---|---|---|---|---|---|---|---|
  - a가 배열 이름인 동시에 배열의 첫번째 원소의 레퍼런스(주소)를 저장
  - a[i]는 인덱스 i를 가지는 원소를 가리키는 레퍼런스
  - 각 원소 a[i]는 a를 가지고 있는 레퍼런스에 원소의 크기(바이트) X i를 더하여 a[i]의 레퍼런스를 계산
  - a[i] = a + (원소의 크기 *i)
  - char 배열의 원소의 크기 = 2바이트, int 배열의 원소의 크기 = 4바이트

### Overflow 
- 배열은 미리 정해진 크기의 메모리 공간을 할당 받은 뒤 사용해야하므로, 빈자리가 없어 새 항목을 삽입할 수 없는 상황(overflow) 발생 -> 
- overflow 발생 시 에러 처리를 하여 프로그램을 정지시키는 방법이 주로 사용 됨. 하지만 프로그램의 안정성을 향상시키기 위해 다음과 같은 방법을 사용
- 배열에 overflow가 발생하면 배열 크기를 2배로 확장. 배열의 3/4가 비어있다면 배열 크기롤 1/2로 축소 -> 동적배열
- 동적배열(dynamic array) : 프로그램이 실행되는 동안에 할당된 배열

### ArrayList
- 리스트를 배열로 구현: ArrayList 클래스
```java
import java.util.NosuchElementException; // 리스트가 empty인 상황에서 항목을 읽으려고 하면(underflow 발생 시) 프로그램을 정지시키는 예외처리
public class ArrList <E> {
  private E a[]; // 리스트의 항목들을 저장할 배열
  private int size; // 리스트의 항목 수
  public ArrList() {
    a = (E[]) new Object[1]; // 최초로 1개의 원소를 가진 배열 생성
    size = 0; // 항목 수를 0으로 초기화
  }
  // 탐색, 삽입, 삭제 연산을 위한 메소드 선언
}
```

```java
public E peek(int k) { // k번째 항목을 리턴, 단순히 읽기만 함
  if (size == 0)
    throw new NosuchElementException(); // underflow 경우 프로그램 정지
  return a[k];
}
```
```java
public void insertLast(E newItem){ // 가장 뒤에 새 항목 삽입
  if (size == a.length) // 배열에 빈 공간이 없으면
    resize(2*a.length); // 배열 크기 2배로 확장
  a[size] = newItem; // 새 항목 삽입
}
```
```java
public void insert(E newItem, int k) { // 새 항목을 k-1번째 항목 다음에 삽입
  if (size == a.length)
    resize(2*a.length);
    for (int i = size-1; i >= k; i--) a[i+1] = a[i] // 한 칸씩 뒤로 이동
    a[k] = newItem;
    size++;   
}

```
- 배열 삭제
- 배열 크기 축소

> 가비지 컬렉션: 메모리 상에 쓸모가 없어진 공간을 heap에 돌려보내는 것

### 수행시간
- peek() 메소드는 인덱스를 이용하여 배열 원소를 직접 접근하므로 O(1) 시간에 수행 가능
- 삽입이나 삭제는 최악의 경우 O(N)시간 소요
- 새 항목을 가장 뒤에 삽입하는 경우 O(1)시간 소요
- 배열의 크기를 확대 or 축소시키는 경우 최악의 경우 O(N)시간
- 상각분석(총 연산시간을 총 연산횟수로 나누어 수행시간 분석)삽입이나 삭제의 평균 수행시간은 O(1)

## 단순연결리스트
- 동적 메모리 할당을 이용해 리스트를 구현하는 가장 간단한 형태의 자료구조
  - 동적 메모리 할당을 받아 노드를 저장하고, 노드는 레퍼런스를 이용하여 다음 노드를 가리키도록 만들어 노드들을 한 줄로 연결.
  ㅁ->ㅁ->ㅁ->ㅁ->ㅁ
  - 삽입이나 삭제 시 항목들의 이동이 필요 없음
  - 연결리스트는 빈 공간이 존재X
  - 연결리스트에서 항목을 탐색하려면 항상 첫 노드부터 원하는 노드를 찾을 때깢 차례로 방문하는 순차탐색을 해야 함
- 예시
```java
public class Node <E> {
  private E item;
  private Node<E> next;
  public Node (E newItem, Node<E> node){ //생성자
    item = newItem;
    next = node;
  }
  // get, set 메소드
  public E getItem(){return item;}
  public Node<E> getNext(){return next;}
  public void setItem(E newItem) {item = newtItem;}
  public void setNext(Node<E> newNext){next = newNext;}
}
```
  - Node 객체는 항목을 저장할 item과 Node 레퍼런스를 저장하는 next를 가짐
- 탐색
```java
public int search(E target){ //target을 탐색
  Node p = head;
  for (int k = 0; k < size ; k++){
    if (target == p.getItem()) return k;
    p = p.getNext();
  }
  return -1; // 탐색을 실패하면 -1 리턴
}
```
- 새노드 삽입
  -> 코드 추가
- 연결리스트 맨 앞에 새 노드 삽입
  - head가 새 노드 전체를 가리키고, 새 노드의 레퍼런스는 헤드 다음을 가리킴
### 수행시간
- search()연산 : 탐색을 위해 연결리스트의 노드들을 첫 노드부터 순차적으로 방문해야 하므로 O(N)의 시간이 소요
- 삽입이나 삭제 연산 : 각각 상수 개의 레퍼런스를 갱신하므로 O(1)시간이 소요
  - 단, insertAfter()나 deleteAfter()의 경우에 특정 노드 p의 레퍼런스가 주어지지 않으면 head로부터 p를 찾기 위해 search()를 수행해야 하므로 O(N)시간 소요

## 이중연결리스트
- 각 노드가 두 개의 레퍼런스를 가지고 각각 이전 노드와 다음 노드를 가리키는 연결리스트
### 특징

- 단순연결리스트는 삽입이나 삭제할 때 반드시 이전 노드를 가리키는 레퍼런스를 추가로 알아내야 하고, 역방향으로 노드를 탐색할 수 없음
- 이중연결리스트는 이러한 단점을 보완, 그러나 각 노드마다 추가로 한 개의 레퍼런스를 추가로 지정해야 한다는 단점을 가짐
```java
package list;

public class BidirectionalNode<E> {
	public BidirectionalNode<E> prev;
 	public E item;
 	public BidirectionalNode<E> next;
 	public BidirectionalNode() {
 		prev = next = null;
 		item = null;
 	}
 	public BidirectionalNode(E newItem) {
 		prev = next = null;
 		item = newItem;
 	}
 	public BidirectionalNode(BidirectionalNode<E> prevNode, E newItem, BidirectionalNode<E> nextNode) {
 		prev = prevNode; next = nextNode;
 		item = newItem;
 	}
}
```
### 수행시간
- 이중연결리스트에서 삽입이나 삭제 연산은 각각 상수 개의 레퍼런스만을 갱신하므로 O(1)시간에 수행
- 탐색 연산 : head 또는 tail로부터 노드들을 순차적으로 탐색해야 하므로 O(N)시간 소요

## 원형연결리스트
- 마지막 노드가 첫 노드와 연결된 단순연결리스트
- 마지막 노드의 레퍼런스가 저장된 last가 단순연결리스트의 head와 같은 역할
### 특징
- 마지막 노드와 첫 노드를 O(1) 시간에 방문할 수 있음
- 리스트가 empty가 아니면 어떤 노드도 null 레퍼런스를 갖고 있지 않으므로, 프로그램에서 null 조건을 검사하지 않아도 됨
- 원형연결리스트에서 반대 방향으로 노드들을 방문하기 쉽지 않으며, 무한 루프가 발생할 수 있음
### 응용
- 여러 사람이 차례로 돌아가며 하는 게임
- 많은 사용자들이 동시에 사용하는 컴퓨터에서 CPU 시간을 분할하여 작업들에 할당하는 운영체제에 사용
- 이항힙이나 피보나치힙과 같은 우선순위큐를 구현하는데에도 부분적으로 사용
### 수행시간
- 원형연결리스트에서 삽입이나 삭제 연산 각각 상수 개의 레퍼런스를 갱신하므로 O(1) 시간에 수행
- 탐색 연산: last로부터 노드들을 순차적으로 탐색해야하므로 O(N) 소요