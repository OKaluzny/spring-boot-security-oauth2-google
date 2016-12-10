## Spring Boot Security OAuth2 Google and Angular JS
 
Microservice using OAuth 2.0 and OpenID Connect to authenticate in the Google and get information to user.

### Technology stack:

* Maven;
* Spring Boot;
* Spring Web;
* Spring Security;
* OAuth2 authentication;
* Angular JS, HTML, CSS.

### 1. For registration your app in Google App, perform the following steps:

* Go to https://console.developers.google.com and login with your Google account (this will be the developer account and the email of this account will be published when someone tries to authenticate with the Google application).
* If you don't have a project create a new one and then click into the project.
* In the menu "API manager" on the left side select "Credentials" --> "Create credentials" --> "OAuth client ID".

![alt tag](http://i.piccy.info/i9/c88b72e2d85f9a5a754bde87266d2d53/1480693194/70408/1085055/oauth1.jpg)

* Application Type -> "Web Application",
* Authorized Javascript Origins -> " ", 
* Authorized Redirect URI -> [http://localhost:8181/google/login](http://localhost:8181/google/login)

![alt tag](http://i.piccy.info/i9/a5cd6bb69a9e8a243a31386341c57245/1480693875/89876/1085055/oauth2.jpg)

* Copy the client ID and client Secret and update the `application.yml`

![alt tag](http://i.piccy.info/i9/9b536cd9e0b49d8a1199df529a47719c/1480698351/29528/1085055/oauth3.jpg)
  
### 2. To run this application use:

```bash
mvn spring-boot:run
  ```

###3. Open browser and browse at 
[http://localhost:8181/google/login](http://localhost:8181/google/login)
