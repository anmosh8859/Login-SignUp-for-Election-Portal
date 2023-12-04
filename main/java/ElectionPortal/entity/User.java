package ElectionPortal.entity;

public class User {
    private String userType;
    private String fullName;
    private String id;
    private String uid;
    private String password;
    private String cnfPassword;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

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

    public String getCnfPassword() {
        return cnfPassword;
    }

    public void setCnfPassword(String cnfPassword) {
        this.cnfPassword = cnfPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userType='" + userType + '\'' +
                ", fullName='" + fullName + '\'' +
                ", id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", password='" + password + '\'' +
                ", cnfPassword='" + cnfPassword + '\'' +
                '}';
    }
}