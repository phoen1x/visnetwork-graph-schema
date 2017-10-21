package de.livingfire.demo.documentation.constant;

import java.util.Date;
import java.util.StringJoiner;

public interface DocumentationType {

    public static final String DOCUMENTATION_TYPE_LOGSTASH = new StringJoiner("").add(new Date().toString())
                                                                                 .add(
                                                                                         " https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html[SimpleDateFormat]")
                                                                                 .toString();

    public static final String DOCUMENTATION_TYPE_DESCRIPTION = "Description or name";
    public static final String DOCUMENTATION_TYPE_DIMENSION = "Name of a dimension in a https://en.wikipedia.org/wiki/Matrix_(mathematics)[matrix]. E.g. distance, time, x, y, z, ...";
    public static final String DOCUMENTATION_TYPE_ENRTY_DATE = "creation date";
    public static final String DOCUMENTATION_TYPE_GROUP = "The group this value belongs to. This can be thougt of a as a another dimension in a https://en.wikipedia.org/wiki/Matrix_(mathematics)[matrix]";
    public static final String DOCUMENTATION_TYPE_HTTP_STATUS = "a HTTP status code like 201";
    public static final String DOCUMENTATION_TYPE_SKYLAR_CODE = "native Skylar code like 005001 see https://github.com/phoen1x/skylar-the-scholar/blob/master/project/skylar-library/src/main/java/de/livingfire/skylar/constant/SkylarCodeConstant.java[SkylarCodeConstant.java]";
    public static final String DOCUMENTATION_TYPE_SKYLAR_DEVELOPER_MESSAGE = "Additional information for debugging";
    public static final String DOCUMENTATION_TYPE_SKYLAR_USER_MESSAGE = "Message shown in the user interface";
    public static final String DOCUMENTATION_TYPE_UNIT = "A unit of measurement like km, s, ccm";
    public static final String DOCUMENTATION_TYPE_URL = "a URL like https://www.youtube.com/";
    public static final String DOCUMENTATION_TYPE_UUID = "https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html[Java UUID]";
    public static final String DOCUMENTATION_TYPE_VALUE = "Value like 42, 3.1415, 'Hello World!'";
}
