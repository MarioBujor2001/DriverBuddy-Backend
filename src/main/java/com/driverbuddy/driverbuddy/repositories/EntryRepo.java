package com.driverbuddy.driverbuddy.repositories;

import com.driverbuddy.driverbuddy.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EntryRepo extends JpaRepository<Entry, Integer> {
    @Query("SELECT e FROM Entry e WHERE YEAR(e.date) = :year AND MONTH(e.date) = :month ORDER BY e.date ASC ")
    List<Entry> findByYearAndMonth(Integer year, Integer month);

    Optional<Entry> findByDate(LocalDate date);
}
