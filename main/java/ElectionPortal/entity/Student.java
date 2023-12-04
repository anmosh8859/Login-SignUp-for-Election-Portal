package ElectionPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentUser")
public class Student {
    @Column(name = "name")
    private String fullName;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "university_Id")
    private String uid;

    @Column(name = "password")
    private String password;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}