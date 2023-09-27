package org.aupp.diarybackend.service;

import org.aupp.diarybackend.entity.Diary;
import org.aupp.diarybackend.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {
    @Autowired
    DiaryRepository diaryRepository;

    public List<Diary> getDiaries() {
        return diaryRepository.findAll();
    }

    public Diary getDiary(int diaryID) {
        return diaryRepository.findById(diaryID).get();
    }

    public Diary saveDiary(Diary diary) {
        return diaryRepository.saveAndFlush(diary);
    }

    public void deleteDiary(int diaryID) {
        diaryRepository.deleteById(diaryID);
    }
}
