/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoVehiculo;

/**
 *
 * @author oapaises
 */
@Stateless
public class TipoEstadoVehiculoFacade extends AbstractFacade<TipoEstadoVehiculo> {

    @PersistenceContext(unitName = "sv.edu.uesocc.ingenieria.prn335_2018.flota.datos_FlotaWebApp_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoEstadoVehiculoFacade() {
        super(TipoEstadoVehiculo.class);
    }
    
}
