# Amazon-TestAutomation
> This is a test automation project on [AmazonEG](https://www.amazon.eg/-/en) website.

## Installation

Clone the repo:

```sh
git clone https://github.com/Mohammed-Nabil99/TestAutomation-Task.git
```

Install dependencies:

You need to install these dependencies from [_mvnrepository_](https://mvnrepository.com/):

```sh
Selenium
Testng
Webdrivermanager
```

## Test Cases

### Test Add Item To Cart
1.	 Open this website: “https://www.amazon.eg/-/en”
2.   Type in Search Field "Car accessories" and click search.
3.   Click on First Product
4.   Click on the add to cart button.
5.   Verify that the product is added to the cart.

### Test TodayDeals Category
1.	 Open this website: “https://www.amazon.eg/-/en”
2.   Click On TodayDeals.
3.   Verify that the page title is same as choosen category.

### Test Filter By Department
1.	 Open this website: “https://www.amazon.eg/-/en”
2.   Click On TodayDeals.
3.	From the left side filters select Department(I used dataProvider for multiple departments).
4.	From the discount part choose "10% off or more".
5.	Verify that the product is added to the cart.


## Tools

- Java
- Selenium
- TestNG
- POM (Page Object Model)
- DDT (Data-driven Testing)
