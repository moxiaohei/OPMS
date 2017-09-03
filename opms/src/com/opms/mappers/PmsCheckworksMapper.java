package com.opms.mappers;

import com.opms.entity.PmsCheckworkandrealname;
import com.opms.entity.PmsCheckworks;
import com.opms.entity.PmsUsers;
import com.opms.entity.Subtotal;

import java.sql.Date;
import java.util.List;

public interface PmsCheckworksMapper {
   
    List<PmsCheckworks> listCheckworkbyPmsCheckworks(PmsCheckworks PmsCheckworks);
    List<PmsCheckworkandrealname> listAllCheckwork(PmsCheckworks PmsCheckworks);
    void insertCheckwork(PmsCheckworks PmsCheckworks);
    List<PmsCheckworks> countCheckwork(PmsCheckworks PmsCheckworks);
    List<Subtotal> typecountCheckwork(PmsCheckworks PmsCheckworks);
    float workdays(PmsCheckworks PmsCheckworks);
    List<PmsCheckworks> listCheckworkbytype(PmsCheckworks PmsCheckworks);
    List<PmsCheckworks> listCheckworkbycreated(PmsCheckworks PmsCheckworks);
    List<PmsCheckworkandrealname> listAllCheckworkbycreated(PmsCheckworks PmsCheckworks);
    
    List<PmsUsers> listusername();
}