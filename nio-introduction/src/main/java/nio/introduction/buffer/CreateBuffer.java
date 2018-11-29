package nio.introduction.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.bytebuffer
 * Author: houzm
 * Date: Created in 2018/10/7 21:15
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 测试 Buffer类API
 * <p>
 * 四大要素大小关系：mark<=position<=limit<=capacity
 */
public class CreateBuffer {
    private static Logger logger = LoggerFactory.getLogger(CreateBuffer.class);

    public static void main(String[] args) {
        //创建缓冲区
        byte[] bytes = {1, 2, 4, 5, 3};
        Buffer bufferParam = ByteBuffer.wrap(bytes);
        logger.debug("======创建缓冲区-第一种方式-wrap(array)-一个入参(array)======");
        logger.debug("capacity:" + bufferParam.capacity());
        logger.debug("limit:" + bufferParam.limit());
        logger.debug("position:" + bufferParam.position());
        logger.debug("mark:" + bufferParam.mark());
        Buffer bufferParams = ByteBuffer.wrap(bytes, 0, 0);
        logger.debug("======创建缓冲区-第二种方式-wrap(array)-三个入参(array, offset, length)======");
        logger.debug("capacity:" + bufferParams.capacity());
        logger.debug("limit:" + bufferParams.limit());
        logger.debug("position:" + bufferParams.position());
        logger.debug("mark:" + bufferParams.mark());
    }
}
