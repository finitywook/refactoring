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

### [Combine Methods Into Class(여러 메서드를 클래스로 묶기)](src/basic/CombineMethodsIntoClass.java)

> 메서드 호출 시 매개변수로 전달되는 공통 데이터를 중심으로 긴밀하게 엮여 작동하는 메서드 목록이 있다면, 클래스 하나로 묶는다. 클래스로 묶으면 이 함수들이 공유하는 공통 환경을 더 명확하게 표현할 수 있다.

### [Combine Methods Into Transform(여러 메서드를 변환 메서드로 묶기)](src/basic/CombineMethodsIntoTransform.java)

> 메서드 호출 시 매개변수로 전달되는 공통 데이터를 중심으로 긴밀하게 엮여 작동하는 메서드 목록이 있다면, 클래스 하나로 묶는다. 클래스로 묶으면 이 함수들이 공유하는 공통 환경을 더 명확하게 표현할 수 있다.


## 2. 캡슐화

### [Encapsulate Record(레코드 캡슐화하기)](src/encapsulate/EncapsulateRecord.java)

> 레코드는 여러가지 데이터를 직관적인 방식으로 묶을 수 있어서 각각을 따로 취급할 때보다 훨씬 의미있는 단위로 전달이 가능하다. 하지만 레코드는 단점이 있다. 계산해서 얻을 수 있는 값과 그렇지 않은 값을 명확히 구분해서 저장해야 한다.
> 이로 인해 레코드보다 객체를 사용하자. 객체를 사용하면 어떻게 저장했는지를 숨긴 채 각각의 메서드로 값을 제공할 수 있다.
 
### [Encapsulate Collection(컬렉션 캡슐화하기)](src/encapsulate/EncapsulateCollection.java)

> 컬렉션을 직접 변경할 수 있으면 눈치채지 못하는 곳에서 컬렉션의 원소들이 바뀔 수 있다. 이러한 문제를 방지하기 위해 컬렉션을 변경하는 메서드를 만든다.

### [Replace Primitive With Object(기본형을 객체로 바꾸기)](src/encapsulate/ReplacePrimitiveWithObject.java)

> 단순한 출력 이상의 기능이 필요해지는 순간 그 데이터를 표현하는 전용 클래스를 정의하자. 나중에 특별한 동작이 필요해지면, 이 클래스에 추가하면 되니 프로그램이 커질수록 점점 유용한 도구가 된다.

### [Replace Temp With Query(임시 변수를 질의 함수로 바꾸기)](src/encapsulate/ReplaceTempWithQuery.java)

> 함수 안에서 어떤 코드의 결과값을 뒤에서 다시 참조할 목적으로 임시 변수를 사용하기도 한다. 임시 변수를 사용하면 값을 계산하는 코드가 반복되는것을 줄일 수 있어서 유용하다.
> 하지만 한걸음 더 나아가 함수로 만들어 사용하는 편이 나을 때가 많다. 변수 대신 함수로 만들어 두면 비슷한 계산을 수행하는 다른 함수에서도 사용할 수 있어 코드 중복이 줄어든다.