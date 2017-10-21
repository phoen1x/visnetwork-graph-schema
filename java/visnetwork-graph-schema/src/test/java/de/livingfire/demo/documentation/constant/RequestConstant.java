package de.livingfire.demo.documentation.constant;

public interface RequestConstant {

    public static final String REQUEST_DOMAIN = "skylar.livingfire.de";

    public static final String REQUEST_PARAM_CODE = "code";
    public static final String REQUEST_PARAM_DESCRIPTION = "description";
    public static final String REQUEST_PARAM_DEVELOPER_MESSAGE = "developerMessage";
    public static final String REQUEST_PARAM_DIMENSION = "dimension";
    public static final String REQUEST_PARAM_ENTRY_DATE = "entryDate";
    public static final String REQUEST_PARAM_GROUP = "group";
    public static final String REQUEST_PARAM_LOGSTASH = "logstash";
    public static final String REQUEST_PARAM_OPEN = "open";
    public static final String REQUEST_PARAM_PAGE = "page";
    public static final String REQUEST_PARAM_STATUS = "status";
    public static final String REQUEST_PARAM_UNIT = "unit";
    public static final String REQUEST_PARAM_USER_MESSAGE = "userMessage";
    public static final String REQUEST_PARAM_UUID = "uuid";
    public static final String REQUEST_PARAM_VALUE = "value";

    public static final String REQUEST_PATH_FIND_BY_DESCRIPTION = "/findByDescription";
    public static final String REQUEST_PATH_FIND_BY_UUID = "/findByUuid";
    public static final String REQUEST_PATH_SEARCH = "/search";

    public static final String REQUEST_WEB = "/";

    public static final String REQUEST_MANAGEMENT = "/management";
    public static final String REQUEST_MANAGEMENT_ENV = REQUEST_MANAGEMENT + "/env";
    public static final String REQUEST_MANAGEMENT_HEALTH = REQUEST_MANAGEMENT + "/health";

    public static final String REQUEST_ERROR = "/error";

    public static final String REQUEST_BASE_API = "/api";

    public static final String REQUEST_REPOSITORY_PROFILE = REQUEST_BASE_API + "/profile";
    public static final String REQUEST_REPOSITORY_PROFILE_LISTDATAS = REQUEST_REPOSITORY_PROFILE + "/listdatas";
    public static final String REQUEST_REPOSITORY_PROFILE_SETTINGS = REQUEST_REPOSITORY_PROFILE + "/settings";
    public static final String REQUEST_REPOSITORY_PROFILE_USERS = REQUEST_REPOSITORY_PROFILE + "/users";

    public static final String REQUEST_REPOSITORY_USER = REQUEST_BASE_API + "/users";
    public static final String REQUEST_REPOSITORY_USER_SEARCH = REQUEST_REPOSITORY_USER + REQUEST_PATH_SEARCH;
    public static final String REQUEST_REPOSITORY_USER_SEARCH_BY_UUID = REQUEST_REPOSITORY_USER_SEARCH
            + REQUEST_PATH_FIND_BY_UUID;
    public static final String REQUEST_REPOSITORY_USER_SEARCH_BY_DESCRIPTION = REQUEST_REPOSITORY_USER_SEARCH
            + REQUEST_PATH_FIND_BY_DESCRIPTION;

    public static final String REQUEST_REPOSITORY_SETTING = REQUEST_BASE_API + "/settings";
    public static final String REQUEST_REPOSITORY_SETTING_SEARCH = REQUEST_REPOSITORY_SETTING + REQUEST_PATH_SEARCH;
    public static final String REQUEST_REPOSITORY_SETTING_SEARCH_BY_UUID = REQUEST_REPOSITORY_SETTING_SEARCH
            + REQUEST_PATH_FIND_BY_UUID;
    public static final String REQUEST_REPOSITORY_SETTING_SEARCH_BY_DESCRIPTION = REQUEST_REPOSITORY_SETTING_SEARCH
            + REQUEST_PATH_FIND_BY_DESCRIPTION;

