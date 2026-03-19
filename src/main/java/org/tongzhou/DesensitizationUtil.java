package org.tongzhou;

/**
 * @Author: tongZ
 * @CreateTime: 2026-03-19
 * @Description:
 * @Version: 1.0
 */

/**
 * 敏感信息脱敏工具类（公司规范）
 */
public class DesensitizationUtil {

    // 手机号脱敏：138****1234
    public static String phone(String phone) {
        if (phone == null || phone.length() != 11) {
            return phone;
        }
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    // 身份证脱敏
    public static String idCard(String idCard) {
        if (idCard == null || idCard.length() < 8) {
            return idCard;
        }
        return idCard.replaceAll("(.{4})(.+)(.{4})", "$1********$3");
    }
}
