package com.icebuf.util;

import android.os.Build;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IceTang
 * @version 1.0
 * Data: 2020/10/20
 * E-mail：bflyff@hotmail.com
 */
public class StorageManagerCompat {


    public static @NonNull List<StorageVolume> getStorageVolumes(StorageManager storageManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //API24以后新增的公开访问方法
            return storageManager.getStorageVolumes();
        }
        List<StorageVolume> volumeList = new ArrayList<>();
        StorageVolume[] volumes = ReflectUtil.invoke(storageManager, "getVolumeList");
        if(volumes != null) {
            volumeList.addAll(Arrays.asList(volumes));
        }
        return volumeList;
    }

    public static List<?> getVolumeInfos(StorageManager storageManager) {
        List<?> infos = ReflectUtil.invoke(storageManager, "getVolumes");
        return null;
    }
}
