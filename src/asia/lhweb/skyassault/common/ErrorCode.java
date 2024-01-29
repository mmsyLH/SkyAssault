package asia.lhweb.skyassault.common;

/**
 * 错误码
 *
 * @author 罗汉
 * @date 2024/01/25
 */
public enum ErrorCode {
    SUCCESS(200, "ok", ""),
    SUCCESS_START(201, "游戏类", ""),
    SUCCESS_STOP(202, "游戏类", ""),
    //例如玩家飞机被击毁了 是否复活
    //登录成功，弹个弹窗
    //是否重新开始游戏
    PARAMS_ERROR(300, "输入参数错误", ""),
    SYSTEM_ERROR(500, "系统内部异常", "");

    private final int code;

    /**
     * 状态码信息
     */
    private final String message;

    /**
     * 状态码描述（详情） 用来显示具体信息
     */
    private final String description;

    ErrorCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }
        public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

}