package asia.lhweb.skyassault.model.behavior;

import asia.lhweb.skyassault.model.bean.FlyingObj;

import java.awt.*;

/**
 * 飞行对象装饰器
 *
 * @author 罗汉
 * @date 2024/01/26
 */
public abstract class FlyingObjDecorator extends FlyingObj {
    protected FlyingObj decoratedFlyingObj;

    public FlyingObjDecorator(FlyingObj decoratedFlyingObj) {
        this.decoratedFlyingObj = decoratedFlyingObj;
    }
    @Override
    public  void drawFlyer(Graphics g){
        decoratedFlyingObj.drawFlyer(g);
    }
}