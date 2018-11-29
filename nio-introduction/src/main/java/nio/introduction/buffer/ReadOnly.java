package nio.introduction.buffer;

import java.nio.ByteBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/22 20:26
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： ReadOnly
 */
public class ReadOnly {
    private static Logger logger = LoggerFactory.getLogger(ReadOnly.class);

    public static void main(String[] args) {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        logger.debug(" buffer read only {}", buffer.isReadOnly());
        ByteBuffer bufferReadOnly = buffer.asReadOnlyBuffer();
        logger.debug(" buffer read only {}", bufferReadOnly.isReadOnly());

    }
}
