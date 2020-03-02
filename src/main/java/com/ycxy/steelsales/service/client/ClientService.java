package com.ycxy.steelsales.service.client;

import com.ycxy.steelsales.pojo.client.SteelsaleClient;

import java.util.List;

public interface ClientService {
    /**
     * 分页模糊查询客户列表
     * @param page
     * @param limit
     * @param name
     * @param creatTime
     * @param updateTime
     * @return
     */
    List<SteelsaleClient> findClients(Integer page, Integer limit, String name, String creatTime, String updateTime);

    /**
     * 添加客户
     * @param client
     */
    void addClient(SteelsaleClient client);

    /**
     * 通过客户id查询该客户信息
     * @param id
     * @return
     */
    SteelsaleClient findClient(Integer id);

    /**
     * 修改客户
     * @param client
     */
    void editClient(SteelsaleClient client);

    /**
     * 删除客户
     * @param id
     */
    void removeClientByCid(Integer id);
}
