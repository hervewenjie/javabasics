package designpattern;

/**
 * Created by chengwenjie on 2018/12/10.
 */
public class AbstractFactoryTest {

}

interface AbstractFactory {

    void createObject1();

    void createObject2();

    void createObject3();
}

class Factory1 implements AbstractFactory {

    @Override
    public void createObject1() {
        System.out.println("");
    }

    @Override
    public void createObject2() {

    }

    @Override
    public void createObject3() {

    }
}

class Factory2 implements AbstractFactory {

    @Override
    public void createObject1() {

    }

    @Override
    public void createObject2() {

    }

    @Override
    public void createObject3() {

    }
}