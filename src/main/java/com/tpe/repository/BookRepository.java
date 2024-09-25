package com.tpe.repository;

import com.tpe.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//optional
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByTitle(String title);//select * from t_book where title=?


    @Query("select b from Book b where b.author=:yazar")
    List<Book> findByAuthorWithJPQL(@Param("yazar") String author);//select * from t_book where author=?


    //ödev!!!
    //Sql:select * from t_book where author=? and publication_date=?  jpql ile yapıcaz

}
