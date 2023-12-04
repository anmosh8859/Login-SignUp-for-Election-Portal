package ElectionPortal.dao;

import ElectionPortal.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public String saveStudent(Student student){
        return (String) this.hibernateTemplate.save(student);
    }
    @Transactional
    public Student findStudent(String id){
        return this.hibernateTemplate.get(Student.class,id);
    }
}
