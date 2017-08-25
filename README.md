# FTChat

FTChat is a client-server chat application that lets you add other users and communicate them via text messages, plus, it lets you export all your messages too, in a .txt file.

## Team

  * Kauê Eufrosino Lima
    * 177650
    * kaueel
    
  * Vinícius Cazelli Ferreira
    * 188110
    * viniciuscazelli
    
  * Felipe Yanagui Gomiero 
    * 171257
    * FelipeGomiero


## Requisites

 * the FTChat application must let you create a new account (using just a name and a password) on it
 * the FTChat application must let you add a known user by his name
 * the FTChat application must let you see the list of added users, lets name they as a friend
 * the FTChat application must let you select a friend from your list of friends and go to the conversation page, that will show all the past messages
 * the FTChat application must let you send messages in a conversation page to the selected friend
 * the FTChat application must let you export all the past conversation as a .txt file
 
### Technology Stack

What we will use for this project is:
  * a SQL Server container on Microsoft Azure as our database
  * Java for our back-end using JDBC for the MySQL connection as a "bridge"
  * Swing for our interface 

### Principal parts

Here we will describe some of the principal parts of the application, explaining a little about their details
  * User
    * the user is the final client that is using our application
  * Account
    * Account is the credencial information that a registred user have, it's basically composed by a name (that is used to login and used as a reference to become a friend of other user), a password and other meta informations 
  * Friend
    * Friend is a relation between two different users (a user must not be able to add himself as a friend)
  * List of Friends
    * A list of friend relations that the actualy logged user have (it must be a clickable list)
  * Converstion Page
    * It's a page containing all messages already sent by each one of the users, lifecycle:
      * the conversation page send a request to the back-end saying that it needs all messages between the user with ID X and the user with ID Y
      * the back-end go ask MySQL for the information
      * the MySQL can answer to this request with either a array with all messages or a empty array, if no rows was matched
      * the back-end send the response to the front-end
      * the front-end create all messages found
      * the back-end from the conversation page keeps asking to the MySQL if is there any new messages since last check
      * if there's any new message, the back-end will send to the front-end, that will create the message node
  * Message
    * Message is as package of information, here we will describe his lifecycle:
      * the message text is sent by the client
      * the front-end send it to the back-end
      * the back-end validate it (check if the sender and the receiver have a valid ID, if the message text is not empty)
      * the back-end fullfil it with some meta information like sender ID, receiver ID, sent date, etc
      * the back-end send it to the MySQL database wich keeps it storaged as well all the meta information around it
      * the MySQL send a confirmation saying that the information was storaged with success
      * the back-end will refresh and create all needed nodes
  * Export
    * Export is a feature that let the user export all the messages with a friend, to a .txt file

## License

This project is licensed under the **MIT** License
