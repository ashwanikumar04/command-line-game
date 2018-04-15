package in.ashwanik.clgame.commands;

import java.util.Locale;

import static in.ashwanik.clgame.utils.StringUtils.isNotLowercase;

/**
 * Created by Ashwani Kumar on 13/04/18.
 */
public class CommandDetail {
    private final String name;
    private final String info;

    CommandDetail(String name, String info) {
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

    public String getName() {
        return this.name;
    }

    public String getInfo() {
        return this.info;
    }
}
