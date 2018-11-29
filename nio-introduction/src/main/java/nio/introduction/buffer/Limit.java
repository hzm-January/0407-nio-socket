package nio.introduction.buffer;

import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/7 22:03
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 限制的获取和设置
 * limit:
 *      第一个不能读取和写入元素的index
 *      从0开始，初始默认值=capacity(从1开始)，所以limit的数量比capacity大1
 *      不能为负，不能大于capacity
 * 使用场景：
 *      第一次写入9个元素，第二次写入4个元素，覆盖了第一次的前四个元素后5个元素还存在，此时必须限制读取时只能读取到第4个元素
 *
 * 相关api：
 *      limit()  返回此缓冲区的限制
 *      limit(int newLimit) 设置此缓冲区的限制
 *
 */
public class Limit {
    private static Logger logger = LoggerFactory.getLogger(Limit.class);

    public static void main(String[] args) {
        //1. 创建buffer
        byte[] bytes = {1, 2, 4, 5, 3};
        ByteBuffer bufferParam = ByteBuffer.wrap(bytes);
        //2. 获取limit
        logger.debug("======限制的获取======");
        logger.debug("limit:"+bufferParam.limit());
        logger.debug("capacity:"+bufferParam.capacity());
        //3. 设置limit
        logger.debug("======限制的设置======");
        bufferParam.limit(0);
        logger.debug("limit:"+bufferParam.limit());
        bufferParam.limit(5);
        logger.debug("limit:"+bufferParam.limit());
    }
}
