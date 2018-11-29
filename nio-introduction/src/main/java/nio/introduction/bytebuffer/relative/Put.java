package nio.introduction.bytebuffer.relative;

import java.nio.ByteBuffer;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.bytebuffer.relative
 * Author: houzm
 * Date: Created in 2018/11/1 12:43
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 相对位置操作
 *
 * public abstract ByteBuffer put(byte b); 将字节写入当前位置，并递增position
 *
 *  Put 超出限制，会抛出异常
 * Exception in thread "main" java.nio.BufferOverflowException
 *
 *
 */
public class Put {
    private static Logger logger = LoggerFactory.getLogger(Put.class);

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());

        logger.debug("===================  put  =================");
        IntStream.rangeClosed(1, 11).forEach(key->{
            buffer.put((byte) key);
            logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        });

//

    }
}
