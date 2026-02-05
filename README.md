## Spring Boot 4 + Spring Security 7 demo: Google OAuth 2.0 / OpenID Connect authentication

[![Java CI with Maven](https://github.com/OKaluzny/spring-boot-security-oauth2-google/actions/workflows/maven.yml/badge.svg)](https://github.com/OKaluzny/spring-boot-security-oauth2-google/actions/workflows/maven.yml)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen)
![Spring Security](https://img.shields.io/badge/Spring%20Security-7.0.2-brightgreen)
![Java](https://img.shields.io/badge/Java-17+-orange)

Microservice using OAuth 2.0 and OpenID Connect to authenticate with Google and get user information.

### Technology stack:

* Java 17+
* Maven
* Spring Boot 4.0
* Spring Security 7
* OAuth2 Client
* AngularJS, HTML, CSS

### 1. Register your app in Google Cloud Console:

* Go to https://console.cloud.google.com and login with your Google account
* Create a new project or select an existing one
* Navigate to "APIs & Services" → "Credentials" → "Create Credentials" → "OAuth client ID"
* Application Type: "Web Application"
* Authorized redirect URIs: `http://localhost:8181/login/oauth2/code/google`
* Copy the **Client ID** and **Client Secret**

### 2. Configure the application:

Copy the example config and add your credentials:
```bash
cp src/main/resources/application-local.yml.example src/main/resources/application-local.yml
```

Edit `application-local.yml` with your Client ID and Client Secret.

### 3. Run the application:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

**Alternative:** use environment variables instead of `application-local.yml`:
```bash
export GOOGLE_CLIENT_ID=your-client-id
export GOOGLE_CLIENT_SECRET=your-client-secret
mvn spring-boot:run
```

### 4. Open browser:

Navigate to http://localhost:8181

Click "Google Login" to authenticate with your Google account.
