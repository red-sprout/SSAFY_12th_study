# 색인과 이진 검색 트리
## 레코드, 키, 색인
### 레코드
- 개체(Entity)에 대한 모든 정보가 들어 있음
- ex) 사람의 레코드 - 이름, 집, 전화번호...
### 색인
- 개체의 레코드를 검색
- 색인에 레코드를 다 저장 -> 데이터베이스

## 이진 검색 트리
### 소개
- 컴퓨터 과학에서 데이터를 정렬된 방식으로 구성하고 저장하는데 사용
- 기본적으로 **이진 트리**, 각 노드는 최대 2개의 자식 노드가 존재
### 주요 성질
- 왼쪽 자식은 부모보다 **작은 값**
- 오른쪽 자식은 부모보다 **큰 값**
- 중복된 노드가 없어야 함(BST는 다른 처리 방식에 따라 중복된 값을 가질 수 있음).
```java
class Node {
	int key;
	Node left, right;
	
	Node(int item) {
		this.key = item;
		this.left = null;
		this.right = null;
	}
}

class BST {
  // 앞으로의 구현 사항
}
```
  
### 검색
1. 검색할 요소를 트리의 현재 노드와 비교
   - 루트가 대상 요소와 일치하면 노드의 위치를 반환
   - 작으면 왼쪽으로, 크면 오른쪽으로 이동
2. 일치하는 항목을 찾을 때까지 위 절차를 반복
3. 요소가 트리에 존재하지 않으면 NULL 반환
```java
Node search(Node node, int key) {
  if(node == null || node.key == key)
    return node;
  if(node.key < key)
    return search(node.right, key);
  return search(node.left, key);
}
```

### 삽입
1. 해당 요소를 현재 노드와 비교
   - 작으면 왼쪽으로, 크면 오른쪽으로 이동
2. 더이상 진행할 노드가 없으면 삽입
   - 작으면 왼쪽으로, 크면 오른쪽으로 삽입
```java
Node insert(Node node, int key) {
  if(node == null)
    return new Node(key);
  if(node.key == key)
    return node;
  if(node.key < key)
    node.right = insert(node.right, key);
  else
    node.left = insert(node.left, key);
  return node;
}
```

### 삭제
- 리프 노드의 경우 그냥 NULL 처리하면 끝
- 단 하나의 하위 노드가 있을 경우 교체
- 두 개의 하위 노드가 있을 경우
  - 대체 노드가 필요
  - 왼쪽 하위 노드에서 가져올 경우 왼쪽에서의 최대값을 취함
  - 오른쪽 하위 노드에서 가져올 경우 오른쪽에서의 최소값을 취함
```java
Node delete(Node node, int key) {
  if(node == null) 
    return node;
  if(node.key > key) 
    node.left = delete(node.left, key);
  else if(node.key < key)
    node.right = delete(node.right, key);
  else {
    if(node.left == null)
      return node.right;
    if(node.right == null)
      return node.left;
    Node successor = getSuccessor(node);
    node.key = successor.key;
    node.right = delete(node.right, successor.key);
  }
  return node;
}

Node getSuccessor(Node node) {
  node = node.right;
  while(node != null && node.left != null) {
    node = node.left;
  }
  return node;
}
```

### 순회
- 전위 순회(Pre Order) : **부모** -> 왼쪽 -> 오른쪽
- 중위 순회(In Order) : 왼쪽 -> **부모** -> 오른쪽
- 후위 순회(Post Order) : 왼쪽 -> 오른쪽 -> **부모**
