package com.mygroup.myproject.response;

public class ApiCode {
    public final static int OK                      = 1511200;

    public final static int INTERNAL_SERVER_ERROR   = 1511500;
    public final static int BAD_REQUEST             = 1511501;

    public final static int MISS_PARAMETER          = 1511502;
    public final static int INVALID_PARAMETER       = 1511503;
    public final static int UNAUTHORIZED            = 1511504;
    public final static int INVALID_VERIFICATION    = 1511533;

    public final static int CHECK_FAIL              = 1511401;
    public final static int NOT_FOUND_ACTIVITY      = 1511404;
    public final static int NOT_FOUND               = 1511404;

    public final static int EXISTED                 = 1511630;

    public final static int EXISTED_CASHMENT        = 1511635;//有未完成的转账记录

    public final static int HAS_CASHMENT            = 1511636;//重回提现

    public final static int NOT_FOUND_CHANNEL       = 1511620;//未绑定提现账号

    public final static int OUT_OF_STOCK            = 1511901; //库存不足，商品已脱销

    public final static int OUT_OF_EARNSMONEY       = 15119541; //保证金不足

    public final static int DB_EXCEPTION       = 10710;
    public final static int DB_NULL_VALUE      = 10711;

    public final static int SERVICE_NOT_START  = 10720;
    public final static int SERVICE_EXCEPTION  = 10721;

    public  final static int ON_SELL  =  10722;

    public final static int DELIVERED_OR_UNPAID = 10723;
    public  final static int PLEDGE_LESS  = 10724;
    public  final static int PRESELL_PLEDGE_LESS  = 10725;

    public  final static int EXISTED_PARAMETER = 1511505;//物流单号已存在

    public  final static int ORDER_GENERATED = 1511506;//已经生成订单不允许下架

    public final static int CAPTCHA_VALIDATE_FAIL = 1511621;//验证码错误

    public final static int CAPTCHA_INVALID = 1511622;//验证码失效

    public  final static int FREEZE  =  1511507;   //冻结

    public final static int AFTER_SALE = 1511508; //售后订单

    public final static int CUSTOMERNO_EXISTED= 1511631; //已生成售后单号

    public final static int SOLD_OUT=1511900;//已下架

    public final static int CAPTCHA_IS_NOT_NULL = 1511623;//验证码不能为空

    public final static int MOBILE_IS_NOT_NULL = 1511624;//手机号码不能为空

    public final static int USER_DEVICE_ROUTE_OVER = 1511625;//同用户同设备访问过多

    public final static int UPDATE_CLIENT = 1517999;//手机号码不能为空

    public final static int EXISTED_WITHDRAW = 1511701;//已有正在提现中申请


    public final  static int SPIDER_ERROR = 1511444; //爬取数据失败

    public  final static int NOT_LOGIN = 1511445; //未登录

    public final static int NO_CHANCE = 1511446;//抽奖机会用完

    public final static int RED_PACKET_RECEIVE_NOT = 1511666;//红包已经领取完

    public final static int REPEAT_DRAW= 1511447;//领取过红包

    public final static int UP_LIMIT = 1511448;//达到领取上限

    public final static int FAILE_CACHE = 1511449;//读取缓存失败

    public final static int OVER_TIMES = 1511450;//超出次数

    public final static int FAILE_CHECK=1511451;//检查失败
    public final static int DO_NOT_OPERATE = 1511911;//验证中，请勿操作


    public final static int USER_FORBIDDEN = 1511800;//用户禁言

    public final static int FOLLOW = 1511801;//关注

    public final static int ACTIVITY_REMIND = 1511802;//活动提醒提示

    public final static int CHECKING_NOT_CANCEL=1511689;//正在鉴定中,无法撤销

    public final static int PUBLISH_FAIL=1511690;//发布鉴定失败

    public final static int LESS_LIMIT = 1511890;//提现金额不少于0.1元

    public final static int REPEAT_REPORT  = 1511870;//重复举报

    public final static int POSTING_TOO_FAST  = 1511871;//发帖太频繁

    public final static int COMMENT_TOO_FAST  = 1511872;//评论太频繁

