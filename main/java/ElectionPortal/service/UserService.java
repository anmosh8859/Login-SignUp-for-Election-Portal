package ElectionPortal.service;

import ElectionPortal.dao.AdminDao;
import ElectionPortal.dao.StudentDao;
import ElectionPortal.entity.Admin;
import ElectionPortal.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private AdminDao adminDao;

    public String createAdmin(Admin admin){
        return this.adminDao.saveAdmin(admin);
    }

    public String createStudent(Student student){
        return this.studentDao.saveStudent(student);
    }

    public Admin getAdmin(String id){
        return this.adminDao.findAdmin(id);
    }

    public Student getStudent(String id){
        return this.studentDao.findStudent(id);
    }
}
