package org.ejemplo;

import org.ejemplo.model.Student;
import org.ejemplo.produce.Produce;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/estudiante")
public class Resource {

    @Inject
    Produce produce;

    @POST
    @Path("/crear")
    @Produces(MediaType.APPLICATION_JSON)
    public String send(Student student) {
        return produce.sendMessage(student);
    }
}