# Labs - SOEN 487

This is the template provided to start the web server for the second lab.

We encourage you to use either IntelliJ IDE **or** maven from command line in order to get the best support from our TAs.

## Included Projects ##

1. The server/REST API
   * Located in the rest package
   * Is used to hold the REST API built in the previous lab

2. The client
   * Located in the client package
   * Is used to hold the related classes for building the client side for our lab


## Maven Instructions ##

    Run the following commands in the associated project directory:

    Compile:
        mvn install

    Run (Server)
        mvn exec:java -Pserver

    Run (Customer Client)
        mvn -e exec:java -Pbook

    Clean:
        mvn clean
