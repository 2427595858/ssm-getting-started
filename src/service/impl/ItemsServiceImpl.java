package service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mapper.ItemsCustomMapper;
import mapper.ItemsMapper;
import po.ItemCustom;
import po.Items;
import po.ItemsQueryVo;
import service.ItemsService;

/**
 * 继承ItemsService接口
 *
 * 将Service对象注入到spring的IOC容器中的两种方法：
 * 1.通过@Service方式（即在ItemsServiceImpl上标注@Service）
 * 2.通过bean标签方式
 *     在applicationContext-service.xml文件中添加如下bean语句配置
 *     <bean id="itemsService" class="service.impl.ItemsServiceImp1"/>
 *
 * 两种方式可以并存
 */

@Service
public class ItemsServiceImpl implements ItemsService{
    //注入mapper，之前已经在applicationContext-dao中使用扫描器扫描mapper包，可以直接注入
    @Autowired
    private ItemsCustomMapper itemsCustomMapper;

    @Autowired
    private ItemsMapper itemsMapper;    //需要用到逆向工程生成的ItemsMapper中的方法

    //商品查询列表（重写ItemsService接口中的findItemsList方法）
    @Override
    public List<ItemCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception{
        return itemsCustomMapper.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemCustom findItemsById(Integer id) throws Exception{
        //通过mapper包下itemsMapper中的selectByPrimaryKey方法找到相应的item
        Items items=itemsMapper.selectByPrimaryKey(id);

        //考虑到可能扩展另外的属性，这里使用继承了Items类的ItemCustom类
        ItemCustom itemCustom=new ItemCustom();

        //通过spring提供的BeanUtils.copyProperties方法将items的属性拷贝到itemCustom中
        BeanUtils.copyProperties(items,itemCustom);
        return itemCustom;
    }

    @Override
    public void updateItems(Integer id,ItemCustom itemCustom) throws Exception{
        //传入id
        itemCustom.setId(id);
        /**
         * ItemsMapper中关于更新的有两个方法
         * updateByPrimaryKeySelective和updateByPrimaryKey
         * 第一个只是更新新的model中不为空的字段
         * 第二个会将为空的字段在数据库中置为NULL
         * 这里选择第二个
         */
        itemsMapper.updateByPrimaryKey(itemCustom);

    }
}
