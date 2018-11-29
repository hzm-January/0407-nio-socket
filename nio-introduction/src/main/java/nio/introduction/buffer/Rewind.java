package nio.introduction.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/23 7:20
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： rewind
 * <p>
 *      public final Buffer rewind() {
 *           position = 0;
 *           mark = -1;
 *           return this;
 *      }
 */
public class Rewind {
    private static Logger logger = LoggerFactory.getLogger(Rewind.class);

    public static void main(String[] args) {
        byte[] bytes = {1, 2, 4, 5, 3};
        Buffer buffer = ByteBuffer.wrap(bytes);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.position(2);
        buffer.limit(3);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.rewind();
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
    }
}
