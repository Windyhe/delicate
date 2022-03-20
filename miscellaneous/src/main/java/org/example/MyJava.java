package org.example;

import org.openjdk.jol.info.ClassLayout;

public class MyJava {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        java.lang.Object object internals:
//        OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
//        0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//        4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//        8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
//        12     4        (loss due to the next object alignment)
//        Instance size: 16 bytes
//        Space losses: 0 bytes internal + 4 bytes external = 4 bytes total

//        对象头（markword，8B） + 类指针（class pointer，4B） + 实例数据 + 对齐（padding）

        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
//            java.lang.Object object internals:
//            OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
//            0     4        (object header)                           58 f8 6f 76 (01011000 11111000 01101111 01110110) (1987049560)
//            4     4        (object header)                           1b 00 00 00 (00011011 00000000 00000000 00000000) (27)
//            8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
//            12     4        (loss due to the next object alignment)

//            锁的信息记录在markword中
        }


    }
}
