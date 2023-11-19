// MainFrame.java
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    // 전체 패널 및 하위 패널들을 정의
    JPanel basePanel = new JPanel(new BorderLayout());
    JPanel centerPanel = new JPanel(new BorderLayout());
    JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel southPanel = new JPanel();
    
    

    // 아이디와 비밀번호 라벨 정의
    JLabel idL = new JLabel("아이디");
    JLabel pwL = new JLabel("비밀번호");

    // 아이디와 비밀번호를 입력받는 텍스트 필드 및 패스워드 필드 정의
    JTextField id = new JTextField();
    JPasswordField pw = new JPasswordField();

    // 로그인, 회원가입, 프로그램 종료 버튼 정의
    JButton loginBtn = new JButton("로그인");
    JButton joinBtn = new JButton("회원가입");
    JButton exitBtn = new JButton("프로그램 종료");
    
  

    // Operator 클래스의 인스턴스 변수
    Operator o = null;

    // 생성자
    MainFrame(Operator _o) {
        // Operator 클래스의 인스턴스 할당
        o = _o;

        // 프레임의 제목 설정
        setTitle("로그인");
        setLayout(null);

        // 패널들의 크기 설정
        centerPanel.setPreferredSize(new Dimension(260, 80));
        westPanel.setPreferredSize(new Dimension(210, 75));
        eastPanel.setPreferredSize(new Dimension(90, 75));
        southPanel.setPreferredSize(new Dimension(290, 40));

        // 라벨들의 크기 설정
        idL.setPreferredSize(new Dimension(50, 30));
        pwL.setPreferredSize(new Dimension(50, 30));

        // 텍스트 필드 및 패스워드 필드의 크기 설정
        id.setPreferredSize(new Dimension(140, 30));
        pw.setPreferredSize(new Dimension(140, 30));

        // 버튼들의 크기 설정
        loginBtn.setPreferredSize(new Dimension(75, 63));
        joinBtn.setPreferredSize(new Dimension(135, 25));
        exitBtn.setPreferredSize(new Dimension(135, 25));

        // 기본 패널로 설정
        setContentPane(basePanel);

        // 각 패널들을 프레임에 추가
        basePanel.add(centerPanel, BorderLayout.CENTER);
        basePanel.add(southPanel, BorderLayout.SOUTH);
        centerPanel.add(westPanel, BorderLayout.WEST);
        centerPanel.add(eastPanel, BorderLayout.EAST);

        // 각 패널들의 레이아웃 설정
        westPanel.setLayout(new FlowLayout());
        eastPanel.setLayout(new FlowLayout());
        southPanel.setLayout(new FlowLayout());

        // westPanel에 아이디, 비밀번호 관련 컴포넌트 추가
        westPanel.add(idL);
        westPanel.add(id);
        westPanel.add(pwL);
        westPanel.add(pw);

        // eastPanel에 로그인 버튼 추가
        eastPanel.add(loginBtn);

        // southPanel에 회원가입, 프로그램 종료 버튼 추가
        southPanel.add(exitBtn);
        southPanel.add(joinBtn);

        // ActionListener 객체 생성
        ButtonListener bl = new ButtonListener();

        // 각 버튼에 ActionListener 등록
        loginBtn.addActionListener(bl);
        exitBtn.addActionListener(bl);
        joinBtn.addActionListener(bl);

        // 프레임의 크기, 위치, 가시성, 크기 조절 불가 설정 및 종료 동작 설정
        setSize(310, 150);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ActionListener를 구현한 내부 클래스
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();

            // 입력된 아이디와 비밀번호 얻기
            String uid = id.getText();
            String upass = new String(pw.getPassword());

            // 버튼에 따른 동작 수행
            if (b.getText().equals("프로그램 종료")) {
                System.out.println("프로그램 종료");
                System.exit(0);
            } else if (b.getText().equals("회원가입")) {
                // Operator 클래스의 jf 멤버 변수를 통해 회원가입 화면 표시
                o.jf.setVisible(true);
            } else if (b.getText().equals("로그인")) {
                // 아이디 또는 비밀번호가 비어있을 경우 에러 메시지 표시
                if (uid.equals("") || upass.equals("")) {
                    JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
                    System.out.println("로그인 실패 > 로그인 정보 미입력");
                } else {
                    // 로그인 시도
                    if (o.db.logincheck(uid, upass)) {
                        System.out.println("로그인 성공");
                        JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");

                        // 로그인 성공 시 SoloGroupCheck 클래스 패널로 이동
                        project.SoloGroupCheck soloGroupCheckPanel = new project.SoloGroupCheck(o);
                        soloGroupCheckPanel.setVisible(true);
                        dispose();
                    } else {
                        System.out.println("로그인 실패 > 로그인 정보 불일치");
                        JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
                    }
                }
            }
        }
    }
}
