package com.wulianwang.iotl.Service;

import com.wulianwang.iotl.Bean.Push;
import com.wulianwang.iotl.DataBase.PushDao;
import com.wulianwang.iotl.Interface.PushInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lhk
 * @description
 * @create 2020-09-15 20:27
 */
@Service
public class PushService implements PushInterface {
    @Autowired
    PushDao pushDao;

    @Override
    public List<Push> getPushList() {
        return pushDao.getPushList();
    }
}