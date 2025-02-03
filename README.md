# 📧 Vérification d'Email avec Java Spring Boot

## 📝 Description
Ce projet est une API REST en **Spring Boot** permettant l'inscription d'un utilisateur avec vérification d'email. Lorsqu'un utilisateur s'inscrit, un email contenant un lien de validation est envoyé. Une fois le lien cliqué, le compte est activé.

## 📌 Fonctionnalités
✅ Inscription d'un utilisateur
✅ Envoi d'un email de vérification
✅ Validation du compte via un lien unique
✅ Sécurité avec **Spring Security**
✅ Stockage des utilisateurs dans une base de données MySQL

---

## 🚀 Installation et Exécution

### 🔹 1. Cloner le projet
```sh
git clone https://github.com/votre-repo/email-verification-springboot.git
cd email-verification-springboot
```

### 🔹 2. Configurer MySQL
Assurez-vous que **MySQL est installé et en cours d'exécution**, puis créez une base de données :
```sql
CREATE DATABASE spring_email_verification;
```
Modifiez le fichier `src/main/resources/application.properties` :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_email_verification?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=ton_mot_de_passe
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

### 🔹 3. Configurer l'envoi d'email (SMTP)
Ajoutez votre configuration SMTP dans `application.properties` :
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=ton-email@gmail.com
spring.mail.password=ton-mot-de-passe
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
🛑 **Important** : Activez **"Less Secure Apps"** pour Gmail ou utilisez **Mailtrap** en test.

### 🔹 4. Lancer l'application
```sh
mvn spring-boot:run
```

L'application démarre sur `http://localhost:8080` 🚀

---

## 🔥 Tester l'API

### 1️⃣ Inscription d'un utilisateur
- **Endpoint :** `POST /api/auth/register`
- **Body (JSON) :**
```json
{
    "email": "test@example.com",
    "password": "password123"
}
```

📩 Un email de vérification est envoyé avec un lien contenant un **token**.

### 2️⃣ Vérification du compte
- **Endpoint :** `GET /api/auth/verify?token=xxxx-xxxx-xxxx`
- **Réponse attendue :** `Compte vérifié !`

Vérifiez dans la base MySQL :
```sql
SELECT * FROM users WHERE email='test@example.com';
```
Si `isVerified = true`, tout fonctionne ✅

---

## 🔒 Sécurité avec Spring Security
- **Endpoints ouverts** : `/api/auth/register` et `/api/auth/verify`
- **Endpoints protégés** : Tous les autres nécessitent une authentification
- **Configuration dans `WebSecurityConfig.java`**

---

## 📜 Licence
Ce projet est sous licence **MIT**. Vous pouvez l'utiliser librement !

---

## 🤝 Contribution
Les PRs sont les bienvenues ! Clonez, testez et proposez vos améliorations 🚀

---

## 📬 Contact
📧 **Email** : walid.madad123@gmail.com  
🐙 **GitHub** : [github.com/votre-profil](https://github.com/walidmadad)  
💼 **LinkedIn** : [linkedin.com/in/votre-nom](https://www.linkedin.com/in/walid-madad-610828200/)
