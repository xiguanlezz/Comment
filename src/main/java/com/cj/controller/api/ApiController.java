package com.cj.controller.api;

import com.cj.cache.CodeCache;
import com.cj.cache.TokenCache;
import com.cj.dto.*;
import com.cj.entity.Advertisement;
import com.cj.entity.Page;
import com.cj.service.*;
import com.cj.util.CommonUtil;
import com.cj.util.MD5Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RequestMapping("/api")
@RestController
public class ApiController {

    @Autowired
    private AdvertisementService advertisementService;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CommentService commentService;

    @Value("${businessHome.number}")
    private int businessHomeNumber;
    @Value("${businessSearch.number}")
    private int businessSearchNumber;

    @RequestMapping(value = "/homead", method = RequestMethod.GET)
    public List<AdvertisementDto> homead() throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        String s = "[{\"title\":\"暑假5折\",\"img\":\"https://images2015.cnblogs.com/blog/138012/201610/138012-20161016191639092-2000037796.png\",\"link\":\"https://www.imooc.com/wap/index\"}," +
//                "{\"title\":\"特价出国\",\"img\":\"https://images2015.cnblogs.com/blog/138012/201610/138012-20161016191648124-298129318.png\",\"link\":\"https://www.imooc.com/wap/index\"}," +
//                "{\"title\":\"亮亮车\",\"img\":\"https://images2015.cnblogs.com/blog/138012/201610/138012-20161016191653983-1962772127.png\",\"link\":\"https://www.imooc.com/wap/index\"}," +
//                "{\"title\":\"学钢琴\",\"img\":\"https://images2015.cnblogs.com/blog/138012/201610/138012-20161016191700420-1584459466.png\",\"link\":\"https://www.imooc.com/wap/index\"}," +
//                "{\"title\":\"电影\",\"img\":\"https://images2015.cnblogs.com/blog/138012/201610/138012-20161016191706733-367929553.png\",\"link\":\"https://www.imooc.com/wap/index\"}," +
//                "{\"title\":\"旅游热线\",\"img\":\"https://images2015.cnblogs.com/blog/138012/201610/138012-20161016191713186-495002222.png\",\"link\":\"https://www.imooc.com/wap/index\"}]";
//        return mapper.readValue(s, new TypeReference<List<Ad>>() {
//        });
        List<AdvertisementDto> ads = advertisementService.ForApiQueryShow();
        return ads;
    }

    @RequestMapping(value = "/homelist/{businessCityCode}/{page.currentPage}", method = RequestMethod.GET)
    public BusinessListDto homelist(BusinessDto businessDto) throws JsonProcessingException {
//        ObjectMapper mapper=new ObjectMapper();
//        String s="{\"hasMore\":true,\"data\":[{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201638030-473660627.png\",\"title\":\"汉堡大大\",\"subTitle\":\"叫我汉堡大大，还你多彩口味\",\"price\":\"28\",\"distance\":\"120m\",\"mumber\":\"389\",\"id\":\"4271921243674752\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201645858-1342445625.png\",\"title\":\"北京开源饭店\",\"subTitle\":\"[望京]自助晚餐\",\"price\":\"98\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"9520374873361015\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201652952-1050532278.png\",\"title\":\"服装定制\",\"subTitle\":\"原价xx元，现价xx元，可修改一次\",\"price\":\"1980\",\"distance\":\"160\",\"mumber\":\"106\",\"id\":\"6735605236807856\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201700186-1351787273.png\",\"title\":\"婚纱摄影\",\"subTitle\":\"免费试穿，拍照留念\",\"price\":\"2899\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"6569145880592859\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201708124-1116595594.png\",\"title\":\"麻辣串串烧\",\"subTitle\":\"双人免费套餐等你抢购\",\"price\":\"0\",\"distance\":\"160\",\"mumber\":\"1426\",\"id\":\"678374488801714\"}]}";
//        return mapper.readValue(s, new TypeReference<BusinessListDto>() {
//        });
        businessDto.getPage().setPageSize(businessHomeNumber);
        BusinessListDto blist = businessService.ForApiQueryLikeByPage(businessDto);
        return blist;
    }

    /**
     * 搜索结果页 - 搜索结果 - 三个参数
     */
    @RequestMapping(value = "/search/{page.currentPage}/{businessCityCode}/{businessCateCode}/{keyword}", method = RequestMethod.GET)
    public BusinessListDto searchByKeyword(BusinessDto businessDto) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        String s = "{\"hasMore\":true,\"data\":[{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145742279-606202974.jpg\",\"title\":\"河束人家\",\"subTitle\":\"南锣鼓巷店\",\"price\":\"150\",\"distance\":\"120m\",\"mumber\":\"389\",\"id\":\"8149902620958753\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145750123-1745839503.jpg\",\"title\":\"漫漫火锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"924294420322336\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145755545-1770557408.jpg\",\"title\":\"北方涮肉\",\"subTitle\":\"什刹海店\",\"price\":\"92\",\"distance\":\"160\",\"mumber\":\"106\",\"id\":\"25086444430965793\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"姓高火锅\",\"subTitle\":\"知春里店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"5740847877773936\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145806201-1193851669.jpg\",\"title\":\"八重牛府\",\"subTitle\":\"最好吃的牛丸\",\"price\":\"85\",\"distance\":\"160\",\"mumber\":\"1426\",\"id\":\"5750180790120485\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022150855185-1659375763.jpg\",\"title\":\"蜀乡涮锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"1329161095301321\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"满楼福火锅\",\"subTitle\":\"知春路店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"07778127624539666\"}]}";
