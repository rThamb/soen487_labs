package com.example.rest;

import javax.annotation.PostConstruct;
import javax.print.attribute.standard.Media;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{title}")
    public Book getBook(@PathParam("title") String title) {

        if(library.size() == 0){
            loadMock();
        }

        Book book = library.stream().filter(theBook -> theBook.getTitle().equals(title))
                .findFirst()
                .orElse(null);
        if (book != null) {
            return book;
        } else {
            return null;
        }
    }

    /**
     * Meant for adding book with specific title
     * @param newBook Book object
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(Book newBook) {

        if(library.size() == 0){
            loadMock();
        }

        library = library.stream().filter(book -> !book.getTitle().equals(newBook.getTitle()))
                .collect(Collectors.toCollection(ArrayList::new));

        library.add(newBook);

        return "New book added";
    }

    /**
     * Meant for editing book.
     *
     * @param title
     * @param author
     * @param isbn
     * @throws Exception
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String editBook(@FormParam("title") String title, @FormParam("author") String author, @FormParam("isbn") String isbn) throws Exception {

        Book book = new Book(title, author, isbn);
        library.remove(book);
        library.add(book);

        return "Edited book.";
    }

}
