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