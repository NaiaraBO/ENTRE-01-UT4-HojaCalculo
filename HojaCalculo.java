
/**
 *  Un objeto de esta clase representa a una sencilla
 *  hoja de cálculo. La hoja tiene hasta un máximo de 3 filas (no más)
 *  En cada fila la empresa "apunta" los ingresos y gastos en 
 *  una determinada fecha
 * 
 * @author -   Naiara Borrega
 *  
 */
public class HojaCalculo
{
    private String nombre;
    private Fila fila1;
    private Fila fila2;
    private Fila fila3;

    /**
     * Constructor  
     * Crea la hoja de cálculo con el nombre indicado 
     * e inicializa las filas al valor null (inicialmente
     * la hoja se crea sin filas)
     */
    public HojaCalculo(String nombre){
        this.nombre = nombre;
        this.fila1 = null;
        this.fila2 = null;
        this.fila3 = null;
    }

    /**
     * accesor para el nombre de la hoja
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * accesor para la fila1
     */
    public Fila getFila1(){
        return fila1;
    }

    /**
     * accesor para la fila2
     */
    public Fila getFila2(){
        return fila2;
    }

    /**
     * accesor para la fila3
     */
    public Fila getFila3(){
        return fila3;
    }

    /**
     * Devuelve el nº de filas de la hoja
     * (dependerá de cuántas filas estén a null)
     */
    public int getNumeroFilas(){
        int numeroFila = 0;
        if(fila1 != null){numeroFila ++;}
        if(fila2 != null){numeroFila ++;}
        if(fila3 != null){numeroFila ++;}
        return numeroFila;
    }

    /**
     * Devuelve true si la hoja está completa
     * (tiene exactamente 3 filas)
     */
    public boolean hojaCompleta(){
      boolean hojaTrueFalse;
      if(getNumeroFilas() == 3){
          hojaTrueFalse = true;
      }else{
          hojaTrueFalse = false;
      }        
      return hojaTrueFalse;
    }

    /**
     * Se añade una nueva fila a la hoja
     * Si la hoja está completa se muestra el mensaje "FilaX no se puede añadir en HOJAX"
     * Si no está completa se añade la fila a la hoja teniendo en cuenta
     * si se añade como primera, segunda o tercera fila (no han de quedar huecos)
     */
    public void addFila(Fila fila){         
        if(getNumeroFilas() < 3){
               if(fila1 == null && fila2 == null && fila3 == null){
                  fila1 = fila;
                  if(fila1 != null && fila2 == null && fila3 == null){
                        fila2 = fila;
                        if(fila1 != null && fila2 != null && fila3 == null){
                            fila3 = fila;
                        }else{
                            System.out.println("Fila" + fila.getId() + "no se puede añadir en HOJA" + this.nombre);
                        }
                  }
               }
        }
    }

    /**
     * Dada la información a guardar en una fila el método
     * crea la fila y la añade a la hoja
     * (evita repetir código)
     */
    public void addFila(String id, Fecha fecha, double ingresos, double gastos){
        Fila nuevaFila = new Fila (id, fecha, ingresos, gastos);
        this.addFila(nuevaFila);
    }

    /**
     * Calcula y devuelve el total de ingresos entre
     * todas las filas que incluye la hoja
     */
    public double getTotalIngresos(){
     double ingresos1 = 0;
     double ingresos2 = 0;
     double ingresos3 = 0;
     if(fila1 != null && fila2 != null && fila3 != null){
          ingresos1 += fila1.getIngresos();
          ingresos2 += fila2.getIngresos();
          ingresos3 += fila3.getIngresos();
          if(fila1 != null && fila2 != null && fila3 == null){
                ingresos1 += fila1.getIngresos();
                ingresos2 += fila2.getIngresos();
                ingresos3 = 0;
                if(fila1 != null && fila2 == null && fila3 == null){
                    ingresos1 += fila1.getIngresos();
                    ingresos2 = 0;
                    ingresos3 = 0;
                }
          }
     }        
     double totalIngresos = ingresos1 + ingresos2 + ingresos3;
     return totalIngresos;
    }

    /**
     * Calcula y devuelve el total de gastos
     * entre todas las filas que incluye la hoja
     */
    public double getTotalGastos() {
        double gastos1 = 0;
        double gastos2 = 0;
        double gastos3 = 0;
        if(fila1 != null && fila2 != null && fila3 != null){
          gastos1 += fila1.getGastos();
          gastos2 += fila2.getGastos();
          gastos3 += fila3.getGastos();
          if(fila1 != null && fila2 != null && fila3 == null){
                gastos1 += fila1.getGastos();
                gastos2 += fila2.getGastos();
                gastos3 = 0;
                if(fila1 != null && fila2 == null && fila3 == null){
                    gastos1 += fila1.getGastos();
                    gastos2 = 0;
                    gastos3 = 0;
                }
          }
        }        
        double totalGastos = gastos1 + gastos2 + gastos3;
        return totalGastos;
    }

    /**
     * Calcula y devuelve el total del beneficio
     * entre todas las filas que incluye la hoja
     */
    public double getBeneficio() {
        double beneficio1 = 0;
        double beneficio2 = 0;
        double beneficio3 = 0;
        if(fila1 != null && fila2 != null && fila3 != null){
            beneficio1 += fila1.getBeneficio();
            beneficio2 += fila2.getBeneficio();
            beneficio3 += fila3.getBeneficio();
            if(fila1 != null && fila2 != null && fila3 == null){
                beneficio1 += fila1.getBeneficio();
                beneficio2 += fila2.getBeneficio();
                beneficio3 = 0;
                if(fila1 != null && fila2 == null && fila3 == null){
                    beneficio1 += fila1.getBeneficio();
                    beneficio2 = 0;
                    beneficio3 = 0;
                }
            }
        }        
        double totalBeneficio = beneficio1 + beneficio2 + beneficio3;
        return totalBeneficio;
    }

    /**
     * Representación textual de la hoja
     * con el formato exacto que indica el enunciado
     */
    public String toString(){
       return null;
    }

    /**
     * Devuelve un duplicado de la hoja actual.
     * El nombre de la hoja duplicada será "Duplicada HojaX"
     * Al duplicar la hoja se duplicarán también las filas que contenga
     */
    public HojaCalculo duplicarHoja(){
      HojaCalculo hojaNueva = new HojaCalculo("Duplicada HojaX");  
      hojaNueva.addFila(this.fila1);
      hojaNueva.addFila(this.fila2);
      hojaNueva.addFila(this.fila3);
      return hojaNueva;
    }
   
}
