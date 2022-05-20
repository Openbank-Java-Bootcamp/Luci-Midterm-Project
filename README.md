# LUCI BANKING SYSTEM 

## Description
In this REST API project I built a banking system. The system has 4 types of Accounts:
- Student Checking
- Checking
- Credit Card
- Savings

It has 3 types of Users too:
- AccountHolder
- Admin
- Third Party

Admins can create new accounts, but only Checking, Credit Card or Savings. They have access to the balance to any account and they can modify it as well.
AccountHolders have access to their balance and the can transfer money to any other account.
Thir Party Users can receive and send money with their hashed key.

## Set Up
1. Clone or download the project from the repository.
2. Open the directory as a project on a IDE as IntelliJ.
3. Create a MySQL database: banking.
4. Run the *DemoMidtermApllicationProject.java* file on the path:

```
.src/main/java/com/example/demomidtermproject/DemoMidtermProjectApplication.java
```
5. Use the Server Routes with Postman.

## Techonologies Used
MySQL, Spring Boot & Java

## Models

## Server Routes
  <img src="https://github.com/Openbank-Java-Bootcamp/Luci-Midterm-Project/blob/c1083fd6ca210a4b8ae6fadbf522a9e557d1c6ea/endpoints.png">

## Future Work

## Resources

