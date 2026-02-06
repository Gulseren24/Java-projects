/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzaapp;

/**
 *
 * @author Gülseren
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Order extends JFrame {
    private JComboBox<String> pizzaCombo, hamurCombo, boyutCombo;
    private JTextArea siparisAlani;
    private JButton sepeteEkleButton, toplamButton;
    


    private ArrayList<Double> fiyatlar = new ArrayList<>();

    public Order(String kullaniciAdi) {
        setTitle("Sipariş Ekranı - Hoşgeldin " + kullaniciAdi);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Hazır pizzalar
        String[] pizzalar = {
            "Extravaganza", "Karışık", "Pizza Mexicano", "Italiano", "Turkish Pizza", "Favorite Three"
        };

        // Hamur
        String[] hamurTipleri = {
            "Klasik Hamur", "İnce Hamur", "Dubleks Çift Kat Peynir"
        };

        // Boyut
        String[] boyutlar = {
            "Küçük (4 dilim)", "Orta (6 dilim)", "Büyük (8 dilim)"
        };

        pizzaCombo = new JComboBox<>(pizzalar);
        hamurCombo = new JComboBox<>(hamurTipleri);
        boyutCombo = new JComboBox<>(boyutlar);

        sepeteEkleButton = new JButton("Sepete Ekle");
        toplamButton = new JButton("Toplam Fiyatı Göster");
        siparisAlani = new JTextArea(10, 30);
        siparisAlani.setEditable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Pizza Seç:"));
        panel.add(pizzaCombo);

        panel.add(new JLabel("Hamur Seç:"));
        panel.add(hamurCombo);

        panel.add(new JLabel("Boyut Seç:"));
        panel.add(boyutCombo);

        panel.add(sepeteEkleButton);
        panel.add(toplamButton);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(siparisAlani), BorderLayout.CENTER);
       
        
        sepeteEkleButton.addActionListener(e -> sepeteEkle());
        toplamButton.addActionListener(e -> toplamFiyat());

        setVisible(true);
    }

    private void sepeteEkle() {
        String pizza = pizzaCombo.getSelectedItem().toString();
        String hamur = hamurCombo.getSelectedItem().toString();
        String boyut = boyutCombo.getSelectedItem().toString();

        double fiyat = 0;

        // Örnek fiyatlandırma
        switch (pizza) {
            case "Extravaganza": fiyat += 90; break;
            case "Karışık": fiyat += 85; break;
            case "Pizza Mexicano": fiyat += 95; break;
            case "Italiano": fiyat += 80; break;
            case "Turkish Pizza": fiyat += 88; break;
            case "Favorite Three": fiyat += 83; break;
        }

        switch (hamur) {
            case "Klasik Hamur": fiyat += 5; break;
            case "İnce Hamur": fiyat += 4; break;
            case "Dubleks Çift Kat Peynir": fiyat += 10; break;
        }

        switch (boyut) {
            case "Küçük (4 dilim)": fiyat += 0; break;
            case "Orta (6 dilim)": fiyat += 10; break;
            case "Büyük (8 dilim)": fiyat += 20; break;
        }
       

        fiyatlar.add(fiyat);

        siparisAlani.append(pizza + " - " + hamur + " - " + boyut + " = " + fiyat + "₺\n");
    }

    private void toplamFiyat() {
        double toplam = 0;
        for (double f : fiyatlar) {
            toplam += f;
        }

        siparisAlani.append("\nToplam Tutar: " + toplam + "₺\n");
    }
}



