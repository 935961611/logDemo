package org.tongzhou;

import lombok.Data;

/**
 * @Author: tongZ
 * @CreateTime: 2026-03-19
 * @Description:
 * @Version: 1.0
 */
@Data
public class UserDTO {
    private Long userId;
    private String username;
    private String phone;
    private String password; // 敏感信息
}
