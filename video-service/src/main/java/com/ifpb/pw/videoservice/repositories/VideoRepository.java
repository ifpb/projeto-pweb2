package com.ifpb.pw.videoservice.repositories;

import com.ifpb.pw.videoservice.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