//        return mapper.readValue(s, new TypeReference<BusinessListDto>() {
//        });
        businessDto.getPage().setPageSize(businessHomeNumber);
        BusinessListDto blist = businessService.ForApiQueryLikeByPage(businessDto);
        return blist;
    }

    /**
     * 搜索结果页 - 搜索结果 - 两个参数
     */
    @RequestMapping(value = "/search/{page.currentPage}/{businessCityCode}/{businessCateCode}", method = RequestMethod.GET)
    public BusinessListDto search(BusinessDto businessDto) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        String s = "{\"hasMore\":true,\"data\":[{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145742279-606202974.jpg\",\"title\":\"河束人家\",\"subTitle\":\"南锣鼓巷店\",\"price\":\"150\",\"distance\":\"120m\",\"mumber\":\"389\",\"id\":\"8149902620958753\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145750123-1745839503.jpg\",\"title\":\"漫漫火锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"924294420322336\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145755545-1770557408.jpg\",\"title\":\"北方涮肉\",\"subTitle\":\"什刹海店\",\"price\":\"92\",\"distance\":\"160\",\"mumber\":\"106\",\"id\":\"25086444430965793\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"姓高火锅\",\"subTitle\":\"知春里店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"5740847877773936\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145806201-1193851669.jpg\",\"title\":\"八重牛府\",\"subTitle\":\"最好吃的牛丸\",\"price\":\"85\",\"distance\":\"160\",\"mumber\":\"1426\",\"id\":\"5750180790120485\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022150855185-1659375763.jpg\",\"title\":\"蜀乡涮锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"1329161095301321\"}," +
//                "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"满楼福火锅\",\"subTitle\":\"知春路店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"07778127624539666\"}]}";
//        return mapper.readValue(s, new TypeReference<BusinessListDto>() {
//        });
        businessDto.getPage().setPageSize(businessHomeNumber);
        BusinessListDto blist = businessService.ForApiQueryLikeByPage(businessDto);
        return blist;
    }

    /**
     * 详情页 - 商户信息
     */
    @RequestMapping(value = "/detail/info/{id}", method = RequestMethod.GET)
    public BusinessDto detail(@PathVariable("id") Long id) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        String s = "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201645858-1342445625.png\"," +
