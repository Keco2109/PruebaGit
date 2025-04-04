import java.util.Scanner;

public class Sokoban {
	public static final int DIRECCION_ARRIBA = 8;
	public static final int DIRECCION_ABAJO = 2;
	public static final int DIRECCION_IZQUIERDA = 4;
	public static final int DIRECCION_DERECHA = 6;
	public static void main(String[] args) {
		
		boolean[][] paredes=
			{
				{false, false, false, false, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false},
				{false, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false, false, false, false},
				{false, false, false, false, true, false, false, false, true, false, false, false, false, false, false, false, false, false, false},
				{false, false, true, true, true, false, false, false, true, true, false, false, false, false, false, false, false, false, false},
				{false, false, true, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false},
				{true, true, true, false, true, false, true, true, false, true, false, false, false, true, true, true, true, true, true},
				{true, false, false, false, true, false, true, true, false, true, true, true, true, true, false, false, false, false, true},
				{true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true},
				{true, true, true, true, true, false, true, true, true, false, true, false, true, true, false, false, false, false, true},
				{false, false, false, false, true, false, false, false, false, false, true, true, true, true, true, true, true, true, true},
				{false, false, false, false, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false}
			};
		boolean[][] cajas=
			{
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,true,false,true,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,true,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}
			};
		boolean[][] objetivos=
			{
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,true,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,true,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,true,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},
				{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}
			};
		Scanner scanner = new Scanner (System.in);
		int filaSokoban = 8;
		int columnaSokoban = 11;
		int movimientos = 0;
		boolean salida = false;
		while(!salida) {
			mostrarNivel(paredes, cajas, objetivos, filaSokoban, columnaSokoban);
			char direccion = scanner.nextLine().charAt(0);
			if (direccion == 'e') {
				System.out.println("exit");
				salida = true;
			}
			if (direccion == 'w') {
				if (sePuedeMover(paredes, cajas, filaSokoban, columnaSokoban, DIRECCION_ARRIBA)) {
					filaSokoban--;
					movimientos ++;
				}
				if (cajas[filaSokoban][columnaSokoban]) {
					cajas[filaSokoban][columnaSokoban] = false;
					cajas[filaSokoban-1][columnaSokoban] = true;
				}
			}
			if (direccion == 'a') {
				if (sePuedeMover(paredes, cajas, filaSokoban, columnaSokoban, DIRECCION_IZQUIERDA)) {
					columnaSokoban--;
					movimientos ++;
				}
				if (cajas[filaSokoban][columnaSokoban]) {
					cajas[filaSokoban][columnaSokoban] = false;
					cajas[filaSokoban][columnaSokoban-1] = true;
				}
					
			}
			if (direccion == 's') {
				if (sePuedeMover(paredes, cajas, filaSokoban, columnaSokoban, DIRECCION_ABAJO)) {
					filaSokoban++;
				movimientos ++;
				}
				if (cajas[filaSokoban][columnaSokoban]) {
					cajas[filaSokoban][columnaSokoban] = false;
					cajas[filaSokoban+1][columnaSokoban] = true;
				}
			}
			if (direccion == 'd') {
				if (sePuedeMover(paredes, cajas, filaSokoban, columnaSokoban, DIRECCION_DERECHA)) {
					columnaSokoban++;
					movimientos ++;
			}
				if (cajas[filaSokoban][columnaSokoban]) {
					cajas[filaSokoban][columnaSokoban] = false;
					cajas[filaSokoban][columnaSokoban+1] = true;
				}
			}
			if (hasGanado(cajas, objetivos)) {
				mostrarNivel(paredes, cajas, objetivos, filaSokoban, columnaSokoban);
				System.out.println("Ganaste en "+ movimientos + " movimientos");
				break;
			}
		}
		scanner.close();
	}
		
	
	public static void mostrarNivel(boolean[][] paredes, boolean[][] cajas, boolean[][] objetivos, int filaSokoban, int columnaSokoban) {
		for(int f = 0; f<paredes.length;f++) {
			
			for(int c = 0; c < paredes[f].length;c++) {
				if (f == filaSokoban && c == columnaSokoban) 
					System.out.print("()");
				else 
				if(paredes[f][c]) {
					System.out.print('\u2593');
					System.out.print('\u2593');
				}
				else if(cajas[f][c]) 
					System.out.print("[]");
				else if(objetivos[f][c])
					System.out.print("<>");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	public static boolean sePuedeMover(boolean[][] paredes, boolean[][] cajas, int filaSokoban, int columnaSokoban, int direccion) {
		boolean sePuedeMover = true;
			if(direccion == DIRECCION_ARRIBA && paredes[filaSokoban - 1][columnaSokoban]) 
				sePuedeMover = false;
			else if(direccion==DIRECCION_ARRIBA && cajas[filaSokoban - 2][columnaSokoban] && cajas[filaSokoban - 1][columnaSokoban])
				sePuedeMover = false;
			else if(direccion==DIRECCION_ARRIBA && paredes[filaSokoban - 2][columnaSokoban] && cajas[filaSokoban - 1][columnaSokoban])
				sePuedeMover = false;
			
			
			if(direccion == DIRECCION_ABAJO && paredes[filaSokoban + 1][columnaSokoban])
				sePuedeMover = false;
			else if(direccion==DIRECCION_ABAJO && cajas[filaSokoban + 2][columnaSokoban] && cajas[filaSokoban + 1][columnaSokoban])
				sePuedeMover = false;
			else if(direccion==DIRECCION_ABAJO && paredes[filaSokoban + 2][columnaSokoban] && cajas[filaSokoban + 1][columnaSokoban])
				sePuedeMover = false;
			
			if(direccion == DIRECCION_IZQUIERDA && paredes[filaSokoban][columnaSokoban - 1])
				sePuedeMover = false;
			else if(direccion==DIRECCION_IZQUIERDA && cajas[filaSokoban][columnaSokoban - 2] && cajas[filaSokoban][columnaSokoban - 1])
				sePuedeMover = false;
			else if(direccion==DIRECCION_IZQUIERDA && paredes[filaSokoban][columnaSokoban - 2] && cajas[filaSokoban][columnaSokoban - 1])
				sePuedeMover = false;
			
			if(direccion == DIRECCION_DERECHA && paredes[filaSokoban][columnaSokoban + 1])
				sePuedeMover = false;
			else if(direccion==DIRECCION_DERECHA && cajas[filaSokoban][columnaSokoban + 2] && cajas[filaSokoban][columnaSokoban + 1])
				sePuedeMover = false;
			else if(direccion==DIRECCION_DERECHA && paredes[filaSokoban][columnaSokoban + 2] && cajas[filaSokoban][columnaSokoban + 1])
				sePuedeMover = false;
			
		return sePuedeMover;
	}
	public static boolean hasGanado (boolean[][] cajas, boolean[][] objetivos) {
		for(int f = 0; f < cajas.length; f++) {
			for(int c = 0; c < cajas[f].length; c++) {
				if(cajas[f][c] && !objetivos[f][c])
					return false;
			}
		}
		return true;
	}
}
