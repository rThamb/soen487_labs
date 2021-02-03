package com.example.rest;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Path("book")
public class BookRest {

    /**
     * Class for holding the list of Books and handling the requests
     */

    private static ArrayList<Book> library = new ArrayList<>();


    private void loadMock() {
        Book b1 = new Book("Book 1" , "John", "isb-1");
        Book b2 = new Book("Book 2" , "John", "isb-2");
        Book b3 = new Book("Book 3" , "John", "isb-3");

        library.add(b1);
        library.add(b2);
        library.add(b3);
    }

    /**
     * Meant for getting a book with a specific title
     * @param title of the book
     * @return toString method of book
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{title}")
    public String getBook(@PathParam("title") String title) {

        if(library.size() == 0){
            loadMock();
        }

        Book book = library.stream().filter(theBook -> theBook.getTitle().equals(title))
                .findFirst()
                .orElse(null);
        if (book != null) {
            return book.toString();
        } else {
            return "";
        }
    }

    /**
     * Meant for replacing book with specific title
     * @param title of the book
     * @param author of the book
     * @param isbn of the book
     */
    @PUT
    @Path("{title}/{author}/{isbn}")
    public void modifyBook(@PathParam("title") String title, @PathParam("author") String author,
                               @PathParam("isbn") String isbn) {

        if(library.size() == 0){
            loadMock();
        }

        library = library.stream().filter(book -> !book.getTitle().equals(title))
                .collect(Collectors.toCollection(ArrayList::new));
        Book newBook = new Book(title, author, isbn);
        library.add(newBook);
    }

}
