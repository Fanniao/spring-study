package com.sun.mapper;

import com.sun.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
	List<Student> findAll();

	Student findById(long id);

	void save(Student student);

	void update(Student student);

	void delete(long id);
}
