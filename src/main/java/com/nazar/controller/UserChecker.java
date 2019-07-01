package com.nazar.controller;

import com.nazar.dto.UserDTO;
import com.nazar.view.Regexes;
import com.nazar.view.TextConst;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserChecker {
    public boolean checkRegex(String exp,String regexp){
        return exp.matches(regexp);
    }
    public String checkUser(UserDTO user){
        StringBuilder resultMessage = new StringBuilder();
        if(!checkRegex(user.getUsername(), Regexes.NICKPAS)){
            resultMessage.append(TextConst.WRONGLOGIN);
            log.info(TextConst.WRONGLOGIN);
        }
        if(!checkRegex(user.getPassword(), Regexes.NICKPAS)){
            resultMessage.append(TextConst.WRONGPASS);
            log.info(TextConst.WRONGPASS);
        }

        return resultMessage.toString();
    }
}
