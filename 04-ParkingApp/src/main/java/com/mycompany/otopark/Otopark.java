/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.otopark;


/**
 *
 * @author Gülseren
 */
public class Otopark {
private int kapasite;//min 10
private double  ucret;//negatif olamaz
private  Arac [] araclar;
private double kazanc;

    public static void main(String[] args) {
     
      
    }
    public Otopark(int kapasite1,int ucret){
    setKapasite(kapasite1);
    setUcret(ucret);
    
    araclar=new Arac [this.kapasite];
    
    }
    public Otopark(double ucret,Arac [] cars ){
    setUcret(ucret);
    setKapasite(cars.length);
    araclar=new Arac[this.kapasite];
     for(int i=0;i<cars.length;i++){
      if (cars[i]!=null)
        araclar[i]=cars[i];
      
     }
    }
     public void AracGiris(Arac arac){
      
         if(araclar.length<kapasite)
           for(int i=0;i<kapasite;i++){
             if( araclar[i]==null){
              araclar[i]=arac;

             }

            }
          
         
       }  
public void aracCıkar(String plaka){
         for(int i=0;i<araclar.length;i++){
           if(araclar[i] != null&& araclar[i].getPlaka().equals(plaka)){
               Arac arac_temp = araclar[i];
               araclar[i]=null;
            }  
         }
       return arac_temp;  
     }


             


    /**
     * @return the kapasite
     */
    public int getKapasite() {
        return kapasite;
    }

    /**
     * @param kapasite the kapasite to set
     */
    public void setKapasite(int kapasite) {
        if(kapasite>10)
        this.kapasite = kapasite;
        else{
            System.out.println("kapasite 10'dan buyuk olmali");
            this.kapasite=10;
        }
    }

    /**
     * @return the ucret
     */
    public double getUcret() {
        return ucret;
    }

    /**
     * @param ucret the ucret to set
     */
    public void setUcret(double ucret) {
       if(ucret>0)
        this.ucret = ucret;
       else{
           System.out.println("negatif sayi girisi hatalı");
           this.ucret=1;
       }
    }

    /**
     * @return the kazanc
     */
    public double getKazanc() {
        return kazanc;
    }
    
}

     
     