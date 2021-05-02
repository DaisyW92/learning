package indi.daisy.javaagent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @author: daisyw
 * @data: 2021/5/2 下午4:51
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("main---");
    }


    //main 方法前执行
    public static void premain(String[] args) {
        System.out.println("premain---");


    }

    //如上有2个 premain() 方法，当1个参数和2个参数的premain()的方法同时存在的时候， premain(String agentArgs) 将被忽略
    public static void premain(String[] args, Instrumentation instrumentation) {


        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

                //add trans
                return new byte[0];
            }
        });
    }
}
