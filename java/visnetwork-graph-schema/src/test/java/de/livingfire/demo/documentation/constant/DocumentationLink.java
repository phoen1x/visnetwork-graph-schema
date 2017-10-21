package de.livingfire.demo.documentation.constant;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;

import org.springframework.restdocs.hypermedia.LinkDescriptor;
import org.springframework.restdocs.hypermedia.LinksSnippet;

public interface DocumentationLink extends DocumentationUrl, DocumentationAsciiDoc {

    public static final String DOCUMENTATION_LINK_EMPLOYEE = "employee";
    public static final String DOCUMENTATION_LINK_PERSON = "person";
    public static final String DOCUMENTATION_LINK_STATION = "station";
    public static final String DOCUMENTATION_LINK_TICKET = "ticket";
    public static final String DOCUMENTATION_LINK_TRAIN = "train";

    // --------------------------------------------------

    public static final String DOCUMENTATION_LINK_EXPORT = "export";
    public static final String DOCUMENTATION_LINK_IMPORT = "import";
    public static final String DOCUMENTATION_LINK_JAVASCRIPT = "javascript";
    public static final String DOCUMENTATION_LINK_LISTDATA = "listdata";
    public static final String DOCUMENTATION_LINK_PROFILE = "profile";
    public static final String DOCUMENTATION_LINK_SEARCH = "search";
    public static final String DOCUMENTATION_LINK_SELENIUM = "selenium";
    public static final String DOCUMENTATION_LINK_SELF = "self";
    public static final String DOCUMENTATION_LINK_SETTING = "setting";
    public static final String DOCUMENTATION_LINK_USER = "user";

    public static final String DOCUMENTATION_LINK_SUBSECTION_EMBEDDED = "_embedded";
    public static final String DOCUMENTATION_LINK_SUBSECTION_LINKS = "_links";

    public static final String DOCUMENTATION_LINK_EMBEDDED_LISTDATA = DOCUMENTATION_LINK_SUBSECTION_EMBEDDED + "."
            + DOCUMENTATION_LINK_LISTDATA;
    public static final String DOCUMENTATION_LINK_EMBEDDED_SETTING = DOCUMENTATION_LINK_SUBSECTION_EMBEDDED + "."
            + DOCUMENTATION_LINK_SETTING;
    public static final String DOCUMENTATION_LINK_EMBEDDED_USER = DOCUMENTATION_LINK_SUBSECTION_EMBEDDED + "."
            + DOCUMENTATION_LINK_USER;

    public static final LinkDescriptor DOCUMENTATION_LINK_DESCRIPTOR_SELF = linkWithRel(
            DOCUMENTATION_LINK_SELF).description("Canonical link for this resource");

    public static final LinkDescriptor DOCUMENTATION_LINK_DESCRIPTOR_SEARCH = linkWithRel(
            DOCUMENTATION_LINK_SEARCH).description("Canonical link to " + DOCUMENTATION_URL_SPRING_HATEOAS_SEARCH);

    public static final LinkDescriptor DOCUMENTATION_LINK_DESCRIPTOR_PROFILE = linkWithRel(
            DOCUMENTATION_LINK_PROFILE).description("The " + DOCUMENTATION_URL_SPRING_HATEOAS_ALPS);

    public static final LinkDescriptor DOCUMENTATION_LINK_DESCRIPTOR_JAVASCRIPT = linkWithRel(
            DOCUMENTATION_LINK_JAVASCRIPT).description("Helper methods <<api-skylar-core-api-javascript,Javascript>>");

    public static final LinkDescriptor DOCUMENTATION_LINK_DESCRIPTOR_SELENIUM = linkWithRel(
            DOCUMENTATION_LINK_SELENIUM).description("See <<api-skylar-core-api-selenium,Selenium>>");

    public static final LinkDescriptor DOCUMENTATION_LINK_DESCRIPTOR_IMPORT = linkWithRel(
            DOCUMENTATION_LINK_IMPORT).description("Helper methods <<api-skylar-core-api-import,Import>>");

    public static final LinkDescriptor DOCUMENTATION_LINK_DESCRIPTOR_EXPORT = linkWithRel(
            DOCUMENTATION_LINK_EXPORT).description("Helper methods <<api-skylar-core-api-export,Export>>");

    public static final LinkDescriptor DOCUMENTATION_LINK_DESCRIPTOR_SETTING = linkWithRel(
            DOCUMENTATION_LINK_SETTING).description("See " + DOCUMENTATION_ASCI_DOC_SETTING);

    public static final LinkDescriptor DOCUMENTATION_LINK_DESCRIPTOR_SETTINGS = linkWithRel(
            DOCUMENTATION_LINK_SETTING + "s").description("See " + DOCUMENTATION_ASCI_DOC_SETTINGS);

    public static final LinksSnippet DOCUMENTATION_LINKS_SELF = links(DOCUMENTATION_LINK_DESCRIPTOR_SELF);

    public static final LinksSnippet DOCUMENTATION_LINKS_ENTITY_LIST = links(
            DOCUMENTATION_LINK_DESCRIPTOR_SELF,
                DOCUMENTATION_LINK_DESCRIPTOR_PROFILE,
                DOCUMENTATION_LINK_DESCRIPTOR_SEARCH);

    public static final LinkDescriptor DOCUMENTATION_LINK_DESCRIPTOR_USER = linkWithRel(
            DOCUMENTATION_LINK_USER).description("See " + DOCUMENTATION_ASCI_DOC_USER);

    public static final LinksSnippet DOCUMENTATION_LINKS_USER = links(
            DOCUMENTATION_LINK_DESCRIPTOR_SELF,
                linkWithRel(DOCUMENTATION_LINK_USER).description("This " + DOCUMENTATION_ASCI_DOC_USER),
                DOCUMENTATION_LINK_DESCRIPTOR_SETTINGS);

    public static final LinksSnippet DOCUMENTATION_LINKS_SETTING = links(
            DOCUMENTATION_LINK_DESCRIPTOR_SELF,
                linkWithRel(DOCUMENTATION_LINK_SETTING).description("This " + DOCUMENTATION_ASCI_DOC_SETTING));

    public static final LinksSnippet DOCUMENTATION_LINKS_LISTDATA = links(
            DOCUMENTATION_LINK_DESCRIPTOR_SELF,
                linkWithRel(DOCUMENTATION_LINK_LISTDATA).description("This " + DOCUMENTATION_ASCI_DOC_LISTDATA));

}
