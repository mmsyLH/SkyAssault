package asia.lhweb.skyassault.Util;

import javax.swing.*;

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
}
