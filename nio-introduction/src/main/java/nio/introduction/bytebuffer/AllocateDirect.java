package nio.introduction.bytebuffer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.bytebuffer
 * Author: houzm
 * Date: Created in 2018/10/24 11:16
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 *
 *  bytebuffer AllocateDirect    分配一个新的直接字节缓冲区
 *
 *  释放内存：
 *      1. 手动释放
 *      2. 交给jvm释放
 *
 */
public class AllocateDirect {
    private static Logger logger = LoggerFactory.getLogger(AllocateDirect.class);

    public static void main(String[] args) throws Exception {
        //1. 创建直接缓存
//        createDirect();
        //2. 手动释放缓存 demo
//        autoRelease();
        //3. 交给jvm自动释放 demo
        jvmRelease();
    }

    private static void jvmRelease() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(Integer.MAX_VALUE); //capacity为字节个数
        byte[] bytes = new byte[]{1};
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            buffer.put(bytes);
        }
        logger.info("=====缓存装填完成：{}=====", buffer);
        //进程结束后，不会马上回收，在某个时刻触发GC垃圾回收器进行回收
    }

    private static void autoRelease() throws InterruptedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(Integer.MAX_VALUE); //capacity为字节个数
        byte[] bytes = new byte[]{1};
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            buffer.put(bytes);
        }
        logger.info("=====缓存装填完成：{}=====", buffer);
        Thread.sleep(1000); //休眠一秒
        Method cleanerMethod = buffer.getClass().getMethod("cleaner");
        cleanerMethod.setAccessible(true);
        Object returnValue = cleanerMethod.invoke(buffer);
        Method cleanMethod = returnValue.getClass().getMethod("clean");
        cleanMethod.setAccessible(true);
        cleanMethod.invoke(returnValue);
//        logger.info("=====清理缓存后：{}=====", buffer);
    }

    private static void createDirect() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(100); //capacity为字节个数
        logger.debug("{}", buffer.isDirect());
    }
}
