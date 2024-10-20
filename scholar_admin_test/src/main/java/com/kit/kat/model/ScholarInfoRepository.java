package com.kit.kat.model;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kit.kat.newScholarship.ScholarInfo;
@Repository
public interface ScholarInfoRepository extends CrudRepository<ScholarInfo,Integer>{

    public List<ScholarInfo> findAll();
    public ScholarInfo findById(int id);
    public void deleteById(int id);
    

}
