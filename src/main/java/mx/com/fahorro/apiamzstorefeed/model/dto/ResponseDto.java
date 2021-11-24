package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;

public class ResponseDto implements Serializable {

    private String status;

    private String code;

    private String mensaje;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
