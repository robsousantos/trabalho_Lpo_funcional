/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author Robson
 */
public class Proposta {
    
    private int id;
    private String ofertante;
    private String desejo;
    private String oferta;
    private String proprietario;
    private String status;
    

    public Proposta() {
    }

    public Proposta(int id, String ofertante, String desejo, String oferta, String proprietario, String status) {
        this.id = id;
        this.ofertante = ofertante;
        this.desejo = desejo;
        this.oferta = oferta;
        this.proprietario = proprietario;
        this.status=status;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getDesejo() {
        return desejo;
    }

    public void setDesejo(String desejo) {
        this.desejo = desejo;
    }

    public String getOfertante() {
        return ofertante;
    }

    public void setOfertante(String ofertante) {
        this.ofertante = ofertante;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
}
