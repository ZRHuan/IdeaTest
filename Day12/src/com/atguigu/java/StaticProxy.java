package com.atguigu.java;

/**
 *
 * 静态代理举例
 特点：代理类和被代理类在编译期间，就确定下来了。
 *
 *
 * @author zhangruhuan
 * @create 2020-08-17 17:59
 */
interface ClothFactory{
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//;/用被代理类对象进行实例化
    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生产一批运动服");
    }
}
public class StaticProxy {
    public static void main(String[] args) {
//        创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
//        创建代理类的对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        proxyClothFactory.produceCloth();
    }
}
