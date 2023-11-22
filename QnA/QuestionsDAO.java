/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QnA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class QuestionsDAO {
    String strDriver = "com.mysql.cj.jdbc.Driver";
    String strUrl = "jdbc:mysql://localhost:3306/java_db";
    String root = "root";
    String password = "test1234";
    
    Connection conn;
    Statement stat;
    ResultSet rs;
    
    public QuestionsDAO(){
        try{
            Class.forName(strDriver);
            conn = DriverManager.getConnection(strUrl, root, password);
            stat = conn.createStatement();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 데이터베이스 연결에러");
        }
    }
    
    //현재 날짜, 시간가져오기
    public String getDate(){
        String sql = "SELECT substring(sysDate(), 3,14) FROM dual";
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
    
    //문의 코드 생성하기
    public String getIdx(String memCode){
        String sql = "SELECT IFNULL(MAX(right(q_index,3)),'-1') FROM questions";
        String code = null;
        String result;
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            rs = pstat.executeQuery();
            if(rs.next()){
                result = rs.getString(1);
                if(result.equals("-1")){
                    code = "Q001";
                }else{
                    int num = Integer.parseInt(result) + 1;
                    code = "Q" + String.format("%03d", num);
                }
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 문의 코드 생성 에러");
        }
        return code;
    }
    
    //문의 내역 삽입하기
    public int insertQuestions(QuestionsVO vo){
        String sql = "INSERT INTO questions VALUES(?, ?, ?, ?, ?,?,0,0)";
        try{
            vo.setQ_index(getIdx(vo.getMemCode()));
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vo.getMemCode());
            pstat.setString(2, vo.getQ_index());
            pstat.setString(3, vo.getMD());
            pstat.setString(4, vo.getTitle());
            pstat.setString(5, vo.getQuestionsText());
            pstat.setString(6, getDate());
            return pstat.executeUpdate();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 문의 내역 삽입에러");
        }
        return -1;
    }
    
    //문의 내역 가져오기
    public Vector selectQuestions(String id){
        String sql = "SELECT q_index,MD,title,substring(questionsDate,3,14),status FROM questions WHERE memcode = (SELECT memcode FROM memInfo WHERE id = ?) and finish = 0";
        Vector<Vector> data = new Vector<>();
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);
            rs = pstat.executeQuery();
            while(rs.next()){
                String stat;
                switch (rs.getInt(5)) {
                    case 1:
                        stat = "O";
                        break;
                    case 2:
                        stat = "U";
                        break;
                    default:
                        stat = "X";
                        break;
                }
                Vector<String> temp = new Vector<>();
                temp.add(rs.getString(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                temp.add(rs.getString(4));
                temp.add(stat);
                data.add(temp);
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 문의 내역 검색에러");
        }
        return data;
    }
    
    //문의 내용 가져오기
    public String getQuestionsText(String qcode){
        String sql = "SELECT questionsText FROM questions WHERE Q_index = ? and finish = 0";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, qcode);
            rs = pstat.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 문의 내용 검색에러");
        }
        return null;
    }
    
    //문의 내역 삭제하기
    public int deleteQuestion(String qcode){
        String sql = "UPDATE questions SET finish = 1 WHERE q_index = ?";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, qcode);
            return pstat.executeUpdate();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 문의 내역 삭제 에러");
        }
        return -1;
    }
    
    //문의 내용 수정하기
    public int updateQuestion(String qcode, String text){
        String sql = "UPDATE questions SET questionsText = ? WHERE q_index = ?";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, text);
            pstat.setString(2, qcode);
            return pstat.executeUpdate();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 문의 내용 수정에러");
        }
        return -1;
    }
}
