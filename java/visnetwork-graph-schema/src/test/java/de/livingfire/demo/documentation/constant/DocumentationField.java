package de.livingfire.demo.documentation.constant;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;

import org.springframework.restdocs.payload.FieldDescriptor;

public interface DocumentationField extends RequestConstant, DocumentationType, DocumentationUrl {
    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_UUID = fieldWithPath(
            REQUEST_PARAM_UUID).description(DOCUMENTATION_TYPE_UUID);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_SKYLARCODE_CODE = fieldWithPath(
            REQUEST_PARAM_CODE).description(DOCUMENTATION_TYPE_SKYLAR_CODE);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_SKYLARCODE_USER_MESSAGE = fieldWithPath(
            REQUEST_PARAM_USER_MESSAGE).description(DOCUMENTATION_TYPE_SKYLAR_USER_MESSAGE);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_SKYLARCODE_DEVELOPER_MESSAGE = fieldWithPath(
            REQUEST_PARAM_DEVELOPER_MESSAGE).description(DOCUMENTATION_TYPE_SKYLAR_DEVELOPER_MESSAGE);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_SKYLARCODE_STATUS = fieldWithPath(
            REQUEST_PARAM_STATUS).description(DOCUMENTATION_TYPE_HTTP_STATUS);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_LOGSTASH = fieldWithPath(
            REQUEST_PARAM_LOGSTASH).description(DOCUMENTATION_TYPE_LOGSTASH);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_DESCRIPTION = fieldWithPath(
            REQUEST_PARAM_DESCRIPTION).description(DOCUMENTATION_TYPE_DESCRIPTION);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_DIMENSION = fieldWithPath(
            REQUEST_PARAM_DIMENSION).description(DOCUMENTATION_TYPE_DIMENSION);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_PAGE = subsectionWithPath(
            REQUEST_PARAM_PAGE).description(DOCUMENTATION_URL_SPRING_HATEOAS_PAGINATION);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_GROUP = subsectionWithPath(
            REQUEST_PARAM_GROUP).description(DOCUMENTATION_TYPE_GROUP);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_ENRTY_DATE = subsectionWithPath(
            REQUEST_PARAM_ENTRY_DATE).description(DOCUMENTATION_TYPE_ENRTY_DATE);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_UNIT = subsectionWithPath(
            REQUEST_PARAM_UNIT).description(DOCUMENTATION_TYPE_UNIT);

    public static final FieldDescriptor DOCUMENTATION_FIELD_DESCRIPTOR_VALUE = subsectionWithPath(
            REQUEST_PARAM_VALUE).description(DOCUMENTATION_TYPE_VALUE);
}
