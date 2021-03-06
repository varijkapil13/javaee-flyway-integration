package dev.varij.flyway.exception.constraints;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {
  
  private static final Logger logger = Logger.getLogger(ConstraintViolationMapper.class.getName());
  
  @Context
  protected Request request;
  
  @Override
  public Response toResponse(ConstraintViolationException ex) {
    StringBuilder error = new StringBuilder();
    for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
      if (constraintViolation.getConstraintDescriptor().getPayload().stream().anyMatch(payload -> payload.isAssignableFrom(
          ValidationExceptionLogger.class))) {
        final String loggerMessage = constraintViolation.getMessage();
        error.append(loggerMessage).append("\n");
        logger.log(Level.SEVERE, loggerMessage, ex);
      } else {
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
      }
    }
    return Response.status(Status.BAD_REQUEST).entity(error).build();
  }
  
}
