/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.socialnetworkhw4;

/**
 *
 * @author Gülseren
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Verilen SocialNetwork sınıfı bir sosyal ağı temsil etmektedir. Sınıfın içinde bir kişinin ismini 
 * arkadaş listesine eşleyen bir Map türünde değişken bulunmaktadır.
 * Bu sınıfın sadece friendsOfFriends, mostPopular ve mostCommonFriends metotlarını değiştirin.
 * Diğer metot ve özellikler testlerin çalışması için gereklidir.
 */
public class SocialNetwork {
  // ************************ Lütfen bu aralıktaki kodları değiştirmeyin *************************
  // Her bir kişinin ismini arkadaş listesine eşleyen bir harita
  private Map<String, List<String>> adjacencyList;
  // Map nesnesi getter
  public Map<String, List<String>> getAdjacencyList() {
    return adjacencyList;
  }

  // Yapıcı
  public SocialNetwork() {
    adjacencyList = new HashMap<>();
  }

  // Sosyal ağa bir kişi ekler
  public void addPerson(String name) {
    if (!adjacencyList.containsKey(name)) {
      adjacencyList.put(name, new ArrayList<String>());
    }
  }

  // İki kişi arasında bir arkadaşlık ekler
  public void addFriendship(String person1, String person2) {
    addPerson(person1);
    addPerson(person2);
    if (!adjacencyList.get(person1).contains(person2)) {
      adjacencyList.get(person1).add(person2);
      adjacencyList.get(person2).add(person1);        
    }
  }

  // Graftaki köşe(vertex) ve kenarların(edge) string temsilini döndürür
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Vertices:\n");
    for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
      String person = entry.getKey();
      builder.append(person + "\n");
    }
    builder.append("\nEdges:\n");
    for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
      String person = entry.getKey();
      List<String> friends = entry.getValue();
      builder.append(person + ": [");
      for (int i = 0; i < friends.size(); i++) {
        String friend = friends.get(i);
        if (i == friends.size() - 1) {
          builder.append(friend);
        } else {
          builder.append(friend + ", ");
        }
      }
      builder.append("]\n");
    }
    return builder.toString();
  }
  // ************************ Lütfen bu aralıktaki kodları değiştirmeyin *************************

  /**
   * Bir kişinin arkadaşının arkadaşı olan, ancak o kişinin arkadaşı olmayan kişileri döndürür
   * 
   * @param name sorgulanacak kişinin ismi(graftaki bir vertex)
   * @return Arkadaşlarının arkadaşlarının listesi
   */
  public List<String> friendsOfFriends(String name) {
    // Sonuç listesi oluştur
    List<String> result = new ArrayList<>();
    
    // Eğer kişi sosyal ağda yoksa boş liste döndür
    if (!adjacencyList.containsKey(name)) {
      return result;
    }
    
    // Kişinin direkt arkadaşlarını al
    List<String> directFriends = adjacencyList.get(name);
    
    // Her bir arkadaşın arkadaşlarını kontrol et
    for (int i = 0; i < directFriends.size(); i++) {
      String friend = directFriends.get(i);
      List<String> friendsOfFriend = adjacencyList.get(friend);
      
      // Arkadaşın her bir arkadaşını kontrol et
      for (int j = 0; j < friendsOfFriend.size(); j++) {
        String potentialFriend = friendsOfFriend.get(j);
        
        // Kendi değilse, direkt arkadaş değilse ve sonuç listesinde yoksa ekle
        if (!potentialFriend.equals(name) && 
            !directFriends.contains(potentialFriend) && 
            !result.contains(potentialFriend)) {
          result.add(potentialFriend);
        }
      }
    }
    
    return result;
  }

  /**
   * Graftaki kişileri arkadaş sayısına göre çoktan aza doğru sıralı olarak döndürür
   * 
   * @return Arkadaş sayısına göre azalan sırada kişilerin adlarının listesi
   */
  public List<String> mostPopular() {
    // Tüm kişileri içeren bir liste oluştur
    List<String> allPeople = new ArrayList<>();
    for (String person : adjacencyList.keySet()) {
      allPeople.add(person);
    }
    
    // Basit bubble sort kullanarak arkadaş sayısına göre sırala
    for (int i = 0; i < allPeople.size(); i++) {
      for (int j = 0; j < allPeople.size() - 1 - i; j++) {
        String person1 = allPeople.get(j);
        String person2 = allPeople.get(j + 1);
        
        int friendCount1 = adjacencyList.get(person1).size();
        int friendCount2 = adjacencyList.get(person2).size();
        
        // Eğer person1'in arkadaş sayısı person2'den azsa yer değiştir
        if (friendCount1 < friendCount2) {
          allPeople.set(j, person2);
          allPeople.set(j + 1, person1);
        }
      }
    }
    
    return allPeople;
  }

  /**
   * En çok ortak arkadaşı olan iki kişiyi liste içinde döndürür. Ortak arkadaş sayısı en çok olan 
   * ikiden fazla kişi olması durumunda herhangi ikisini döndürmek yeterlidir.
   * 
   * @return En çok ortak arkadaşı olan kişilerin isimlerinin bulunduğu liste. Listede 2 vertex bulunmalıdır.
   */
  public List<String> mostCommonFriends() {
    List<String> result = new ArrayList<>();
    int maxCommonFriends = 0;
    
    // Tüm kişileri al
    List<String> allPeople = new ArrayList<>();
    for (String person : adjacencyList.keySet()) {
      allPeople.add(person);
    }
    
    // Her bir kişi çiftini kontrol et
    for (int i = 0; i < allPeople.size(); i++) {
      for (int j = i + 1; j < allPeople.size(); j++) {
        String person1 = allPeople.get(i);
        String person2 = allPeople.get(j);
        
        // İki kişinin ortak arkadaş sayısını hesapla
        int commonCount = 0;
        List<String> friends1 = adjacencyList.get(person1);
        List<String> friends2 = adjacencyList.get(person2);
        
        for (int k = 0; k < friends1.size(); k++) {
          String friend = friends1.get(k);
          if (friends2.contains(friend)) {
            commonCount++;
          }
        }
        
        // Eğer bu çiftin ortak arkadaş sayısı en fazlaysa güncelle
        if (commonCount > maxCommonFriends) {
          maxCommonFriends = commonCount;
          result.clear();
          result.add(person1);
          result.add(person2);
        }
      }
    }
    
    return result;
  }
}
