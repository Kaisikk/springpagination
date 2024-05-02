package com.kaisikk.java.springpagination.repo;

import com.kaisikk.java.springpagination.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepo extends JpaRepository<Person, Long> {

    @Query(value = "select * from person order by id desc limit 10", nativeQuery = true)
    Iterable<Person> findLast10();

    Iterable<Person> findAllByIdBetweenOrderByIdDesc(Long start, Long finish);

}
