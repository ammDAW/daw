import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroFabricante'
})
export class FiltroFabricantePipe implements PipeTransform {

  transform(value: any[], idFab:string): any[] {
    //mi filtrado
    if (value && value.length && idFab != "0")
    return value.filter(coche => coche.fabricante == idFab);

    //return caso de que mi filtrado no tenga sentido
    return value;
  }

}
