package designpattern;

/**
 * Created by chengwenjie on 2018/12/10.
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        BMW bmw3 = SimpleFactory.create(3);
        BMW bmw5 = SimpleFactory.create(5);

    }
}

class SimpleFactory {
    public static BMW create(int type) {
        if (type == 3) {
            return new BMW3Series();
        }
        else if (type == 5) {
            return new BMW5Series();
        }
        return null;
    }
}

class BMW {}

class BMW3Series extends BMW {
    BMW3Series() { System.out.println("3 series created"); }
}

class BMW5Series extends BMW {
    BMW5Series() { System.out.println("5 series created"); }
}
