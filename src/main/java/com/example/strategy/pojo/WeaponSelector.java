package com.example.strategy.pojo;

public class WeaponSelector {
    private Weapon currentWeapon;
    public void selectWeapon(int choice) {
        switch (choice) {
            case 1 -> currentWeapon = new Gun();
            case 2 -> currentWeapon = new Pistol();
            case 3 -> currentWeapon = new Knife();
            default -> System.out.println("잘못된 선택입니다.");
        }
        System.out.println("무기가 변경되었습니다.");
    }

    public void leftClick() {
        if (currentWeapon != null) {
            currentWeapon.leftClick();
        } else {
            System.out.println("무기가 선택되지 않았습니다.");
        }
    }

    public void rightClick() {
        if (currentWeapon != null) {
            currentWeapon.rightClick();
        } else {
            System.out.println("무기가 선택되지 않았습니다.");
        }
    }
}
