# B-트리와 B+트리

## B-트리

- BST (이진 탐색 트리)를 일반화해서 자녀 노드의 최대 개수를 조절할 수 있는 Tree
- 가질 수 있는 최대 자녀 노드 개수에 따라 M차 B tree라고 부른다.
- internal 노드(리프노드 제외)의 key 수가 x개라면 자녀 노드의 수는 언제나 X - 1개이다.
B 트리의 차수와 상관없이 internal 노드는 최소 2개 이상의 자식 노드를 가진다.
- 모든 leaf 노드는 같은 레벨에 있다 => balanced tree => 검색 시간 복잡도 O(logN)
- 노드 내 key들은 항상 오름차순으로 저장된다.

### B-트리의 매개변수

(요소는 4개이나 어떤 값을 기준으로 잡냐에 따라 계산식은 다르다)
* M : 각 노드의 **최대** 자녀 노드 개수
* M - 1 : 각 노드가 가질 수 있는 **최대**  key  개수
* M / 2의 올림 : 각 노드의 **최소** 자녀 노드 개수 (루트 또는 리프에서는 조건 해당 없음)
* M/2의 올림값 - 1 : 각 노드의 **최소** key 개수 (루트 노드는 조건 해당 없음)

### B-트리의 데이터 삽입

- 데이터 삽입은 항상 리프 노드에서 이뤄진다.
(루트 노드에 집어넣고 오름차순에 맞춰서 리프노드가 될 때까지 자식 노드로 옮긴다)
- 노드가 넘칠 경우 가운데 키를 기준으로 좌우 키들을 분할하고 가운데 key는 부모 노드로 올린다.
(하나의 노드에서 M-1개를 넘는 키값을 가질 경우 노드가 넘친다고 표현함)

### B-트리의 데이터 삭제

- 데이터의 삭제 역시 항상 리프 노드에서 발생한다.
- 데이터 삭제 후 최소 key수보다 적어질 경우 재조정한다.
    1. key수가 여유 있는 형제 노드의 지원을 받는다.
    2. 1이 불가능할 경우 부모 노드의 지원을 받고 형제 노드와 합친다.
    3. 2를 수행한 후 부모 노드의 최소 key 수에 문제가 있다면 부모 노드부터 1의 과정부터 시작해 재조정한다.