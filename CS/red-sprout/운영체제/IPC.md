# 프로세스 간 통신 (Inter-Process Communication, IPC)

프로세스 간 통신(IPC, Inter-Process Communication)은 운영체제에서 실행 중인 여러 프로세스가 서로 데이터를 주고받거나 동기화할 수 있도록 하는 메커니즘을 의미합니다. IPC는 여러 프로세스가 협력하여 작업을 수행하거나 데이터를 공유해야 하는 상황에서 필수적인 기능입니다. IPC는 동일한 시스템 내의 프로세스 간 또는 네트워크를 통한 다른 시스템 간에도 이루어질 수 있습니다.

## IPC의 개념 및 종류

IPC는 여러 가지 방법으로 구현될 수 있으며, 각 방법은 사용 사례에 따라 적합한 선택이 될 수 있습니다. 주요 IPC 메커니즘에는 다음과 같은 종류가 있습니다:

### 1. 파이프 (Pipe)
파이프는 한 프로세스의 출력 데이터를 다른 프로세스의 입력으로 전달하는 단방향 통신 채널입니다. 익명 파이프는 동일한 부모 프로세스를 공유하는 자식 프로세스 간에 주로 사용되며, 명명된 파이프(named pipe)는 네임드 파일을 통해 서로 다른 프로세스 간의 통신이 가능합니다.

### 2. 메시지 큐 (Message Queue)
메시지 큐는 커널이 관리하는 FIFO(선입선출) 형태의 메시지 저장소입니다. 여러 프로세스가 메시지를 큐에 넣고 꺼낼 수 있으며, 메시지는 독립적인 단위로 관리됩니다.

### 3. 공유 메모리 (Shared Memory)
공유 메모리는 IPC 방식 중 가장 빠른 방식 중 하나로, 여러 프로세스가 메모리의 특정 영역을 공유하여 데이터를 주고받을 수 있습니다. 단, 데이터의 동기화는 별도의 동기화 메커니즘(예: 세마포어)이 필요합니다.

### 4. 세마포어 (Semaphore)
세마포어는 프로세스 간에 특정 자원의 접근을 제어하기 위해 사용되는 동기화 도구입니다. 세마포어를 통해 자원의 동시 접근을 제어하고, 교착 상태를 방지할 수 있습니다.

### 5. 소켓 (Socket)
소켓은 네트워크를 통한 프로세스 간 통신을 가능하게 합니다. 소켓은 동일한 시스템 내 또는 네트워크 상의 다른 시스템 간의 프로세스 통신에 사용되며, 클라이언트-서버 모델에서 주로 사용됩니다.

## C 언어 코드 예시: 파이프를 이용한 통신

아래는 C 언어에서 파이프를 사용하여 부모 프로세스와 자식 프로세스 간에 데이터를 주고받는 예시입니다.

```c
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int main() {
    int pipefd[2];
    pid_t pid;
    char buffer[100];
    
    // 파이프 생성
    if (pipe(pipefd) == -1) {
        perror("pipe");
        return 1;
    }
    
    // 자식 프로세스 생성
    pid = fork();
    if (pid == -1) {
        perror("fork");
        return 1;
    }

    if (pid == 0) {  // 자식 프로세스
        close(pipefd[0]);  // 읽기 종단 닫기
        char childMessage[] = "Hello from child process!";
        write(pipefd[1], childMessage, strlen(childMessage) + 1);
        close(pipefd[1]);  // 쓰기 종단 닫기
    } else {  // 부모 프로세스
        close(pipefd[1]);  // 쓰기 종단 닫기
        read(pipefd[0], buffer, sizeof(buffer));
        printf("Received from child: %s\n", buffer);
        close(pipefd[0]);  // 읽기 종단 닫기
    }

    return 0;
}
```

### 코드 설명
- `pipefd[2]`: 파이프의 읽기 및 쓰기 파일 디스크립터를 저장하는 배열입니다.
- `fork()`: 부모 프로세스는 자식 프로세스를 생성합니다. 자식 프로세스는 `pid == 0`일 때 실행됩니다.
- 자식 프로세스는 파이프의 쓰기 종단을 사용하여 메시지를 보내고, 부모 프로세스는 읽기 종단을 사용하여 메시지를 수신합니다.

## 면접 예상 질문과 답변

### 1. **IPC란 무엇인가요?**
   **답변:** IPC(Inter-Process Communication)는 서로 다른 프로세스가 데이터를 교환하거나 동기화할 수 있도록 하는 메커니즘입니다. 여러 프로세스가 협력하여 작업을 수행하거나 자원을 공유해야 하는 상황에서 사용됩니다.

### 2. **IPC의 주요 방식에는 어떤 것들이 있나요?**
   **답변:** IPC의 주요 방식에는 파이프, 메시지 큐, 공유 메모리, 세마포어, 소켓 등이 있습니다. 각 방식은 특정 상황에 따라 적합한 용도가 다릅니다.

### 3. **파이프와 메시지 큐의 차이점은 무엇인가요?**
   **답변:** 파이프는 단방향 통신 채널로, 데이터를 바이트 스트림으로 처리합니다. 반면, 메시지 큐는 데이터를 독립적인 메시지 단위로 관리하며, 프로세스 간의 다중 큐 통신을 지원합니다.

### 4. **공유 메모리의 장단점은 무엇인가요?**
   **답변:** 공유 메모리의 장점은 매우 빠른 데이터 접근 속도를 제공한다는 점입니다. 그러나 동시 접근 시 데이터 손상이 발생할 수 있으므로, 별도의 동기화 메커니즘이 필요하다는 단점이 있습니다.

### 5. **세마포어와 뮤텍스의 차이점은 무엇인가요?**
   **답변:** 세마포어는 여러 프로세스가 동시에 접근할 수 있는 자원의 수를 제어할 수 있으며, 여러 프로세스에서 사용할 수 있습니다. 뮤텍스는 하나의 프로세스만이 자원에 접근할 수 있도록 하는 동기화 도구로, 일반적으로 단일 프로세스 내에서 사용됩니다.

이와 같이, IPC는 프로세스 간의 효율적인 데이터 교환과 동기화를 위해 필수적인 기술입니다. 다양한 IPC 메커니즘을 이해하고 이를 적절히 활용하는 것은 시스템 프로그래밍에서 매우 중요한 능력입니다.
