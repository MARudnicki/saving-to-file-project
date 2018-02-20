package com.example.demo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@AllArgsConstructor
public class BookController {

    private BookDao bookDao;

    @GetMapping(value = "books")
    public List<Book> getBooks() {

        Book book = new Book();
        book.setName(UUID.randomUUID().toString());
        bookDao.save(book);

        return bookDao.findAll();

    }

    @GetMapping(value = "save")
    public String saveBooks() throws Exception{

        List<Book> books = bookDao.findAll();

        String content = new GsonBuilder().setPrettyPrinting().create().toJson(books);
        Files.write(Paths.get("/Users/maciej/Desktop/temp/my-super-file.txt"), content.getBytes());

        return "saved";
    }


}
