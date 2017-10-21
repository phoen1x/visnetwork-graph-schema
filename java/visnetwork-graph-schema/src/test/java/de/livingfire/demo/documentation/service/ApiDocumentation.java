package de.livingfire.demo.documentation.service;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.RequestDispatcher;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;

import de.livingfire.demo.documentation.constant.DocumentationConstant;

public class ApiDocumentation implements DocumentationConstant {

    public static void apiError(MockMvc mockMvc,
                                ResultHandler printDebug) {
        try {
            mockMvc.perform(
                    get(REQUEST_ERROR).requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 400)
                                      .requestAttr(RequestDispatcher.ERROR_REQUEST_URI, "/repository/fooBar")
                                      .requestAttr(RequestDispatcher.ERROR_MESSAGE, "Bad Request"))
                   .andDo(printDebug)
                   .andExpect(status().isBadRequest())
                   .andExpect(jsonPath("error", is("Bad Request")))
                   .andExpect(jsonPath("timestamp", is(notNullValue())))
                   .andExpect(jsonPath("status", is(400)))
                   .andExpect(jsonPath("path", is(notNullValue())))
                   .andDo(
                           document(
                                   DOCUMENTATION_SNIPPLET_CHAPTER_API_ERROR,
                                       responseFields(
                                               fieldWithPath("error").description(
                                                       "The " + DOCUMENTATION_URL_HTTP_STATUS_CODES + " that occurred"),
                                                   fieldWithPath("message").description(
                                                           "A massage like `*Bad Request*`"),
                                                   fieldWithPath("path").description(
                                                           "The path to which the request was made"),
                                                   fieldWithPath("status").description(
                                                           "The HTTP status code like `*400*`"),
                                                   fieldWithPath("timestamp").description(
                                                           "The time in milliseconds at which the error occurred"))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void apiIndex(MockMvc mockMvc,
                                ResultHandler printDebug) {
        try {
            mockMvc.perform(get(REQUEST_BASE_API))
                   .andDo(printDebug)
                   .andExpect(status().isOk())
                   .andDo(
                           document(
                                   DOCUMENTATION_SNIPPLET_CHAPTER_API_INDEX,
                                       links(
                                               linkWithRel(DOCUMENTATION_LINK_EMPLOYEE + "s").description(
                                                       "See " + DOCUMENTATION_ASCI_DOC_EMPLOYEES),
                                                   linkWithRel(DOCUMENTATION_LINK_PERSON + "s").description(
                                                           "See " + DOCUMENTATION_ASCI_DOC_PERSONS),
                                                   linkWithRel(DOCUMENTATION_LINK_STATION + "s").description(
                                                           "See " + DOCUMENTATION_ASCI_DOC_STATIONS),
                                                   linkWithRel(DOCUMENTATION_LINK_TICKET + "s").description(
                                                           "See " + DOCUMENTATION_ASCI_DOC_TICKETS),
                                                   linkWithRel(DOCUMENTATION_LINK_TRAIN + "s").description(
                                                           "See " + DOCUMENTATION_ASCI_DOC_TRAINS),
                                                   DOCUMENTATION_LINK_DESCRIPTOR_PROFILE),
                                       responseFields(
                                               subsectionWithPath("_links").description(
                                                       DOCUMENTATION_ASCI_DOC_INDEX_LINKS + " to other resources"))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void search(MockMvc mockMvc,
                              ResultHandler printDebug,
                              String locationEntity,
                              String snippletChapterPrefix) {
        try {
            mockMvc.perform(get(locationEntity))
                   .andDo(printDebug)
                   .andExpect(status().isOk())
                   .andDo(document(snippletChapterPrefix + "-search-details"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void profile(MockMvc mockMvc,
                               ResultHandler printDebug,
                               String locationEntity,
                               String snippletChapterPrefix) {
        try {
            mockMvc.perform(get(locationEntity))
                   .andDo(printDebug)
                   .andExpect(status().isOk())
                   .andDo(document(snippletChapterPrefix + "-profile"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
