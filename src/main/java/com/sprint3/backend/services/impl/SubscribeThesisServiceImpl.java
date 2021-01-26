package com.sprint3.backend.services.impl;

import com.sprint3.backend.entity.*;
import com.sprint3.backend.model.SubscribeThesisDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sprint3.backend.model.MessageDTO;
import com.sprint3.backend.repository.StudentRepository;
import com.sprint3.backend.services.SubscribeThesisService;
import com.sprint3.backend.repository.CheckThesisRepository;
import com.sprint3.backend.repository.ThesisRepository;

@Service
public class SubscribeThesisServiceImpl implements SubscribeThesisService {
    @Autowired
    private ThesisRepository thesisRepository;

    @Autowired
    private CheckThesisRepository checkThesisRepository;

    @Autowired
    private StudentRepository studentRepository;

    /*
     * find student currently logging
     * @param idStudent
     * @return Student
     * */
    @Override
    public Student findStudentCurrentlyLoggingById(Long idStudent) {
        return this.studentRepository.findById(idStudent).orElse(null);
    }

    @Override
    public List<CheckThesis> findAllCheckThesisForMail() {
        return this.checkThesisRepository.findAll();
    }

    /*
     * get all thesis unsubscribed of teacher
     * @param idStudent
     * @return List<Thesis>
     * */
    @Override
    public List<Thesis> findAllThesisUnSubscribedByIdStudent(Long idStudent) {
        boolean check;
        List<Thesis> thesisListResult = new ArrayList<>();
        List<Thesis> thesisListOfTeacher = getThesisOfTeacherCorresponding(idStudent);
        List<CheckThesis> checkThesisList = this.checkThesisRepository.findAll();
        for (Thesis thesis : thesisListOfTeacher) {
            check = true;
            for (CheckThesis checkThesis : checkThesisList) {
                if (checkThesis.getThesis() != null) {
                    if (checkThesis.getThesis().getId().equals(thesis.getId())
                            && checkThesis.getStudentGroup() != null) {
                        check = false;
                        break;
                    }
                } else {
                    this.checkThesisRepository.delete(checkThesis);
                }
            }
            if (check) {
                thesisListResult.add(thesis);
            }
        }
        return thesisListResult;
    }

    /*
     * get all thesis subscribed of teacher
     * @param idStudent
     * @return List<Thesis>
     * */
    @Override
    public List<CheckThesis> findAllThesisSubscribedByIdStudent(Long idStudent) {
        boolean check;
        List<CheckThesis> checkThesisListResult = new ArrayList<>();
        List<Thesis> thesisListOfTeacher = getThesisOfTeacherCorresponding(idStudent);
        List<CheckThesis> checkThesisList = this.checkThesisRepository.findAll();
        for (CheckThesis checkThesis : checkThesisList) {
            check = false;
            if (checkThesis.getThesis() != null) {
                for (Thesis thesis : thesisListOfTeacher) {
                    if (checkThesis.getThesis().getId().equals(thesis.getId())) {
                        check = true;
                        break;
                    }
                }
            }
            if (check) {
                checkThesisListResult.add(checkThesis);
            }
        }
        return checkThesisListResult;
    }

    private List<Thesis> getThesisOfTeacherCorresponding(Long idStudent) {
        Long idTeacher = null;
        Student student = this.studentRepository.findById(idStudent).orElse(null);
        List<Thesis> thesisListOfTeacher = new ArrayList<>();
        List<Thesis> thesisListExists = this.thesisRepository.findAll();
        if (student != null) {
            idTeacher = student.getStudentGroup().getTeacher().getId();
        }
        if (idTeacher != null) {
            for (Thesis thesis : thesisListExists) {
                if (thesis.getTeacher().getId().equals(idTeacher)) {
                    thesisListOfTeacher.add(thesis);
                }
            }
        }
        return thesisListOfTeacher;
    }

    /*
     * get thesis by id
     * @param idThesis
     * @return Thesis
     * */
    @Override
    public Thesis findThesisById(Long idThesis) {
        return this.thesisRepository.findById(idThesis).orElse(null);
    }

    /*
     * subscribe thesis of Teacher
     * @param idThesis, idStudent
     * @return MessageDTO
     * */
    @Override
    public MessageDTO subscribeThesisOfTeacher(Long idThesis, Long idStudent) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            CheckThesis checkThesis = new CheckThesis();
            StudentGroup studentGroup = new StudentGroup();
            Student student = this.studentRepository.findById(idStudent).orElse(null);
            if (student != null) {
                studentGroup = student.getStudentGroup();
            }
            checkThesis.setStatus(false);
            checkThesis.setThesis(thesisRepository.findById(idThesis).orElse(null));
            checkThesis.setStudentGroup(studentGroup);
            this.checkThesisRepository.save(checkThesis);
            messageDTO.setMessage("Complete");
        } catch (RuntimeException runtimeException) {
            messageDTO.setMessage("Failed");
        }
        return messageDTO;
    }

    @Override
    public MessageDTO unsubscribeThesis(Long idCheckThesis) {
        MessageDTO messageDTO = new MessageDTO();
        try {
            CheckThesis checkThesis = this.checkThesisRepository.findById(idCheckThesis).orElse(null);
            if (checkThesis != null) {
                checkThesis.setStudentGroup(null);
                checkThesis.setThesis(null);
                this.checkThesisRepository.save(checkThesis);
                this.thesisRepository.delete(checkThesis.getThesis());
                messageDTO.setMessage("Complete");
            } else {
                messageDTO.setMessage("Failed");
            }
        } catch (RuntimeException runtimeException) {
            messageDTO.setMessage("Error");
        }
        return messageDTO;
    }

    /*
     * create thesis
     * @param idStudent, subscribeThesisDTO
     * @return MessageDTO
     * */
    @Override
    public MessageDTO createThesis(Long idStudent, SubscribeThesisDTO subscribeThesisDTO) {
        MessageDTO messageDTO = new MessageDTO();
        StudentGroup studentGroup;
        Teacher teacher;
        Student student = this.studentRepository.findById(idStudent).orElse(null);
        if (student != null) {
            studentGroup = student.getStudentGroup();
            teacher = studentGroup.getTeacher();

            // create Thesis
            Thesis thesis = createNewThesis(subscribeThesisDTO, teacher);

            // create CheckThesis
            createCheckThesis(studentGroup, thesis);
        }

        return messageDTO;
    }

    private Thesis createNewThesis(SubscribeThesisDTO subscribeThesisDTO, Teacher teacher) {
        Thesis thesis = new Thesis();
        thesis.setStatement(subscribeThesisDTO.getStatement());
        thesis.setAmount(subscribeThesisDTO.getAmount());
        thesis.setDescription(subscribeThesisDTO.getDescription());
        thesis.setTeacher(teacher);
        thesis.setCreateDate(LocalDateTime.now());
        this.thesisRepository.save(thesis);
        return thesis;
    }

    private void createCheckThesis(StudentGroup studentGroup, Thesis thesis) {
        CheckThesis checkThesis = new CheckThesis();
        checkThesis.setThesis(thesis);
        checkThesis.setStudentGroup(studentGroup);
        this.checkThesisRepository.save(checkThesis);
    }
}
