package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.portlet.ModelAndView; 之前引用成这个包了（找了半天错误..）
import po.ItemCustom;
import service.ItemsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
//为了便于管理，添加根路径为/items
@RequestMapping("/items")
public class ItemsController {
    //注入service(通过service来调用数据库的数据）
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/queryItems")
    public ModelAndView queryItems() throws Exception{
        //调用service来显示商品列表
        List<ItemCustom> itemsList=itemsService.findItemsList(null);

        ModelAndView modelAndView=new ModelAndView();   //创建视图对象
        modelAndView.addObject("itemsList",itemsList);
        modelAndView.setViewName("itemsList");  //指定用户访问的jsp页面地址，前缀和后缀已在前端控制器中配好
        return modelAndView;
    }

    @RequestMapping(value="/editItems",method = {RequestMethod.POST,RequestMethod.GET})
    public String editItems(Model model, Integer id) throws Exception{
        // 调用service通过id查找相应的商品信息
        // 这里需要进行绑定参数的设置
        ItemCustom itemCustom=itemsService.findItemsById(id);
        model.addAttribute("itemCustom",itemCustom);
        return "editItems";

    }

    @RequestMapping("/editItemsSubmit")
    public String editItemsSubmit(HttpServletRequest request,Integer id,ItemCustom itemCustom) throws Exception{
        //通过service返回修改后的页面
        //形参中传递了pojo类型参数（即itemCustom）
        itemsService.updateItems(id,itemCustom);

        //重定向到商品查询列表
        return "forward:queryItems.action";
    }
}
