package com.example.service.impl;

import com.example.model.ClassRoom;
import com.example.model.Student;
import com.example.model.Tutor;
import com.example.repository.IStudentRepository;
import com.example.repository.ITutorRepository;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;
    @Autowired
    private ITutorRepository iTutorRepository;

    @Autowired
    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }


    @Override
    public Iterable<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        Set<Tutor> tutors = student.getTutors();
        if (tutors != null && !tutors.isEmpty()) {
            Set<Tutor> managedTutor = new HashSet<>();
            for (Tutor tutor : tutors
            ) {
                if (tutor.getId() != null) {
                    Optional<Tutor> optionalTutor = iTutorRepository.findById(tutor.getId());
                    optionalTutor.ifPresent(managedTutor::add);
                }
            }
            student.setTutors(managedTutor);
        }
        iStudentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(Long id) {
        return iStudentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> findByName(String name) {
        return iStudentRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Student> findByClass(ClassRoom classRoom) {
        return iStudentRepository.findAllByClassRoom(classRoom);
    }

    public Iterable<Student> findStudentByTutors(List<Long> tutorsId) {
        return iStudentRepository.findByTutorsIdIn(tutorsId);
    }
}
