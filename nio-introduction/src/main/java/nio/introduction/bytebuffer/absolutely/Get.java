package nio.introduction.bytebuffer.absolutely;

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
 * Description： 绝对位置操作 get
 * 注： 绝对位置操作后，position并不改变
 * public abstract byte get(int index); 获取缓冲区 position=index 处的元素
 *          index>=limit 抛出异常：java.lang.IndexOutOfBoundsException
 *
 *
 */
public class Get {
    private static Logger logger = LoggerFactory.getLogger(Get.class);

    public static void main(String[] args) {
        byte[] bytes = new byte[]{1,2,3,4,5,6,7,8,9,10};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        logger.debug("===================  get  =================");
        byte b = buffer.get(3);
        logger.debug("  byte of index position in buffer : {}", b);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());

        try {
            byte byteOfIndexOut = buffer.get(11); //java.lang.IndexOutOfBoundsException
            logger.debug("  byte of index position in buffer : {}", byteOfIndexOut);
            logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
