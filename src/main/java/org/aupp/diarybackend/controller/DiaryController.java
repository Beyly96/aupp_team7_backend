package org.aupp.diarybackend.controller;

import org.aupp.diarybackend.entity.Diary;
import org.aupp.diarybackend.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/v1/diaries")
@CrossOrigin("*")
public class DiaryController {
    @Autowired
    DiaryService diaryService;

    @GetMapping("")
    public ResponseEntity get(){
        System.out.println("Called GET /v1/diaries");
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.getDiaries());
    }

    @GetMapping("/{diaryID}")
    public ResponseEntity getDiary(@PathVariable int diaryID){
        System.out.println("Called GET /v1/diaries/{diaryID}");
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.getDiary(diaryID));
    }

    @PostMapping("")
    public ResponseEntity saveDiary(@RequestBody Diary diary){
        System.out.println("Called POST /v1/diaries");
        diary.setCreatedDate(new Date());
        return ResponseEntity.status(HttpStatus.OK).body(diaryService.saveDiary(diary));
    }

    @DeleteMapping("/{diaryID}")
    public ResponseEntity deleteDiary(@PathVariable int diaryID) {
        System.out.println("Called DELETE /v1/diaries/{diaryID}");
        try {
            diaryService.deleteDiary(diaryID);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting diary");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Diary Deleted");
    }
}
