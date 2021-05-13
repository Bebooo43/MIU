package edu.miu.cs544.lab15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.lab15.domain.Course;

@Transactional(readOnly = true)
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
