/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QnA;

public class QuestionsVO {
    private String memCode;
    private String q_index;
    private String MD;
    private String title;
    private String questionsText;
    private String questionsDate;
    private int status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMemCode() {
        return memCode;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    public String getQ_index() {
        return q_index;
    }

    public void setQ_index(String q_index) {
        this.q_index = q_index;
    }

    public String getMD() {
        return MD;
    }

    public void setMD(String MD) {
        this.MD = MD;
    }

    public String getQuestionsText() {
        return questionsText;
    }

    public void setQuestionsText(String questionsText) {
        this.questionsText = questionsText;
    }

    public String getQuestionsDate() {
        return questionsDate;
    }

    public void setQuestionsDate(String questionsDate) {
        this.questionsDate = questionsDate;
    }
    
    
}
