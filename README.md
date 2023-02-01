#Book Store application

Design and implement a book store application usingSpring boot, JPA and mysql database. Expose rest api endpoints to demonstrate the following use cases. Authentication is not required for the system

Use Case 1:
Expose an endpoint to Create a User, Suspend a User and Update a User. Suspended Users will not be able to borrow books from the application.
Each user should have a unique identifier (can be a nickname/unique username) Each user should have a unique mail id andunique phone number



Use Case 2:
Expose an endpoint to Add money to the User's wallet.
If the user does not have sufficient balance he should not be able to borrow the books. Minimum amount accepted is in the multiples of SOO

Use Case 3:
Expose an endpoint to Add Books to the application.
A Book should contain the following name, author, price, category. You should also store the reviews of the book
Each book should have a unique identifier
Each book can have number of copies tracked separately as inventory {Say you can have 10 copies of Harry Potter)

Use Case 4:
Users should have the ability to search for the books available. Books which are currently out of stock should be indicated as out of stock while returning the results. Users have ability to sort by likes and date added

Use Case 5:
Users should be able to borrow books from the application under the below rules The user should deposit 20% of the price if the book asa security deposit
The rental fees are 10%of the price of the book {deducted at the time of return) Users can only rent 3 books at a time
Users can rent the same book multiple times but not consecutively


Use Case 6:
Users should be able to post reviews and likes on the books they have rented upon.Reviewing not rented books are not allowed

Use Case 7:
Users should be able to return the books that they have rented. Once the book is returned the balance amount after deposit is deposited back to the wallet

Use Case 8:
Users should be able to see the transaction history of rentals and returns

Use Case 9:
Users should be able to see transaction history of their wallet


Use Case 10:
Expose an api to generate the stores transaction summary (list of all the transactions across all the users)


Use Case 11:
Users have ability to report a user's review as abusive and if more than 3 reports are made on the user he should be suspended and his reviews should be disabled(should not be deleted)
