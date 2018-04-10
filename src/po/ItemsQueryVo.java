package po;

/**
 * 编写商品的包装类ItemsQueryVo
 */
public class ItemsQueryVo {
    private Items items;
    private ItemCustom itemCustom;
    public ItemCustom getItemCustom(){
        return itemCustom;
    }

    public void setItemCustom(ItemCustom itemCustom){
        this.itemCustom=itemCustom;
    }
}
