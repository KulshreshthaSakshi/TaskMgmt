package com.example.TaskMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskMgmt.entity.SharedNote;

public interface SharedNoteRepository extends JpaRepository<SharedNote, Integer> {
    // Add custom queries if needed
}
