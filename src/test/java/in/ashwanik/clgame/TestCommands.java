package in.ashwanik.clgame;

import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.commands.IssuedCommand;
import in.ashwanik.clgame.commands.list.Help;
import in.ashwanik.clgame.messaging.EventBus;
import in.ashwanik.clgame.messaging.Topics;
import in.ashwanik.clgame.messaging.messages.CommandMessage;
import in.ashwanik.clgame.messaging.messages.MessageType;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static in.ashwanik.clgame.TestData.initBaseData;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
@Category(UnitTest.class)
public class TestCommands {

    private List<String> messages;

    private void init() {
        messages = new ArrayList<>();
        initBaseData(messages);
    }

    private void publishCommand(String command, String[] params) {
        IssuedCommand issuedCommand = new IssuedCommand(command);
        for (String arg : params) {
            issuedCommand.addToken(arg);
        }
        EventBus.getInstance().publish(CommandMessage.builder().messageType(MessageType.COMMAND).topic(Topics.COMMAND).payload(issuedCommand).build());
    }

    private Game setGame() {
        return new Game(() -> {

        });
    }

    @Before
    public void setupTest() throws IOException {
        init();
        messages.clear();
        Game.reset();
        setGame();
    }

    @Test
    public void Should_Two_Commands_Are_Same() {
        Command command1 = new Help("help", "help");
        Command command2 = new Help("help", "help");
        assertThat(command1.equals(command2)).isTrue();
    }

    @Test
    public void Should_Check_If_Game_Initialized() {
        Game game = Application.startGame(() -> publishCommand("Help", new String[]{"Help"}), new TestData.TestDisplay(messages), true);
        assertThat(game).isNotNull();
    }


    @Test
    public void Should_Not_Start_Game_On_New() {
        publishCommand("New", new String[]{"New"});
        assertThat(Game.isStarted()).isFalse();
    }

    @Test
    public void Should_Not_Start_Game_On_Arm() {
        publishCommand("New", new String[]{"New"});
        publishCommand("Arm 1", new String[]{"Arm", "1"});
        assertThat(Game.isStarted()).isFalse();
    }

    @Test
    public void Should_Not_Start_Game_On_Start_FollowedBy_Arm() {
        publishCommand("Debug", new String[]{"Debug"});
        publishCommand("New", new String[]{"New"});
        publishCommand("Arm 1", new String[]{"Arm", "1"});
        publishCommand("Start", new String[]{"Start"});
        assertThat(Game.isStarted()).isTrue();
    }

    @Test
    public void Should_Run_Go_After_Only_Game_Started() {
        publishCommand("New", new String[]{"New"});
        publishCommand("Arm 1", new String[]{"Arm", "1"});
        publishCommand("Start", new String[]{"Start"});
        publishCommand("Go", new String[]{"Go"});
        publishCommand("Go north", new String[]{"Go", "North"});
        assertThat(Game.isStarted()).isTrue();
    }


    @Test
    public void Should_Run_Attack_After_Game_Started() {
        publishCommand("New", new String[]{"New"});
        publishCommand("Arm 1", new String[]{"Arm", "1"});
        publishCommand("Start", new String[]{"Start"});
        publishCommand("Attack", new String[]{"Attack"});
    }

    @Test
    public void Should_Kill_Enemy() {
        publishCommand("New", new String[]{"New"});
        publishCommand("Arm 5", new String[]{"Arm", "5"});
        publishCommand("Start", new String[]{"Start"});
        publishCommand("Attack", new String[]{"Attack"});
        publishCommand("Attack", new String[]{"Attack"});

        assertThat(Game.getGameArena().getPlayer().getExperience()).isGreaterThan(100);
    }


    @Test
    public void Should_Quit_Game() {
        publishCommand("New", new String[]{"New"});
        publishCommand("Quit", new String[]{"Quit"});
        assertThat(Game.isStarted()).isFalse();
    }

    @Test
    public void Should_Save_Game() {
        publishCommand("New", new String[]{"New"});
        publishCommand("Arm 1", new String[]{"Arm", "1"});
        publishCommand("Start", new String[]{"Start"});
        publishCommand("Save", new String[]{"Save"});
    }

    @Test
    public void Should_Load_Game() {
        publishCommand("load", new String[]{"load"});
    }
}

