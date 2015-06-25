import java.io.*;
import java.math.BigDecimal;

class LecturaTXT {
	public static void main (String[] arg) throws Exception {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

			archivo = new File ("C:\\movimientos.txt");
			fr = new FileReader ( archivo );
			br = new BufferedReader ( fr );

			String linea;
			 
			Cliente saldoClientes[] = new Cliente[50];
			inicializarVector(saldoClientes);

				while ( ( linea = br.readLine() ) != null) {
					String listaarray[] = linea.split("\\Q|\\E");
								
					Cliente listaLinea = new Cliente();
						
					listaLinea.idCuenta = listaarray[0];						
					listaLinea.Apellido = listaarray[1];
					listaLinea.Nombre = listaarray[2];
					listaLinea.Nombre = "";
					listaLinea.Saldo = new BigDecimal(listaarray[3].replace(",","."));
					listaLinea.Debitos = new BigDecimal(listaarray[4].replace(",","."));
					listaLinea.Creditos = new BigDecimal(listaarray[5].replace(",","."));
					listaLinea.TopeCtaCte = new BigDecimal(listaarray[6].replace(",","."));
										
					acumularSaldos ( listaLinea , saldoClientes);
					
				}
				br.close();
    		    
			    muestroSaldos ( saldoClientes );
				mostrarMorosos ( saldoClientes );
				mostrarCantDebCred(saldoClientes);
				
}	
	private static void mostrarCantDebCred(Cliente[] saldoClientes){
		BigDecimal valor = new BigDecimal("0");
		
		for (int i = 0; i < 50; i++) {
			System.out.println (" ID DE LA CUENTA: " + saldoClientes[i].idCuenta + " ||  SALDO DEBITOS:  " + saldoClientes[i].CantidadDebitos+ " ||  SALDO CREDITOS:  " + saldoClientes[i].cantidadCreditos );
			
	}
}
	
	
	private static void mostrarMorosos(Cliente[] saldoClientes){
		BigDecimal valor = new BigDecimal("0");
		
		for (int i = 0; i < 50; i++) {
			
			if ((saldoClientes[i].Saldo.compareTo(valor) < 0) ){
				
			System.out.println (" ID DE LA CUENTA: " + saldoClientes[i].idCuenta + " ||  SALDO MOROSO:  " + saldoClientes[i].Saldo);
			
		}
		
	}
}
	private static void inicializarVector(Cliente[] saldoClientes){
		for (int i = 0; i < 50; i++) {
			saldoClientes[i]=new Cliente();	
			saldoClientes[i].idCuenta="";
		}
	}

	private static void muestroSaldos (Cliente[] saldoClientes) {
		for (int i = 0; i < 50; i++) {
			System.out.println (" ID DE LA CUENTA: " + saldoClientes[i].idCuenta + " ||  SALDO:  " + saldoClientes[i].Saldo);
			
		}
	}

	private static void acumularSaldos ( Cliente listaLinea, Cliente saldoClientes[]){
	
		Boolean encontrado = false;	
		BigDecimal valor = new BigDecimal("0");
		
			for ( int i = 0; i < 50; i++ ) { 
					
				if(saldoClientes[i].idCuenta.equals(listaLinea.idCuenta)){
						
						    saldoClientes[i].Saldo=saldoClientes[i].Saldo.add (listaLinea.Creditos).subtract(listaLinea.Debitos);
						
						    if(saldoClientes[i].Creditos.compareTo(valor)> 0){
								
								saldoClientes[i].cantidadCreditos = saldoClientes[i].cantidadCreditos + 1;
								
							}
							else{
								saldoClientes[i].CantidadDebitos = saldoClientes[i].CantidadDebitos + 1;
								
							}
						    
						    i=50;
							
							encontrado=true;
								
					}
			}
			
				if(encontrado==false){
				
					saldoClientes[Global.pos]=listaLinea;
				
			    //la primera pasada debe cargar
				saldoClientes[Global.pos].Saldo=saldoClientes[Global.pos].Saldo.add (listaLinea.Creditos).subtract(listaLinea.Debitos);
				
				if(saldoClientes[Global.pos].Creditos.compareTo(valor)> 0){
					
					saldoClientes[Global.pos].cantidadCreditos = 1;
				}
				else{
					saldoClientes[Global.pos].CantidadDebitos = 1;
				}
				Global.pos=Global.pos+1;
			}
	}	
}
