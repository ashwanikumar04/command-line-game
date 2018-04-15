package in.ashwanik.clgame;

import in.ashwanik.clgame.commands.Command;
import in.ashwanik.clgame.commands.list.Help;
import in.ashwanik.clgame.ui.screens.GameDisplay;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.experimental.categories.Category;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * Created by Ashwani Kumar on 12/04/18.
 */
@Category(UnitTest.class)
public class TestCommands {

    private static List<String> messages;
    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();
    private static GameDisplay gameDisplay;

    private static void init() {
        messages = new ArrayList<>();
        gameDisplay = new TestData.TestDisplay(messages);
    }

    @BeforeClass
    public static void setup() throws IOException {
        init();
    }

    @Before
    public void setupTest() throws IOException {
        messages.clear();
        Game.reset();
    }

    @Test
    public void Should_Two_Commands_Are_Same() {
        Command command1 = new Help("help", "help");
        Command command2 = new Help("help", "help");
        assertThat(command1.equals(command2)).isTrue();
    }

    @Test
    public void Should_Run_Help() {
        systemInMock.provideLines("help", "debug", "Quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(Game.isDebug()).isTrue();
        assertThat(messages.size()).isGreaterThan(0);
    }

    @Test
    public void Should_Run_Arm_No_Weapon_Game_Not_Started() {
        systemInMock.provideLines("new", "arm ", "Quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(Game.isStarted()).isFalse();
    }

    @Test
    public void Should_Run_Arm_Game_Not_Started() {
        systemInMock.provideLines("arm 1", "Quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(Game.isStarted()).isFalse();
    }

    @Test
    public void Should_Run_Arm_Game_Started() {
        systemInMock.provideLines("new", "arm 1", "start", "Quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(Game.isStarted()).isTrue();
    }

    @Test
    public void Should_Run_Go_After_Only_Game_Started() {
        systemInMock.provideLines("arm 1", "go", "Quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(messages.size()).isGreaterThan(0);
    }

    @Test
    public void Should_Run_Go_After_Game_Started() {
        systemInMock.provideLines("arm 1", "start", "go north", "quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(messages.size()).isGreaterThan(0);
    }

    @Test
    public void Should_Run_Attack_After_Game_Started() {
        systemInMock.provideLines("arm 1", "start", "attack", "quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(Game.getGameArena().getPlayer().getHealth()).isLessThan(100);
        assertThat(messages.size()).isGreaterThan(0);
    }

    @Test
    public void Should_Run_Attack_ToFinish() {
        systemInMock.provideLines("arm 1", "start", "attack", "attack", "quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(messages.size()).isGreaterThan(0);
    }

    @Test
    public void Should_Run_Attack_ToKillEnemy() {
        systemInMock.provideLines("arm 5", "start", "attack", "attack", "attack", "quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(messages.size()).isGreaterThan(0);
    }

    @Test
    public void Should_Save_Game() {
        systemInMock.provideLines("arm 5", "start", "save", "quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(messages.size()).isGreaterThan(0);
    }

    @Test
    public void Should_Load_Game() {
        systemInMock.provideLines("load", "quit");
        Application.startGame(System.in, gameDisplay);
        assertThat(messages.size()).isGreaterThan(0);
    }
}

