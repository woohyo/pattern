package com.example.strategy.pojo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeaponSelector context = new WeaponSelector();

        System.out.println("무기를 선택하세요 (1: 총, 2: 권총, 3: 칼): ");
        int choice = scanner.nextInt();

        context.selectWeapon(choice);

        System.out.println("행동을 선택하세요 (1: 좌클릭, 2: 우클릭): ");
        int action = scanner.nextInt();

        if (action == 1) {
            context.leftClick();
        } else if (action == 2) {
            context.rightClick();
        } else {
            System.out.println("잘못된 선택입니다.");
        }
    }
}
