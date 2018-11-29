package nio.introduction.bytebuffer.relative;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Package: nio.introduction.bytebuffer.relative
 * Author: houzm
 * Date: Created in 2018/11/1 12:43
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： 相对位置 批操作
 *
 * public ByteBuffer put(byte[] src, int offset, int length); 将给定数组的指定个数个字节复制到缓冲区当前位置
 *
 *      如果要复制的长度大于缓冲区的剩余字节，抛出异常 java.nio.BufferOverflowException
 *
 *      参数说明：
 *          src： 数据源
 *          offset：数据源开始索引
 *          length：数据源从开始索引，复制元素个数 ，如果length>src.length 抛出角标越界：java.lang.IndexOutOfBoundsException
 *
 * public final ByteBuffer put(byte[] src) 将给定数组的src.length个字节复制到缓冲区, 从缓存区当前位置开始
 *      如果src.length>buffer.remain() 抛出异常 java.nio.BufferOverflowException
 */
public class PutBatch {
    private static Logger logger = LoggerFactory.getLogger(PutBatch.class);

    public static void main(String[] args) {
        /**
         * 1. public ByteBuffer put(byte[] src, int offset, int length);
         */
//        putBatchParams();


        /**
         * 2. public final ByteBuffer put(byte[] src)
         */
        putBatchNoParams();
    }

    private static void putBatchNoParams() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);

        byte[] distBytes = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
        byte[] distBytesGreater = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111};
        byte[] distBytesLess = {101, 102, 103, 104, 105, 106, 107, 108, 109};

        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        logger.debug(" buffer : {}", Arrays.toString(buffer.array()));
        buffer.put(distBytes);
        logger.debug(" buffer : {}", Arrays.toString(buffer.array()));
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());

        buffer.position(1);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        logger.debug(" buffer position is not 0 : {}", Arrays.toString(buffer.array()));
        buffer.put(distBytesLess);
        logger.debug(" buffer position is not 0 : {}", Arrays.toString(buffer.array()));
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());

        buffer.rewind();
        try {
            logger.debug(" buffer less : {}", Arrays.toString(buffer.array()));
            buffer.put(distBytesGreater); //java.nio.BufferOverflowException
            logger.debug(" buffer less : {}", Arrays.toString(buffer.array()));
            logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        } catch (Exception e) {
            e.printStackTrace();
        }

        buffer.rewind();
        try {
            logger.debug(" buffer greater : {}", Arrays.toString(buffer.array()));
            buffer.put(distBytesLess);
            logger.debug(" buffer greater : {}", Arrays.toString(buffer.array()));
            logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void putBatchParams() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        logger.debug("=== 容量：{} 限制：{} 位置：{} 剩余空间：{}", buffer.capacity(), buffer.limit(), buffer.position(), buffer.remaining());
        logger.debug(" buffer : {}", Arrays.toString(buffer.array()));
        buffer.put(new byte[]{101, 102, 103, 104}, 2, 2);
        logger.debug(" buffer : {}", Arrays.toString(buffer.array()));

        buffer.position(4); //position设置为4

        logger.debug("===================  put batch  =================");
        buffer.put(new byte[]{101, 102, 103, 104}, 2, 2);
        logger.debug(" buffer : {}", Arrays.toString(buffer.array()));


        try {
            buffer.position(7); //position设置为4
            logger.debug("===================  put batch  =================");
            buffer.put(new byte[]{101, 102, 103, 104}, 2, 4); //java.lang.IndexOutOfBoundsException
            logger.debug(" buffer : {}", Arrays.toString(buffer.array()));
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            buffer.position(10); //position设置为10
            logger.debug("===================  put batch  =================");
            buffer.put(new byte[]{101, 102, 103, 104}, 2, 2); //java.nio.BufferOverflowException
            logger.debug(" buffer : {}", Arrays.toString(buffer.array()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
