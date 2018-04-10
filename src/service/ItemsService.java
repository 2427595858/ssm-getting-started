package service;

import po.ItemCustom;
import po.ItemsQueryVo;

import java.util.List;

//定义service接口
public interface ItemsService {
    // 商品查询列表
    public List<ItemCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    //根据id查询商品
    //使用Integer类型可以判断id是否为空
    public ItemCustom findItemsById(Integer id) throws Exception;

    //修改商品信息

    /**
     *
     * @param id   (传入需要修改商品的id）
     * @param itemCustom  （需要修改的商品信息）
     * @throws Exception
     */
    public void updateItems(Integer id,ItemCustom itemCustom) throws Exception;
}
