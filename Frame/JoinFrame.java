package Frame;

import User.UserDAO;
import User.UserVO;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author jaemin
 */
public class JoinFrame extends javax.swing.JFrame {
    
    public JoinFrame(){
        initComponents();
        lookatFeel();
        setLocation(600, 250);
        this.setSize(400, 400);
        lblHospital.setVisible(false);
        txtHospital.setVisible(false);
        cbMD.setVisible(false);
        this.setDefaultCloseOperation(JoinFrame.DISPOSE_ON_CLOSE);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        identity = new javax.swing.ButtonGroup();
        sex = new javax.swing.ButtonGroup();
        txtJoinId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnExist = new javax.swing.JButton();
        btnJoinMem = new javax.swing.JButton();
        RegMem = new javax.swing.JRadioButton();
        docMem = new javax.swing.JRadioButton();
        txtJoinPw = new javax.swing.JPasswordField();
        txtPwChk = new javax.swing.JPasswordField();
        lblJoin = new javax.swing.JLabel();
        lblJoinId = new javax.swing.JLabel();
        lblJoinPw = new javax.swing.JLabel();
        lblPwChk = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblIden = new javax.swing.JLabel();
        lblHospital = new javax.swing.JLabel();
        cbMD = new javax.swing.JComboBox<>();
        txtHospital = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblSex = new javax.swing.JLabel();
        Male = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        lblBirth = new javax.swing.JLabel();
        lblHP = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtBirth = new javax.swing.JFormattedTextField();
        txtHP = new javax.swing.JFormattedTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmDomain = new javax.swing.JComboBox<>();
        lblIdCheck = new javax.swing.JLabel();
        lblPwCheck = new javax.swing.JLabel();
        lblEmptyDelete = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtJoinId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJoinIdKeyReleased(evt);
            }
        });

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
        });

        btnExist.setText("중복 확인");
        btnExist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExistActionPerformed(evt);
            }
        });

        btnJoinMem.setText("회원 가입");
        btnJoinMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinMemActionPerformed(evt);
            }
        });

        identity.add(RegMem);
        RegMem.setSelected(true);
        RegMem.setText("일반회원");
        RegMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegMemActionPerformed(evt);
            }
        });

        identity.add(docMem);
        docMem.setText("의사회원");
        docMem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docMemActionPerformed(evt);
            }
        });

        txtJoinPw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtJoinPwKeyReleased(evt);
            }
        });

        txtPwChk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPwChkKeyReleased(evt);
            }
        });

        lblJoin.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblJoin.setText("회원 가입");

        lblJoinId.setText("아이디");

        lblJoinPw.setText("비밀번호");

        lblPwChk.setText("비밀번호 확인");

        lblName.setText("성명");

        lblIden.setText("회원 구분");

        lblHospital.setText("근무 병원");

        cbMD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "진료과 선택", "내과", "안과", "치과", "소아과", "비뇨기과", "산부인과", "신경외과", "심장내과", "정형외과", "이비인후과" }));

        btnBack.setText("취소");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblSex.setText("성별");

        sex.add(Male);
        Male.setSelected(true);
        Male.setText("남자");

        sex.add(Female);
        Female.setText("여자");

        lblBirth.setText("생년월일");

        lblHP.setText("전화번호");

        lblEmail.setText("이메일");

        try {
            txtBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtBirth.setText("2000/01/01 ");
        txtBirth.setToolTipText("생년월일(8자리) 입력");

        try {
            txtHP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("010-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setText("@");

        cmDomain.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "naver.com", "gmail.com", "daum.net", "nate.com" }));

        lblIdCheck.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
        lblIdCheck.setOpaque(true);

        lblPwCheck.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblPwCheck.setOpaque(true);

        lblEmptyDelete.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblEmptyDelete.setForeground(new java.awt.Color(255, 0, 0));
        lblEmptyDelete.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblJoin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnJoinMem))
                            .addComponent(lblHospital, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblJoinId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblJoinPw, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23)
                                        .addComponent(txtJoinId))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPwChk, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblHP, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblIden, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblSex, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Male)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Female))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtJoinPw, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                                    .addComponent(txtPwChk)
                                                    .addComponent(txtBirth)
                                                    .addComponent(txtHP)
                                                    .addComponent(txtEmail)))
                                            .addComponent(txtHospital, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(RegMem, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(docMem, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbMD, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmDomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblIdCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnExist)))
                                        .addComponent(lblPwCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblEmptyDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(13, 13, 13))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblJoin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblJoinId, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtJoinId)
                        .addComponent(btnExist)
                        .addComponent(lblIdCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblJoinPw, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                            .addComponent(txtJoinPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lblPwChk, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                                    .addComponent(txtPwChk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPwCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblSex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Male, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Female))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(cmDomain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIden)
                            .addComponent(RegMem)
                            .addComponent(docMem)
                            .addComponent(cbMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHospital)
                            .addComponent(txtHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack)
                            .addComponent(btnJoinMem))
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmptyDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // 의사, 유저 구분
    private void docMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docMemActionPerformed
        this.setSize(400, 450);
        lblHospital.setVisible(true);
        txtHospital.setVisible(true);
        cbMD.setVisible(true);
    }//GEN-LAST:event_docMemActionPerformed

    private void RegMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegMemActionPerformed
        this.setSize(400, 400);
        lblHospital.setVisible(false);
        txtHospital.setVisible(false);
        cbMD.setVisible(false);
    }//GEN-LAST:event_RegMemActionPerformed

    //취소버튼
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    //아이디 중복체크
    private void btnExistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExistActionPerformed
        UserDAO dao = new UserDAO();
        if(txtJoinId.getText().replaceAll("[^a-zA-Z]", "").length() < 3){
            errorMessage("아이디가 너무 짧아요.\n숫자 제외 3글자 이상으로 해주세요.");
            return;
        }
        if(txtJoinId.getText().length() > 15){
            errorMessage("아이디가 너무 길어요.\n숫자 포함 15글자 이내로 해주세요.");
            return;
        }
        if(txtJoinId.getText().isEmpty() || dao.isId(txtJoinId.getText())){    // 아이디가 존재
            lblIdCheck.setText("Fail");
            lblIdCheck.setForeground(new Color(255, 0, 0));
        }else{
            lblIdCheck.setText("OK");
            lblIdCheck.setForeground(new Color(11, 102, 35));
        }
    }//GEN-LAST:event_btnExistActionPerformed

    //패스워드 유효성검사
    private void txtPwChkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPwChkKeyReleased
        if(txtPwChk.getText().isEmpty()){
            lblPwCheck.setText("");
            return;
        }
       
        if(evt.getKeyChar() == KeyEvent.VK_SPACE){
            txtPwChk.setText(txtPwChk.getText().replaceAll(" ", ""));
            lblEmptyDelete.setText("공백 자동 삭제");
            return;
        }else{
            lblEmptyDelete.setText("");
        }
        
        pwChk();
    }//GEN-LAST:event_txtPwChkKeyReleased

    //패스워드 확인 유효성검사
    private void txtJoinPwKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJoinPwKeyReleased
        if(evt.getKeyChar() == KeyEvent.VK_SPACE){
            txtJoinPw.setText(txtJoinPw.getText().replaceAll(" ", ""));
            lblEmptyDelete.setText("공백 자동 삭제");
        }else{
            lblEmptyDelete.setText("");
        }
        
        if(txtJoinPw.getText().isEmpty() || txtPwChk.getText().isEmpty()){
            lblPwCheck.setText("");
            return;
        }
        
        pwChk();
    }//GEN-LAST:event_txtJoinPwKeyReleased

    //아이디 유효성검사
    private void txtJoinIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJoinIdKeyReleased
        String pattern = "^([a-zA-Z0-9]*)$";
        if(!Pattern.matches(pattern, txtJoinId.getText())){ //ID에 a-z, A-Z, 0-9 이외의 값이 들어오면
            txtJoinId.setText(txtJoinId.getText().replaceAll("[^a-zA-Z0-9]", "")); //그 외 모든 값을 제거한다.
        }
    }//GEN-LAST:event_txtJoinIdKeyReleased

    //회원가입버튼
    private void btnJoinMemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinMemActionPerformed
        if(txtJoinId.getText().isEmpty()){
            errorMessage("아이디를 입력해주세요.");
            txtJoinId.requestFocus();
            return;
        }else if(txtJoinId.getText().length() < 3){
            errorMessage("아이디가 너무 짧아요.\n숫자 제외 3글자 이상으로 해주세요.");
            txtJoinId.requestFocus();
            return;
        }else if(!lblIdCheck.getText().equals("OK")){
            errorMessage("아이디 중복체크 확인해주세요.");
            txtJoinId.requestFocus();
            return;
        }else if(txtJoinPw.getText().isEmpty()){
            errorMessage("패스워드를 입력해주세요.");
            txtJoinPw.requestFocus();
            return;
        }else if(txtJoinPw.getText().length() < 8 || txtJoinPw.getText().length() > 20){
            errorMessage("패스워드는 8~20자 이내로 입력해주세요.");
            txtJoinPw.requestFocus();
            return;
        }else if(!lblPwCheck.getText().equals("비밀번호 일치")){
            return;
        }else if(txtName.getText().isEmpty()){
            errorMessage("이름을 입력해주세요");
            txtName.requestFocus();
            return;
        }else if(txtBirth.getText().replace(" ", "").length() != 10){
            errorMessage("생년월일이 형식과 맞지않습니다\nex)2000/01/01");
            txtBirth.requestFocus();
            return;
        }else if(txtHP.getText().replace(" ", "").length() != 13){
            errorMessage("전화번호가 형식과 맞지않습니다.\nex)010-1234-5678");
            txtHP.requestFocus();
            return;
        }else if(txtEmail.getText().isEmpty()){
            errorMessage("이메일을 입력해주세요.");
            txtEmail.requestFocus();
            return;
        }else if(docMem.isSelected()){
            if(cbMD.getSelectedIndex() == 0){
                errorMessage("본인의 전공을 선택해주세요");
                return;
            }
            if(txtHospital.getText().isEmpty()){
                errorMessage("본인의 직장(병원)을 입력해주세요.");
                txtHospital.requestFocus();
                return;
            }
        }
        UserVO vo = new UserVO();
        UserDAO dao = new UserDAO();
        vo.setId(txtJoinId.getText());
        vo.setPw(txtJoinPw.getText());
        vo.setEmail(txtEmail.getText());
        vo.setName(txtName.getText());
        vo.setHP(txtHP.getText());
        vo.setBirth(txtBirth.getText());
        vo.setSex(Male.isSelected() ? "M" : "F");
        vo.setIdentity(docMem.isSelected() ? "D" : "M");
        vo.setMemCode(dao.createMemCode(vo.getIdentity()));

        int loginResult = dao.insertLogin(vo);
        int perInfoResult = dao.insertPerInfo(vo);
        int memInfoResult = dao.insertMemInfo(vo);
        System.out.println(loginResult+"|"+perInfoResult+"|"+memInfoResult);

        int total = loginResult + perInfoResult + memInfoResult;
        if(docMem.isSelected()){
            dao.insertDocInfo(vo, txtHospital.getText(), (String) cbMD.getSelectedItem());
        }
        JOptionPane.showMessageDialog(null, "회원가입 완료!\n로그인 후 이용해주세요.", "회원가입", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();

               
    }//GEN-LAST:event_btnJoinMemActionPerformed

    //이름 유효성검사
    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        String pattern = "^([a-zA-Zㄱ-ㅎ가-힣]*)$";
        if(!Pattern.matches(pattern, txtName.getText())){ //ID에 a-z, A-Z, 0-9 이외의 값이 들어오면
            txtName.setText(txtName.getText().replaceAll("[^a-zA-Zㄱ-ㅎ가-힣]", "")); //그 외 모든 값을 제거한다.
        }
    }//GEN-LAST:event_txtNameKeyReleased
    
    // 에러메시지 출력
    public void errorMessage(String error){
        JOptionPane.showMessageDialog(null, error, "Error_Message", JOptionPane.ERROR_MESSAGE);
    }
    
    //패스워드 확인
    public void pwChk(){
        if(txtJoinPw.getText().equals(txtPwChk.getText())){
            lblPwCheck.setText("비밀번호 일치");
            lblPwCheck.setForeground(new Color(11, 102, 35));
        }else{
            lblPwCheck.setText("비밀번호 미일치");
            lblPwCheck.setForeground(new Color(255, 0, 0));
        }
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Female;
    private javax.swing.JRadioButton Male;
    private javax.swing.JRadioButton RegMem;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExist;
    private javax.swing.JButton btnJoinMem;
    private javax.swing.JComboBox<String> cbMD;
    private javax.swing.JComboBox<String> cmDomain;
    private javax.swing.JRadioButton docMem;
    private javax.swing.ButtonGroup identity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBirth;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmptyDelete;
    private javax.swing.JLabel lblHP;
    private javax.swing.JLabel lblHospital;
    private javax.swing.JLabel lblIdCheck;
    private javax.swing.JLabel lblIden;
    private javax.swing.JLabel lblJoin;
    private javax.swing.JLabel lblJoinId;
    private javax.swing.JLabel lblJoinPw;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPwCheck;
    private javax.swing.JLabel lblPwChk;
    private javax.swing.JLabel lblSex;
    private javax.swing.ButtonGroup sex;
    private javax.swing.JFormattedTextField txtBirth;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JFormattedTextField txtHP;
    private javax.swing.JTextField txtHospital;
    private javax.swing.JTextField txtJoinId;
    private javax.swing.JPasswordField txtJoinPw;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPwChk;
    // End of variables declaration//GEN-END:variables
}
