package com.example.strategy.pojo;

public class Gun implements Weapon{
    @Override
    public void leftClick() {
        System.out.println("주무기 총알 나간다.");
    }

    @Override
    public void rightClick() {
        System.out.println("줌이 켜진다.");
    }
}
