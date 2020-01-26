package com.example.qiniu.storage;


import com.example.qiniu.storage.server.Storage;
import org.springframework.core.io.Resource;


import java.io.InputStream;
import java.nio.file.Path;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * 提供存储服务类，所有存储服务均由该类对外提供
 */
public class StorageService  {
    private String active;
    private Storage storage;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param fileName      文件索引名
     */
    public boolean store(InputStream inputStream, long contentLength, String contentType, String fileName) {
        String key=generateKey(fileName);
        storage.store(inputStream, contentLength, contentType, key);
//        String url = generateUrl(key);
//        业务相关
//        保存key等信息到数据库
        return true;
    }
    private String generateKey(String originalFilename) {
        int index = originalFilename.lastIndexOf('.');
        String suffix = originalFilename.substring(index);
        String key = UUID.randomUUID().toString();
        key = key.replace("-", "");
        key+=suffix;
        return key;
    }

    public Stream<Path> loadAll() {
        return storage.loadAll();
    }

    public Path load(String keyName) {
        return storage.load(keyName);
    }

    public Resource loadAsResource(String keyName) {
        return storage.loadAsResource(keyName);
    }

    public void delete(String keyName) {
        storage.delete(keyName);
    }

    private String generateUrl(String keyName) {
        return storage.generateUrl(keyName);
    }
}
