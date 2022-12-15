3단계 로또(2등)
===

## 기능 요구 사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통게에 2등도 추가해야 한다.

## 구현 요구 사항
* 모든 기능을 TDD로 구현하며, pulbic으로 접근 가능한 메서드에 대해 단위 테스트를 작성 한다.
* 핵심 로직과 UI를 담당하는 로직을 분리한다.
* 들여쓰기는 2 depth를 넘지 않도록 구현한다.
* 함수의 길이가 15라인을 넘어가지 않도록 구현한다.
* 구현할 기능 목록을 README.md에 작성한 후, 기능 목록 단위로 commit한다.
* **Enum 클래스를 적용해 프로그래밍을 구현한다.**
* **일급컬렉션을 쓴다.**

## 구현 기능 목록
* Domain
  * [x] WinningNumber : 2등 추첨을 위한 보너스 번호와 6개의 당첨 번호를 표현한다.
    * [x] 2등 추첨을 위한 WinningNumber 클래스 필드 수정
      * AS-IS : WinningNumber.of(Set<LottoNumber>) 
      * TO-BE : WinningNumber.of(Set<Int>, Int)
        * 문자열로 입력된 값을 도메인으로 변경하기 위해 비슷한 기능을 수행하는 함수가 각 도메인에 흩어져 관리 포인트가 증가하는 부분을 기존 설계된 객체를 재활용함으로써 개선 
    * 보너스 번호 유효성 검사
      * [x] `1~45 숫자 범위` 여부 확인
      * [x] `6개의 당첨 번호`와 `중복` 여부 확인

  * [x] Lotto : 보너스 번호 포함 여부를 판별한다.
  
  * [x] MatchResult : 2등에 대한 당첨 결과를 판별한다.
    * 일치하는 숫자 개수와 보너스 번호 포함여부에 따른 당첨 등수 타입을 수정한다.
      * 6개 일치 -> FIRST_PLACE 
      * 5개 일치 && 보너스 번호 포함 -> SECOND_PLACE 
      * 5개 일치 && 보너스 번호 미포함 -> THIRD_PLACE 
      * 4개 일치 -> FOURTH_PLACE 
      * 3개 일치 -> FIFTH_PLACE 
      * 0~2개 일치 -> NOT_WINNING
    * [x] 2등과 3등을 판별한다. 
      * `일치하는 숫자의 개수`가 `5개`이고 `보너스 번호를 포함`하는 경우 2등 
      * `일치하는 숫자의 개수`가 `5개`이고 `보너스 번호를 미 포함`하는 경우 3등

* View
  * [x] Input : `2등 추첨`을 위한 `보너스 번호`를 `입력` 받는다.
  * [x] OutPut : 2등이 포함된 당첨 통계를 출력한다.

TODO
- [ ] 1~45 범위의 숫자라는 `동일한 요구사항`을 가지는 로또 번호와 보너스 번호를 `Value Class`로 `표현`해 보기
- [x] 문자열로 입력된 값으로 각 도메인 생성에 필요한 자료형으로 변환하기 위해 팩토리 메서드 혹은 별도의 Converter로 구현되어 비슷한 기능이 흩어진 부분을 확장 함수를 구현함으로써 관리 포인트를 단일화
  - 1~45의 범위를 가져야하는 로또 번호, 보너스 번호 도메인을 생성하기 위해 입력된 String 값을 Int로 변경하는 확장 함수 작성
  - 6개의 숫자로 구성된 하나의 로또 도메인을 생성하기 위해 입력된 List<String>값을 Set<Int>로 변경하는 확장 함수 작성
---