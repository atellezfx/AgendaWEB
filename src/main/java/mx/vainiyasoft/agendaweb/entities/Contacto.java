package mx.vainiyasoft.agendaweb.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "CONTACTO", catalog = "agenda", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto.findById", query = "SELECT c FROM Contacto c WHERE c.serverId = :id"),
    @NamedQuery(name = "Contacto.findByAndroidId", query = "SELECT c FROM Contacto c WHERE c.androidId = :androidId"),
    @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contacto.findByEmail", query = "SELECT c FROM Contacto c WHERE c.email = :email"),
    @NamedQuery(name = "Contacto.findByTelefono", query = "SELECT c FROM Contacto c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Contacto.findByDireccion", query = "SELECT c FROM Contacto c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Contacto.findByImageUri", query = "SELECT c FROM Contacto c WHERE c.imageUri = :imageUri"),
    @NamedQuery(name = "Contacto.findByPropietario", query = "SELECT c FROM Contacto c WHERE c.propietario = :propietario"),
    @NamedQuery(name = "Contacto.findByMd5", query = "SELECT c FROM Contacto c WHERE c.md5 = :md5")})
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer serverId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "androidId", nullable = false)
    private int androidId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email", length = 255)
    private String email;
    @Size(max = 45)
    @Column(name = "telefono", length = 45)
    private String telefono;
    @Size(max = 255)
    @Column(name = "direccion", length = 255)
    private String direccion;
    @Size(max = 255)
    @Column(name = "imageUri", length = 255)
    private String imageUri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "propietario", nullable = false, length = 45)
    private String propietario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "md5", nullable = false, length = 32)
    private String md5;

    public Contacto() {
    }

    public Contacto(Integer serverId) {
        this.serverId = serverId;
    }

    public Contacto(Integer serverId, int androidId, String nombre, String propietario, String md5) {
        this.serverId = serverId;
        this.androidId = androidId;
        this.nombre = nombre;
        this.propietario = propietario;
        this.md5 = md5;
    }

    //<editor-fold defaultstate="collapsed" desc="GETTER METHODS">
    public Integer getServerId() {
        return serverId;
    }
    
    public int getAndroidId() {
        return androidId;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public String getImageUri() {
        return imageUri;
    }
    
    public String getPropietario() {
        return propietario;
    }
    
    public String getMd5() {
        return md5;
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="SETTER METHODS">
    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }
    
    public void setAndroidId(int androidId) {
        this.androidId = androidId;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
    
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
    
    public void setMd5(String md5) {
        this.md5 = md5;
    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="EQUALS & HASHCODE METHODS">
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.serverId);
        hash = 67 * hash + this.androidId;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.propietario);
        hash = 67 * hash + Objects.hashCode(this.md5);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.serverId, other.serverId)) {
            return false;
        }
        if (this.androidId != other.androidId) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.propietario, other.propietario)) {
            return false;
        }
        if (!Objects.equals(this.md5, other.md5)) {
            return false;
        }
        return true;
    }
//</editor-fold>
    
}
