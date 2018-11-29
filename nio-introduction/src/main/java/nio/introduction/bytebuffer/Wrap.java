package nio.introduction.bytebuffer;

import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.bytebuffer
 * Author: houzm
 * Date: Created in 2018/10/31 13:26
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： wrap
 * public static ByteBuffer wrap(byte[] array, int offset, int length)
 * array: 缓冲区中关联的字节数组
 * offset: 设置位置position， 0<=position<=array.length
 * length: 设置从position开始，往后多少位为有效位，相当于设置limit=length+offset
 */
public class Wrap {
    private static Logger logger = LoggerFactory.getLogger(Wrap.class);
    public static void main(String[] args) {
        byte [] bytes = new byte[]{1,2,3,4,5,6,7,8};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes, 2, 4); //offset->设置position；length->设置limit为length+offset
        logger.debug("===buffer  容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        logger.debug("===buffer2 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer2.capacity(), buffer2.limit(), buffer2.position(), buffer2.remaining());
    }
}
