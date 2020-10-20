package com.icebuf.util.internal;

import com.icebuf.util.FileOpEngine;

import java.io.File;
import java.io.FileFilter;
import java.util.List;

import io.reactivex.Flowable;

/**
 * @author IceTang
 * @version 1.0
 * Data: 2020/10/20
 * E-mail：bflyff@hotmail.com
 */
public class FileOpEngineImpl implements FileOpEngine {


    public FileOpEngineImpl() {

    }


    @Override
    public Flowable<List<File>> find(String path, String pattern) {
        return find(path, pattern, null);
    }

    @Override
    public Flowable<List<File>> find(String path, String pattern, FileFilter fileFilter) {
        return Flowable.create(new FileFindHandler(path, pattern, fileFilter), null);
    }

    @Override
    public Flowable<List<File>> copy(String srcPath, String dstPath) {
        return copy(srcPath, dstPath, null);
    }

    @Override
    public Flowable<List<File>> copy(String srcPath, String dstPath, FileFilter fileFilter) {
        return null;
    }

    @Override
    public Flowable<List<File>> move(String srcPath, String dstPath) {
        return move(srcPath, dstPath, null);
    }

    @Override
    public Flowable<List<File>> move(String srcPath, String dstPath, FileFilter fileFilter) {
        return null;
    }

    @Override
    public Flowable<List<File>> delete(String path) {
        return delete(path, null);
    }

    @Override
    public Flowable<List<File>> delete(String path, FileFilter fileFilter) {
        return null;
    }
}
