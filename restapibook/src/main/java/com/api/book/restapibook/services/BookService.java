package com.api.book.restapibook.services;
import com.api.book.restapibook.dao.BookRepository;
import com.api.book.restapibook.entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookService {
//    private static List<Book> list = new ArrayList<>();
//    static{
//        list.add(new Book(3,"happiness","raj"));
//        list.add(new Book(4,"race","aman"));
//        list.add(new Book(5,"legend","chaman"));
//    }
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> list = (List<Book>)this.bookRepository.findAll();
        return list;
    }

    public Book singleBook(int id){
        int searchID = id;
        Book res=null;
        try{
//            for(Book e : list ){
//                if(e.getId() == searchID){
//                    res = e;            }
//            }
            res = this.bookRepository.findById(searchID);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    // for adding book
    public Book addBook(Book b){
       Book result = bookRepository.save(b);
        return result;
    }

    //delete book
    public void deleteBook(int bid){
//        list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    //update book
    public void updateBook(Book book, int bid){
//        list = list.stream().map(b -> {
//            if(b.getId()==bid){
//                b.setAuthor(book.getAuthor());
//                b.setTitle(book.getTitle());
//            }
//            return b;
//        }).collect(Collectors.toList());
        book.setId(bid);
        bookRepository.save(book);
    }
}