    public static final String REQUEST_REPOSITORY_LISTDATA = REQUEST_BASE_API + "/listdatas";
    public static final String REQUEST_REPOSITORY_LISTDATA_SEARCH = REQUEST_REPOSITORY_LISTDATA + REQUEST_PATH_SEARCH;
    public static final String REQUEST_REPOSITORY_LISTDATA_SEARCH_BY_UUID = REQUEST_REPOSITORY_LISTDATA_SEARCH
            + REQUEST_PATH_FIND_BY_UUID;
    public static final String REQUEST_REPOSITORY_LISTDATA_SEARCH_BY_DESCRIPTION = REQUEST_REPOSITORY_LISTDATA_SEARCH
            + REQUEST_PATH_FIND_BY_DESCRIPTION;

    public static final String REQUEST_JAVASCRIPT = REQUEST_BASE_API + "/javascript";
    public static final String REQUEST_JAVASCRIPT_ENTITY_PROPERTIES = REQUEST_JAVASCRIPT + "/entityProperties";
    public static final String REQUEST_JAVASCRIPT_LISTDATA_GROUP_DIMENSIONS = REQUEST_JAVASCRIPT
            + "/listdataGroupDimensions";
    public static final String REQUEST_JAVASCRIPT_TTS_GOOGLE_CALENDAR = REQUEST_JAVASCRIPT + "/ttsGoogleCalendar";
    public static final String REQUEST_JAVASCRIPT_TTS_GREETING = REQUEST_JAVASCRIPT + "/ttsGreeting";
    public static final String REQUEST_JAVASCRIPT_TTS_KANBOARD_OVERDUE = REQUEST_JAVASCRIPT + "/ttsKanboardOverdue";
    public static final String REQUEST_JAVASCRIPT_TTS_KANBOARD_SHOPPING = REQUEST_JAVASCRIPT + "/ttsKanbaordShopping";
    public static final String REQUEST_JAVASCRIPT_TTS_WEATHER = REQUEST_JAVASCRIPT + "/ttsWeather";
    public static final String REQUEST_JAVASCRIPT_EMAIL_KANBOARD_SHOPPING = REQUEST_JAVASCRIPT
            + "/emailKanbaordShopping";

    public static final String REQUEST_EXPORT = REQUEST_BASE_API + "/export";
    public static final String REQUEST_EXPORT_DATABASE = REQUEST_EXPORT + "/database";

    public static final String REQUEST_IMPORT = REQUEST_BASE_API + "/import";
    public static final String REQUEST_IMPORT_GARMIN = REQUEST_IMPORT + "/garmin";
    public static final String REQUEST_IMPORT_GARMIN_ACTIVITY = REQUEST_IMPORT_GARMIN + "/activity";
    public static final String REQUEST_IMPORT_LIBRA = REQUEST_IMPORT + "/libra";
    public static final String REQUEST_IMPORT_MICROLIFE = REQUEST_IMPORT + "/microlife";
    public static final String REQUEST_IMPORT_ORUXMAPS = REQUEST_IMPORT + "/oruxmaps";

    public static final String REQUEST_SAY = REQUEST_BASE_API + "/say";

    public static final String REQUEST_SELENIUM = REQUEST_BASE_API + "/selenium";
    public static final String REQUEST_SELENIUM_SESSION = REQUEST_SELENIUM + "/session";
    public static final String REQUEST_SELENIUM_SESSION_CLOSE = REQUEST_SELENIUM_SESSION + "/close";
    public static final String REQUEST_SELENIUM_SESSION_HTML = REQUEST_SELENIUM_SESSION + "/html";
    public static final String REQUEST_SELENIUM_WEBPAGE = REQUEST_SELENIUM + "/webpage";
    public static final String REQUEST_SELENIUM_WEB_RADIO = REQUEST_SELENIUM + "/webRadio";

}
