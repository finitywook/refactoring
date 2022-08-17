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

### [Change Method Declaration(메서드 선언 바꾸기)](src/basic/ChangeMethodDeclaration.java)

> 메서드의 이름은 연결부에서 가장 중요한 요소이다. 이름이 좋으면 구현 코드를 보지 않고도 무슨 일을 하는지 명확히 알 수 있다. 매개변수도 마찬가지다.
> 예컨대 전화번호 포매팅 함수가 매개변수로 사람 객체를 받게 된다면, 회사 전화번호에는 사용할 수 없다. 번호 자체를 받도록 정의하면 함수의 활용 범위를 넓힐 수 있다.

### [Encapsulate Variable(변수 캡슐화하기)](src/basic/EncapsulateVariable.java)

> 리팩터링은 결국 프로그램의 요소를 조작하는 일. 메서드는 데이터보다 다루기가 수월하다. 데이터는 메서드보다 다루기가 어려운데, 메서드 선언 바꾸기와 같은 방식으로 전달 메서드를 만들기가 어렵기 때문이다.
> 접근할 수 있는 범위가 넓은 데이터는 데이터를 독점하는 함수를 만드는게 좋다(Getter) 또 데이터를 변경(Setter)하고 사용하는 코드를 감시할 수 있는 확실한 통로가 되어준다. 

### [Introduce Parameter Object(파라미터 객체 만들기)](src/basic/IntroduceParameterObject.java)

> 데이터 항목 여러개가 이 메서드에서 저 메서드로 몰려다니는 경우가 자주 있다. 이런 데이터 구조를 하나로 모아주자. 데이터를 데이터 구조로 묶으면 데이터 관계가 명확해진다.
> 같은 데이터 구조를 사용하는 모든 함수가 원소를 참조할 때 항상 똑같은 이름을 사용하기에 일관성도 높다.
