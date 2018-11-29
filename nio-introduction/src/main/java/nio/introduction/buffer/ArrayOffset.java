package nio.introduction.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/23 21:37
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： ArrayOffset
 */
public class ArrayOffset {
    private static Logger logger = LoggerFactory.getLogger(IsDirect.class);

    public static void main(String[] args) {
        byte[] bytes = {1, 2, 4, 5, 3};
        Buffer buffer = ByteBuffer.wrap(bytes);
        logger.debug("array off set {}", buffer.arrayOffset());
    }
}
