package wayvlyte.space.octane.Enums;

/**
 * A general list of categories for this plugin, jar plugins can also use this api to categorize their commands
 */
public enum ECommandCategory {
    /**
     * Could be anything but related to the categories below
     */
    General,

    /**
     * Kick, Ban, and Warns
     */
    Moderation,

    /**
     * Joining Voice Channels, playing audio
     */
    Audio,

    /**
     * Utilities such as color math, vector data, avatar utils
     */
    Utility,

    /**
     * Image manipulation
     */
    Imaging,

    /**
     * Handles roles
     */
    Roles
}
