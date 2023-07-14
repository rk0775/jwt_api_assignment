# Demo video of <u>signUp and login authentication</u>
https://github.com/rk0775/jwt_api_assignment/assets/118426413/8fa8969e-908e-4bec-bb75-d357d62fd410

# installation and setup
* Get the code and once you update maven all the dependencies are added automatically.
* Once the project is setup, run the Java application.
* Open the postman appliation for testing the api.
* Then test the following apis to sign up and login with web token security.
  # Sign-up
  * Url : POST -> localhost:8080/signUp <br/>
  * And provide the user registration data in JSON formate like<br/>
  {<br/>
    "name" : "rohit",<br/>
    "email" : "rohit@gmail.com",<br/>
    "password" : "rohit"<br/>
  }<br/>
   
![Screenshot (37)](https://github.com/rk0775/jwt_api_assignment/assets/118426413/1f784c52-1284-4616-b7b7-d8713f19784b)
<hr/>
# Login
Url : POST -> localhost:8080/login <br/>
* If registration succefful then login with credentials.
* Provide JSON data<br/>
{<br/>
  "email" : "rohit@gmail.com",<br/>
  "password" : "rohit"<br/>
}<br/>

* If login with wrong credential then server give the invalid credential message.
![Screenshot (38)](https://github.com/rk0775/jwt_api_assignment/assets/118426413/5d93fd0c-5bb2-42c9-b584-4a24ef2a36a4)

* If login with correct credetial then server give one jwt token for security.
![Screenshot (39)](https://github.com/rk0775/jwt_api_assignment/assets/118426413/a38a084b-e864-46d9-8706-0a5707678963)


* Using this token we can access the protected urls.

# Security (demo)
Url : GET -> localhost:8080/hello
* If you add correct <b>JWT token</b> in authorization header then show the data<br/>
  "Hello from GreenStitch"
  ![Screenshot (41)](https://github.com/rk0775/jwt_api_assignment/assets/118426413/bfbb8b34-511b-4f75-9c9a-4b045b7cb41c)

* If you not add authorization header TOKEN then can access this page or url
![Screenshot (42)](https://github.com/rk0775/jwt_api_assignment/assets/118426413/dfbcb5ae-c497-4c91-b3e3-93fd214b2d90)



