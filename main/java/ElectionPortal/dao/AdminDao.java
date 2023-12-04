package ElectionPortal.dao;

import ElectionPortal.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AdminDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public String saveAdmin(Admin admin){
        return (String) this.hibernateTemplate.save(admin);
    }
    @Transactional
    public Admin findAdmin(String id){
        return this.hibernateTemplate.get(Admin.class,id);
    }
}