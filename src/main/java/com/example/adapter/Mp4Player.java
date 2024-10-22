package com.example.adapter;

// Adaptee
// target과 호환되지 않는 클래스1, 새롭게 추가된 기능
// 클라이언트가 사용하려는 (어댑터가 감싸서 호출할) 실제 객체이다.
public class Mp4Player {

    // 타겟의 인터페이스와 호환되지 않는 인터페이스를 가진다.
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
