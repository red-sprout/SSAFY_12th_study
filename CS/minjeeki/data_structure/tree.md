# 트리

## 트리

: 계층적 구조를 나타내는 자료구조

### 트리 구성 요소

- 노드(node) : 트리의 각 요소
    - 노드에는 각 노드에 해당하는 데이터와 노드와 노드가 연결되기 위한 정보(데이터)가 들어감
    - 일반적으로 프로그램에서 노드를 구현하는 방법
        
        : 데이터 필드 (데이터를 담는 공간)과 링크 필드 (다음 노드 연결 정보, 주소값)로 구성
        
- 간선(edge) : 노드와 노드 사이의 연결을 의미하는 표현

### 트리의 종류

- 이진 트리
    
    : 각 노드가 최대 두개의 자식 노드를 가질 수 있는 트리
    
    > 구분 기분
    : 부모 - 자식 관계에서 한개의 부모노드가 갖는 최대 자식 노드 수가 2개 이하
    > 
- 완전 이진 트리
    
    : 모든 레벨이 완전히 채워져 있고, 마지막 레벨은 왼쪽부터 채워지는 이진 트리
    
    - 레벨 : 특정 노드가 트리의 루트 노드로부터 얼마나 떨어져있는가를 나타내는 값
    (트리 내에서 해당 트리의 층 위치)
        - 루트 노드의 레벨 : 레벨 0
        - 루트 노드로부터 내려가면서 각 층마다 레벨이 1씩 증가
    
    > 구분 기준
    : 마지막 레벨 제외한 레벨의 노드는 모두 자식 레벨을 2개씩 갖고 있음
    마지막 레벨은 부모 - 자식의 관계 여부와는 상관없이 항상 왼쪽부터 채워짐
    > 
- 이진 탐색 트리
    
    : 왼쪽 자식 노드는 부모 노드보다 작고, 오른쪽 자식 노드는 부모 노드보다 큰 값을 가짐
    
    - 효율적인 검색, 삽입, 삭제가 필요한 경우 사용
    
    > 구분 기준
    : 노드의 데이터 필드 크기값을 기준으로 트리 정렬
    (마지막 레벨 제외 레벨의 노드가 모두 채워질 필요 없음)
    > 

### Q. 트리와 그래프의 차이

## 이진 트리

: 각 노드가 최대 두개의 자식 노드를 가질 수 있는 트리

- 정의로 비롯된 성질
    - n개의 노드를 가진 이진 트리는 n - 1개의 간선을 갖게 된다
    - 높이가 h인 이진 트리가 갖는 노드 범위 : 최소 h개 ~ 최대 $2^k - 1$개
    - n개의 노드가 가지는 이진 트리의 높이
    : 최소 $log_2 (n+1)$에서 올림해서 정수 개수 가짐 ~ 최대 n개

### 이진 트리 분류

- 구조적 분류
    - 포화 이진 트리
    : 각 레벨에 노드가 꽉 차 있는 이진 트리
    - 완전 이진 트리
    : 마지막 레벨 상위의 레벨까지는 포화 + 마지막 레벨은 왼쪽부터 채워짐
    (중간에 빈 곳이 없음)
- 균형 형태에 따른 분류
    - 균형 이진 트리
    : 모든 노드에 대해 두 서브 트리의 높이 차이가 일정 범위 내에 있는 트리
        - ex. AVL 트리 / 레드 - 블랙 트리
    - 불균형 이진 트리
- 데이터 저장 방식에 따른 분류
    - 이진 탐색 트리
    - 이진 힙

### Q. 이진 트리를 왜 중점적으로 다루는가

- 자식 노드의 개수가 정해지지 않을 경우 생기는 문제
    
    : 자식 노드 개수만큼의 링크 필드 개수가 필요하다
    
    ⇒ 노드의 크기가 고정되지 않음
    
    ⇒ 프로그램이 복잡해짐
    
- 일반 트리를 이진 트리로 변환하는 방법도 존재함

### 이진 트리의 표현

- 배열을 이용하는 방법 (배열 표현법)
    - 주로 포화 이진 트리나 완전 이진 트리의 경우 많이 사용
    (이외의 상황에 사용할 경우 메모리 낭비가 심해짐)
    - 인덱스 0은 사용하지 않음 (계산을 보다 간단하게 하기 위함)
    - 인덱스를 통해 부모나 자식을 쉽게 알 수 있음
        
        ```markdown
        * 노드 i의 부모 노드 인덱스 = i / 2
        * 노드 i의 왼쪽 자식 노드 인덱스 = 2i
        * 노드 i의 오른쪽 자식 노드 인덱스 = 2i + 1
        ```
        
    - 길이 : 트리의 깊이가 k의 경우 최대 $2^k - 1$개의 공간 연속 할당
