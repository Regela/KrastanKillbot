package ru.application.rege.krastersomeapp;

import android.support.annotation.Nullable;

/**
 * Created by rege on 11.04.17.
 */

public interface MainSet {

    // buttons which can have events
    enum ButtonType { LEFT, UP, RIGHT, DOWN, SHOCK, FIRE, STOP }

    enum ButtonEvent {OFF, ON}

    /**
     *  @param button Name of button which has event.
     *  @param event Event type.
     *  @return Error message to show as toast or null if all is okay.
     */
    @Nullable
    String onButtonEvent(ButtonType button, ButtonEvent event);

    /**
     * @param conf A configuration which user wanna set.
     * @return Error message to show as toast or null if all is okay.
     */
    @Nullable
    String onConfigurationApplied(Configuration conf);

    void onStart();
    void onStop();
}
