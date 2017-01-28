package com.seven.eleven.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by JPMPC-B210 on 1/6/2017.
 */
@Repository
public interface SevenElevenRepo extends JpaRepository<SevenElevenModel,Integer>{
}

