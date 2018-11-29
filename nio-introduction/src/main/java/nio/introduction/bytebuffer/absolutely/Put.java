package nio.introduction.bytebuffer.absolutely;

import java.nio.ByteBuffer;
import java.util.Arrays;
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
 * Description： 绝对位置操作
 *
 * 注： 绝对位置操作后，position并不改变
 *
 * public abstract ByteBuffer put(int index, byte b); 在缓冲区的指定位置，插入指定值
 *
 *              Put index超出限制，会抛出异常 java.lang.IndexOutOfBoundsException
 *
 *
 */
public class Put {
    private static Logger logger = LoggerFactory.getLogger(Put.class);

    public static void main(String[] args) {
        byte[] bytes = new byte[]{1,2,3,4,5,6,7,8,9,10};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        logger.debug(" buffer : {}", Arrays.toString(buffer.array()));
        logger.debug("===================  put  =================");
        buffer.put(3, (byte) 111);
        logger.debug(" buffer : {}", Arrays.toString(buffer.array()));
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());

        try {
            buffer.put(11, (byte) 0); //java.lang.IndexOutOfBoundsException
            logger.debug(" buffer : {}", Arrays.toString(buffer.array()));
            logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
