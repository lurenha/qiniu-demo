package com.example.qiniu.controller;

import com.example.qiniu.storage.StorageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/admin")
@Validated
public class AdminStorageController {
    private final Log logger = LogFactory.getLog(AdminStorageController.class);

    @Autowired
    private StorageService storageService;

    @PostMapping("/create")
    public Object create(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        storageService.store(file.getInputStream(), file.getSize(),
                file.getContentType(), originalFilename);
        return true;
    }

    @PostMapping("/delete")
    public Object delete(@RequestParam("key") String key) {
        if (StringUtils.isEmpty(key)) {
            return "exception";
        }
        storageService.delete(key);
        return true;
    }
}
