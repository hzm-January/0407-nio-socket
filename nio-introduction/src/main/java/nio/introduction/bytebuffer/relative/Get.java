package nio.introduction.bytebuffer.relative;

import java.nio.ByteBuffer;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.bytebuffer.relative
 * Author: houzm
 * Date: Created in 2018/11/1 12:59
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： relative get
 *
 * public abstract byte get(); 获取缓冲区当前位置的字节，递增position
 *      get 超出限制，会抛出异常
 *      java.nio.BufferUnderflowException
 */
public class Get {
    private static Logger logger = LoggerFactory.getLogger(Get.class);

    public static void main(String[] args) {
        byte[] bytes = new byte[]{1,2,3,4,5,6,7,8,9,10};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        buffer.rewind();
        logger.debug("===================  get  =================");
        IntStream.rangeClosed(1,11).forEach(key->{
            buffer.get();
            logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        });
    }
}
