/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frame;

import QnA.AnswerDAO;
import QnA.QuestionsDAO;
import QnA.QuestionsVO;
import User.UserDAO;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author min_
 */
public class MemFrame extends javax.swing.JFrame {
    private String id;
    
    public MemFrame(String id) {
        this.id = id;
        lookatFeel();
        initComponents();
        QTableRefresh();
        lblDate.setText(new UserDAO().getDate());
        lblName.setText(new UserDAO().getName(id)+"님 환영합니다");
        setLocation(600, 250);
        btnQuestionDelete.setEnabled(false);
        btnQuestionUpdate.setEnabled(false);
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
    
    public void QTableRefresh(){
        Vector<String> title = new Vector<>(Arrays.asList("문의 코드","문의 전공","문의 제목","문의 일자","답변여부"));
        Vector<Vector> data = new QuestionsDAO().selectQuestions(id);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        frmAnswerList = new javax.swing.JFrame();
        lblAnswerTitle1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAnswerUpdateList = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        listMD = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDataField = new javax.swing.JTextArea();
        btnInsertQ = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableQuestions = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQuestions = new javax.swing.JTextArea();
        btnQuestionUpdate = new javax.swing.JButton();
        btnQuestionDelete = new javax.swing.JButton();
        lblCode = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();

        lblAnswerTitle1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblAnswerTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnswerTitle1.setText("답변내역보기");

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
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("문의하기");

        lblName.setText("xxx님 lblName");

        tab.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabStateChanged(evt);
            }
        });

        listMD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "진료과 선택", "내과", "안과", "치과", "소아과", "비뇨기과", "산부인과", "신경외과", "심장내과", "정형외과", "이비인후과" }));

        jLabel2.setText("문의제목");

        txtDataField.setColumns(20);
        txtDataField.setRows(5);
        jScrollPane3.setViewportView(txtDataField);

        btnInsertQ.setText("문의하기");
        btnInsertQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertQActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listMD, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsertQ)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInsertQ)
                .addContainerGap())
        );

        tab.addTab("문의하기", jPanel1);

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

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        jLabel3.setText("*답변이 있을 경우 내용수정이 불가합니다");

        txtQuestions.setColumns(20);
        txtQuestions.setRows(4);
        jScrollPane1.setViewportView(txtQuestions);

        btnQuestionUpdate.setText("내용수정");
        btnQuestionUpdate.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnQuestionUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestionUpdateActionPerformed(evt);
            }
        });

        btnQuestionDelete.setText("문의삭제");
        btnQuestionDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuestionDeleteActionPerformed(evt);
            }
        });

        lblCode.setForeground(new java.awt.Color(0, 204, 0));
        lblCode.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnQuestionDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuestionUpdate))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCode, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addContainerGap(191, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnQuestionDelete, btnQuestionUpdate});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuestionUpdate)
                    .addComponent(btnQuestionDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.addTab("문의내역", jPanel2);

        lblDate.setText("오늘날짜 lblDate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblName))))
                    .addComponent(tab))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(lblName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //테이블 클릭시
    private void tableQuestionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableQuestionsMouseClicked
       String Qcode = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 0).toString();
       lblCode.setText(Qcode);
       String text = new QuestionsDAO().getQuestionsText(Qcode);
       AnswerDAO dao = new AnswerDAO();
       
       txtQuestions.setText(text);
       if(tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 4).equals("X")){
            frmAnswerList.dispose();
            btnQuestionDelete.setEnabled(true);
            btnQuestionUpdate.setEnabled(true);
       }else{
            String Acode = dao.getAcode(Qcode);
            txtAnswerUpdateList.setText(null);
            if(dao.getCount(Qcode, Acode) > 0){
                HashMap<String,String> data = dao.getAnswerList(Qcode, Acode);
                for(String date : data.keySet()){
                    String list = date+" 답변 내용=========\n";
                    list += data.get(date)+"\n\n";
                    txtAnswerUpdateList.append(list);
                    txtAnswerUpdateList.setEditable(false);
                }
                frmAnswerList.setSize(470,350);
                frmAnswerList.setLocation(1100, 350);
                frmAnswerList.setVisible(true);
            }
            txtQuestions.setEditable(false);
            btnQuestionDelete.setEnabled(false);
            btnQuestionUpdate.setEnabled(false);
       }
    }//GEN-LAST:event_tableQuestionsMouseClicked

    //탭클릭시
    private void tabStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabStateChanged
        lblCode.setText(null);
        txtQuestions.setText(null);
        btnQuestionDelete.setEnabled(false);
        btnQuestionUpdate.setEnabled(false);
        frmAnswerList.dispose();
    }//GEN-LAST:event_tabStateChanged

    //문의하기
    private void btnInsertQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertQActionPerformed
        String title = txtTitle.getText();
        String text = txtDataField.getText();
        String md = (String) listMD.getSelectedItem();
        if(title == null || title.isEmpty()){
            JOptionPane.showMessageDialog(null, "제목이 입력되지않았습니다.", "Error_Message", JOptionPane.ERROR_MESSAGE);
            txtTitle.requestFocus();
        }else if(text == null || text.isEmpty()){
            JOptionPane.showMessageDialog(null, "내용이 입력되지않았습니다.", "Error_Message", JOptionPane.ERROR_MESSAGE);
            txtDataField.requestFocus();
        }else if(md.equals("진료과 선택")){
            JOptionPane.showMessageDialog(null, "문의하실 전공이 선택되지않았습니다.", "Error_Message", JOptionPane.ERROR_MESSAGE);
        }else{
            QuestionsVO vo = new QuestionsVO();
            QuestionsDAO dao = new QuestionsDAO();
            String memCode = new UserDAO().getSelectMemCode(id);
            vo.setTitle(title);
            vo.setQuestionsText(text);
            vo.setMD(md);
            vo.setMemCode(memCode);
            dao.insertQuestions(vo);
            QTableRefresh();
            
            txtTitle.setText(null);
            txtDataField.setText(null);
            listMD.setSelectedIndex(0);
            
            tab.setSelectedIndex(1);
            return;
        }
    }//GEN-LAST:event_btnInsertQActionPerformed

    //삭제하기
    private void btnQuestionDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestionDeleteActionPerformed
        /*
        답변이 없을 경우 삭제, 있으면 disable
        */
        String code = lblCode.getText();
        new QuestionsDAO().deleteQuestion(code);
        JOptionPane.showMessageDialog(null, "문의내역 삭제 완료!", "Error_Message", JOptionPane.INFORMATION_MESSAGE);
        txtQuestions.setText(null);
        QTableRefresh();
    }//GEN-LAST:event_btnQuestionDeleteActionPerformed

    //수정하기
    private void btnQuestionUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuestionUpdateActionPerformed
        /*
        답변이 없을 경우 수정가능, 있으면 disable
        */
        String code = lblCode.getText();
        new QuestionsDAO().updateQuestion(code,txtQuestions.getText());
        JOptionPane.showMessageDialog(null, "문의내역 수정 완료!", "Error_Message", JOptionPane.INFORMATION_MESSAGE);
        QTableRefresh();
    }//GEN-LAST:event_btnQuestionUpdateActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertQ;
    private javax.swing.JButton btnQuestionDelete;
    private javax.swing.JButton btnQuestionUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFrame frmAnswerList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblAnswerTitle1;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JComboBox<String> listMD;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tableQuestions;
    private javax.swing.JTextArea txtAnswerUpdateList;
    private javax.swing.JTextArea txtDataField;
    private javax.swing.JTextArea txtQuestions;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
