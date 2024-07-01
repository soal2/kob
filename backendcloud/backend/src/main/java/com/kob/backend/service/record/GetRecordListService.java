package com.kob.backend.service.record;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface GetRecordListService {
    JSONObject getList(Integer page);
}
