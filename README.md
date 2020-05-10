# Beverage Factory

A simple beverage order application using Spring Boot deployed on on embedded tomcat.

Beverage Factory serves a variety of drinks, juices etc to the customers from its pre-defined set of menu Items.
It offers the customers a choice to customize their drinks in case they want to avoid some specific ingredients from their drinks,
e.g. a person ordering "Chai Latte" which has ingredients as "tea leaves, milk, water, sugar, condiments" a person can order a chai latter without sugar and condiments.
The order value is recalculated based on the actual price of the menu minus the price of the removed ingredient.
So if 1 Cup Chai costed 5 $ and sugar costed 0.5 $ and milk costed 1$ the order: "Chai, - sugar, -milk" would charge
5 - 0.5 - 1.0=3.5$ for the order.
The order to be placed to the shop is always a String concatenated by exclusions. 
1. "Chai, -sugar"
2. "Chai, -sugar, -milk"
3. "Chai"
4. ["Chai, -sugar", "Chai", "Coffee, -milk"] // Chai and Coffee are menu items
are all valid orders.
As a part of this exercise you have to write a program should be able to compute the total price of the order placed. Remember the order can only be a String.

**Below are the Menu Items with their respective ingredients and prices:**
Coffee: "Coffee, milk, sugar, water" Price: 5$
Chai: "Tea, milk, sugar, water" Price: 4$
Banana Smoothie: "banana, milk, sugar, water" Price: 6$
Strawberry Shake: "Strawberries, sugar, milk, water" Price: 7 $
Mojito: "Lemon, sugar, water, soda, mint" Price 7.5 $

**Ingredients prices:**

Milk: 1 $
Sugar: 0.5 $
Soda: 0.5 $
mint: 0.5 $
water: 0.5 $



****Required Developments Tools:****

Java8
Gradle(Optional, as gradle wrapper is packaged in the application)

**Steps to run the test cases:**

`gradlew clean test`

**Steps to run the application:**

`gradlew bootRun`



**Sample Request:** 
`curl --location --request GET 'localhost:8082/beverage/order?customization=Chai,%20-Milk' \
 --header 'Content-Type: application/json'`

**Response:** 
Price: 3.0 $



### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.7.RELEASE/gradle-plugin/reference/html/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

