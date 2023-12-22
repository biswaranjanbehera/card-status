Here in this repositories I have implement to fetch the card status by giving the card Id.

The tech stack here used:- Java, Spring boot framework Database used MySql

In the csv_file I have store all the csv file related thing in which I can upload that csv file data to my database, I have used 5 tables for different state with their timestamp and comment to store particular details of a card. Current_status table will give the latest status of the card id. 
these are the tables made
|current_status        |
| delivered_card       |
| delivered_exception  |
| pickup_card          |
| returned

So when you hit the /get_card_status end point with providing the card id it will give all the details of that partiular id like on which date it have on what state and at last it will give the current status, and for the delivery exception state it will give the count of the particular time it will go under the failure of delivered exception state.
This is the response of the postman for a particular card id details
![asgmt](https://github.com/biswaranjanbehera/card-status/assets/79159364/0b8b9471-99ba-4121-92d7-3b044a575202)
