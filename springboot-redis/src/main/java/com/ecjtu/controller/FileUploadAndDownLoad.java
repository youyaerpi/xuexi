package com.ecjtu.controller;

import com.ecjtu.config.StorageFileNotFoundException;
import com.ecjtu.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @program springboot-redis
 * @description: 文件上传和下载
 * @author: xiexiang
 * @create: 2018/10/15 09:55
 */
public class FileUploadAndDownLoad {
      private final StorageService storageService;

      @Autowired
      public FileUploadAndDownLoad(StorageService storageService) {
            this.storageService = storageService;
      }

      @GetMapping("/")
      public String listUploadedFiles(Model model) throws IOException {

            model.addAttribute("files", storageService
                    .loadAll()
                    .map(path ->
                            MvcUriComponentsBuilder
                                    .fromMethodName(FileUploadAndDownLoad.class, "serveFile", path.getFileName().toString())
                                    .build().toString())
                    .collect(Collectors.toList()));

            return "uploadForm";
      }

      @GetMapping("/files/{filename:.+}")
      @ResponseBody
      public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

            Resource file = storageService.loadAsResource(filename);
            return ResponseEntity
                    .ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                    .body(file);
      }

      @PostMapping("/")
      public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                     RedirectAttributes redirectAttributes) {

            storageService.store(file);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");

            return "redirect:/";
      }

      @ExceptionHandler(StorageFileNotFoundException.class)
      public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
            return ResponseEntity.notFound().build();
      }

}


