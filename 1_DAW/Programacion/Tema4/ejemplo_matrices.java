//MATRICES

int edificio[][]={{3,4,7},{1,2,3,5},{8,3,5,9,2}};

int edificio[][]=new int[3][];
int edificio[0]=new int[3];
int edificio[1]=new int[4];
int edificio[2]=new int[5];

edicifio
---------------------
| 8 | 3 | 5 | 9 | 2 |	//edificio[2]
|  1 |  2  | 3 |  5 |	//edificio[1]
|  3 |	  4    |  7	|	//edicifio[0]
---------------------	
edificio[0][3];
edificio[1][4];
edificio[2][5];

for(int planta=0; planta<edificio.length; planta++){
	for(int piso=0; piso<edificio[planta].length; piso++){
		sout(edificio[planta][piso]);
	}
}