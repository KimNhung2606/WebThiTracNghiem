package com.tttn.webthitracnghiem.repository;

import com.tttn.webthitracnghiem.dto.QuestionDto;
import com.tttn.webthitracnghiem.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query(value = "SELECT * FROM question join exam_question where question.ques_id = exam_question.ques_id and exam_question.exam_id = :id ", nativeQuery = true)
    List<Question> findAllId(@Param("id") int i);

    @Query(value = "SELECT * FROM question join exam where question.exams_id = exam.id and exam.id = :id",
            nativeQuery = true)
    Page<Question> findAllByExams(@Param("id") int id, Pageable pageable);

    @Query(value = "select question.* from question " +
            "where question.subject_id = :id",
            countQuery = "SELECT COUNT(*) FROM question " +
                    "WHERE question.subject_id = :id",nativeQuery = true)
    Page<Question> findAllBySubject(@Param("id") Optional<Integer> id, Pageable pageable);

    Page<Question> findAllByTitleContaining(String title, Pageable pageable);

    @Query(value = "select question.* from question where question.subject_id = :id and question.title like %:name%",
            countQuery = "select COUNT(*) from question where question.subject_id = :id and question.title like %:name%",
            nativeQuery = true)
    Page<Question> findAllBySubjectAndTitleContaining(@Param("id") int id, @Param("name") String name, Pageable pageable);
    @Query(nativeQuery = true,value = "SELECT * FROM question WHERE lesson_id = :id")
    List<Question> findByLesson(int id);
    @Query(nativeQuery = true,value = "SELECT * FROM question JOIN exam_question ON exam_question.ques_id = question.ques_id WHERE exam_question.exam_id = :examId")
    List<Question> findByExam(@Param("examId") int examId);
    @Query(nativeQuery = true,value = "SELECT * FROM question " +
            "WHERE question.subject_id = :subId")
    List<Question> findBySubAndClass(@Param("subId") int subId);
    @Query(nativeQuery = true,value = "SELECT * FROM question " +
            "WHERE question.subject_id = :subId")
    List<Question> findBySubject(@Param("subId") int subId);

    List<Question> findBySubjectId(@Param("subId") int subId);
}
