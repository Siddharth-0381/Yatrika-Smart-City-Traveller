package Database;

public class UserHelperClass {

    String fullname,username, emailID,password,phoneNo,gender;
    public UserHelperClass(){}

    public UserHelperClass(String fullname, String username, String emailID, String password, String phoneNo, String gender) {
        this.fullname = fullname;
        this.username = username;
        this.emailID = emailID;
        this.password = password;
        this.phoneNo = phoneNo;
        this.gender = gender;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
