package com.eastrise.xunwu.repository;

import java.util.List;

import com.eastrise.xunwu.entity.Subway;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by 瓦力.
 */
public interface SubwayRepository extends CrudRepository<Subway, Long>{
    List<Subway> findAllByCityEnName(String cityEnName);
}
