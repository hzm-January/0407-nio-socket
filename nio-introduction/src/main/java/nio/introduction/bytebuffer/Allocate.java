package nio.introduction.bytebuffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import javax.security.auth.login.AccountLockedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.bytebuffer
 * Author: houzm
 * Date: Created in 2018/10/24 11:19
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description：
 *      allocate 分配一个新的非直接字节缓冲区
 *      buffer.warp 也可以创建一个新的非直接字节缓冲区
 *      源码：
 *      HeapByteBuffer(int cap, int lim) {            // package-private
            super(-1, 0, lim, cap, new byte[cap], 0);
        }
 *      warp 使用传入的字节数组作为存储空间
 *              如果对该数组进行修改，会影响缓存中数据
 *              如果对缓存中的数据进行修改，也会影响数组中的数据
 */
public class Allocate {
    private static Logger logger = LoggerFactory.getLogger(Allocate.class);

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        logger.debug(" create buffer by allocate  is direct : {}", buffer.isDirect());

        byte[] bytes = {1, 2, 3, 4, 5};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        logger.debug(" create buffer by wrap  is direct : {}", byteBuffer.isDirect());

        bytes[2] = 7;
        logger.debug(" modify byte[] make the cache update : {}", byteBuffer.get(2));

        byteBuffer.put(0, (byte) 8);
        logger.debug(" modify the cache make byte[] update : {}", byteBuffer.get(0));
    }
}
