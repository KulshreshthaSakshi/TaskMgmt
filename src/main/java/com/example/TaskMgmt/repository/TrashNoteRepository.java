package com.example.TaskMgmt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskMgmt.entity.TrashNote;
import com.example.TaskMgmt.entity.User;

public interface TrashNoteRepository extends JpaRepository<TrashNote, Integer> {

    List<TrashNote> findByUser(User user);

    Optional<TrashNote> findTopByOrderByIdDesc();
}
