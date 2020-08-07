RMIT University Vietnam 
Course: INTE2512 
Object-Oriented Programming
Semester: 2019C
Assessment name: ASM1
Team name: None
Team members: Nguyen Dinh Dang Nguyen.

1. INTRODUCTION
This is a Java based programme coded for a small local library in Victoria, Australia with purpose to manage the library's collection of items (books, journals, and DVDs) and lend them to registered members. This programme is written to manage a Library database with an interface of menu for users. As shown in the Task Description, the interface contains 10 different functions which access to the data storage, which are the text files. There are 4 text files containing 5 types of data: Books, Journals, DVDs, Members, Transactions. 
And each data's information is stored with formats: 
Books: id;title;authors;edition;publication;year;isbn;language;subject;status;numberOfCopy;
Journals: id;title;publication;year;issn;language;subject;status;numberOfCopy;
Dvd Info Format: id;title;authors;publication;year;language;subject;status;numberOfCopy;
Member Info Format: fullName;id;phone;email;address;expiredDate;status;
Transactions: memberId;itemId;borrowingDate;penaltyRecord;status;

2. FEATURES
The 10 aforementioned functions are, respectively: search items by keywords, add new item, update item info, search members by keywords, register new member, update member info, borrow items, return items, save data, quit.

3. DESIGN
For searching both in item lists and member lists, it's simply just to turn the input into regex and check if any data matches the given regex.
For adding new data, the input of new information is advised to be put in a constructor to create new object with data.
For update new data, the Setter methods is used to set new data for the existing object.
For borrowing and returning an items, the programme will load in the information of the member and the item in transaction and update data from both objects using Setter methods. And also, an object is manipulated to store the information of the transactions.
For the record, all the methods above load data from multiple text files and keeps it in the Java software. it gives no change to the text files whilst processing. Therefore, a save method is created to save new data to where it loads from.
Also, a save method is put in the quit method as the software saves data automatically when user stops it.  
4. INSTALLATION
the software starts with a loop showing the menu of functions once the user run the series of code. Instructions of input will be described on the screen while the software is running.
5. KNOWN BUGS
None detected.
6. ACKNOWLEDGEMENT
None.