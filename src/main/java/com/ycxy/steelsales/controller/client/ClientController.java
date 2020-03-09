package com.ycxy.steelsales.controller.client;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.ycxy.steelsales.pojo.client.SteelsaleClient;
import com.ycxy.steelsales.service.client.ClientService;
import com.ycxy.steelsales.util.CityUtil;
import com.ycxy.steelsales.util.SteelSaleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 客户controller
 */
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * 模糊查询
     *
     * @param page
     * @param limit
     * @param name
     * @param creatTime
     * @param updateTime
     * @return
     */
    @RequestMapping("/client/list")
    @ResponseBody
    public SteelSaleResult findClients(Integer page, Integer limit, String name, String creatTime, String updateTime) {
        SteelSaleResult result = new SteelSaleResult();
        List<SteelsaleClient> clients = clientService.findClients(page, limit, name, creatTime, updateTime);
        PageInfo pageInfo = new PageInfo(clients);
        result.setData(pageInfo.getList());
        result.setCode(0);
        result.setCount((int) pageInfo.getTotal());
        return result;
    }

    /**
     * 添加客户
     *
     * @param client
     * @param cityUtil
     * @return
     */
    @RequestMapping("/client/add")
    @ResponseBody
    public SteelSaleResult addClient(SteelsaleClient client, CityUtil cityUtil) {
        SteelSaleResult result = new SteelSaleResult();
        client.setCity(JSON.toJSONString(cityUtil)); //设置城市
        clientService.addClient(client);//添加到数据库
        result.setCode(0);
        result.setMsg("添加失败");
        return result;
    }

    /**
     * 根据id 查找客户 用户修改客户信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/client/findeclient/{id}")
    @ResponseBody
    public SteelSaleResult findClient(@PathVariable("id") Integer id) {
        SteelSaleResult result = new SteelSaleResult();
        SteelsaleClient client = clientService.findClient(id);
        result.setData(client);
        result.setCode(0);
        return result;
    }

    /**
     * 修改客户
     *
     * @param client
     * @param cityUtil
     * @return
     */
    @RequestMapping("/client/edit")
    @ResponseBody
    public SteelSaleResult editClient(SteelsaleClient client, CityUtil cityUtil) {
        SteelSaleResult result = new SteelSaleResult();
        client.setCity(JSON.toJSONString(cityUtil));
        clientService.editClient(client);
        result.setCode(0);
        return result;
    }

    /**
     * 删除客户
     *
     * @param id
     * @return
     */
    @RequestMapping("/client/delete/{id}")
    @ResponseBody
    public SteelSaleResult removeClient(@PathVariable Integer id) {
        SteelSaleResult result = new SteelSaleResult();
        clientService.removeClientByCid(id);
        result.setCode(0);
        return result;
    }

    @RequestMapping("/client/deleteBatch")
    @ResponseBody
    public SteelSaleResult removeClients(@RequestParam("ids") List<Integer> ids) {
        SteelSaleResult result = new SteelSaleResult();
        for (Integer id : ids) {
            clientService.removeClientByCid(id);
        }
        result.setCode(0);
        System.out.println(ids);
        return result;
    }

}
