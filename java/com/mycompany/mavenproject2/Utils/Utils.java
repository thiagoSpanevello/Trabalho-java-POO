package com.mycompany.mavenproject2.Utils;

import com.mycompany.mavenproject2.Equipment.Item;
import java.util.HashMap;
import java.util.Scanner;

public class Utils {
    public static <K, T> T getClassKeyName(K obj, HashMap<String, T> map) {
        try {
            String className = obj.getClass().getSimpleName();
            return map.get(className);
        } catch (Error e) {
            return null;
        }
    }

    public static void print(Item[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            System.out.print(i + 1 + ": " + arr[i].data.getName());
            if (arr[i].maxStack > 1) {
                System.out.print(" x" + arr[i].getCurrentStack());
            }
            System.out.println();
        }
    }

    public static int select(Item[] arr, int size) {
        int res = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            Utils.print(arr);

            res = scanner.nextInt();
        } while (res < 0 || res > size);

        scanner.close();
        return res - 1;
    }
}
