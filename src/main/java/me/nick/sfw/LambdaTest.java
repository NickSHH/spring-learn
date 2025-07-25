package me.nick.sfw;

/**
 * 
1. 确保接口是函数式接口
函数式接口是只包含一个抽象方法的接口。可以通过添加@FunctionalInterface注解来确保接口符合要求。

2. 使用正确的Lambda表达式
确保Lambda表达式的目标类型是一个函数式接口。
 */
public class LambdaTest {

    @FunctionalInterface
    interface PrintOp {
        String printStr(String a, String b);
    }

    public void test(String a, String b, PrintOp c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c.printStr(a, b));
    }

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        lambdaTest.test("Hello", "World", (String a, String b) -> {
            return a+" "+b;
        });

    }
}
