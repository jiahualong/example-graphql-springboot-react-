package cc.stan.example.graphqlexample.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Dog Vo
 *
 * @author hualong.jia(at)seaboxdata.com
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private String id;
    private String name;
    private String imgUrl;
}
