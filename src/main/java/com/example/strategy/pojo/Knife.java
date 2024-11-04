package com.example.strategy.pojo;

public class Knife implements Weapon{
    @Override
    public void leftClick() {
        System.out.println("베기");
    }

    @Override
    public void rightClick() {
        System.out.println("찌르기");
    }
}
