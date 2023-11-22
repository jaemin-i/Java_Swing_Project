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
import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author min_
 */
public class AnswerDAO {
    String strDriver = "com.mysql.cj.jdbc.Driver";
    String strUrl = "jdbc:mysql://localhost:3306/java_db?serverTimezone=Asia/Seoul";
    String root = "root";
    String password = "test1234";
    
    Connection conn;
    Statement stat;
    ResultSet rs;
    
    public AnswerDAO(){
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
        String sql = "SELECT sysDate() FROM dual";
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
    
    //답변 내역 삽입하기
    public int insertAnswer(AnswerVO vo){
        String sql = "INSERT INTO answer VALUES(?, ?, ?, ?, ?)";
        try{
            vo.setA_index(getIdx(vo.getMemCode()));
            vo.setAnswerDate(getDate());
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vo.getMemCode());
            pstat.setString(2, vo.getQ_index());
            pstat.setString(3, vo.getA_index());
            pstat.setString(4, vo.getAnswerText());
            pstat.setString(5, vo.getAnswerDate());
            if(pstat.executeUpdate()>0){
                insertAnswerLog(vo);
                updateStatus(vo, 1);
                return 1;
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 문의 내역 삽입에러");
        }
        return -1;
    }

    //답변시 문의 내역 수정
    public int updateStatus(AnswerVO vo, int idx){
        String sql = "UPDATE questions SET status = ? WHERE q_index = ?";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setInt(1, idx);
            pstat.setString(2, vo.getQ_index());
            if(pstat.executeUpdate()>0){
                return 1;
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 문의내역 상태 수정에러");
        }
        return -1;
    }
    
    //답변 내용 수정하기
    public int updateAnswer(AnswerVO vo){
        String sql = "UPDATE answer SET answerText = ? WHERE memCode = ? and a_index = ?";
        try{
            vo.setAnswerDate(getDate());
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vo.getAnswerText());
            pstat.setString(2, vo.getMemCode());
            pstat.setString(3, vo.getA_index());
            if(pstat.executeUpdate()>0){
                insertAnswerLog(vo);
                updateStatus(vo, 2);
                return 1;
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 답변 수정에러");
        }
        return -1;
    }
    
    //답변 로그 
    public int insertAnswerLog(AnswerVO vo){
        String sql = "INSERT INTO answerLog VALUES(?, ?, ?, ?)";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, vo.getQ_index());
            pstat.setString(2, vo.getA_index());
            pstat.setString(3, vo.getAnswerText());
            pstat.setString(4, vo.getAnswerDate());
            return pstat.executeUpdate();
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 답변내역 수정 로그에러");
        }
        return -1;
    }
    
    //답변 코드 생성하기
    public String getIdx(String memCode){
        String sql = "SELECT IFNULL(MAX(right(q_index,3)),'-1') FROM answer WHERE memCode = ?";
        String code = null;
        String result;
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, memCode);
            rs = pstat.executeQuery();
            if(rs.next()){
                result = rs.getString(1);
                if(result.equals("-1")){
                    code = "A001";
                }else{
                    int num = Integer.parseInt(result) + 1;
                    code = "A" + String.format("%03d", num);
                }
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 답변 코드 생성 에러");
        }
        return code;
    }
    
    //의사의 전공에 맞는 문의 내역 가져오기
    public Vector selectQuestionsAnswer(String id){
        String sql = "SELECT q_index,MD,title,substring(questionsDate,3,14),status FROM questions WHERE finish <> 1 and MD = (SELECT md FROM docInfo WHERE memCode = (SELECT memCode FROM memInfo WHERE id = ?))";
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
            System.out.println("SQL Exception : "+e.getMessage()+"| 의사전용, 환자 문의 내역 검색에러");
        } 
        return data;
    }
    
    //답변 내역 가져오기
    public Vector selectAnswer(String id){
        String sql = "SELECT  b.a_index, a.q_index, title, substring(b.answerDate,3,14) FROM questions a join answer b on a.q_index = b.q_index where b.q_index in (select q_index from answer where memCode = (select memCode from memInfo where  id = ?))";
        Vector<Vector> data = new Vector<>();
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, id);
            rs = pstat.executeQuery();
            while(rs.next()){
                Vector<String> temp = new Vector<>();
                temp.add(rs.getString(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                temp.add(rs.getString(4));
                data.add(temp);
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 의사전용, 답변 내역 검색에러");
        }
        return data;
    }
    
    //답변 내용 가져오기
    public String getAnswerText(String qcode){
        String sql = "SELECT answerText FROM answer WHERE Q_index = ?";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, qcode);
            rs = pstat.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 답변 내용 검색에러");
        }
        return null;
    }
    
    //답변 내역 리스트 가져오기
    public HashMap<String, String> getAnswerList(String qcode, String acode){
        String sql = "SELECT datelog, textlog FROM answerLog WHERE q_index = ? and a_index = ?";
        HashMap<String, String> data = new HashMap();
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, qcode);
            pstat.setString(2, acode);
            rs = pstat.executeQuery();
            while(rs.next()){
                data.put(rs.getString(1),rs.getString(2));
            }
            return data;
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 수정내역 검색에러");
        }
        return null;
    }
    
    //답변 수정 횟수 가져오기
    public int getCount(String qcode, String acode){
        String sql = "SELECT count(*) FROM answerLog WHERE q_index = ? and a_index = ?";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, qcode);
            pstat.setString(2, acode);
            rs = pstat.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 수정내역 개수 검색에러");
        }
        return 0;
    }
    
    //Acode 가져오기
    public String getAcode(String qcode){
        String sql = "SELECT a_index FROM answer WHERE q_index = ?";
        try{
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1, qcode);
            rs = pstat.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(Exception e){
            System.out.println("SQL Exception : "+e.getMessage()+"| 답변코드 검색에러");
        }
        return null;
    }
}
