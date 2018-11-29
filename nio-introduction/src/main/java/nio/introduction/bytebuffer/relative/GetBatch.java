package nio.introduction.bytebuffer.relative;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.bytebuffer.relative
 * Author: houzm
 * Date: Created in 2018/11/1 12:59
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 相对位置 批量操作 get
 *
 * public ByteBuffer get(byte[] dst, int offset, int length) 将缓冲区的指定元素个数复制到 目标数组指定索引后
 *
 *      参数说明：
 *          dst：目标数组
 *          offset：目标数组开始索引 offset>dst.length-1 : java.lang.IndexOutOfBoundsException
 *          length：从缓冲区复制多少个元素到目标数组，从缓冲区的position=0处开始
 *                      length>buffer.capacity ： java.lang.IndexOutOfBoundsException
 *                      length> dst.remain ： java.lang.IndexOutOfBoundsException
 *
 * public ByteBuffer get(byte[] dst) 将缓冲区的dst.length个元素复制到 目标数组 从目标数组0索引开始
 *                                   相当于public ByteBuffer get(byte[] dst, 0, dst.length)
 *                                   dst.length > buffer.remain() 抛出异常：java.nio.BufferUnderflowException
 */
public class GetBatch {
    private static Logger logger = LoggerFactory.getLogger(GetBatch.class);

    public static void main(String[] args) {
//        getBatchParams();

        byte[] bytes = new byte[]{1,2,3,4,5,6,7,8,9,10};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        byte[] distBytes = new byte[10];
        byte[] distBytesLess = new byte[9];
        byte[] distBytesGreater = new byte[11];
        logger.debug("dist byte[] : {}", Arrays.toString(distBytes));
        buffer.get(distBytes);
        logger.debug("dist byte[] : {}", Arrays.toString(distBytes));

        buffer.rewind();

        try {
            logger.debug("dist byte[] less length : {}", Arrays.toString(distBytesLess));
            buffer.get(distBytesLess); //java.nio.BufferUnderflowException
            logger.debug("dist byte[] less length : {}", Arrays.toString(distBytesLess));
        } catch (Exception e) {
            e.printStackTrace();
        }

        buffer.rewind();

        try {
            logger.debug("dist byte[] greater length : {}", Arrays.toString(distBytesGreater));
            buffer.get(distBytesGreater); //java.nio.BufferUnderflowException
            logger.debug("dist byte[] greater length : {}", Arrays.toString(distBytesGreater));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getBatchParams() {
        byte[] bytes = new byte[]{1,2,3,4,5,6,7,8,9,10};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        logger.debug("===================  get batch  =================");
        byte[] distBytes = new byte[10];
        logger.debug("dist byte[] : {}", Arrays.toString(distBytes));
        buffer.get(distBytes, 2, 2);
        logger.debug("dist byte[] : {}", Arrays.toString(distBytes));

        try {
            buffer.get(distBytes, 10, 2); //java.lang.IndexOutOfBoundsException
            logger.debug("dist byte[] : {}", Arrays.toString(distBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            buffer.get(distBytes, 2, 11); //java.lang.IndexOutOfBoundsException
            logger.debug("dist byte[] : {}", Arrays.toString(distBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            buffer.get(distBytes, 8, 4);
            logger.debug("dist byte[] : {}", Arrays.toString(distBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
