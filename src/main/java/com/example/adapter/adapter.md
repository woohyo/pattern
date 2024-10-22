# 어댑터 패턴(Adapter Pattern)

----


## 어댑터 패턴이란?
<blockquote> 
<strong>서로 호환되지 않는 인터페이스를 가진 클래스들을 연결해주는 디자인 패턴</strong>
<br>
: 서로 다른 인터페이스를 가진 클래스들이 함께 동작할 수 있도록 중간에 어댑터 역할을 하는 클래스를 두는 구조
<br><br>
- 어댑터 객체: 클라이언트가 요구하는 인터페이스와 실제로 제공되는 인터페이스가 다를 때, 중간에서 변환해주는 객체
</blockquote> 
<br>

### ➤ 어댑터 패턴의 필요성 <br>

<p>기존 코드와 새 코드가 서로 다른 인터페이스를 가질 때, 기존 코드 변경 없이 레거시 코드와 새 코드를 통합할 수 있다. 시스템의 변경을 최소화하면서 새로운 기능을 추가해야하는 상황에서 유용하다.</p>

  

<br><br>

### ➤ 어댑터 패턴의 구조 <br>

<table class="table">
<tbody>
<tr>
<td><strong>클라이언트(Client)</strong></td>
<td>어댑터 패턴을 사용하는 객체로, 인터페이스를 호출한다.
</tr>
<tr>
<td><strong>타겟(Target)</strong></td>
<td>클라이언트가 기대하는 인터페이스이다.</td>
</tr>
<tr>
<td><strong>어댑터(Adapter)</strong></td>
<td>타겟의 인터페이스를 어댑티의 인터페이스로 변환해주는 역할을 한다. 타겟 인터페이스를 구현하며, 실제로는 어댑터가 감싼 객체의 메서드를 호출한다.</td>
</tr>
<tr>
<td><strong>어댑터 대상(Adaptee)</strong></td>
<td>클라이언트가 사용하려는 실제 객체이다. 어댑터가 감싸서 호출할 실제 객체로, 타겟의 인터페이스와 호환되지 않는 인터페이스를 가지고 있다.</td>
</tr>
</tbody>
</table>

<br><br>

### ➤ 어댑터 패턴의 UML 다이어그램 <br>

![img.png](https://velog.velcdn.com/images%2Fnewtownboy%2Fpost%2F261f7abf-d13c-444c-9296-17632ede3add%2Fimage.png)

<code> Client는 Target 인터페이스를 사용하여 method()를 호출한다. Target 인터페이스를 구현한 Adapter에서는 Adaptee 인터페이스를 사용하여 concreateMethod() 호출로 변경한다. 
이때, Client는 중간에 Adapter가 있다는 것을 인지하지 못한다.
</code>


***
<br><br>

## 장점과 단점

### ➤ 장점
- <strong>인터페이스 호환성 문제 해결:</strong> 기존 코드의 수정 없이 새 코드와 통합할 수 있다. 
- <strong>유연성:</strong>  다양한 클래스 간의 호환성을 제공하여 재사용성을 높일 수 있다.
- <strong>단일 책임 원칙 준수:</strong>어댑터 클래스가 인터페이스 변환 책임을 맡기 때문에 기존 클래스의 역할을 분리할 수 있다.


### ➤ 단점
- <strong>복잡성 증가:</strong> 어댑터가 많아질 경우 코드가 복잡해지고 관리가 어려울 수 있다.
- <strong>성능 문제:</strong> 중간에 어댑터가 끼어들면서 호출 과정이 복잡해지고, 성능에 약간의 영향을 미칠 수 있다.

***
<br><br>

