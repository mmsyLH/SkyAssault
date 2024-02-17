package asia.lhweb.skyassault.Util;

import asia.lhweb.skyassault.config.GameConfig;
import asia.lhweb.skyassault.controller.PlaneController;
import asia.lhweb.skyassault.model.bean.Player;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * 对话框工具类
 *
 * @author 罗汉
 * @date 2024/02/05
 */
public class DialogUtils {
    /**
     * 显示消息对话框
     *
     * @param message 消息
     */
    public static void showMessageDialog(String message, String title) {
        showMessageDialog(null, message, title);
    }

    /**
     * 显示消息对话框
     *
     * @param frame   框架
     * @param message 消息
     * @param title   标题
     */
    public static void showMessageDialog(JFrame frame, String message, String title) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 显示选项对话框
     *
     * @param message 消息
     * @param title   标题
     * @param options 选项
     * @return int
     */
    public static int showOptionDialog(String message, String title, Object[] options) {
        return JOptionPane.showOptionDialog(null, message, title,
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);
    }
    /**
     * 显示top3对话框
     *
     * @param top3Player 超越球员
     */
    public static void showTop3Dialog(List<Player> top3Player) {
        // 创建表头和数据数组
        String[] columnNames = {"昵称", "历史总分", "排名"};
        Object[][] data = new Object[top3Player.size()][3];

        // 填充数据数组
        for (int i = 0; i < top3Player.size(); i++) {
            Player player = top3Player.get(i);
            data[i][0] = player.getPlayerName(); // 昵称
            data[i][1] = player.getPlayerScore(); // 历史总分
            data[i][2] = i + 1; // 排名
        }

        // 创建表格模型
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // 创建表格并设置模型，同时设置为不可编辑
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 设置单元格不可编辑
            }
        };

        // 创建滚动面板，并将表格添加到其中
        JScrollPane scrollPane = new JScrollPane(table);

        // 创建对话框并设置内容为滚动面板
        JDialog dialog = new JDialog();
        dialog.setTitle("排行榜");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.getContentPane().add(scrollPane);

        // 设置对话框居中显示
        dialog.setLocationRelativeTo(null);

        dialog.pack();
        dialog.setVisible(true);
    }

    /**
     * 显示自定义关卡选择对话框
     */
    public static void showCustomLevelDialog(JFrame parentFrame) {
        // 创建对话框
        JDialog jd = new JDialog(parentFrame, "自定义窗口");
        jd.setBounds(parentFrame.getX(), parentFrame.getY() + 200, 750, 400);
        jd.setLayout(null);
        jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jd.setBackground(Color.WHITE);
        // 添加组件
        JLabel speed = new JLabel("敌机速度:");
        speed.setBounds(30, 50, 100, 30);
        jd.add(speed);

        // 添加显示文本
        JLabel speedTest = new JLabel();
        speedTest.setBounds(400, 50, 300, 30);
        jd.add(speedTest);

        JLabel select = new JLabel("选择关卡:");
        select.setBounds(30, 100, 100, 30);
        jd.add(select);

        JLabel selectLVTest = new JLabel();
        selectLVTest.setBounds(300, 100, 300, 30);
        jd.add(selectLVTest);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 6, 1);
        slider.setPaintTicks(false); // 隐藏刻度
        slider.setPaintLabels(true);
        slider.setBounds(100, 50, 200, 30);
        jd.add(slider);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER)); // 使用流式布局，居中放置组件
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("请选择关卡");
        comboBox.addItem("第1关");
        comboBox.addItem("第2关");
        comboBox.addItem("第3关");
        comboBox.addItem("自定义关卡");
        comboBox.setBounds(50, 50, 200, 30); // 设置位置和大小
        panel.add(comboBox);
        panel.setBounds(50, 100, 200, 30);
        jd.add(panel);

        JButton button = new JButton("确定");
        button.setBounds(200, 300, 100, 50);
        jd.add(button);

        JButton button2 = new JButton("取消");
        button2.setBounds(400, 300, 100, 50);
        jd.add(button2);


        // 事件监听
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                speedTest.setText("选择了敌机速度：" + slider.getValue());
            }
        });

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLevel = (String) comboBox.getSelectedItem();
                selectLVTest.setText("选择了第：" + selectedLevel);
            }
        });
        // 确定按钮
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameConfig.setEnemySpeed(slider.getValue());
                // 根据对应的关卡加载对应的lv
                String selectedLevel = (String) comboBox.getSelectedItem();
                // 根据对应的关卡加载对应的lv
                if (selectedLevel != null && selectedLevel.startsWith("第")) {
                    int levelNumber = Integer.parseInt(selectedLevel.substring(1, 2));
                    GameConfig.initLv(levelNumber);
                }

                // PlaneController.getInstance().init();
                jd.dispose();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jd.dispose();
            }
        });

        // 设置对话框可见
        jd.setVisible(true);
    }

    /**
     * 显示暂停游戏对话框
     *
     * @param parentFrame 父框架
     */
    public static void showPauseDialog(JFrame parentFrame) {
        // 创建对话框
        JDialog pauseDialog = new JDialog(parentFrame, "游戏暂停", true);
        pauseDialog.setLayout(new BorderLayout());

        // 创建包含背景图的标签
        ImageIcon backgroundIcon = new ImageIcon(ImageUtils.getBgPauseImage());
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());
        backgroundLabel.setOpaque(true); // 设置标签为不透明
        backgroundLabel.setBackground(Color.WHITE); // 设置背景色为白色

        // 提示文本
        JLabel messageLabel = new JLabel("游戏已暂停");
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        backgroundLabel.add(messageLabel, BorderLayout.CENTER);

        // 确认按钮
        JButton resumeButton = new JButton("继续游戏");
        resumeButton.addActionListener(e -> {
            // 继续游戏逻辑
            pauseDialog.dispose(); // 关闭对话框
            PlaneController.getInstance().resumeGame(); // 继续游戏
        });
        backgroundLabel.add(resumeButton, BorderLayout.SOUTH);

        // 将背景标签添加到对话框的内容面板
        pauseDialog.add(backgroundLabel, BorderLayout.CENTER);

        // 设置对话框大小和位置
        pauseDialog.setSize(backgroundIcon.getIconWidth(), backgroundIcon.getIconHeight());
        pauseDialog.setLocationRelativeTo(parentFrame);
        pauseDialog.setVisible(true);
    }

}
