// SoloGroupCheck.java
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoloGroupCheck extends JFrame {
    JPanel panel = new JPanel();
    JLabel label = new JLabel();

    // SoloGroupCheck 클래스 생성자
    SoloGroupCheck(Operator o) {
        // 프레임의 제목 설정
        setTitle("SoloGroupCheck");

        // SoloGroupCheck 프레임 내부의 패널 설정
        panel.setLayout(null); // 레이아웃 매니저를 사용하지 않음

        // "단체" 버튼 추가
        JButton groupButton = new JButton("단체 좌석");
        groupButton.setBounds(50, 50, 100, 30); // x, y, width, height

        // "개인" 버튼 추가
        JButton soloButton = new JButton("개인 좌석");
        soloButton.setBounds(200, 50, 100, 30); // x, y, width, height

        // 각 버튼에 ActionListener 등록
        groupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "단체" 버튼이 눌렸을 때 수행할 동작
                // Group.java로 이동
                Group groupPage = new Group(o);
                groupPage.setVisible(true);
                dispose(); // 현재 프레임 닫기
            }
        });

        soloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "개인" 버튼이 눌렸을 때 수행할 동작
                // Solo.java로 이동
                Solo soloPage = new Solo(o);
                soloPage.setVisible(true);
                dispose(); // 현재 프레임 닫기
            }
        });

        // 버튼을 패널에 추가
        panel.add(groupButton);
        panel.add(soloButton);

        // 탭 패널 생성
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(50, 100, 700, 400);

        // 첫 번째 탭에 추가할 컴포넌트 생성 및 추가
        JPanel statusPanel = new JPanel();
//        statusPanel.add(new JLabel("현재 현황을 보여주는 내용"));

        // 두 번째 탭에 추가할 컴포넌트 생성 및 추가
        JPanel anotherPanel = new JPanel();
//        anotherPanel.add(new JLabel("다른 현황을 보여주는 내용"));

     // 첫 번째 탭에 추가할 컴포넌트 생성 및 추가
        JPanel statusPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // 4개의 300x170 크기의 사각형을 그립니다.
                int rectWidth = 300;
                int rectHeight = 170;

                // 첫 번째 사각형
                g2d.drawRect(10, 10, rectWidth, rectHeight);
                // 두 번째 사각형
                g2d.drawRect(320, 10, rectWidth, rectHeight);
                // 세 번째 사각형
                g2d.drawRect(10, 190, rectWidth, rectHeight);
                // 네 번째 사각형
                g2d.drawRect(320, 190, rectWidth, rectHeight);

                // 각 사각형 안에 텍스트 추가
                g2d.drawString("사각형 1", 10 + rectWidth / 2 - 30, 10 + rectHeight / 2);
                g2d.drawString("사각형 2", 320 + rectWidth / 2 - 30, 10 + rectHeight / 2);
                g2d.drawString("사각형 3", 10 + rectWidth / 2 - 30, 190 + rectHeight / 2);
                g2d.drawString("사각형 4", 320 + rectWidth / 2 - 30, 190 + rectHeight / 2);
            }
        };

        // 탭에 패널 추가
        tabbedPane.addTab("단체 좌석 현황 보기", statusPanel1);

     // 두 번째 탭에 추가할 컴포넌트 생성 및 추가
        JPanel anotherPanel1 = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // 사각형 배열
                Rectangle[] rectangles = new Rectangle[]{
                    new Rectangle(10, 10, 50, 50),
                    new Rectangle(100, 10, 50, 50),
                    new Rectangle(190, 10, 50, 50),
                    new Rectangle(10, 70, 50, 50),
                    new Rectangle(100, 70, 50, 50),
                    new Rectangle(190, 70, 50, 50),
                    new Rectangle(10, 130, 50, 50),
                    new Rectangle(100, 130, 50, 50),
                    new Rectangle(190, 130, 50, 50),
                    new Rectangle(10, 190, 50, 50),
                };

                // 각 사각형 그리기
                for (int i = 0; i < rectangles.length; i++) {
                    Rectangle rect = rectangles[i];
                    g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
                    g2d.drawString("사각형 " + (i + 1), rect.x + rect.width / 2 - 20, rect.y + rect.height / 2);
                }
            }
        };

        // 탭에 패널 추가
        tabbedPane.addTab("개인 좌석 현황 보기", anotherPanel1);


        // SoloGroupCheck 프레임에 탭 패널 추가
        panel.add(tabbedPane);

        // SoloGroupCheck 프레임 설정
        setContentPane(panel);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Operator 클래스를 생성하여 SoloGroupCheck에 전달
        Operator operator = new Operator();
        SoloGroupCheck soloGroupCheck = new SoloGroupCheck(operator);
        soloGroupCheck.setVisible(true);
    }
}
