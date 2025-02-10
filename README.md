# ASSIGN-week1-cli-program

**주제** 📅 TodoList: 할 일을 관리하자!<br>
**Skills** JAVA 21, MacOS, IntelliJ, Git & GitHub

## 1. 클래스 다이어그램
<img width="382" alt="image" src="https://github.com/user-attachments/assets/3758006b-665c-483c-9a54-75e3cf660c5e" />

#### 1. 핵심 클래스 및 상속 관계
  - model.TodoBase (부모 클래스)
    - 모든 할 일의 기본 구조를 정의하는 클래스
    - id(할 일 번호)와 task(할 일 내용) 속성을 포함하며, 이를 조회하는 getId() 및 getTask() 메서드를 제공
  - model.TodoItem (할 일 클래스, model.TodoBase 상속)
    - isDone(완료 여부) 속성을 추가하여 할 일의 완료 상태를 관리
    - markDone() 메서드를 통해 완료 상태를 변경할 수 있으며, toString()을 오버라이딩하여 콘솔 출력 시 상태를 시각적으로 표시
  - model.DeadlineTodoItem (마감 기한이 있는 할 일, model.TodoItem 상속)
    - dueDate 속성을 추가하여 마감 기한을 저장
    - toString() 메서드를 오버라이딩하여 마감 기한이 있는 할 일에 대해 별도의 출력 형식을 제공
#### 2. 할 일 목록 관리 (service.TodoList 클래스)
  - service.TodoList 클래스는 ArrayList<model.TodoItem>을 이용하여 여러 개의 할 일을 저장하고 관리
  - 주요 기능:
    - addTask(): 일반 할 일 추가
    - addTaskWithDeadline(): 마감 기한이 있는 할 일 추가
    - showTasks(): 현재 등록된 할 일 목록을 출력
    - markTaskDone(): 특정 할 일을 완료 처리
    - deleteTask(): 특정 할 일을 삭제
#### 3. 콘솔 색상 관리 (util.ConsoleColor 클래스)
  - ANSI 색상 코드를 정의하여 콘솔 출력에 색상을 적용하는 역할
  - 예를 들어, GREEN(완료), RED(미완료), CYAN(메뉴 강조), YELLOW(마감 기한 표시) 등의 색상을 정의하여 가독성 향상
#### 4. 구조적인 특징 및 활용
  - 객체지향 프로그래밍(OOP) 원칙 적용
    - 상속(Inheritance): TodoItem이 TodoBase를 상속하고, DeadlineTodoItem이 TodoItem을 상속하는 구조로 확장성을 고려
    - 캡슐화(Encapsulation): service.TodoList 내부에서 ArrayList<model.TodoItem>을 사용하여 할 일 목록을 관리하고, 특정 메서드를 통해 조작할 수 있도록 설계
  - 확장 가능성
    - 향후 다른 유형의 할 일(예: 우선순위가 있는 할 일, 반복되는 할 일 등)을 쉽게 추가할 수 있도록 model.TodoBase 클래스를 기반으로 설계

## 2. 시뮬레이션 시나리오
````
[1] 오프닝 -> 프로그램 시작 및 메인 메뉴 출력
[2] 사용자 선택에 따른 분기 처리
    [1] 일반 할 일 추가 (메뉴 번호 1)
        [1] 할 일 입력: "프로젝트 보고서 작성"
    [2] 마감 기한 할 일 추가 (메뉴 번호 2)
        [1] 할 일 입력: "팀 회의 준비"
        [2] 마감일 입력: "2025-01-31"
    [3] 할 일 목록 보기 (메뉴 번호 3)
    [4] 할 일 완료 체크 (메뉴 번호 4)
        [1] 완료 항목 입력: "1"
    [5] 할 일 삭제 (메뉴 번호 5)
        [1] 삭제 목 입력: "2"
[3] 엔딩 -> 프로그램 종료
````

## 3. 프로그램 시연
![cli-program](https://github.com/user-attachments/assets/e1cfc5f6-07d5-49b4-8a8f-be8c8ddb3700)
