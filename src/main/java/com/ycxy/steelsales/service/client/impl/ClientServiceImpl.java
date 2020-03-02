package com.ycxy.steelsales.service.client.impl;

import com.github.pagehelper.PageHelper;
import com.ycxy.steelsales.mapper.client.SteelsaleClientMapper;
import com.ycxy.steelsales.pojo.client.SteelsaleClient;
import com.ycxy.steelsales.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private SteelsaleClientMapper clientMapper;

    @Override
    public List<SteelsaleClient> findClients(Integer page, Integer limit, String name, String creatTime, String updateTime) {
        Map map=new HashMap<>();
        map.put("name",name);
        map.put("createTime",creatTime);
        map.put("updateTime",updateTime);
        PageHelper.startPage(page, limit);
        List<SteelsaleClient> clients=clientMapper.fuzzyQuery(map);
        return clients;
    }

    @Override
    public void addClient(SteelsaleClient client) {
        clientMapper.insert(client);
    }

    @Override
    public SteelsaleClient findClient(Integer id) {

        return  clientMapper.selectByPrimaryKey(id);
    }

    @Override
    public void editClient(SteelsaleClient client) {
        clientMapper.updateByPrimaryKeySelective(client);
    }

    @Override
    public void removeClientByCid(Integer id) {
        clientMapper.deleteByPrimaryKey(id);
    }
}
