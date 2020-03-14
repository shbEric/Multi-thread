package com.super404.atomic.chapter6_5;

import java.util.concurrent.atomic.AtomicReference;

/**
 * AtomicReference Demo
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<Student> studentAtomicReference = new AtomicReference<>();
        Student xdclass = new Student(1L, "xdclass");
        Student super404 = new Student(2L, "super404");

        studentAtomicReference.set(xdclass);
        studentAtomicReference.compareAndSet(xdclass,super404);
        Student student = studentAtomicReference.get();
        System.out.println(student);
    }
}

class Student{
    private long id;
    private String name;

    public Student() {
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}