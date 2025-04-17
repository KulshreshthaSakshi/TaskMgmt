package com.example.TaskMgmt.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.TaskMgmt.entity.Note;
import com.example.TaskMgmt.entity.User;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByUser(User user);
    List<Note> findByUserAndEventDateGreaterThanEqualOrderByEventDateAsc(User user, Date date);
    List<Note> findByEventDate(LocalDate localDate);
    List<Note> findByUserAndIdNotIn(User user, List<Integer> excludedIds);
    
    
    Optional<Note> findTopByOrderByIdDesc();

    @Query("SELECT n FROM Note n WHERE n.eventDate >= :now AND n.user = :user ORDER BY n.eventDate ASC")
    List<Note> findFutureEventsSorted(User user, Date now);

    @Query("SELECT n FROM Note n WHERE n.ID NOT IN (SELECT s.ID FROM SharedNote s) AND n.user = :user")
    List<Note> findNotesNotInShared(User user);

    @Query("SELECT n FROM Note n WHERE n.eventDate = CURRENT_DATE")
    List<Note> findByEventDateToday();
	List<Note> findByUserAndEventDateIsNotNull(User user);
}
