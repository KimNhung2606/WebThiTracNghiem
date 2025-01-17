package com.tttn.webthitracnghiem.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tttn.webthitracnghiem.model.Exam;
import com.tttn.webthitracnghiem.model.ExamRequest;
import com.tttn.webthitracnghiem.repository.ExamRepository;
import com.tttn.webthitracnghiem.service.IExamService;

@Service
public class ExamServiceImpl implements IExamService {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<Exam> findAll(Pageable pageable) {
        return examRepository.findAll(pageable);
    }

    @Override
    public Exam save(ExamRequest examRequest) {
        Exam exam = modelMapper.map(examRequest,Exam.class);
        System.out.println("Đề thi mới lưu : "+exam);
        return examRepository.save(exam);
    }

    @Override
    public List<Exam> findAllBySubject(int id) {
        return examRepository.findAllBySubject(id);
    }

    @Override
    public Iterable<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public List<Exam> getAll() {
        return examRepository.findAll();
    }

    @Override
    public Exam findById(Integer id) {
        return examRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Exam exam) {
        examRepository.save(exam);
    }

    @Override
    public void delete(Exam exam) {
        examRepository.delete(exam);
    }

    @Override
    public Page<Exam> findAllBySubject(int id, Pageable pageable) {
        return examRepository.findAllBySubject(id, pageable);
    }

    @Override
    public Page<Exam> findAllByLesson(int id, Pageable pageable) {
        return examRepository.findAllByLesson(id,pageable);
    }

    @Override
    public Page<Exam> findAllByNameExamContaining(String name, Pageable pageable) {
        return examRepository.findAllByNameExamContaining(name, pageable);
    }

    @Override
    public Page<Exam> findAllBySubjectId(int subjectId, Pageable pageable) {
        return examRepository.findAllBySubjectId(subjectId, pageable);
    }

    @Override
    public Page<Exam> findAllByNameExamContainingAndBySubject(Integer subjectId, String name, Pageable pageable) {
        return examRepository.findAllBySubjectAndNameExamContaining(subjectId, name,pageable);
    }

    @Override
    public Page<Exam> findAllByNameExamContainingAndByLesson(int id, String name, Pageable pageable) {
        return examRepository.findByNameExamContainingAndLesson(id,name,pageable);
    }

}