    public final static int SENDED_GOODS  = 1511509;//卖家已发货不能取消订单

    //求购
    public final static int PRICE_CHANGED  = 1511900;//提交变现-求购价改变

    public final static int EXPRESSNO_UPPER_LIMIT = 1511509; //超过该物流单号对应订单数量的上线

    public final static int INVALID_HELP  = 1511405;//无效的助力

    public final static int OLDUSER_HELP_INVALID  = 1511406;//非新用户助力无效

    public final static int EXPIRED  = 1511555;//现货券寄存时间已经到期

    public final static int ENABLE_SUCCESSS  = 1511407;//已激活成功

    public final static int CERTIFICATION_FAIL  = 1511408;//认证失败

    public final static int POSTING_NOT_CHENCK = 1511409;// 帖子未被审核

    public final static int isNotAllowSell = 1511410;//不是指定卖家不允许出售

    public final static int NOT_IDENTIFY = 1511411;// 用户未实名

    public final static int NOT_MATCH = 1511412;// 信息不匹配

    public final static int EXISTED_UNDEAL_ORDER = 1511510;// 存在未完成订单

    public final static int SIGN_PEOPLE_FULL = 1511413;// 门店抽奖报名人数已满

    public final static int NOT_JOIN_TEAM = 1511417;// 未加团

    public final static int BID_FAIL = 1511414;// 出价失败 -有更高出价

    public final static int INITBID_OR_PRICEINCEEASE_FAIL = 1511399;// 起拍价或加价幅度不符合

    public final static int BUILD_LIMIT = 1511415;// 鞋友团创建限制

    public final static int ALREADY_SIGN_IN = 1511428;// 今日已签到，签到失败

    public final static int RELATION_ON_USERSELF = 1511430;

    public final static int NEWBALL_NO_COUPON = 1511431; //优惠券已被全部兑换

    public final static int APP_CODE_LACK_BEES = 1511612; //牛丸不知

    public final static int APP_CODE_OPERATION_FAILURE = 1511600; //操作失败

    public final static int MORE_ACTION_REQUIRED = 1518360;

    public final static int ADMIN_ERROE_CODE = 1515236;  //管理端代码提示错误
//    1511200: "request completed",
//    1511500: "server error",
//    1511501: "invalid request",
//    1511502: "missing parameter",
//    1511503: "invalid parameter",
//    1511504: "invalid signature",
//    1511510: "server busy",
//    1511530: "SMS verification code sent failed",
//    1511531: "verification code sent frequently, 60s interval",
//    1511532: "no verification code sent",
//    1511533: "invalid verification code",
//    1511540: "invalid auth token",
//    1511541: "expired auth token",
//    1511542: "already logged in on other devices",
//    1511543: "unregistered account",
//    1511544: "account has been registered",
//    1511545: "not logged in",
//    1511546: "abnormal account",
//    1511547: "incorrect account or password",
//    1511548: "incorrect username format",
//    1511600: "operation failure",
//    1511601: "upload file failed",
//    1511602: "address info is error",
//    1511610: "abnormal orders",
//    1511611: "abnormal order status",
//    1511612: "lack bees",
//    1511620: "operation repeat",
//    1511630: "already exists",
//    1511631: "already got",
//    1511640: "doesn't exist",
//    1511641: "coupon doesn't exist",
//    1511650: "not reached",
//    1511660: "already expired",
//    1511810: "该券已被领完",
//    1511811: "该券已领取达限制",
//    1511812: "该券已被使用",
//    1511813: "该券已过期",
//    1511814: "无效的优惠券",
//    1511900: "已下架",
//    1511901: "out of stock",
//    1511902: "over limit count",
//    1512001: "no use vip card",
//    1513001: "Your comments have been banned because of your violation",
//    1513002: "Your comments have been banned because of your violation",
//    1514001: "idcard is required",
//    1514002: "idcard is Invalid",
//    1514003: "支付失败",
//    1514004: "此商品不支持退换货",
//    1515001: "mobile is Invalid",
//    1516001: "The same order can be extended only once",
//    1516002: "The order is reject refund",
//    1516003: "商品已下架或删除"
//     10723: 订单已发货或订单未付款
}

