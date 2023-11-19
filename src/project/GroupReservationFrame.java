// GroupReservationFrame.java
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GroupReservationFrame extends JFrame {
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Reservation Frame");
    Operator operator;
    private boolean roomStatus;

    GroupReservationFrame(Operator o, boolean roomStatus) {
        setTitle("Reservation");
        operator = o;
        this.roomStatus = roomStatus;

        panel.setLayout(new FlowLayout());
        panel.add(label);

        JButton reserveButton = new JButton("자리 예약하기");
        JButton clearButton = new JButton("자리 비우기");

        reserveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "자리 예약이 완료되었습니다.");
            updateRoomStatus(!roomStatus); // 확인 버튼을 누르면 이전 페이지로 이동 및 방 상태 업데이트
            goBack();
        });

        clearButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "자리를 비웠습니다.");
            updateRoomStatus(roomStatus); // 자리 비우기 버튼을 누르면 이전 페이지로 이동 및 방 상태 업데이트
            goBack();
        });

        panel.add(reserveButton);
        panel.add(clearButton);

        // Set the initial room status UI
        updateRoomStatusUI();

        setContentPane(panel);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 현재 프레임만 닫기
    }

    private void goBack() {
        SoloGroupCheck soloGroupCheck = new SoloGroupCheck(operator);
        soloGroupCheck.setVisible(true);
        dispose();
    }

    private void updateRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
        updateRoomStatusUI();
    }

    private void updateRoomStatusUI() {
        panel.removeAll(); // Clear existing components

        JLabel roomStatusLabel = new JLabel("Room Status: " + (roomStatus ? "Vacant" : "Occupied"));
        panel.add(roomStatusLabel);

        // Customize colors based on room status
        if (roomStatus) {
            panel.setBackground(Color.GREEN); // Use green for vacant
        } else {
            panel.setBackground(Color.RED); // Use red for occupied
        }

        // Add reserve and clear buttons again
        JButton reserveButton = new JButton("자리 예약하기");
        JButton clearButton = new JButton("자리 비우기");

        reserveButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "자리 예약이 완료되었습니다.");
            updateRoomStatus(!roomStatus); // 확인 버튼을 누르면 이전 페이지로 이동 및 방 상태 업데이트
            goBack();
        });

        clearButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "자리를 비웠습니다.");
            updateRoomStatus(roomStatus); // 자리 비우기 버튼을 누르면 이전 페이지로 이동 및 방 상태 업데이트
            goBack();
        });

        panel.add(reserveButton);
        panel.add(clearButton);

        revalidate(); // Refresh the panel
    }

    public static void main(String[] args) {
        Operator operator = new Operator();
        boolean roomStatus = true; // 예시로 초기 방 상태를 설정
        GroupReservationFrame reservationFrame = new GroupReservationFrame(operator, roomStatus);
        reservationFrame.setVisible(true);
    }
}
