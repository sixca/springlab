package com.kbstar.service;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Marker;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.AdmMapper;
import com.kbstar.mapper.MarkerMapper;
import org.apache.ibatis.javassist.bytecode.stackmap.MapMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerService implements KBService<Integer, Marker> {
    @Autowired
    MarkerMapper mapper;

    /**
     * 등록 및 가입 진행
     * argument: Object
     * return: null
     *
     * @param marker
     */
    @Override
    public void register(Marker marker) throws Exception {
        mapper.insert(marker);
    }

    @Override
    public void remove(Integer id) throws Exception {
        mapper.delete(id);
    }

    @Override
    public void modify(Marker marker) throws Exception {
        mapper.update(marker);

    }

    @Override
    public Marker get(Integer id) throws Exception {
        return mapper.select(id);
    }

    @Override
    public List<Marker> get() throws Exception {
        return mapper.selectall();
    }

    public List<Marker> getLoc(String loc) throws Exception{
        return mapper.getloc(loc);
    }
}
