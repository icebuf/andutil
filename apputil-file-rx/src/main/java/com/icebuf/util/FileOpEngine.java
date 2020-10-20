package com.icebuf.util;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

import io.reactivex.Flowable;

/**
 * @author IceTang
 * @version 1.0
 * Data: 2020/10/19
 * E-mail：bflyff@hotmail.com
 */
public interface FileOpEngine {

    Flowable<List<File>> find(String path, String pattern);

    Flowable<List<File>> find(String path, String pattern, FileFilter fileFilter);

    Flowable<List<File>> copy(String srcPath, String dstPath);

    Flowable<List<File>> copy(String srcPath, String dstPath, FileFilter fileFilter);

    Flowable<List<File>> move(String srcPath, String dstPath);

    Flowable<List<File>> move(String srcPath, String dstPath, FileFilter fileFilter);

    Flowable<List<File>> delete(String path);

    Flowable<List<File>> delete(String path, FileFilter fileFilter);

}
