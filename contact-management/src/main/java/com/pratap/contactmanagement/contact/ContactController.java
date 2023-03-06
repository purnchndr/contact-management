package com.pratap.contactmanagement.contact;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactDaoServices contactServices;


    @Operation(summary = "Home Page", description = "home page handling", tags = "extras")
    @GetMapping("/")
    public String home(){
        return "<h1>Welcome to Contact Management System</h1>" +
                " <p>Please go to <a href=\"/contacts\"> /contacts </a> to view all the contacts</p> " +
                "<p>Or go to <a href=\"/swagger-ui/index.html\"> /API Documentation</a> to view all APIs</p>";
    }

    @Operation(summary = "Get all contacts", description = "Get all the contacts", tags = "get")
    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "Search executed successfully",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Resource Not found",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    })}
    )
    @GetMapping("/contacts")
    public List<Contact> getContacts(){
        return contactServices.getContacts();
    }


    @Operation(summary = "Search Contacts by name, email or phone", description = "Search Contacts by name, email or phone number", tags = "Searching")
    @Parameter(in = ParameterIn.PATH, name = "query", description = "search term : name, email or phone")
    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "Search executed successfully",
                    content = {@Content (mediaType = "application/json",
                    schema = @Schema(implementation = ContactDaoServices.class))
            }),
            @ApiResponse(responseCode = "404", description = "Resource Not found",
            content = {@Content (mediaType = "application/json",
                    schema = @Schema(implementation = ContactDaoServices.class))
            })}
    )
    @GetMapping("/contacts/search/{query}")
    public List<Contact> getContactsWildcard(@PathVariable("query") String query){
        return contactServices.getContactByAnyWildcard(query);
    }

    @Operation(summary = "Search Contacts with email", description = "Search Contacts by email", tags = "Searching")
    @Parameter(in = ParameterIn.PATH, name = "email", description = "email of customer")
    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "Search executed successfully",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Resource Not found",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    })}
    )
    @GetMapping("/contacts/email/{email}")
    public List<Contact> getContactsByEmail(@PathVariable("email") String email){
        return contactServices.getContactByEmail(email);
    }

    @Operation(summary = "Search Contacts with phone number", description = "Search Contacts by phone number", tags = "Searching")
    @Parameter(in = ParameterIn.PATH, name = "phone", description = "phone of customer")
    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "Search executed successfully",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Resource Not found",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    })}
    )
    @GetMapping("/contacts/phone/{phone}")
    public List<Contact> getContactsByPhone(@PathVariable("phone") String phone){
        return contactServices.getContactByPhone(phone);
    }

    @Operation(summary = "Search Contacts with first name", description = "Search Contacts by first name", tags = "Searching")
    @Parameter(in = ParameterIn.PATH, name = "name", description = "first name of customer")
    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "Search executed successfully",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Resource Not found",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    })}
    )
    @GetMapping("/contacts/firstname/{name}")
    public List<Contact> getContactsByFirstName(@PathVariable("name") String name){
        return contactServices.getContactByFirstName(name);
    }


    @Operation(summary = "Search Contacts with last name", description = "Search Contacts by last name", tags = "Searching")
    @Parameter(in = ParameterIn.PATH, name = "name", description = "last name of customer")

    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "Search executed successfully",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Resource Not found",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    })}
    )
    @GetMapping("/contacts/lastname/{name}")
    public List<Contact> getContactsByLastName(@PathVariable("name") String name){
        return contactServices.getContactByLastName(name);
    }

    @Operation(summary = "add contacts", description = "add new contact to list", tags = "inserting")
    @Parameter(in = ParameterIn.PATH, name = "contact", description = "new contact object with all the attributes")

    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "Resource added successfully",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    }),
            @ApiResponse(responseCode = "501", description = "Server Error",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    })}
    )
    @PostMapping("/contacts")
    public Contact getContactsByLastName(@RequestBody Contact contact){
        return contactServices.addContact(contact);
    }

    @Operation(summary = "Delete Contacts with phone", description = "Delete Contacts by phone number", tags = "deleting")
    @Parameter(in = ParameterIn.PATH, name = "phone", description = "phone number of customer")

    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "resource deleted successfully",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Resource Not found",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    })}
    )
    @DeleteMapping("/contacts/phone/{phone}")
    public Contact deleteByPhone(@PathVariable("phone") String phone){
        return contactServices.deleteByPhone(phone);
    }


    @Operation(summary = "Delete Contacts with email", description = "Delete Contacts by email", tags = "deleting")
    @Parameter(in = ParameterIn.PATH, name = "email", description = "email of customer")

    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "resource deleted successfully",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Resource Not found",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    })}
    )
    @DeleteMapping("/contacts/email/{email}")
    public Contact deleteByEmail(@PathVariable("email") String email){
        return contactServices.deleteByEmail(email);
    }


    @Operation(summary = "Update Contacts with email", description = "Update Contacts by email", tags = "updating")
    @Parameter(in = ParameterIn.PATH, name = "email", description = "email of customer")

    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "resource updated successfully",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Resource Not found",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    })}
    )
    @PatchMapping("/contacts/email")
    public Contact updateByEmail(@RequestBody Contact contact){
        return contactServices.updateContactByEmail(contact);
    }

    @Operation(summary = "Update Contacts with phone number", description = "update Contacts by phone number", tags = "updating")
    @Parameter(in = ParameterIn.PATH, name = "phone", description = "phone number of customer")

    @ApiResponses( value ={
            @ApiResponse(responseCode = "200", description = "resource updated successfully",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Resource Not found",
                    content = {@Content (mediaType = "application/json",
                            schema = @Schema(implementation = ContactDaoServices.class))
                    })}
    )
    @PatchMapping("/contacts/phone")
    public Contact updateByPhone(@RequestBody Contact contact){
        return contactServices.updateContactByPhone(contact);
    }

    @Operation(summary = "Error Page", description = "Error page handling", tags = "extras")
    @GetMapping("/{anything}")
    public String error(@PathVariable("anything") String anything){
        return "<h1>End point <b>"+anything+" </b> Not Defined, " +
                "Error 404, Please check the end points and try again.</h1> " +
                "<p>Please go to <a href=\"/contacts\"> /contacts </a> to view all the contacts</p>"+
                "<p>Or go to <a href=\"/swagger-ui/index.html\"> /API Documentation</a> to view all APIs</p>";
    }
}
