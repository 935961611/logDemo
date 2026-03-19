package org.tongzhou;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(1001L);
        userDTO.setUsername("张三");
        userDTO.setPhone("13812345678");
        userDTO.setPassword("123456");

        // ======================================
        // 演示 1：INFO 级别 —— 关键业务流程
        // ======================================
        log.info("====== 日志规范演示开始 ======");
        log.info("用户查询业务开始，用户ID：{}", userDTO.getUserId());


        // ======================================
        // 演示 2：DEBUG 级别 —— 调试详情（生产关闭）
        // ======================================
        log.debug("用户详细信息：{}", userDTO);


        // ======================================
        // 演示 3：WARN 级别 —— 业务非预期、潜在风险
        // ======================================
        if (userDTO.getPassword() != null) {
            log.warn("用户密码未加密存储，用户ID：{}", userDTO.getUserId());
        }


        // ======================================
        // 演示 4：ERROR 级别 —— 异常 + 堆栈 + 业务参数（最重要）
        // ======================================
        try {
            // 模拟异常
            int i = 1 / 0;
        } catch (Exception e) {
            // ✅ 正确：提示 + 参数 + 异常堆栈
            log.error("用户数据计算异常，用户ID：{}，用户名：{}", userDTO.getUserId(), userDTO.getUsername(), e);
        }


        // ======================================
        // 演示 5：敏感信息脱敏（规范要求）
        // ======================================
        log.info("用户登录成功，脱敏手机号：{}", DesensitizationUtil.phone(userDTO.getPhone()));
        // ❌ 错误示范（禁止）：log.info("用户手机号：{}", userDTO.getPhone());


        log.info("====== 日志规范演示结束 ======");
    }
}