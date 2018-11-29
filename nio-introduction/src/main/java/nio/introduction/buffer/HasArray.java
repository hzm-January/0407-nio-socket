package nio.introduction.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/22 21:19
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： HasArray
 */
public class HasArray {
    private static Logger logger = LoggerFactory.getLogger(HasArray.class);

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        logger.debug(" buffer has array : {}", buffer.hasArray());

        byte[] bytes = {1, 2, 4, 5, 3};
        Buffer buffer2 = ByteBuffer.wrap(bytes);
        logger.debug(" buffer has array : {}", buffer2.hasArray());
    }
}
