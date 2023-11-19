// Solo.java
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Solo extends JFrame {
    protected static final boolean roomStatus = false;
	JPanel panel = new JPanel();
    JLabel label = new JLabel("Solo Frame");

    // Solo 클래스 생성자
    Solo(Operator o) {
        // 프레임의 제목 설정
        setTitle("Solo");

        // Solo 프레임 내부의 패널 설정
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // 가운데 정렬, 가로 간격 10, 세로 간격 10

        // 개별적으로 10개의 버튼 추가
        for (int i = 1; i <= 10; i++) {
            JButton seatButton = createSeatButton("좌석 " + i, o);
            panel.add(seatButton);
        }

        // Solo 프레임 설정
        setContentPane(panel);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 버튼을 생성하고 크기를 조절하는 메서드
    private JButton createSeatButton(String text, Operator operator) {
        JButton seatButton = new JButton(text);
        seatButton.setPreferredSize(new Dimension(200, 100)); // 크기 설정

     // 좌석 버튼에 ActionListener 등록
        seatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 좌석 버튼이 눌렸을 때 수행할 동작
                JOptionPane.showMessageDialog(null, text + " 버튼이 눌렸습니다.");

                // GroupReservationFrame으로 이동
                GroupReservationFrame groupReservationFrame = new GroupReservationFrame(operator, roomStatus);
                groupReservationFrame.setVisible(true);

                // Solo 프레임은 닫기
                dispose();
            }
        });


        return seatButton;
    }

    public static void main(String[] args) {
        // Operator 클래스를 생성하여 Solo에 전달
        Operator operator = new Operator();
        Solo solo = new Solo(operator);
        solo.setVisible(true);
    }
}
