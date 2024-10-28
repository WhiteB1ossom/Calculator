# GUI 계산기 프로그램

Java의 GUI 라이브러리를 활용하여 구현한 사칙연산 계산기 프로그램입니다. 이 계산기는 기본 연산뿐만 아니라 다양한 추가 기능도 제공합니다.

---

## 프로그램 설명
이 프로그램은 Java의 AWT 및 Swing을 활용하여 GUI 기반의 계산기를 구성합니다. 기본 사칙연산(+, -, *, /)과 함께 다양한 유틸리티 기능이 포함되어 있으며, 계산 과정을 실시간으로 확인할 수 있습니다.

---

## 기능
1. **기본 사칙연산**  
    - 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/)을 포함한 계산이 가능합니다.

2. **추가기능**  
    - **Backspace(←)**: 마지막 입력을 삭제합니다.
    - **Clear(C)**: 모든 입력을 초기화합니다.

3. **실시간 계산 과정 표시**  
    - 모든 연산 과정은 실시간으로 화면에 표시됩니다.

---

## 예제
다음과 같은 소수점 연산을 지원합니다:
- 4 / 5 = 0.8
- 2 / 3 = 0.6666666667
- 2 / 9 = 0.2222222222

> **Note**: 최대 소수점 10자리까지 계산되며, 이를 초과하면 반올림 처리를 수행합니다.

---

## 사용된 Java 라이브러리

### AWT 기능
- **BorderLayout**  
    - 패널 내 요소 배치에 사용되었습니다.

- **Color**  
    - 버튼과 텍스트의 배경색 변경에 사용되었습니다.

- **Font**  
    - 글자와 숫자의 폰트 변경에 사용되었습니다.

- **GridLayout**  
    - 계산기 버튼 배열을 구성하기 위한 격자 형태의 레이아웃에 사용되었습니다.

- **ActionEvent & ActionListener**  
    - 버튼 클릭 시 이벤트 처리에 사용되었습니다.

### Swing 기능
- **JButton**  
    - 각 버튼에 기능을 부여하고 생성하는 데 사용되었습니다.

- **JFrame**  
    - GUI 창을 생성하는 데 사용되었습니다.

- **JPanel**  
    - 기능별로 UI 요소를 배치하기 위해 사용되었습니다.

- **JTextField**  
    - 계산 결과와 과정을 표시하는 영역으로 사용되었습니다.

### BigDecimal 클래스
- 부동소수점 연산의 정확성을 높이기 위해 사용되었습니다.

---

## 참조 링크
- [Java GUI 계산기 만들기](https://code-review.tistory.com/entry/%ED%81%B4%EB%A1%A0%EC%BD%94%EB%94%A9-%EC%9E%90%EB%B0%94%EB%A1%9C-%EA%B3%84%EC%82%B0%EA%B8%B0-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0)
- [문자열 판별](https://developer-talk.tistory.com/768)
- [BackSpace 및 기타 변수 이름 참고](https://0rcticfox.tistory.com/entry/822-%EC%9E%90%EB%B0%94Java-GUI-%ED%99%9C%EC%9A%A9-JPanel-%ED%99%9C%EC%9A%A9-%EA%B3%84%EC%82%B0%EA%B8%B0-%EC%98%A4%EB%AA%A9-%EA%B2%8C%EC%9E%84)
- [계산기 기호 작동 방식 참고](https://comain.tistory.com/14)
- [BigDecimal 참고 자료](https://developer-hm.tistory.com/229)
- [README.md 참고 자료](https://12716.tistory.com/entry/Github-GIthub%EC%97%90%EC%84%9C-READMEmd-%EC%9E%91%EC%84%B1%ED%95%98%EA%B8%B0)

---

