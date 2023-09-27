package org.aupp.diarybackend.repository;

import org.aupp.diarybackend.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryRepository extends JpaRepository<Diary, Integer> {
}
