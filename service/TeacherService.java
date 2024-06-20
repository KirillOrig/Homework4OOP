package service;

import data.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherService implements UserService<Teacher> {

    private final List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Long countMaxId = 0L;
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() > countMaxId) {
                countMaxId = teacher.getTeacherId();
            }
        }
        countMaxId++;
        Teacher teacher = new Teacher(firstName, secondName, patronymic, dateOfBirth, countMaxId);
        teachers.add(teacher);
    }

    public Teacher findTeacherById(long id) {
        for (Teacher teacher : teachers) {
            if (teacher.getTeacherId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public void editTeacherName(Long id, String newFirstName, String newSecondName, String newPatronymic) {
        Teacher teacher = findTeacherById(id);
        if (teacher != null) {
            teacher.setFirstName(newFirstName);
            teacher.setSecondName(newSecondName);
            teacher.setPatronymic(newPatronymic);
        }
    }
}