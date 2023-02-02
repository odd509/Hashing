## How to use

    After cloning the repository, compile it in src with *javac \*.java*
    Then run the compiled code with *java MessageBox”*
    The program takes no arguments and is fully dependent on the .data files and for user inputs, the UI. Characters “-” and “_” are not allowed to be used in text fields for design purposes. 

The development java version is java 15.0.2. 

## Signing Up

You can sign up as a user by clicking the “sign up” button at the homepage. Application then 
creates an instance of User with the provided username and password. Every user must have a 
unique username. Passwords are hashed with SHA3-256 before being stored in the instance. A 
“successful sign up” pop-up window can be seen after the valid credentials are given. 
## Leaving Message

A message can be left to a user at the “Leave a Message” page. Authenticated user needs to 
be selected from the dropdown menu listing every user in the database, a password must be set 
alongside with a codename for the message. Then, the desired message can be left. A Message 
instance is created with the given info and stored inside the message database. Every message 
must have a unique codename. A “successful message” pop-up window can be seen after valid 
credentials are given. 

## Developed by

[odd509](https://github.com/odd509) and [bitsima](https://github.com/bitsima)

![Semodd](/assets/semodd.png)
