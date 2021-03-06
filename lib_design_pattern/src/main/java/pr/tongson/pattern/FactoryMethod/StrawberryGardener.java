package pr.tongson.pattern.FactoryMethod;

import pr.tongson.pattern.SimpleFactory.Fruit;
import pr.tongson.pattern.SimpleFactory.Strawberry;

/**
 * <b>Create Date:</b> 2017/11/6<br>
 * <b>Author:</b> Tongson <br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 */
public class StrawberryGardener implements FruitGardener {
    @Override
    public Fruit factory() {
        return new Strawberry();
    }
}
