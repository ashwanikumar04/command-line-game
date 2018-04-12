package in.ashwanik.clgame.commands;

import lombok.Getter;

import java.util.Locale;

import static in.ashwanik.clgame.utils.StringUtils.isNotLowercase;

/**
 * Created by jh80 on 13/04/18.
 */
@Getter
public class CommandDescription {
    private final String name;
    private final String info;

    CommandDescription(String name, String info) {
        if (isNotLowercase(name)) {
            name = name.toLowerCase(Locale.ENGLISH);
        }
        this.name = name;
        this.info = info;
    }

    @Override
    public String toString() {
        return getName() + " - " + getInfo();
    }
}
