package mx.com.fahorro.apiamzstorefeed.model.dto;

import java.io.Serializable;

public class DocumentDto implements Serializable {

    private String documentId;

    private String documentType;

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }
}