//                "\"title\":\"天下第一锅\",\"star\":4,\"price\":\"88\",\"subTitle\":\"重庆 & 四川 麻辣火锅\",\"desc\":\"" +
//                "营业时间 11:00 - 21:00 <br> 电话订购 11:00 - 19:00 <br> 网络订购 11:00 - 19:00\"};";
//        return mapper.readValue(s, new TypeReference<BusinessDto>() {
//        });
        return businessService.ForApiQueryById(id);
    }


    @RequestMapping(value = "/detail/comment/{currentPage}/{businessId}", method = RequestMethod.GET)
    public CommentListDto detail(@PathVariable("businessId") Integer businessId, Page page) {
        return commentService.ForApiQueryByPage(businessId, page);
    }

    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    public ApiCodeDto sms(@RequestParam("username") Long username) {
        ApiCodeDto apiCodeDto = new ApiCodeDto();
        if (memberService.isExist(username)) {
            String code = String.valueOf(CommonUtil.generateRandom(6));
            System.out.println(code);
            if (memberService.saveCode(username, MD5Util.getMD5(code))) {
                if (memberService.sendCode(username, code)) {
                    apiCodeDto.setErrno(0);
                    apiCodeDto.setMsg("发送成功");
                    apiCodeDto.setCode(code);
                } else {
                    apiCodeDto.setErrno(1);
                    apiCodeDto.setMsg("发送失败");
                }
            } else {
                apiCodeDto.setErrno(1);
                apiCodeDto.setMsg("保存失败");
            }
        } else {
            apiCodeDto.setErrno(1);
            apiCodeDto.setMsg("手机号不存在");
        }
//        System.out.println("1111短信接口1111");
        return apiCodeDto;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiCodeDto login(@RequestParam("username") Long username, @RequestParam("code") String code) {
        ApiCodeDto apiCodeDto = new ApiCodeDto();
        System.out.println(code);
        if (memberService.hasCode(username)) {
            String t = memberService.getCode(username);
            //MD5只能加密无法解密
            //将加密后的数据存到数据库, 登陆的时候将输入的数据加密后再和数据库中存放的数据对比
            if (t.equals(code)) {    //前端APP已经将请求参数加密过了
                apiCodeDto.setErrno(0);
                apiCodeDto.setMsg("登陆成功");
                String token = CommonUtil.getUUID();
                apiCodeDto.setToken(token);
                //保存token
                memberService.saveToken(username, token);
            } else {
                apiCodeDto.setErrno(1);
                apiCodeDto.setMsg("登陆失败");
            }
        } else {
            apiCodeDto.setErrno(1);
            apiCodeDto.setMsg("登陆失败");
        }
        return apiCodeDto;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ApiCodeDto order(OrderForBuyDto orderForBuyDto) {
//        System.out.println(orderForBuyDto);
        //每次Ajax请求头里面会带上token
        ApiCodeDto dto = new ApiCodeDto();
        Long phone = memberService.getPhone(orderForBuyDto.getToken());
        //比较token中存放的信息是否和请求参数中一致
        if (phone != null && phone.equals(orderForBuyDto.getUsername())) {
            //phone.equals(orderForBuyDto.getUsername())
            OrderDto orderDto = new OrderDto();
            orderDto.setOrderBId(orderForBuyDto.getId());
            Integer memberId = memberService.QueryIdByPhone(phone);
            orderDto.setOrderMId(memberId);
            orderDto.setOrderNumber(orderForBuyDto.getNum());
            orderDto.setOrderPrice(orderForBuyDto.getPrice());
            orderDto.setOrderTime(CommonUtil.getcurrentTime("yyyy-MM-dd HH:mm:ss"));
            if (orderService.Add(orderDto)) {
                dto.setMsg("下单成功");
//                System.out.println("下单成功");
            } else {
                dto.setMsg("下单失败");
//                System.out.println("下单失败");
            }

            //更新商户表的已售数量
            //采用定时任务完成更新
        } else {
            dto.setMsg("还未登录, 请先登录");
            System.out.println("请先登录");
        }
        return dto;
    }

    @RequestMapping(value = "/orderlist/{username}", method = RequestMethod.GET)
    public List<OrderDto> orderlist(@PathVariable("username") Long username) {
        // 根据手机号取出memberId
        Integer memberId = memberService.QueryIdByPhone(username);
        return orderService.QueryByMId(memberId);
    }

    @RequestMapping(value = "/submitComment", method = RequestMethod.POST)
    public ApiCodeDto submitComment(CommentForSubmitDto commentForSubmitDto) {
//        System.out.println(commentForSubmitDto);
        ApiCodeDto apiCodeDto = new ApiCodeDto();
        Long phone = memberService.getPhone(commentForSubmitDto.getToken());
        if (phone != null) {
            //根据订单id查询该订单的用户id
            Integer MId = orderService.QueryMIdById(commentForSubmitDto.getId());
//            System.out.println(memberService.QueryIdByPhone(commentForSubmitDto.getUsername()));
//            System.out.println(MId);
            if (MId != null && MId.equals(memberService.QueryIdByPhone(commentForSubmitDto.getUsername()))) {
                //是本人评论
                CommentDto c = new CommentDto();
                c.setCommentOId(commentForSubmitDto.getId());
                c.setCommentMId(MId);
                c.setCommentStar(commentForSubmitDto.getStar());
                c.setCommentContent(commentForSubmitDto.getComment());
                c.setCommentTime(CommonUtil.getcurrentTime("yyyy-MM-dd HH:mm:ss"));
//                System.out.println("评论好了");
                commentService.Add(c);
                apiCodeDto.setErrno(0);
                apiCodeDto.setMsg("评论成功");

                //TODO 差一步 定时更新商户的星级
            } else {
                //非本人评论
                apiCodeDto.setErrno(1);
                apiCodeDto.setMsg("评论失败");
            }
        }
        return apiCodeDto;
    }
}
