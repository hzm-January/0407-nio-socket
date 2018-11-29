package nio.introduction.buffer;

import java.nio.CharBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/7 22:06
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： position 获取和设置
 *
 * position :
 *          下一个要读取或写入元素的索引
 *          缓冲区的position不能为负
 *          position不能,大于limit
 *          0<=position<=limit
 * 相关api:
 *      position() 返回此缓冲区的位置
 *      position(int newPosition) 设置此缓冲区的新位置
 */
public class Position {
    private static Logger logger = LoggerFactory.getLogger(Position.class);

    public static void main(String[] args) {
        //1. 创建buffer
        char[] chars = {'a', 'b', 'c', 'd'};
        CharBuffer bufferParam = CharBuffer.wrap(chars);
        //2. 获取limit
        logger.debug("======位置的获取======");
        logger.debug("position:"+bufferParam.position());
        //3. 设置limit
        logger.debug("======位置的设置======");
        bufferParam.position(2);
        logger.debug("position:"+bufferParam.position());

        bufferParam.put("z");
        logger.debug("{}", Arrays.toString(chars));
    }
}
