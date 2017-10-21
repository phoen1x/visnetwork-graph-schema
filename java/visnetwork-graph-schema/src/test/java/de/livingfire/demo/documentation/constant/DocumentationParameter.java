package de.livingfire.demo.documentation.constant;

import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;

import org.springframework.restdocs.request.ParameterDescriptor;

public interface DocumentationParameter extends RequestConstant, DocumentationType {

    public static final ParameterDescriptor DOCUMENTATION_PARAMETER_DESCRIPTOR_OPEN = parameterWithName(
            REQUEST_PARAM_OPEN).description(DOCUMENTATION_TYPE_URL);

    public static final ParameterDescriptor DOCUMENTATION_PARAMETER_DESCRIPTOR_UUID = parameterWithName(
            REQUEST_PARAM_UUID).description(DOCUMENTATION_TYPE_UUID);

    public static final ParameterDescriptor DOCUMENTATION_PARAMETER_DESCRIPTOR_DESCRIPTION = parameterWithName(
            REQUEST_PARAM_DESCRIPTION).description(DOCUMENTATION_TYPE_DESCRIPTION);
}