- 포인터를 이용하는 방법 (링크 표현법)
    
    > in C : 노드가 구조체로 표현
    > 
    > 
    > in Python : 노드를 클래스로 표현
    > 
    - 

## 이진 검색 트리

: 정렬된 이진 트리

- 규칙 : 왼쪽 자식 노드 > 부모 노드 > 오른쪽 자식 노드

## 균형 검색 트리

: 트리의 높이(깊이)가 최소화된 이진 트리

### 레드 블랙 트리

### AVL 트리

### Q. 균형 형태가 중요한 이유가 뭔가?

## 질문 for 기술 면접

### 1. 이진탐색트리가 되기 위한 조건에 대해서 설명하고, 어떻게 구현할지 설명하세요.

1. root node의 값보다 작은 값은 left subtree, 큰 값은 right subtree에 있다.
2. subtree 역시 작은 값은 left subtree, 큰 값은 right subtree에 있다 ⇒ 재귀적으로 조건을 만족해야 한다.
- chatGPT
    
    ### 이진 탐색 트리가 되기 위한 조건
    
    이진 탐색 트리(Binary Search Tree, BST)가 되기 위한 조건은 다음과 같습니다:
    
    1. **노드의 왼쪽 서브트리**에는 그 노드의 값보다 작은 값들만 저장됩니다.
    2. **노드의 오른쪽 서브트리**에는 그 노드의 값보다 큰 값들만 저장됩니다.
    3. **각 서브트리** 역시 이진 탐색 트리여야 합니다.
    
    즉, BST는 각 노드에 대해 왼쪽 자식의 값이 부모 노드의 값보다 작고, 오른쪽 자식의 값이 부모 노드의 값보다 큰 구조를 유지합니다.
    
    ### 이진 탐색 트리 구현 방법
    
    이진 탐색 트리를 구현하는 방법에 대해서는 다음과 같이 설명할 수 있습니다:
    
    ### 노드 정의
    
    먼저 트리의 노드를 정의합니다. 각 노드는 값, 왼쪽 자식, 오른쪽 자식을 가집니다.
    
    ```python
    python코드 복사
    class TreeNode:
        def __init__(self, key):
            self.left = None
            self.right = None
            self.val = key
    
    ```
    
    ### 삽입 연산
    
    이진 탐색 트리에 새로운 값을 삽입하는 연산을 정의합니다. 새로운 값은 현재 노드의 값과 비교하여 왼쪽 또는 오른쪽 서브트리에 재귀적으로 삽입됩니다.
    
    ```python
    python코드 복사
    def insert(root, key):
        if root is None:
            return TreeNode(key)
    
        if key < root.val:
            root.left = insert(root.left, key)
        else:
            root.right = insert(root.right, key)
    
        return root
    
    ```
    
    ### 검색 연산
    
    이진 탐색 트리에서 특정 값을 검색하는 연산을 정의합니다. 현재 노드의 값과 비교하여 왼쪽 또는 오른쪽 서브트리에서 재귀적으로 검색합니다.
    
    ```python
    python코드 복사
    def search(root, key):
        if root is None or root.val == key:
            return root
    
        if key < root.val:
            return search(root.left, key)
    
        return search(root.right, key)
    
    ```
    
    ### 삭제 연산
    
    이진 탐색 트리에서 값을 삭제하는 연산을 정의합니다. 삭제할 노드가 자식이 없는 경우, 하나의 자식만 있는 경우, 두 개의 자식을 모두 가진 경우를 고려해야 합니다.
    
    ```python
    python코드 복사
    def deleteNode(root, key):
        if root is None:
            return root
    
        if key < root.val:
            root.left = deleteNode(root.left, key)
        elif key > root.val:
            root.right = deleteNode(root.right, key)
        else:
            if root.left is None:
                return root.right
            elif root.right is None:
                return root.left
    
            temp = minValueNode(root.right)
            root.val = temp.val
            root.right = deleteNode(root.right, temp.val)
    
        return root
    
    def minValueNode(node):
        current = node
        while current.left is not None:
            current = current.left
        return current
    
    ```
    
    ### 마무리
    
    이와 같이, 이진 탐색 트리의 정의와 이를 구현하는 방법에 대해 설명하였습니다. 이진 탐색 트리는 효율적인 검색, 삽입, 삭제 연산을 가능하게 하여 다양한 응용 분야에서 사용됩니다.
    

