package User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    String strDriver = "com.mysql.jdbc.Driver";
    String strUrl = "jdbc:mysql://localhost:3306/java_db";
    String root = "root";
    String password = "test1234";
    
    Connection conn;
    Statement stat;
    ResultSet rs;
    
    public UserDAO(){
        try{
            Class.forName(strDriver);
            conn = DriverManager.getConnection(strUrl, root, password);
            stat = conn.createStatement();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 데이터베이스 연결에러");
        }
    }
    
    //현재날짜 가져오기
    public String getDate(){
        String sql = "SELECT left(sysdate(),10) FROM dual";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 현재 날짜 가져오기 에러");
        }
        return null;
    }
    
    //아이디 중복확인
    public boolean isId(String id){
        String sql = "SELECT id FROM login WHERE id = ?";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);
            rs = pstat.executeQuery();
            return rs.next();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 아이디 찾기 에러");
        }
        return false;
    }
    
    //회원 이름 가져오기
    public String getName(String id){
        String sql = "SELECT name FROM memInfo WHERE id = ?";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);
            rs = pstat.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 고객 이름 검색 에러");
        }
        return null;
    }
    
    //멤버코드 가져오기
    public String getSelectMemCode(String id){
        String sql = "SELECT memCode FROM memInfo WHERE id = ?";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);
            rs = pstat.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 멤버코드 조회 에러");
        }
        return null;
    }
    
    //멤버코드 생성하기
    public String createMemCode(String identity){
        String sql = "SELECT IFNULL(max(right(memCode, 3)),'-1') FROM login natural join memInfo WHERE identity = ?";
        String code = null;
        String result;
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, identity);
            rs = pstat.executeQuery();
            if(rs.next()){
                result = rs.getString(1);
                if(result.equals("-1")){
                    code = identity + "001";
                }else{
                    int num = Integer.parseInt(result) + 1;
                    code = identity + String.format("%03d", num);
                }
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 멤버코드 생성 에러");
        }
        return code;
    }
    
    //회원 구분 조회
    public String selectIdentity(UserVO vo){
        String sql = "SELECT identity FROM login WHERE id = ?";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vo.getId());
            rs = pstat.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 구분 조회 에러");
        }
        return null;
    }

    //로그인 인증
    public boolean loginResult(UserVO vo){
        String sql = "SELECT * FROM login WHERE id = ? and pw = sha2(?,512)";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vo.getId());
            pstat.setString(2, vo.getPw());
            rs = pstat.executeQuery();
            return rs.next();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 로그인 인증 에러");
        }
        return false;
    }
    
    //회원가입 login Table
    public int insertLogin(UserVO vo){
        String sql = "INSERT INTO login VALUES(?, sha2(?,512), ?)";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vo.getId());
            pstat.setString(2, vo.getPw());
            pstat.setString(3, vo.getIdentity());
            return pstat.executeUpdate();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 유저 (login) 테이블 삽입 에러");
        }
        return -1;
    }
    
    public int insertPerInfo(UserVO vo){
        String sql = "INSERT INTO perInfo VALUES(?, ?, ?)";
        try{
            //vo.setMemCode(getIdentity(vo.getIdentity()));
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vo.getId());
            pstat.setString(2, vo.getEmail());
            pstat.setString(3, vo.getHP());
            return pstat.executeUpdate();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"|  유저 (perInfo) 테이블 삽입 에러");
        }
        return -1;
    }
    
    public int insertMemInfo(UserVO vo){
        String sql = "INSERT INTO memInfo VALUES(?, ?, ?, ?, ?)";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vo.getId());
            pstat.setString(2, vo.getMemCode());
            pstat.setString(3, vo.getName());
            pstat.setString(4, vo.getSex());
            pstat.setString(5, vo.getBirth());
            return pstat.executeUpdate();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"|  유저 (memInfo) 테이블 삽입 에러");
        }
        return -1;
    }
    
    public int insertDocInfo(UserVO vo, String hospital, String MD){
        String sql = "INSERT INTO docInfo VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vo.getMemCode());
            pstat.setString(2, vo.getName());
            pstat.setString(3, hospital);
            pstat.setString(4, MD);
            return pstat.executeUpdate();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"|  유저 (docInfo) 테이블 삽입에러");
        }
        return -1;
    }
     
}
