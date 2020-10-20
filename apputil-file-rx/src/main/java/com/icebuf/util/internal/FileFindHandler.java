package com.icebuf.util.internal;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.annotations.NonNull;

/**
 * @author IceTang
 * @version 1.0
 * Data: 2020/10/20
 * E-mail：bflyff@hotmail.com
 */
public class FileFindHandler implements FlowableOnSubscribe<List<File>> {

    private String path;

    private String pattern;

    private FileFilter fileFilter;

    private List<File> result;

    public FileFindHandler(String path, String pattern, FileFilter fileFilter) {
        this.path = path;
        this.pattern = pattern;
        this.fileFilter = fileFilter;
    }

    @Override
    public void subscribe(@NonNull FlowableEmitter<List<File>> emitter) throws Exception {
        File directory = new File(path);
        if(!directory.exists() || directory.isFile()) {
            emitter.onComplete();
            return;
        }

        result = new ArrayList<>();
        emitter.onNext(new ArrayList<>());
        emitter.onNext(new ArrayList<>());
        emitter.onComplete();
    }
}
