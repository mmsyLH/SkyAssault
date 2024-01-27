package asia.lhweb.skyassault.Test;

import asia.lhweb.skyassault.View.LoginJFrame;
import asia.lhweb.skyassault.View.RegisterFrame;
import asia.lhweb.skyassault.controller.PlaneController;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;

/**
 * @author :罗汉
 * @date : 2024/1/25
 */
public class Test {
    public static void main(String[] args) {
        try
        {
            // 设置本属性将改变窗口边框样式定义
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
            UIManager.put("RootPane.setupButtonVisible", false);
            // 启用皮肤
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e)
        {
            //TODO exception
            System.out.println("加载炫彩皮肤失败！");
        }
        new RegisterFrame();
    }
}
