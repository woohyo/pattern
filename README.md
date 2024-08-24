### 정의

```dart
상위 클래스(AbsctractDisplay) 에서 템플릿이 될 메소드가 정의되어 있고,
그 메소드 정의에 추상 메소드가 사용 된다. 따라서 상위 클래스의 코드만 봐서는 
최종적으로 어떻게 처리되는지 알 수 없다.

실제로 구현하는 것은 하위 클래스(CharDisplay, StringDisplay) 에서 이루어 진다.
처리의 흐름은 상위 클래스의 역할 이기때문 이처럼 상위 클래스에서 처리의 뼈대를 결정하고
하위 클래스에서 그 구체적 내용을 결정하는 것이 Template Method 패턴이다.
```

### Class List
| Class Name        | Description                              |
|-------------------|------------------------------------------|
| `AbsctractDisplay` | Template Method 인 display  뼈대를 결정하는 상위 클래스 |
| `CharDisplay`     | print 가 5회 출력되며 1번 출력시 char 가 1씩 증가한다.   |
| `StringDisplay`   | String 이 7회 출력                           |
| `Main`            | 동작 테스트 클래스                               |