### 2. 이진탐색트리의 최악의 경우 발생할 수 있는 시간복잡도와 이에 대한 상황 설명, 이를 피하기 위한 방안에 대해 설명하세요.

- chatGPT
    
    ### 이진 탐색 트리의 최악의 경우 시간 복잡도
    
    이진 탐색 트리(Binary Search Tree, BST)의 최악의 경우 시간 복잡도는 O(n)입니다. 이는 트리가 한쪽으로 치우친(skewed) 형태가 되는 경우에 발생합니다.
    
    ### 최악의 경우 발생 상황
    
    최악의 경우는 삽입되는 값들이 이미 정렬된(오름차순 또는 내림차순) 상태로 들어올 때 발생합니다. 예를 들어, 1, 2, 3, 4, 5의 순서로 삽입될 경우 트리는 다음과 같이 한쪽으로 치우친 형태가 됩니다:
    
    ```markdown
    markdown코드 복사
        1
         \
          2
           \
            3
             \
              4
               \
                5
    
    ```
    
    이런 경우, BST는 사실상 링크드 리스트와 같은 형태가 되어 검색, 삽입, 삭제 연산의 시간 복잡도가 O(n)이 됩니다.
    
    ### 이를 피하기 위한 방안
    
    이러한 최악의 경우를 피하기 위해서는 트리의 균형을 유지하는 것이 중요합니다. 이를 위해 사용되는 대표적인 방법은 균형 이진 탐색 트리(Balanced Binary Search Tree)를 사용하는 것입니다. 주요 균형 이진 탐색 트리에는 다음과 같은 것들이 있습니다:
    
    1. **AVL 트리 (AVL Tree)**: 모든 노드에 대해 두 자식 트리의 높이 차이가 최대 1이 되도록 유지합니다. 삽입과 삭제 시 트리를 회전시키는 방식으로 균형을 맞춥니다.
    2. **레드-블랙 트리 (Red-Black Tree)**: 자가 균형 이진 탐색 트리로, 트리의 높이를 O(log n)으로 유지합니다. 각 노드에 색상(빨간색 또는 검은색)을 부여하고, 특정 규칙을 통해 트리의 균형을 유지합니다.
    
    ### 예시: AVL 트리의 삽입 연산
    
    ```python
    python코드 복사
    class AVLNode:
        def __init__(self, key):
            self.key = key
            self.left = None
            self.right = None
            self.height = 1
    
    def insert(node, key):
        if not node:
            return AVLNode(key)
    
        if key < node.key:
            node.left = insert(node.left, key)
        else:
            node.right = insert(node.right, key)
    
        node.height = 1 + max(getHeight(node.left), getHeight(node.right))
    
        balance = getBalance(node)
    
        if balance > 1 and key < node.left.key:
            return rotateRight(node)
    
        if balance < -1 and key > node.right.key:
            return rotateLeft(node)
    
        if balance > 1 and key > node.left.key:
            node.left = rotateLeft(node.left)
            return rotateRight(node)
    
        if balance < -1 and key < node.right.key:
            node.right = rotateRight(node.right)
            return rotateLeft(node)
    
        return node
    
    def rotateLeft(z):
        y = z.right
        T2 = y.left
        y.left = z
        z.right = T2
        z.height = 1 + max(getHeight(z.left), getHeight(z.right))
        y.height = 1 + max(getHeight(y.left), getHeight(y.right))
        return y
    
    def rotateRight(y):
        x = y.left
        T2 = x.right
        x.right = y
        y.left = T2
        y.height = 1 + max(getHeight(y.left), getHeight(y.right))
        x.height = 1 + max(getHeight(x.left), getHeight(x.right))
        return x
    
    def getHeight(node):
        if not node:
            return 0
        return node.height
    
    def getBalance(node):
        if not node:
            return 0
        return getHeight(node.left) - getHeight(node.right)
    
    ```
    
    ### 마무리
    
    이와 같이, 이진 탐색 트리의 최악의 경우 시간 복잡도와 발생 상황, 그리고 이를 피하기 위한 방법에 대해 설명할 수 있습니다. 균형 이진 탐색 트리를 사용하면 트리의 높이를 일정하게 유지하여 모든 연산의 시간 복잡도를 O(log n)으로 유지할 수 있습니다.
    
    4o