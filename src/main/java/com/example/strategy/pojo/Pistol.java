package com.example.strategy.pojo;

public class Pistol implements Weapon{
    @Override
    public void leftClick() {
        System.out.println("보조무기 한발 나간다.");
    }

    @Override
    public void rightClick() {
        System.out.println("아무 반응 없다.");
    }
}
