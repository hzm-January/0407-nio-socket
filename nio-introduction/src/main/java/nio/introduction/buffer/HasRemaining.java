package nio.introduction.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/22 21:22
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： HasRemaining
 */
public class HasRemaining {
    private static Logger logger = LoggerFactory.getLogger(HasRemaining.class);

    public static void main(String[] args) {
        byte[] bytes = {1, 2, 4, 5, 3};
        Buffer buffer = ByteBuffer.wrap(bytes);
        logger.debug(" has remaining {}", buffer.hasRemaining());
        buffer.position(4);
        buffer.limit(4);
        logger.debug(" has remaining {}", buffer.hasRemaining());
    }
}
