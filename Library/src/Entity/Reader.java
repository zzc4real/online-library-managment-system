package Entity;

/* 读者（学生）类别 */
/* 姓名 学号 证件号（0:未办理） 密码（0:未办理）证件状态(0未办 1在 2挂失) 性别 年龄 专业*/

public class Reader 
{
    private String readername;	//1. 姓名
    private String stuID;		//2. 学号
    private String certiID;		//3. 借书证件号
    private String password;	//4. 密码
    private int state;         //5. 证件状态
    private String sex;			//6. 性别
    private int age;			//7. 年龄
    private String major;		//8. 专业
    private int status;			//9. 黑名单


    public Reader() {
    }

    public String getreadername() {
        return readername;
    }

    public void setreadername(String readername) {
        this.readername = readername;
    }
    
    public String getStuID(){
    	return stuID;
    }
    
    public void setStuID(String stuID){
    	this.stuID = stuID;
    
    }
    
    public String getCertiID(){
    	return certiID;
    }
    
    public void setCertiID(String certiID){
    	this.certiID = certiID;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
