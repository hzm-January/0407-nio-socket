package nio.introduction.buffer;

import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/22 20:29
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： IsDirect 是否直接缓存
 *
 * 非直接缓存：向磁盘存取数据时，需要将数据暂存在jvm的中间缓冲区，每次操作都需要将数据暂存在JVM的中间缓冲区，降低数据吞吐量，提高内存占用率
 * 直接缓存 ： 直接操作内核空间，无需jvm创建新的缓冲区，减少了jvm创建中间缓存的步骤，增加程序运行效率
 *
 */
public class IsDirect {
    private static Logger logger = LoggerFactory.getLogger(IsDirect.class);

    public static void main(String[] args) {
        byte[] bytes = {1, 2, 4, 5, 3};
        ByteBuffer bufferParam = ByteBuffer.wrap(bytes);
        logger.debug(" buffer is direct : {}", bufferParam.isDirect());
        ByteBuffer buffer = ByteBuffer.allocateDirect(100);
        logger.debug(" buffer is direct : {}", buffer.isDirect());
    }
}
