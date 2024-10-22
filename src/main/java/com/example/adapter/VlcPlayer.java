package com.example.adapter;

// Adaptee
// target과 호환되지 않는 클래스2, 새롭게 추가된 기능
public class VlcPlayer {
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }
}
