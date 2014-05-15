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
    
    private String ofertante;
    private String desejo;
    private String oferta;

    public Proposta() {
    }

    public Proposta(String ofertante, String desejo, String oferta) {
        this.ofertante = ofertante;
        this.desejo = desejo;
        this.oferta = oferta;
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

    
    
    
}
