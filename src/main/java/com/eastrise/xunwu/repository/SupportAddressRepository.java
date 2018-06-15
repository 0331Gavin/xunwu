package com.eastrise.xunwu.repository;

import com.eastrise.xunwu.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * create by gzq on 2018/6/15 14:13
 */
public interface SupportAddressRepository extends CrudRepository<SupportAddress, Long> {
    /**
     * 获取所有对应行政级别的信息
     * @return
     */
    List<SupportAddress> findAllByLevel(String level);
    SupportAddress findByEnNameAndLevel(String enName, String level);

    SupportAddress findByEnNameAndBelongTo(String enName, String belongTo);

    List<SupportAddress> findAllByLevelAndBelongTo(String level, String belongTo);
}
