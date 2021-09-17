package cc.stan.example.graphqlexample.game;

import org.springframework.beans.BeanUtils;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Game Controller
 *
 * @author hualong.jia(at)seaboxdata.com
 * @since 1.0
 */

@Controller
public class GameCtl {
    private static List<Game> games = new ArrayList<>();

    static {
        games.add(new Game("a", "DarkSouls", "https://image.api.playstation.com/trophy/np/NPWR13281_00_00A03E8F7ED2727FADE2548E45F2781D32F5D048F6/B26EE8644603C33DBEB01C4E172FB4972D069B2E.PNG"));
        games.add(new Game("b", "Sekiro", "https://image.api.playstation.com/trophy/np/NPWR15587_00_00B683E5453204A612C38DC218AEF0317CD5E8E9CC/85B017F39EA939B035F2C5A6B7198E87DAC9B610.PNG"));
        games.add(new Game("c", "GuiltyGear", "https://image.api.playstation.com/trophy/np/NPWR10126_00_00B71A99A02F0CBA06FD43F769BD6779B115B44825/2271ABD0BB48D27B8557943FDEA2C2AC4C58470A.PNG"));
        games.add(new Game("d", "GodOfWar", "https://image.api.playstation.com/trophy/np/NPWR12518_00_009C1232E900005FE409857E926767DFE9CAC7F371/CCDC60CADE4B3970C348FEFDE0094BA95C0A802F.PNG"));
    }

    @QueryMapping
    public List<Game> games() {
        return games;
    }

    @QueryMapping
    public Game queryGameById(@Argument String id) {
        if (Objects.equals(null, id) || id.length() <= 0) {
            return null;
        }
        return games.stream().filter(game -> Objects.equals(game.getId(), id)).findFirst().orElse(null);
    }

    @MutationMapping
    public Game createGame(@Argument GameInput input) {
        if (Objects.nonNull(input)) {
            Game game = new Game();
            BeanUtils.copyProperties(input, game);
            games.add(game);
            return game;
        }
        return null;
    }
}
