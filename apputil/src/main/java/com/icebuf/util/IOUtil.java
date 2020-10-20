package com.icebuf.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author IceTang
 * @version 1.0
 * Data: 2020/10/19
 * E-mail：bflyff@hotmail.com
 */
public class IOUtil {


    public static void close(Closeable ... cls) {
        if(cls != null) {
            for (Closeable closeable : cls) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
