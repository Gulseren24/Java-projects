/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homework2;

/**
 *
 * @author Gülseren
 */
public class Subject {
   String name;
 double midterm;
 double finall;
 public Subject(String name,double vize,double finall){
this.name=name;
this.midterm=vize;
this.finall=finall;
}
 public double findAverage(){
 
     return (finall*0.6)+(midterm*0.4);
 } 
}
