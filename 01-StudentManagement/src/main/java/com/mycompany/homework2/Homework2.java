/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.homework2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Gülseren
 */
public class Homework2 {
static List<Student>students=new ArrayList<>();
static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {
       
       while (true) {
           ShowMenu();
            
            int choice = scanner.nextInt();
                    scanner.nextLine();
                    if(choice <0||choice>9)
                        System.out.println("enter a number again  1 to 9");
                        if (choice == 9) break;
             runMenu(choice);
       }      
             scanner.close();
    }  
    private static void ShowMenu(){
        System.out.println("--------/MENU/-------");
                    System.out.println("1-enter students info");
                    System.out.println("2-display students info");
                    System.out.println("3-find average");
                    System.out.println("4-display students that's lower than 60");
                    System.out.println("5-display grades that's higher than average");
                    System.out.println("6-display count of grades that's lower than 60");
                    System.out.println("7-display best grade");
                    System.out.println("8-sequence of students to averages");
                    System.out.println("9-exit");
                    System.out.println("enter a number to 1-9");
                    
    }
    
    private static void runMenu(int choice){
                   switch (choice) {
                        case 1:Student.getInfo(); break;
                        case 2:Student.displayStudents();break;
                        case 3:Student.StudentAverage();break;
                        case 4:Student.notesOfUnderSixty();break;
                        case 5:Student.notesOfUpperAverage();break;
                        case 6:Student.countOfunderSixtyNotes();break;
                        case 7:Student.bestNotes();break;
                        case 8:Student.SortingAverages();break;
                        case 9:return;
                        default:
                        
                    }
    }
}
    

