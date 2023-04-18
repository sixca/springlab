package com.kbstar.service;

import com.kbstar.dao.UserDAO;
import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("uservice")
public class UserService implements MyService<String, UserDTO> {

    @Autowired
    UserDAO dao; // 인터페이스를 안쓰고 그냥 무조건 이거 쓸거야 할 때는 이렇게
//    MyDao<String,UserDTO> dao; // 인터페이스를 활용한 이유는 오라클을 사용할수도 Mysql을 사용할수도 있으니

    @Override
    public void register(UserDTO userDTO) {
        dao.insert(userDTO);
        System.out.println("register. send mail~");
    }

    @Override
    public void remove(String s) {
        dao.delete(s);
        System.out.println("delete. send mail~");
    }

    @Override
    public void modify(UserDTO userDTO) {
        dao.update(userDTO);
        System.out.println("update. send mail~");
    }

    @Override
    public UserDTO get(String s) {
        return dao.select(s);
    }

    @Override
    public List<UserDTO> get() {
        return dao.select();
    }
}
