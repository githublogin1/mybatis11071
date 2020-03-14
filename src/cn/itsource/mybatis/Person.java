package cn.itsource.mybatis;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

    @NonNull
    private Long id;

    private String name;
}
