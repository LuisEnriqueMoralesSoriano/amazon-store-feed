package mx.com.fahorro.apiamzstorefeed.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//SELECT farma_id,calle,num_ext,colonia,ciudad,codigo_postal,estado,email,deleg_municipio,longitud,latitud FROM  FA_APEX_CC.fah_cc_sucursales_farm where farma_id='GDPN';
@Entity
@Table(name = "fah_cc_sucursales_farm", schema="FA_APEX_CC")
public class BranchEntity implements Serializable {

    @Id
    @Column(name = "SUCURSAL_COD")
    private Long sucursalCod;

    @Column(name = "farma_id")
    private String farmaId;

    @Column(name = "calle")
    private String street;

    @Column(name = "num_ext")
    private String numExt;

    @Column(name = "colonia")
    private String suburb;

    @Column(name = "deleg_municipio")
    private String town;

    @Column(name = "ciudad")
    private String city;

    @Column(name = "estado")
    private String state;

    @Column(name = "codigo_postal")
    private String postalCode;

    @Column(name = "longitud")
    private String length;

    @Column(name = "latitud")
    private String latitude;

    @Column(name = "email")
    private String email;


    public Long getSucursalCod() {
        return sucursalCod;
    }

    public void setSucursalCod(Long sucursalCod) {
        this.sucursalCod = sucursalCod;
    }

    public String getFarmaId() {
        return farmaId;
    }

    public void setFarmaId(String farmaId) {
        this.farmaId = farmaId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumExt() {
        return numExt;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressComplete(){
        return this.getStreet() + " No." +this.getNumExt()+ " COLONIA " + this.getSuburb()+" , " + this.getTown() + "," + this.getState();
    }
}
