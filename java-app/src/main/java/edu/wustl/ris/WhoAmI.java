package edu.wustl.ris;

import java.security.Principal;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "whoami" path)
 */
@Path("whoami")
public class WhoAmI {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt(@javax.ws.rs.core.Context javax.ws.rs.core.SecurityContext context) {
        Principal user = context.getUserPrincipal();
        Boolean isRoled = context.isUserInRole("info");
        return String.format("You are identified as user %s and info role is %s", user, isRoled);
    }
}
