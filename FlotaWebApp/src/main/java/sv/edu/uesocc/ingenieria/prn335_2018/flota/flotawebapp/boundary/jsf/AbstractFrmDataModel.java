/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.boundary.jsf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.Modelo;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.datos.definicion.TipoEstadoReserva;
import sv.edu.uesocc.ingenieria.prn335_2018.flota.flotawebapp.control.AbstractFacade;

/**
 *
 * @author oapaises
 */
public abstract class AbstractFrmDataModel<T> {

    public abstract T getEntity();

    public abstract AbstractFacade<T> getFacade();
    List<T> List = new ArrayList<>();
    LazyDataModel<T> lazyModel;

    public void llenarLista(List<T> Lista) {
        if (getFacade().findAll() != null) {
            Lista = getFacade().findAll();
        } else {
            Lista = Collections.EMPTY_LIST;
        }
    }
    
    public void crear(T entity) {
        if (getFacade() != null && getEntity() != null) {
            try {
                getFacade().create(entity);
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
    }
    
     public void delete(T entity) {
         if (getFacade() != null && getEntity() != null) {
            try {
                getFacade().remove(entity);
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
         }
    }
     
     public void update(T entity) {
         if (getFacade() != null && getEntity() != null) {
            try {
                getFacade().edit(entity);
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
         }
    }
     
//     public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
//        int size = selectOne ? entities.size() + 1 : entities.size();
//        SelectItem[] items = new SelectItem[size];
//        int i = 0;
//        if (selectOne) {
//            items[0] = new SelectItem("", "---");
//            i++;
//        }
//        for (Object x : entities) {
//            items[i++] = new SelectItem(x, x.toString());
//        }
//        return items;
//    }
     
      
     public void modelo(){
         try {
            lazyModel = (LazyDataModel<T>) new LazyDataModel<Modelo>() {
                @Override
                public Object getRowKey(Modelo object) {
                    if (object != null) {
                        return object.getIdModelo();
                    }
                    return null;
                }

                @Override
                public Modelo getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (Modelo tipo : (List<Modelo>) getWrappedData()) {
                                if (tipo.getIdModelo().compareTo(buscado) == 0) {
                                    return tipo;
                                }
                            }
                        } catch (NumberFormatException e) {
                            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }
                    }
                    return null;
                }

                @Override
                public List<Modelo> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Modelo> salida = new ArrayList<>();
                    try {
                        if (getFacade() != null) {
                            this.setRowCount(getFacade().count());
                            salida = (List<Modelo>) getFacade().findRange(first, pageSize);
                        }
                    } catch (Exception e) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                    return salida;
                }
            };
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

     
     
//    public List<T> listar(int first, int pageSize, String sortField, boolean asc) {
//        try {
//
//            if (getFacadeLocal() != null) {
//                List = getFacadeLocal().findRange(first, pageSize);
//            }
//        } catch (Exception e) {
//            System.out.println("Excepcion" + e.getMessage());
//        }
//
//        if (sortField != null) {
//            if (asc == true) {
//                Lista.addAll(List);
//            } else {
//
//            }
//        }
//        return Lista;
//
//    }
}


