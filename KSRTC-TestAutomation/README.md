# KSRTC-TestAutomation
> This is a test automation project on [_KSRTC_](https://ksrtc.in/oprs-web/guest/home.do?h=1) website (Indian Transporation Company).

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

### Test Checkout
1.	Open this website: “https://ksrtc.in/oprs-web/guest/home.do?h=1”
2.	Choose the following Cities (from "CHIKKAMAGALURU" to "BENGALURU”)
3.	Choose the arrival date only (date picker)
4.	Click “Search for bus”
5.	Select a seat
6.	Choose the boarding point and dropping point
7.	Fill in the “Customer” and “Passenger” details
8.	Click on “make payment” and fill in all the fields without submitting the payment
9.	Assert that the Bus Booking Transaction is appeared

### Test Valid Customer Details
1.	Open this website: “https://ksrtc.in/oprs-web/guest/home.do?h=1”
2.	Choose the following Cities (from "CHIKKAMAGALURU" to "BENGALURU”)
3.	Choose the arrival date only (date picker)
4.	Click “Search for bus”
5.	Select a seat
6.	Choose the boarding point and dropping point
7.	Fill in the “Customer” (I used **data-driven** for different customers) details
8.	Assert that the Proceed To Checkout Button is enabled

### Test Search For Trip
1.	Open this website: “https://ksrtc.in/oprs-web/guest/home.do?h=1”
2.	Choose the following Cities (from "CHIKKAMAGALURU" to "BENGALURU”)
3.	Choose the arrival date only (date picker)
4.	Click “Search for bus”
5.	Assert that the appeared trips contain the name of selected departure city

## Tools

- Java
- Selenium
- TestNG
- POM (Page Object Model)
- DDT (Data-driven Testing)
