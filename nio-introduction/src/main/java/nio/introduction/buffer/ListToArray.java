package nio.introduction.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.buffer
 * Author: houzm
 * Date: Created in 2018/10/23 21:38
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： TODO
 */
public class ListToArray {
    private static Logger logger = LoggerFactory.getLogger(ListToArray.class);

    public static void main(String[] args) {
        Buffer buffer1 = ByteBuffer.wrap(new byte[]{1, 2, 4, 5, 3});
        Buffer buffer2 = ByteBuffer.wrap(new byte[]{1, 2, 4, 5, 3});
        Buffer buffer3 = ByteBuffer.wrap(new byte[]{1, 2, 4, 5, 3});
        List<Buffer> buffers = new LinkedList<>();
        buffers.add(buffer1);
        buffers.add(buffer2);
        buffers.add(buffer3);
        ByteBuffer[] byteBuffers = new ByteBuffer[buffers.size()];
        buffers.toArray(byteBuffers);
        logger.debug("{}", Arrays.toString(byteBuffers));
    }
}
