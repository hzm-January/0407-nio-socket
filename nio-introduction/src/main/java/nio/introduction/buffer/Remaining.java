package nio.introduction.buffer;

import java.nio.CharBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/22 7:49
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： remaining
 */
public class Remaining {

    private static Logger logger = LoggerFactory.getLogger(Remaining.class);

    public static void main(String[] args) {
        //1. 创建buffer
        char[] chars = {'a', 'b', 'c', 'd'};
        CharBuffer bufferParam = CharBuffer.wrap(chars);

        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", bufferParam.capacity(), bufferParam.limit(), bufferParam.position(), bufferParam.remaining());
        bufferParam.position(2);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", bufferParam.capacity(), bufferParam.limit(), bufferParam.position(), bufferParam.remaining());

    }
}
