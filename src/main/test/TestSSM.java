import com.cj.constant.DicTypeConst;
import com.cj.dto.*;
import com.cj.entity.*;
import com.cj.service.*;

import com.cj.util.MD5Util;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-config.xml")
public class TestSSM {

    @Autowired
    private AdvertisementService advertisementService;
    @Autowired
    private DicService dicService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private NumtaskService numtaskService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private StartaskService startaskService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private ReportService reportService;

    @Test
    public void test01() {
        Advertisement advertisement = advertisementService.QueryById(1);
        System.out.println(advertisement);
    }

    @Test
    public void test02() {
        advertisementService.AddBatch();
    }

    @Test
    public void test03() {
        AdvertisementDto a = new AdvertisementDto();
        a.setAdvertisementId(57);
        a.setAdvertisementName("14hh");
        a.setAdvertisementImgName("14.jpg");
        a.setAdvertisementLink("www");
        a.setAdvertisementWeight(1);
        advertisementService.Update(a.getAdvertisementId(), a);
    }

    @Test
    public void test04() {
        List<AdvertisementDto> advertisementDtos = advertisementService.ForApiQueryShow();
    }

    @Test
    public void test05() {
        System.out.println(dicService.QueryByType(DicTypeConst.CATE));
    }

    @Test
    public void test06() {
        businessService.AddBatch();
    }

    @Test
    public void test07() {
        BusinessDto businessDto = new BusinessDto();
        businessDto.setBusinessCityCode("北京");
        businessDto.getPage().setPageSize(8);
        System.out.println(businessService.ForApiQueryLikeByPage(businessDto));
    }

    @Test
    public void test08() {
        BusinessDto businessDto = new BusinessDto();
        businessDto.setBusinessCateCode("meishi");
        businessDto.setBusinessTitle("汉堡");
        businessDto.setBusinessCityCode("广州");
        businessDto.getPage().setCurrentPage(0);
        System.out.println(businessService.ForApiQueryLikeByPage(businessDto));
    }

    @Test
    public void test09() {
//        Map<String, String> map = new LinkedHashMap<String, String>();
//        map.put("1", "hhh");
//        map.put("2", "xxx");
//        System.out.println(map.get("3"));  e72e757be70e81a39dea8ddf9c6b76e6
//        System.out.println(MD5Util.getMD5("738489"));
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderBId(208);
        orderDto.setOrderMId(1);
        orderDto.setOrderNumber(2);
        orderDto.setOrderPrice(375);
        orderService.Add(orderDto);
    }

    @Test
    public void test10() {
        Integer memberId = memberService.QueryIdByPhone(17367117439L);
        List<OrderDto> orderDtos = orderService.QueryByMId(memberId);
        for (OrderDto o : orderDtos) {
            System.out.println(o);
        }
    }

    @Test
    public void test11() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = format.format(date);
        System.out.println(currentTime);
//        timeService.Add(currentTime);
        numtaskService.Update(currentTime);
        int i = businessService.newUpdateNumber();
        System.out.println(i);
    }

    @Test
    public void test12() {
//        Orders orders = new Orders();
//        orders.setOrderTime(CommonUtil.getcurrentTime("yyyy-MM-dd HH:mm:ss"));
//        orders.setOrderBId(207);
//        orders.setOrderMId(1);
//        orders.setOrderState(0);
//        orders.setOrderNumber(11);
//        OrderDto o = new OrderDto();
//        BeanUtils.copyProperties(orders, o);
//        orderService.Add(o);
//        businessService.newUpdateNumber();
        businessService.newUpdateNumber();
//        timeService.Update(CommonUtil.getcurrentTime("yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test13() {
        if (orderService.UpdateState(3)) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void test14() {
        Page p = new Page();
        p.setCurrentPage(1);

        CommentListDto commentListDto = commentService.ForApiQueryByPage(3, p);
        System.out.println(commentListDto);
    }

    @Test
    public void test15() {
//        List<Startask> startasks = startaskService.QueryAll();
//        System.out.println(startasks);
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = format.format(date);
        startaskService.Add(currentTime);

    }

    @Test
    public void test16() {
        int i = businessService.UpdateRedundancy();
        System.out.println(i);
//        int j = businessService.newUpdateStar();
//        System.out.println(j);
    }

    @Test
    public void test17() {
        AdminDto adminDto = new AdminDto();
        adminDto.setAdminNickname("admin1");
        adminDto.setAdminUsername("admin");
        adminDto.setAdminPassword(MD5Util.getMD5("123"));
        adminService.Add(adminDto);
    }

    @Test
    public void test18() {
        OrderDto orderDto = new OrderDto();
        Page p = new Page();
        p.setCurrentPage(1);
        orderDto.setPage(p);
        System.out.println(orderService.QueryByPage(orderDto));
    }

    @Test
    public void test19() {
        CommentDto commentDto = new CommentDto();
        Page p = new Page();
        p.setCurrentPage(1);
        commentDto.setPage(p);
        Member member = new Member();
        member.setMemberPhone(173L);
        commentDto.setCommentMember(member);
        System.out.println(commentService.QueryByPage(commentDto));
    }

    @Test
    public void test20() {
        List<Reports> reports = reportService.QueryCount();
//        System.out.println(reports);
        System.out.println(reportService.Package(reports));
    }
}
