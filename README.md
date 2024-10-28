# 프로그램 설명
Java로 구현한 GUI 계산기 프로그램 입니다.

# 기능
기본적으로 사칙연산(+, -, *, /)이 가능합니다.

Backspace기능(←)과 초기화 기능(C)을 탑재하고 있습니다.

계산 과정을 실시간으로 확인할 수 있습니다.

# 예제
4 / 5 = 0.8

다음과 같이 소수점 계산이 됩니다.

2 / 3 = 0.6666666667
2 / 9 = 0.2222222222

최대 소수점 10자리까지 계산이 되며, 10자리를 초과하면 반올림 혹은 반내림 합니다.

# 사용된 기능

다음과 같은 Java awt의 기능들을 사용하였습니다.

BorderLayout

Swing 기능인 Panel의 배치를 적절히 하는데 사용

Color

글자 숫자 밑 버튼의 Background의 색상 변경시 사용

Font

글자 폰트 변경시 사용

GridLayout

계산기 모양의 격자 무늬를 생성시 사용

ActionEvent

ActionListener

버튼을 눌렀을 때 생성되는 이벤트 처리에 사용

BigDecimal

부동소수점 처리에 사용

다음과 같은 Java swing 기능들을 사용하였습니다.

JButton

계산 기능이 들어갈 버튼 생성시 사용

JFrame

GUI창을 생성시에 사용

JPanel

기능별로 적절한 곳에 배치하기 위해 사용

JTextField

계산이 진행될 곳과 같은 숫자나 기호가 들어갈 곳 생성시에 사용

# 참조

-[Java Gui 계산기 만들기](https://code-review.tistory.com/entry/%ED%81%B4%EB%A1%A0%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94%EB%A1%9C-%EA%B3%84%EC%82%B0%EA%B8%B0-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0)

-[문자열 판별](https://developer-talk.tistory.com/768)

-[BackSpace 및 다른 변수 이름 참고 외부링크](https://0rcticfox.tistory.com/entry/822-%EC%9E%90%EB%B0%94Java-GUI-%ED%99%9C%EC%9A%A9-JPanel-%ED%99%9C%EC%9A%A9-%EA%B3%84%EC%82%B0%EA%B8%B0-%EC%98%A4%EB%AA%A9-%EA%B2%8C%EC%9E%84)

-[계산기 기호 작동 참고 외부링크(https://comain.tistory.com/14)

-[BigDecimal 참고 외부링크](https://developer-hm.tistory.com/229)
