# refactoring

## 1. 기본

### [Extract Method(메서드 추출하기)](src/basic/ExtractMethod.java)

> 코드 조각을 찾아서 무슨 일을 하는지 파악한 다음, 독립된 함수로 추출하고 목적에 맞는 이름을 붙이기

### [Inline Method(메서드 인라인하기)](src/basic/InlineMethod.java)

> 메서드의 본문이 메서드의 명칭 만큼 명확한 경우에는 분리 된 메서드를 인라인한다.

### [Extract Variable(변수 추출하기)](src/basic/ExtractVariable.java)

> 표현식이 너무 복잡해서 이해하기 어려울 때 지역변수를 활용하여 표현식을 쪼개 관리하기 더 쉽게 만든다.
> 현재 함수 안에서만 의미가 있는 값일 때 변수로 추출하고, 함수를 벗어나서 넓은 문맥에서 의미가 있다면 함수로 추출하는것이 좋다.

### [Inline Variable(변수 인라인하기)](src/basic/InlineVariable.java)

> 이름이 원래 표현식과 다를 바 없을 때는 주변 코드를 리팩터링할 때 방해가 될 수 있다. 이럴 때 변수를 인라인한다.

### [Change Method Declaration(메서드 선언 바꾸기)](src/basic/InlineVariable.java)

> 메서드의 이름은 연결부에서 가장 중요한 요소이다. 이름이 좋으면 구현 코드를 보지 않고도 무슨 일을 하는지 명확히 알 수 있다. 매개변수도 마찬가지다.
> 예컨대 전화번호 포매팅 함수가 매개변수로 사람 객체를 받게 된다면, 회사 전화번호에는 사용할 수 없다. 번호 자체를 받도록 정의하면 함수의 활용 범위를 넓힐 수 있다.
