Feature: Trendyol Giriş Fonksiyonu

  Scenario: Kullanıcı doğru bilgilerle Trendyol'a giriş yapar

    Given "common@cookiesButton" tiklanir
    And "common@girisYapButton" tiklanir
    And "common@emailInput" alanına "nazlicanrfsdemir0@gmail.com" yazılır
    And "common@passwordInput" alanına "Nazlican.1236" yazılır
    And "common@loginSubmitButton" tiklanir
