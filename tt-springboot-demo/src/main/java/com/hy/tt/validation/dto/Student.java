package com.hy.tt.validation.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @auther thy
 * @date 2019/9/23
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = -3571958868498653169L;

    @NotNull(message = "id 不能为空!")
    private Long id;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String phone;

    @NotBlank(message = "name 不能为空!")
    @Length(max = 10, message = "用户名不能超过10个字符")
    private String name;
}
