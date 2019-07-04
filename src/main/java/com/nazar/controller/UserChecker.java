package com.nazar.controller;

import com.nazar.dto.UserDTO;
import com.nazar.view.Regexes;
import com.nazar.view.TextConst;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class UserChecker {
    private boolean checkRegex(String exp,String regexp){
        return exp.matches(regexp);
    }
    public boolean checkUser(UserDTO user, Map<String, Object> model){
        boolean check = true;
        if(!checkRegex(user.getUsername(), Regexes.NICKPAS)){
            model.put("loginerr", TextConst.WRONGLOGIN);
            log.info(TextConst.WRONGLOGIN);
            check = false;
        }
        if(!checkRegex(user.getPassword(), Regexes.NICKPAS)){
            model.put("passerr", TextConst.WRONGPASS);
            log.info(TextConst.WRONGPASS);
            check = false;
        }
        return check;
    }
}
