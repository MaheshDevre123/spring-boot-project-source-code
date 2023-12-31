package com.fourserveglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fourserveglobal.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
