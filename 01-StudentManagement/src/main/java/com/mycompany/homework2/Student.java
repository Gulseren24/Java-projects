/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework2;

import static com.mycompany.homework2.Homework2.scanner;
import static com.mycompany.homework2.Homework2.students;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gülseren
 */
public class Student {
static List<Student>students=new ArrayList<>();
static Scanner scanner=new Scanner(System.in);


    
 String num;
 String name;
 List<Subject>subjects;
 public Student(String number,String name){
 this.num=number;
 this.name=name;
 this.subjects=new ArrayList<>();
 
 }
   static void getInfo() {
        System.out.println("Student number: ");
        String number1 = scanner.nextLine();

        System.out.println("Student name: ");
        String name1 = scanner.nextLine();

        Student student = new Student(number1, name1);

        while (true) {
            System.out.println("name of subject (enter '*' to exit): ");
            String subName = scanner.nextLine();

            if (subName.equals("*")) {
                break;
            } else {
                System.out.println("Midterm Note: ");
                double midterm1 = scanner.nextDouble();
                scanner.nextLine(); // Satır sonunu temizle

                System.out.println("Final Note: ");
                double finall1 = scanner.nextDouble();
                scanner.nextLine(); // Satır sonunu temizle

                student.subjects.add(new Subject(subName, midterm1, finall1));
            }
        }
        students.add(student);
}  
 static void displayStudents(){
        for(Student student:students){
            System.out.println(student.num+"-"+student.name);
            for(Subject subject:student.subjects){
                System.out.println(" "+subject.name+"Average: "+subject.findAverage());
            }
        }
    }
    static void StudentAverage(){
        for(Student s:students){
            System.out.println(s.num+"-"+s.name);
            for(Subject sub:s.subjects){
                System.out.println(" "+sub.name+" Average of Student : "+sub.findAverage());
            }
        }
    }

    static void notesOfUnderSixty(){
        for(Student s:students){
            for(Subject sub:s.subjects){
                if ( sub.findAverage()<60){
                    System.out.println(s.num+" - "+s.name+" - "+sub.name+" - "+"Average of him/her: "+sub.findAverage());
                }
            }
        }
    }
    static void notesOfUpperAverage(){
        double sum=0;
        int count=0;
        for(Student s:students){
            for(Subject sub:s.subjects){
                sum+=sub.findAverage();
                count++;
            }
        }
        double generalAverage=sum/count;
        for(Student s:students){
            for(Subject sub:s.subjects){
                if(sub.findAverage()>generalAverage)
                    System.out.println(s.num+" - "+s.name+" - "+sub.name+"Average of him/her: "+sub.findAverage());
            }
        }
    }
    static void countOfunderSixtyNotes(){
        int count=0;
        for(Student s:students){
            for(Subject sub:s.subjects){
                if(sub.findAverage()<60)
                    count++;
            }
        }
        System.out.println("Count Of Notes that is Under Sixty:  "+count);
    }
    static void bestNotes(){
        double bestNote=0;
        for(Student s:students){
            for(Subject sub:s.subjects){
                if(sub.midterm>bestNote){
                    if(sub.finall>sub.midterm){
                        bestNote=sub.finall;
                    }else{
                        bestNote=sub.midterm;
                    }
                }
            }
        }
        for(Student s:students){
            for(Subject sub:s.subjects){
                if(sub.finall==bestNote||sub.midterm==bestNote)
                    System.out.println(s.num+" - "+s.name+" - "+sub.name+" - "+"Best Grade: "+bestNote);
            }
        }
    }
    static void SortingAverages(){
        for(int i=0;i<students.size()-1;i++){
            for(int j=0;j<students.size()-i-1;j++){
                double ave1=students.get(j).subjects.stream().mapToDouble(Subject::findAverage).average().orElse(0);
                double ave2=students.get(j+1).subjects.stream().mapToDouble(Subject::findAverage).average().orElse(0);
                if(ave1<ave2){
                    Student temp=students.get(j);
                    students.set(j,students.get(j+1));
                    students.set(j+1,temp);
                }
            }
        }
        displayStudents();
    }

}
