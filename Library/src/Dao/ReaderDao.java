package Dao;

import Entity.Reader;
import Util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReaderDao extends DBConnect
{
	
	public String stulogin(Reader r)
    {
        try {
            Connection conn = super.getConnection();
            
            String sql = "SELECT password,readername FROM reader WHERE certiID=?";
            
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, r.getCertiID()); //"SELECT password,readername FROM reader WHERE certiID= 得到确切的certiID"
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                if (r.getPassword().equals(rs.getString("password")))
                {
                    r.setreadername(rs.getString("readername"));
                    System.out.println("---------------- 学生用户名密码验证成功了-————————————----");
                    return "true";
                }
                else{
                    return "false";
                }
            }
            else{
                return "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
    public Reader QueryReaderById(String id)
    {
        Reader reader = new Reader();
        IODao ioDao = new IODao();
        Connection conn = null;
        try {
            conn = super.getConnection();
            String sql = "SELECT * FROM reader WHERE readername=" + "'" + id + "'";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) /* 姓名 [学号] 证件号（0:未办理） 密码（0:未办理）证件状态(0未办 1在 2挂失) 性别 年龄 专业 黑名单(1正0非)*/
            {
                reader.setreadername(rs.getString("readername"));
                reader.setCertiID(rs.getString("certiID"));
                reader.setPassword(rs.getString("password")); /*考虑要不要显示出来*/
                reader.setState(rs.getInt("state"));
                reader.setSex(rs.getString("sex"));
                reader.setAge(rs.getInt("age"));
                reader.setMajor(rs.getString("major"));
                reader.setStatus(rs.getInt("status"));
                //reader.setBorrow(ioDao.QueryBorrowNumByReaderid(id).size());
            }
            return reader;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public ArrayList<Reader> GetAllReader()
    {
        ArrayList<Reader> ReaderList = new ArrayList<>();
        Connection conn = null;
        try {
            conn = super.getConnection();
            String sql = "SELECT * FROM reader";
            PreparedStatement pst = null;
            ResultSet rs = null;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Reader reader = null;
            while(rs.next()){
                reader = new Reader();
                reader.setreadername(rs.getString("readername"));
                reader.setStuID(rs.getString("stuID"));
                reader.setCertiID(rs.getString("certiID"));
                reader.setPassword(rs.getString("password"));
                reader.setState(rs.getInt("state"));
                reader.setSex(rs.getString("sex"));
                reader.setAge(rs.getInt("age"));
                reader.setMajor(rs.getString("major"));
                reader.setStatus(rs.getInt("status"));
                ReaderList.add(reader);
            }
            return ReaderList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void SetBlackList(String readername, boolean isblack)
    {
        int i = 0;
        Connection conn = null;
        String sql = null;
        try {
            conn = super.getConnection();
            PreparedStatement pst = null;
            if(isblack == true)
                sql = "UPDATE reader SET status=1 WHERE readername=?";
            else
                sql = "UPDATE reader SET status=-1 WHERE readername=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, readername);
            i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
