package com.ifpb.pw.videoservice.service;

import com.ifpb.pw.videoservice.domain.Video;
import com.ifpb.pw.videoservice.repositories.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> findAll(){
        return videoRepository.findAll();
    }

    public Video findById(Long id){
        return videoRepository.findById(id).get();
    }

    public Video createOrUpdate(Video Video){
        return videoRepository.save(Video);
    }

    public void delete(Long id){
        videoRepository.deleteById(id);
    }

}
