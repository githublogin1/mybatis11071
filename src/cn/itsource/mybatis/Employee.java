package cn.itsource.mybatis;

import lombok.*;

@Data
//@AllArgsConstructor //所有的参数的构造方法
//@NoArgsConstructor //默认的无参数构造方法
//@RequiredArgsConstructor //部分参数构造方法
public class Employee {

    //@NonNull
    private Long id;

    private String name;
}
