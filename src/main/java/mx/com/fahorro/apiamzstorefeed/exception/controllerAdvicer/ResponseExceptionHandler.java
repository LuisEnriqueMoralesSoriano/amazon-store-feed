package mx.com.fahorro.apiamzstorefeed.exception.controllerAdvicer;

import mx.com.fahorro.apiamzstorefeed.exception.EntityExceptionHandler;
import mx.com.fahorro.apiamzstorefeed.model.dto.ResponseDto;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityExceptionHandler.class)
    protected ResponseEntity<Object> handleExceptionNotFound(EntityExceptionHandler ex){
        ResponseDto responseDto = new ResponseDto();
        responseDto.setStatus(ex.getStatus());
        responseDto.setMensaje(ex.getMessage());
        responseDto.setCode(ex.getCode());

        return buildResponseEntity(responseDto);
    }

    private ResponseEntity<Object> buildResponseEntity(ResponseDto responseDto){
        return new ResponseEntity<>(responseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
