# CBR Market Platform, Backend

#### Greeting from Harold澂冰!

## An Introduction to the market platform:

The CBR Market Platform designs for the online market financial people. Currently under construction. it uses Spring Boot as the Backend and React.js + Material UI as the Frontend. This part belongs to the backend development.

#### For more info about frontend and other project info: https://github.com/Harold-y/cbrMarketPlatform_Frontend

## More Information about Backend and the Database:

- The backend uses Maven as the dependency control tool. 

- We have AES256 Encryption for the user and personnel or seller's password info. 

- The Alibaba's druid SQL pool has been integrated into the project to deal with high frequency of queries. 

- Swagger2 is included.

- Mybatis-plus from baomidou is included for easy access of database operation methods and easy creation of MVC system.

- Sa-Token is included for the permission verification, login system, token, etc.

- We also included the Redis connection and operation dependency for your further development's needs.

- Several global and partial web filters and configurations have been added, including the CORS settings, which allows cross origin access from the frontend.

## Some Screen Shot of the development:
![image](https://user-images.githubusercontent.com/68500948/148695296-04d39d56-fa0c-4edd-9073-184369a82e0d.png)

Example Authentification Table:
![image](https://user-images.githubusercontent.com/68500948/148695312-bf9f3606-7b14-4831-815b-12c09333276a.png)

See the Detail of a image if you are a seller:
![image](https://user-images.githubusercontent.com/68500948/148695350-db721a81-692c-490c-8e94-610f8c47cec9.png)

For one merchandise, you can add its images (at most 6), its description images(no limit), its options (for example, a laptop can have option of 16GB RAM or 32GB RAM), option prices, etc.
![image](https://user-images.githubusercontent.com/68500948/148695414-c7cdc7f7-5705-4d15-85c4-1d02ad803f5b.png)

You can even add specific (1) image for each option!
![image](https://user-images.githubusercontent.com/68500948/148695431-c80fbc34-aac1-4a3d-b997-b98888e065ad.png)

## Thanks for Reading
