// Group.java
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Group extends JFrame {
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Group Frame");
    
    boolean room1 = true;
    boolean room2 = true;
    boolean room3 = true;
    boolean room4 = true;

    // Group 클래스 생성자
    Group(Operator o) {
        // 프레임의 제목 설정
        setTitle("Group");

        // Group 프레임 내부의 패널 설정
        panel.setLayout(null); // 레이아웃 매니저를 사용하지 않음

        // 단체방 버튼 4개 추가
        JButton room1 = new JButton("단체방 1");
        room1.setBounds(50, 50, 100, 30);

        JButton room2 = new JButton("단체방 2");
        room2.setBounds(200, 50, 100, 30);

        JButton room3 = new JButton("단체방 3");
        room3.setBounds(50, 100, 100, 30);

        JButton room4 = new JButton("단체방 4");
        room4.setBounds(200, 100, 100, 30);

        // 각 버튼에 ActionListener 등록
        room1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "단체방 1" 버튼이 눌렸을 때 수행할 동작
                JOptionPane.showMessageDialog(null, "단체방 1 버튼이 눌렸습니다.");

                // "자리 예약하기" 버튼이 있는 새로운 창 생성
                SoloReservationFrame SoloreservationFrame = new SoloReservationFrame(o);
                SoloreservationFrame.setVisible(true);
            }
        });

        room2.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "단체방 2 버튼이 눌렸습니다.");
            
         // "자리 예약하기" 버튼이 있는 새로운 창 생성
            SoloReservationFrame SoloreservationFrame = new SoloReservationFrame(o);
            SoloreservationFrame.setVisible(true);
        });

        room3.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "단체방 3 버튼이 눌렸습니다.");
            
         // "자리 예약하기" 버튼이 있는 새로운 창 생성
            SoloReservationFrame SoloreservationFrame = new SoloReservationFrame(o);
            SoloreservationFrame.setVisible(true);
        });

        room4.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "단체방 4 버튼이 눌렸습니다.");
            
         // "자리 예약하기" 버튼이 있는 새로운 창 생성
            SoloReservationFrame SoloreservationFrame = new SoloReservationFrame(o);
            SoloreservationFrame.setVisible(true);
        });

        // 버튼을 패널에 추가
        panel.add(room1);
        panel.add(room2);
        panel.add(room3);
        panel.add(room4);

        // Group 프레임 설정
        setContentPane(panel);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // Operator 클래스를 생성하여 Group에 전달
        Operator operator = new Operator();
        Group group = new Group(operator);
        group.setVisible(true);
    }

}

