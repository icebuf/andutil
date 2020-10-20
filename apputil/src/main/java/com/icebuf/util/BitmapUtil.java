package com.icebuf.util;

import android.graphics.Bitmap;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * @author IceTang
 * @version 1.0
 * Data: 2020/10/19
 * E-mail：bflyff@hotmail.com
 */
public class BitmapUtil {

    private static final String TAG = BitmapUtil.class.getSimpleName();

    private BitmapUtil() { }

    /**
     * Save bitmap 2 jpeg.
     *
     * @param bitmap  the bitmap
     * @param path    the path
     * @param quality the quality
     * @throws IOException the io exception
     */
    public static void compress2Jpeg(Bitmap bitmap, String path, int quality)
            throws IOException {
        compress2Jpeg(bitmap,new File(path), quality);
    }

    /**
     * Save bitmap 2 jpeg string.
     *
     * @param bitmap  the bitmap
     * @param path    the path
     * @param name    the name
     * @param quality the quality
     * @return the string
     * @throws IOException the io exception
     */
    public static String compress2Jpeg(Bitmap bitmap, String path, String name, int quality)
            throws IOException {
        return compress(bitmap, Bitmap.CompressFormat.JPEG, path, name, quality);
    }

    /**
     * Save bitmap 2 png string.
     *
     * @param bitmap the bitmap
     * @param path   the path
     * @param name   the name
     * @return the string
     * @throws IOException the io exception
     */
    public static String compress2Png(Bitmap bitmap, String path, String name)
            throws IOException {
        return compress(bitmap, Bitmap.CompressFormat.PNG, path, name, 100);
    }

    /**
     * Compress bitmap to image string.
     *
     * @param bitmap  the bitmap
     * @param format  the format
     * @param path    the path
     * @param name    期望的文件名
     * @param quality the quality
     * @return 实际保存的文件路径
     * @throws IOException the io exception
     */
    public static String compress(@NonNull Bitmap bitmap, Bitmap.CompressFormat format,
                                  String path, String name, int quality) throws IOException {
        //转换小写
        String fileName = name.toLowerCase();
        //文件名补全
        switch (format){
            case PNG:
                fileName = FileUtil.getNameWithExtension(fileName, ".png");
                break;
            case JPEG:
                String reg = ".(jp[e]?g)$";
                if(!Pattern.matches(reg, fileName)) {
                    fileName = FileUtil.getNameWithExtension(fileName, ".jpg");
                }
                break;
            case WEBP:
            case WEBP_LOSSY:
            case WEBP_LOSSLESS:
                fileName = FileUtil.getNameWithExtension(fileName, ".webp");
                break;
            default:
                throw new IOException("Unsupported compress format!");
        }
        File pathFile = new File(path, fileName);
        compress(bitmap, format, new File(pathFile, fileName),quality);
        return pathFile.getPath();
    }

    /**
     * Compress bitmap to jpeg.
     *
     * @param bitmap  the bitmap
     * @param file    the file
     * @param quality the quality
     * @throws IOException the io exception
     */
    public static void compress2Jpeg(Bitmap bitmap, File file, int quality)
            throws IOException {
        compress(bitmap, Bitmap.CompressFormat.JPEG, file, quality);
    }

    /**
     * Compress bitmap to png.
     *
     * @param bitmap the bitmap
     * @param file   the file
     * @throws IOException the io exception
     */
    public static void compress2Png(Bitmap bitmap, File file) throws IOException {
        compress(bitmap, Bitmap.CompressFormat.PNG, file, 100);
    }

    /**
     * Compress bitmap to specified image.
     *
     * @param bitmap  the bitmap
     * @param format  the format
     * @param file    the file
     * @param quality the quality
     * @throws IOException the io exception
     */
    public static void compress(@NonNull Bitmap bitmap, Bitmap.CompressFormat format,
                                @NonNull File file, int quality) throws IOException {
        File parent = file.getParentFile();
        if(parent != null && !parent.exists()) {
            if(!parent.mkdirs()){
                throw new IOException("directory " + parent.getPath() + " create failed!");
            }
        }
        if(file.isDirectory()) {
            if(!file.delete()) {
                throw new IOException("directory " + file.getPath() + " delete failed!");
            }
        }
        if(!file.exists() && !file.createNewFile()) {
            throw new IOException("file " + file.getPath() + " create failed!");
        }
        FileOutputStream out = new FileOutputStream(file);
        if (!bitmap.compress(format, quality, out)) {
            out.close();
            throw new IOException("file " + file.getPath()
                    + " compressed to the specified stream failed!");
        }
        out.flush();
        out.close();
        Log.d(TAG, "write file " + file.getName() + " length "
                + FileUtil.readableFileSize(file.length()));
    }

}
