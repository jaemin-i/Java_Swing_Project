/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import QnA.AnswerDAO;
import QnA.AnswerVO;
import QnA.QuestionsDAO;
import User.UserDAO;
import java.awt.Frame;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author min_
 */
public class DocFrame extends javax.swing.JFrame {
    private String id;
    
    public DocFrame(String id) {
        this.id = id;
        lookatFeel();
        initComponents();
        questionsTablePanelFunc();
        lblDate.setText(new UserDAO().getDate());
        lblName.setText(new UserDAO().getName(id)+"님 환영합니다.");
        setLocation(600, 250);
        btnAnswer.setEnabled(false);
    }
    
    public void lookatFeel(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    //테이블 초기화
    public void questionsTablePanelFunc(){
        System.out.println(id);

        Vector<String> title = new Vector<>(Arrays.asList("문의 코드","문의 전공","문의 제목","문의 일자","답변여부"));
        Vector<Vector> data = new AnswerDAO().selectQuestionsAnswer(id);
        tableQuestions.setModel(new DefaultTableModel(data, title){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        tableQuestions.getColumnModel().getColumn(0).setPreferredWidth(60);
        tableQuestions.getColumnModel().getColumn(1).setPreferredWidth(80);
        tableQuestions.getColumnModel().getColumn(2).setPreferredWidth(150);
        tableQuestions.getColumnModel().getColumn(3).setPreferredWidth(125);
        tableQuestions.getColumnModel().getColumn(4).setPreferredWidth(60);
       
        tableQuestions.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        tableQuestions.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
    }
    
    //테이블 초기화
    public void answerTablePanelFunc(){
    Vector<String> title = new Vector<>(Arrays.asList("답변 코드","문의 코드","문의 제목","답변 일자"));
        Vector<Vector> data = new AnswerDAO().selectAnswer(id);
        tableAnswers.setModel(new DefaultTableModel(data, title){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        
        tableAnswers.getColumnModel().getColumn(0).setPreferredWidth(75);
        tableAnswers.getColumnModel().getColumn(1).setPreferredWidth(95);
        tableAnswers.getColumnModel().getColumn(2).setPreferredWidth(180);
        tableAnswers.getColumnModel().getColumn(3).setPreferredWidth(125);
       
        tableAnswers.getTableHeader().setReorderingAllowed(false); // 컬럼들 이동 불가
        tableAnswers.getTableHeader().setResizingAllowed(false); // 컬럼 크기 조절 불가
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        frmAnswer = new javax.swing.JFrame();
        lblAnswerTitle = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnswerInsert = new javax.swing.JTextArea();
        btnAnswerInsert = new javax.swing.JButton();
        frmAnswerList = new javax.swing.JFrame();
        lblAnswerTitle1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAnswerUpdateList = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableQuestions = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestions = new javax.swing.JTextArea();
        btnAnswer = new javax.swing.JButton();
        lblQuestionCode = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAnswers = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtAnswers = new javax.swing.JTextArea();
        btnAnswerUpdate = new javax.swing.JButton();
        lblAnswerCode = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();

        lblAnswerTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblAnswerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnswerTitle.setText("답변하기");

        txtAnswerInsert.setColumns(20);
        txtAnswerInsert.setRows(5);
        jScrollPane3.setViewportView(txtAnswerInsert);

        btnAnswerInsert.setText("답변등록");
        btnAnswerInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmAnswerLayout = new javax.swing.GroupLayout(frmAnswer.getContentPane());
        frmAnswer.getContentPane().setLayout(frmAnswerLayout);
        frmAnswerLayout.setHorizontalGroup(
            frmAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmAnswerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmAnswerLayout.createSequentialGroup()
                        .addGap(0, 314, Short.MAX_VALUE)
                        .addComponent(btnAnswerInsert))
                    .addComponent(lblAnswerTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        frmAnswerLayout.setVerticalGroup(
            frmAnswerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmAnswerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnswerTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnswerInsert)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        lblAnswerTitle1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblAnswerTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnswerTitle1.setText("수정내역보기");

        txtAnswerUpdateList.setColumns(20);
        txtAnswerUpdateList.setRows(5);
        jScrollPane6.setViewportView(txtAnswerUpdateList);

        javax.swing.GroupLayout frmAnswerListLayout = new javax.swing.GroupLayout(frmAnswerList.getContentPane());
        frmAnswerList.getContentPane().setLayout(frmAnswerListLayout);
        frmAnswerListLayout.setHorizontalGroup(
            frmAnswerListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmAnswerListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frmAnswerListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(lblAnswerTitle1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        frmAnswerListLayout.setVerticalGroup(
            frmAnswerListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmAnswerListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAnswerTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTitle.setText("환자문의 관리");

        lblName.setText("xxx님 lblName");

        tab.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabStateChanged(evt);
            }
        });

        jPanel2.setEnabled(false);

        tableQuestions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"M001", "아이악", "ㅇㅁㄴㅇㅁㄴ", "2019-01-01",  new Integer(0)},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "문의 코드", "문의 전공", "문의 제목", "문의 일자", "답변 유무"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableQuestions.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableQuestions.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableQuestions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableQuestionsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableQuestions);

        jLabel1.setText("문의내용보기");

        txtQuestions.setColumns(20);
        txtQuestions.setRows(4);
        jScrollPane1.setViewportView(txtQuestions);

        btnAnswer.setText("답변하기");
        btnAnswer.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerActionPerformed(evt);
            }
        });

        lblQuestionCode.setForeground(new java.awt.Color(0, 204, 0));
        lblQuestionCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblQuestionCode, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuestionCode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnswer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("문의내역", jPanel2);

        jPanel3.setEnabled(false);

        tableAnswers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"M001", "아이악", "ㅇㅁㄴㅇㅁㄴ", "2019-01-01"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "답변 코드", "문의 코드", "문의 제목", "답변 일자"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableAnswers.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableAnswers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableAnswers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAnswersMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableAnswers);

        jLabel5.setText("답변내용보기");

        txtAnswers.setColumns(20);
        txtAnswers.setRows(4);
        jScrollPane5.setViewportView(txtAnswers);

        btnAnswerUpdate.setText("답변수정");
        btnAnswerUpdate.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAnswerUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnswerUpdateActionPerformed(evt);
            }
        });

        lblAnswerCode.setForeground(new java.awt.Color(0, 204, 0));
        lblAnswerCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblAnswerCode, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnswerUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAnswerCode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnswerUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );

        tab.addTab("답변내역", jPanel3);

        lblDate.setText("오늘날짜 lblDate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblName)
                .addContainerGap())
            .addComponent(tab)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(171, 171, 171))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // 탭클릭시 초기화
    private void tabStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabStateChanged
        lblQuestionCode.setText(null);
        txtQuestions.setText(null);
        btnAnswer.setEnabled(false);
        frmAnswerList.dispose();
        answerTablePanelFunc();
        questionsTablePanelFunc();
    }//GEN-LAST:event_tabStateChanged

    // 문의내역 테이블 클릭
    private void tableQuestionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableQuestionsMouseClicked
       String Qcode = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 0).toString();
       lblQuestionCode.setText(Qcode);
       String text = new QuestionsDAO().getQuestionsText(Qcode);
       
       txtQuestions.setText(text);
       txtQuestions.setEditable(false);
       if(tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 4).equals("X")){
            btnAnswer.setEnabled(true);
       }else{
            btnAnswer.setEnabled(false);
       }
    }//GEN-LAST:event_tableQuestionsMouseClicked

    // 답변내역 테이블 클릭
    private void tableAnswersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAnswersMouseClicked
       String Qcode = tableAnswers.getValueAt(tableAnswers.getSelectedRow(), 1).toString();
       String Acode = tableAnswers.getValueAt(tableAnswers.getSelectedRow(), 0).toString();
       lblAnswerCode.setText(Qcode);
       txtAnswerUpdateList.setText(null);
       AnswerDAO dao = new AnswerDAO();
       if(dao.getCount(Qcode, Acode) > 1){
           HashMap<String,String> data = dao.getAnswerList(Qcode, Acode);
           for(String date : data.keySet()){
               String list = date+" 수정 내용=========\n";
               list += data.get(date)+"\n\n";
               txtAnswerUpdateList.append(list);
               txtAnswerUpdateList.setEditable(false);
           }
           frmAnswerList.setSize(470,350);
           frmAnswerList.setLocation(1100, 350);
           frmAnswerList.setVisible(true);
       }else{
           frmAnswerList.dispose();
       }
       
       String text = dao.getAnswerText(Qcode);
       txtAnswers.setText(text);
       
    }//GEN-LAST:event_tableAnswersMouseClicked

    // 답변하기
    private void btnAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerActionPerformed
       frmAnswer.setSize(470,350);
       frmAnswer.setLocation(1100, 350);
       txtAnswerInsert.setText(null);
       frmAnswer.show();
       /*
       
       */
    }//GEN-LAST:event_btnAnswerActionPerformed

    // 답변수정
    private void btnAnswerUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerUpdateActionPerformed
        String Qcode = tableAnswers.getValueAt(tableAnswers.getSelectedRow(), 1).toString();
        String Acode = tableAnswers.getValueAt(tableAnswers.getSelectedRow(), 0).toString();
        String text = new AnswerDAO().getAnswerText(Qcode);
        if(!text.equals(txtAnswers.getText())){
            AnswerVO avo = new AnswerVO();
            avo.setQ_index(Qcode);
            avo.setA_index(Acode);
            avo.setMemCode(new UserDAO().getSelectMemCode(id));
            avo.setAnswerText(txtAnswers.getText());
            if(new AnswerDAO().updateAnswer(avo) > 0){
                questionsTablePanelFunc();
                JOptionPane.showMessageDialog(null, "답변 수정 완료", "Success_Message", JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                JOptionPane.showMessageDialog(null, "답변 수정 실패", "Error_Message", JOptionPane.ERROR_MESSAGE);
            }
        }else{
                JOptionPane.showMessageDialog(null, "수정 사항이 없습니다.", "Error_Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAnswerUpdateActionPerformed

    // 답변등록
    private void btnAnswerInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnswerInsertActionPerformed
        /*
        txtAnswerInsert
        btnAnswerInsert
        frmAnswer.dispose()
          */
        
        if(txtAnswerInsert.getText().isEmpty()){
           return;
        }
        AnswerVO vo = new AnswerVO();
        vo.setMemCode(new UserDAO().getSelectMemCode(id));
        vo.setAnswerText(txtAnswerInsert.getText());
        vo.setQ_index(lblQuestionCode.getText());
        if(new AnswerDAO().insertAnswer(vo) > 0){
            questionsTablePanelFunc();
            JOptionPane.showMessageDialog(null, "답변 등록 완료", "Success_Message", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "답변 등록 실패", "Error_Message", JOptionPane.ERROR_MESSAGE);
        }
        frmAnswer.dispose();
    }//GEN-LAST:event_btnAnswerInsertActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnswer;
    private javax.swing.JButton btnAnswerInsert;
    private javax.swing.JButton btnAnswerUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFrame frmAnswer;
    private javax.swing.JFrame frmAnswerList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblAnswerCode;
    private javax.swing.JLabel lblAnswerTitle;
    private javax.swing.JLabel lblAnswerTitle1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblQuestionCode;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tableAnswers;
    private javax.swing.JTable tableQuestions;
    private javax.swing.JTextArea txtAnswerInsert;
    private javax.swing.JTextArea txtAnswerUpdateList;
    private javax.swing.JTextArea txtAnswers;
    private javax.swing.JTextArea txtQuestions;
    // End of variables declaration//GEN-END:variables
}
