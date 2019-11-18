package comhy.tt.demo;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @auther thy
 * @date 2019/11/15
 */
@ToString
@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class UserContent {

    private String username;
    private String pwd;
}
