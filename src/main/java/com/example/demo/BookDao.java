package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookDao extends PagingAndSortingRepository<Book, Long>, CrudRepository<Book, Long> {

    List<Book> findAll();

}
