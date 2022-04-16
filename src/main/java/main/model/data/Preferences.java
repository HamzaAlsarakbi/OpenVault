package main.model.data;

import java.io.Serializable;

public class Preferences implements Serializable {
    private boolean toolTips, animations, showFirstCharactersOfPassword;
    private int inactivityDuration, timeoutGracePeriodDuration;

    /**
     * Constructs Preferences object with the default parameters.
     */
    public Preferences() {
        toolTips = true;
        animations = true;
        showFirstCharactersOfPassword = true;
        inactivityDuration = 180;
        timeoutGracePeriodDuration = 60;
    }

    /**
     * Constructs a Preferences Object with the specified parameters.
     * @param toolTips true to enable toolTips
     * @param animations true to enable animations
     * @param inactivityDuration inactivity duration before asking user to logout (in seconds)
     * @param timeoutGracePeriodDuration duration of the prompt staying on the screen before logging the user out
     */
    public Preferences(boolean toolTips, boolean animations, int inactivityDuration, int timeoutGracePeriodDuration) {
        toolTips = this.toolTips;
        animations = this.animations;
        inactivityDuration = this.inactivityDuration;
        timeoutGracePeriodDuration = this.timeoutGracePeriodDuration;
    }


}
