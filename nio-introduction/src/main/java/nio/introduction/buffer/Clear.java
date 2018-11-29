package nio.introduction.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/22 20:39
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： Clear 还原一切到默认状态
 *
 * 不是真正意义上的清楚数据，而是
 *  position = 0
 *  limit = capacity
 *  mark = -1
 * 使用场景：
 *      重新读取或写入缓存区时
 */
public class Clear {
    private static Logger logger = LoggerFactory.getLogger(IsDirect.class);

    public static void main(String[] args) {
        byte[] bytes = {1, 2, 4, 5, 3};
        Buffer buffer = ByteBuffer.wrap(bytes);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.position(2);
        buffer.limit(3);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.clear();
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());

    }
}
