package com.mycompany.mavenproject2.Utils;
import com.mycompany.mavenproject2.Equipment.Item;
import java.util.Scanner;

public class Utils {
    
    /* Items aux methods */
    
    public static void print(Item[] arr, int size){
        for(int i = 0; i<size; i++){
            if(arr[i] == null) continue;
            System.out.print(i+1 + ": " + arr[i].data.getName());
            if(arr[i].stackable) System.out.print(" x" + arr[i].getCurrentStack());
            System.out.println();
        }
    }
    
     public static int select(Item[] arr, int size){
        int res = 0;
        Scanner scanner = new Scanner(System.in);
        
        do{
            Utils.print(arr, size);
            
            res= scanner.nextInt();
        } while(res < 0 || res > size);
  
        scanner.close();
        return res - 1;
    }
}
