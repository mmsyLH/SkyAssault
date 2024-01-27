package asia.lhweb.skyassault.Test;

import java.io.IOException;

/**
 * 飞行物
 *
 * @author 罗汉
 * @date 2024/01/26
 */
abstract class Fly {
    private String description;

    public Fly(String description) {
        this.description = description;
    }

    public abstract double JiFen();

    public String getDescription() {
        return description;
    }
}


/**
 * 英雄飞机
 *
 * @author 罗汉
 * @date 2024/01/26
 */
class HeroPlane extends Fly {

    public HeroPlane(String descriptoin) {
        super(descriptoin);
    }

    public double JiFen() {
        return 10;
    }
}

/**
 * 敌人飞机
 *
 * @author 罗汉
 * @date 2024/01/26
 */
class EnemyPlane extends Fly {

    public EnemyPlane(String descriptoin) {
        super(descriptoin);
    }

    public double JiFen() {
        return 10;
    }
}

/**
 * 其他飞行物
 *
 * @author 罗汉
 * @date 2024/01/26
 */
class QiTaFly extends Fly {

    public QiTaFly(String descriptoin) {
        super(descriptoin);
    }

    public double JiFen() {
        return 10;
    }
}
/**
 * 这里我们让道具类继承自飞行物类，显然违背了继承中的"is a"关系，但是在装饰器模式中这个原则就是需要违背
 * 尽管道具不是飞行物，但是为了解决问题，我们也只能让道具去继承飞行物
 */
abstract class CondimentDecorator extends Fly {
    protected Fly Fly;

    public CondimentDecorator(Fly Fly) {
        super("道具");
        this.Fly = Fly;
    }

}

/**
 * 子丹
 *
 * @author 罗汉
 * @date 2024/01/26
 */
class ZiDan extends CondimentDecorator {

    public ZiDan(Fly Fly) {
        super(Fly);
    }

    @Override
    public double JiFen() {
        return Fly.JiFen() + 0.2;
    }

    @Override
    public String getDescription() {
        return Fly.getDescription() + " 子弹";
    }

}


/**
 * 雪挑
 *
 * @author 罗汉
 * @date 2024/01/26
 */
class XueTiao extends CondimentDecorator {
    public XueTiao(Fly Fly) {
        super(Fly);
    }

    @Override
    public double JiFen() {
        return Fly.JiFen() + 0.2;
    }

    @Override
    public String getDescription() {
        return Fly.getDescription() + " 血条";
    }

}

/**
 * DAO丹
 *
 * @author 罗汉
 * @date 2024/01/26
 */
class DaoDan extends CondimentDecorator {

    public DaoDan(Fly Fly) {
        super(Fly);
    }

    @Override
    public double JiFen() {
        return Fly.JiFen() + 0.1;
    }

    @Override
    public String getDescription() {
        return Fly.getDescription() + " 导弹";
    }

}


/**
 * 胡dun
 *
 * @author 罗汉
 * @date 2024/01/26
 */
class HuDun extends CondimentDecorator {

    public HuDun(Fly Fly) {
        super(Fly);
    }

    @Override
    public double JiFen() {
        return Fly.JiFen() + 0.4;
    }

    @Override
    public String getDescription() {
        return Fly.getDescription() + " 护盾";
    }

}

public class Demo03 {
    public static void main(String[] args) throws IOException {
        Fly a=new QiTaFly("蜜蜂");
        Fly c=new EnemyPlane("敌机");
        Fly b = new HeroPlane("英雄飞机");
        Fly c2=new ZiDan(c);
        // 加子弹
        Fly b2 = new ZiDan(b);
        // 加血条
        Fly b3 = new XueTiao(b2);
        // 加导弹
        Fly b4 = new DaoDan(b3);
        // 加第二份子弹
        Fly b5 = new ZiDan(b4);
        // 加护盾
        Fly b6 = new HuDun(b5);
        System.out.println(b6.getDescription() + "积分:" + b6.JiFen());
        System.out.println(a.getDescription() + "积分:" + a.JiFen());
        System.out.println(c2.getDescription() + "积分:" + c2.JiFen());
    }
}
