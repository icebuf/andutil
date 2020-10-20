package com.icebuf.util.internal;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.storage.StorageVolume;

import androidx.annotation.RequiresApi;

import com.icebuf.util.ReflectUtil;

import java.io.File;
import java.lang.reflect.Field;

/**
 * @author IceTang
 * @version 1.0
 * Data: 2020/10/20
 * E-mail：bflyff@hotmail.com
 */
public class StorageVolumeCompat {

    private static Field sPrimaryField;
    private static Field sEmulatedField;
    private static Field sRemovableField;

    private static Field sIdField;

    static {
        try {
            Class<?> clazz = Class.forName("android.os.storage.StorageVolume");
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                sIdField = ReflectUtil.getDeclaredField(clazz, "mId");
            }

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                sPrimaryField = ReflectUtil.getDeclaredField(clazz, "mPrimary");
                sEmulatedField = ReflectUtil.getDeclaredField(clazz, "mEmulated");
                sRemovableField = ReflectUtil.getDeclaredField(clazz, "mRemovable");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static boolean isPrimary(StorageVolume storageVolume) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return storageVolume.isPrimary();
        }
        return ReflectUtil.getBoolean(storageVolume, sPrimaryField);
    }

    public static boolean isEmulated(StorageVolume storageVolume) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return storageVolume.isEmulated();
        }
        return ReflectUtil.getBoolean(storageVolume, sEmulatedField);
    }

    public static boolean isRemovable(StorageVolume storageVolume) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return storageVolume.isRemovable();
        }
        return ReflectUtil.getBoolean(storageVolume, sRemovableField);
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @TargetApi(Build.VERSION_CODES.P)
    public static File getId(StorageVolume storageVolume) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return storageVolume.getDirectory();
        }
        return ReflectUtil.get(storageVolume, sIdField);
    }

    public static File getDirectory(StorageVolume storageVolume) {
        return storageVolume.getDirectory();
    }
}
