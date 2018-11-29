package nio.introduction.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/22 21:02
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： flip 相当于subString
 *      limit = position
 *      position = 0
 *      mark = -1
 * 使用场景：
 *      初始10个位置，写入4个之后，将要开始读取时，后面6个无意义，就进行flip
 */
public class Flip {
    private static Logger logger = LoggerFactory.getLogger(Flip.class);

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        buffer.put((byte) 0);
        buffer.put((byte) 1);
        buffer.put((byte) 2);
        buffer.put((byte) 3);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.flip();
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());

    }
}
