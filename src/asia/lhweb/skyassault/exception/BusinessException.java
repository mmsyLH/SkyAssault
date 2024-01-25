package asia.lhweb.skyassault.exception;
import asia.lhweb.skyassault.common.ErrorCode;

/**
 * 自定义异常类
 *
 * @author 罗汉
 * @date 2024/01/25
 */
public class BusinessException extends Exception {

    private final int code;

    private final String description;

    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = errorCode.getMessage();
    }

    public BusinessException(ErrorCode errorCode, String description) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}