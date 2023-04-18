package com.kbstar.service;

import com.kbstar.dao.OracleDao;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;

import java.util.List;

public class BankingService implements MyService<String, UserDTO> {

    MyDao<String, UserDTO> dao;

    public BankingService(){
        dao = new OracleDao();
    }  // 오라클 안 쓰고 다른 DB 쓰려면 요기만 바꿔주면 됨

    @Override
    public void register(UserDTO userDTO) {
        dao.insert(userDTO);
        System.out.println("회원등록 완료. Send Email");
    }

    @Override
    public void remove(String s) {

    }

    @Override
    public UserDTO get(String s) {
        return null;
    }

    @Override
    public List<UserDTO> get() {
        return null;
    }
}
