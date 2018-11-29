package nio.introduction.buffer;

import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/22 20:14
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： mark
 * <p>
 * mark :
 *      在此缓冲区的位置进行标记
 *      将positon或limit调整为小于该mark值时，该mark被丢弃，丢弃后mark值为-1
 *      如果未定义mark，调用reset()方法将抛出异常
 */
public class Mark {
    private static Logger logger = LoggerFactory.getLogger(Mark.class);

    public static void main(String[] args) {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.position(1);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.mark();
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.position(3);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.reset(); //回退到mark标记处
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.position(0); //position < mark
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.reset(); //java.nio.InvalidMarkException

    }
}
