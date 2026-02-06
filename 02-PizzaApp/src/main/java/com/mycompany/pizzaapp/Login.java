/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzaapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Gülseren
 */


public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        setTitle("Pizza Giriş");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Kullanıcı Adı:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Şifre:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Giriş Yap");
        panel.add(new JLabel()); // boşluk
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> checkLogin());

        setVisible(true);
    }

    private void checkLogin() {
        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        // Basit örnek kontrol
        if (user.equals("admin") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Giriş başarılı!");
            dispose(); // bu ekranı kapat
            new Order(user); // sipariş ekranına geç
        } else {
            JOptionPane.showMessageDialog(this, "Hatalı giriş!");
        }
    }
}


